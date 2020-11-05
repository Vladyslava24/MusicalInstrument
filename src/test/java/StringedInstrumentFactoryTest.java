import enums.Material;
import enums.Resonators;
import exception.NotFoundInstrumentException;
import factory.kind_instruments.BowedInstrument;
import factory.StringedInstrumentFactory;
import factory.kind_instruments.PluckedInstrument;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StringedInstrumentFactoryTest {
    private StringedInstrumentFactory instrumentFactory = new StringedInstrumentFactory();
    private List<BowedInstrument> bowedInstrumentList = new ArrayList<>();
    private List <PluckedInstrument> pluckedInstrumentList= new ArrayList<>();

    @Before
    public void setUp() {
        bowedInstrumentList.add(new BowedInstrument("Violin", "string", true, Material.FIR,
                Resonators.STRINGED_MEDIUM, "bow", "bow"));
        bowedInstrumentList.add(new BowedInstrument("Cello", "string", true, Material.CEDAR,
                Resonators.STRINGED_MEDIUM, "bow","bow"));
        bowedInstrumentList.add(new BowedInstrument("Double bass", "string", true, Material.CEDAR,
                Resonators.STRINGED_LONG, "bow","bow"));
        instrumentFactory.setFactoryBowedList(bowedInstrumentList);
        pluckedInstrumentList.add(new PluckedInstrument("Guitar", "string", true, Material.SPRICE,
                Resonators.STRINGED_MEDIUM, "fingers"));
        pluckedInstrumentList.add(new PluckedInstrument("Cello", "string", true, Material.FIR,
                Resonators.STRINGED_MEDIUM, "fingers"));
        pluckedInstrumentList.add(new PluckedInstrument("Uculele", "string", true, Material.CEDAR,
                Resonators.STRINGED_SMALL, "fingers"));
        instrumentFactory.setFactoryPluckedList(pluckedInstrumentList);
    }


    @Test
    public void generateRandomNumber() {
        int number = instrumentFactory.generateRandomNumber(0, 10);
        assertTrue(number>=0 && number<=10);
        assertFalse(number<0 || number>10);
    }

    /*@Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstElementFromEmptyList() {
        factory.kind_instruments.BowedInstrument bowedInstrument = new factory.kind_instruments.BowedInstrument();
        instrumentFactory.makeBowedInstruments();
    }*/


    @Test
    public void makeBowedInstruments() {
        //List<factory.kind_instruments.BowedInstrument> factoryBowedList;
        //instrumentFactory.makeBowedInstruments();
    }



    @Test
    public void makePluckedInstruments() {
    }

    @Test
    public void collectionBowedIterate() {
        //BowedInstrument bowedInstrument = new BowedInstrument();
        List<BowedInstrument> instrumentList1 = new ArrayList<>();
        instrumentFactory.collectionBowedIterate(instrumentList1);
        assertEquals(0, instrumentList1.size());
        //bowedInstrumentList = bowedInstrument.initInstrument();
        instrumentFactory.collectionBowedIterate(bowedInstrumentList);
        assertEquals(3, bowedInstrumentList.size());
    }

    @Test
    public void collectionPluckedIterate() {
        List<PluckedInstrument> instrumentList2 = new ArrayList<>();
        instrumentFactory.collectionPluckedIterate(instrumentList2);
        assertEquals(0, instrumentList2.size());
        instrumentFactory.collectionPluckedIterate(pluckedInstrumentList);
        assertEquals(3, pluckedInstrumentList.size());
    }

    @Test
    public void objectComprasion() {
    }


    @Test
    public void testCountDuplicates(){
        List <PluckedInstrument> list = new ArrayList<>();
        list.add(new PluckedInstrument("Guitar", "string", true, Material.SPRICE,
                Resonators.STRINGED_MEDIUM, "fingers"));
        list.add(new PluckedInstrument("Guitar", "string", true, Material.SPRICE,
                Resonators.STRINGED_MEDIUM, "fingers"));
        list.add(new PluckedInstrument("Cello", "string", true, Material.SPRICE,
                Resonators.STRINGED_MEDIUM, "fingers"));
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        statistics.countPluckedDuplicates(list);
        //assertThat(statistics.countPluckedDuplicates(list), is());
        //assertEquals("Guitar:2", statistics.countPluckedDuplicates(list));
        assertEquals(1, Collections.frequency(list, list.get(2)));
    }

    @Test
    public void testCalculateBowedAmount(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(3, statistics.calculateBowedAmount());
    }

    @Test
    public void testCalculatePluckedAmount(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(3, statistics.calculatePluckedAmount());
    }

    @Test
    public void testCalculateInstrumentAmount(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(6, statistics.calculateInstrumentAmount());
    }

    @Test(expected = NotFoundInstrumentException.class)
    public void testCalculateInstrumentAmountWithZeroValue(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        List<BowedInstrument> bowedList = new ArrayList<>();
        List<PluckedInstrument> pluckedList = new ArrayList<>();
        instrumentFactory.setFactoryBowedList(bowedList);
        instrumentFactory.setFactoryPluckedList(pluckedList);
        statistics.calculateInstrumentAmount();
    }


    @Test
    public void  testDefineAmountShortStrings(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(1, statistics.defineAmountShortStrings());
    }

    @Test
    public void  testDefineAmountMediumStrings(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(4, statistics.defineAmountMediumStrings());
    }

    @Test
    public void  testDefineAmountLongStrings(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(1, statistics.defineAmountLongStrings());
    }
}