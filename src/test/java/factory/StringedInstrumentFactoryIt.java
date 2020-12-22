package factory;

import enums.Material;
import enums.Resonators;
import exception.NotFoundInstrumentException;
import factory.kind_instruments.BowedInstrument;
import factory.kind_instruments.PluckedInstrument;
import org.junit.After;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;

public class StringedInstrumentFactoryIt {
    private StringedInstrumentFactory instrumentFactory = new StringedInstrumentFactory();
    private List<BowedInstrument> bowedList = new ArrayList<>();
    private List <PluckedInstrument> pluckedList= new ArrayList<>();

    @Mock
    StringedInstrumentFactory factoryMock;

    @Mock
    StringedInstrumentFactory.Statistics statistics;

    MockitoSession session;

    @Captor
    private ArgumentCaptor<List<BowedInstrument>> bowedCaptor;

    @Captor
    private ArgumentCaptor<List<PluckedInstrument>> pluckedCaptor;

    @Before
    public void beforeMethod() {
        session = Mockito.mockitoSession()
                .initMocks(this)
                .startMocking();
        bowedList.add(new BowedInstrument("Violin", "string", true, Material.FIR,
                Resonators.STRINGED_MEDIUM, "bow", "bow"));
        bowedList.add(new BowedInstrument("Cello", "string", true, Material.CEDAR,
                Resonators.STRINGED_MEDIUM, "bow","bow"));
        bowedList.add(new BowedInstrument("Double bass", "string", true, Material.CEDAR,
                Resonators.STRINGED_LONG, "bow","bow"));
        bowedList.add(new BowedInstrument("Double bass", "string", true, Material.CEDAR,
                Resonators.STRINGED_LONG, "bow","bow"));

        pluckedList.add(new PluckedInstrument("Guitar", "string", true, Material.SPRICE,
                Resonators.STRINGED_MEDIUM, "fingers"));
        pluckedList.add(new PluckedInstrument("Guitar", "string", true, Material.SPRICE,
                Resonators.STRINGED_MEDIUM, "fingers"));
        pluckedList.add(new PluckedInstrument("Cello", "string", true, Material.FIR,
                Resonators.STRINGED_MEDIUM, "fingers"));
        pluckedList.add(new PluckedInstrument("Uculele", "string", true, Material.CEDAR,
                Resonators.STRINGED_SMALL, "fingers"));
        pluckedList.add(new PluckedInstrument("Guitar", "string", true, Material.SPRICE,
                Resonators.STRINGED_MEDIUM, "fingers"));
    }

    @Test
    public void whenCollectionBowedIterateThenReturnSize(){
        when(factoryMock.collectionBowedIterate(bowedList)).thenReturn(4);
        assertEquals(4, factoryMock.collectionBowedIterate(bowedList));
        verify(factoryMock).collectionBowedIterate(bowedCaptor.capture());
        List<BowedInstrument> argument = bowedCaptor.getValue();
        assertThat(argument, is(bowedList));
    }

    @Test
    public void whenCollectionPluckedIterateThenReturnSize(){
        when(factoryMock.collectionPluckedIterate(pluckedList)).thenReturn(5);
        assertEquals(5, factoryMock.collectionPluckedIterate(pluckedList));
        verify(factoryMock).collectionPluckedIterate(pluckedCaptor.capture());
        List<PluckedInstrument> argument = pluckedCaptor.getValue();
        assertThat(argument, is(pluckedList));
    }

    @Test
    public void whenCountDuplicatesThenReturnSize(){
        when(statistics.countBowedDuplicates(bowedList)).thenReturn(3);
        when(statistics.countPluckedDuplicates(pluckedList)).thenReturn(3);
        assertEquals(3, statistics.countBowedDuplicates(bowedList));
        assertEquals (3, statistics.countPluckedDuplicates(pluckedList));
        verify(statistics, times(1)).countBowedDuplicates(bowedList);
        verify(statistics, times(1)).countPluckedDuplicates(pluckedList);
    }

    @Test(expected = NotFoundInstrumentException.class)
    public void whenCalculateInstrumentAmountExceptionThenThrowNotFoundInstrumentException() throws NotFoundInstrumentException{
        doThrow(new NotFoundInstrumentException("List of intruments is empty")).when(statistics).calculateInstrumentAmount();
        statistics.calculateInstrumentAmount();
    }

    @Test
    public void whenCalculateInstrumentAmountThenReturnAmount(){
        StringedInstrumentFactory.Statistics stat = spy(instrumentFactory.new Statistics());
        instrumentFactory.setFactoryBowedList(bowedList);
        instrumentFactory.setFactoryPluckedList(pluckedList);
        when(stat.calculateInstrumentAmount()).thenReturn(9);
        stat.calculateInstrumentAmount();
        verify(stat).calculateInstrumentAmount();
        assertEquals(9, stat.calculateInstrumentAmount());
        verify(stat, atLeast(2)).calculateInstrumentAmount();
    }


    @After
    public void afterMethod() {
        session.finishMocking();
    }
}