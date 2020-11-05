package factory.kind_instruments;

import enums.Material;
import enums.Resonators;
import factory.kind_instruments.BowedInstrument;
import factory.kind_instruments.PluckedInstrument;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class BowedInstrumentTest {
    //private factory.kind_instruments.BowedInstrument bowedInstrument;



    @Test
    public void initInstrument() {
        BowedInstrument bowedInstrument = new BowedInstrument();
        List<BowedInstrument> bowedInstrumentList  = new ArrayList<>();
        assertThat(bowedInstrumentList.size(), is(0));
        bowedInstrumentList = bowedInstrument.initInstrument();
        assertThat(bowedInstrumentList.size(), is(3));
    }



    /*@Test
    public void stringRepresentation() {
        factory.kind_instruments.BowedInstrument bowedInstrument = new factory.kind_instruments.BowedInstrument();
        factory.kind_instruments.BowedInstrument.stringRepresentation(bowedInstrument);
    }*/

    @Test
    public void testEquals() {
        BowedInstrument bowedInstrument1 = new BowedInstrument("Violin", "string", true, Material.FIR,
                Resonators.STRINGED_MEDIUM, "bow", "bow");
        BowedInstrument bowedInstrument2 = new BowedInstrument("Violin", "string", true, Material.FIR,
                Resonators.STRINGED_MEDIUM, "bow", "bow");
        BowedInstrument bowedInstrument3 = new BowedInstrument("Double bass", "string", true, Material.CEDAR,
                Resonators.STRINGED_LONG, "bow","bow");
        PluckedInstrument pluckedInstrument = new PluckedInstrument();
        assertTrue(bowedInstrument1.equals(bowedInstrument1));
        assertFalse(bowedInstrument1.equals(null));
        assertFalse(bowedInstrument1.equals(pluckedInstrument));
        assertTrue(bowedInstrument1.equals(bowedInstrument2));
        assertFalse(bowedInstrument1.equals(bowedInstrument3));
    }

    @Test
    public void generateSound() {
    }
}