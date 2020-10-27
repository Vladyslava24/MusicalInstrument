
public class MusicInstrumentApp {
    public static void main(String[] args) {
        //StringedInstrumentFactory stringedFactory = (StringedInstrumentFactory) getFactoryByKindInstrument(GeneralKind.STRINGLED);
       StringedInstrumentFactory stringedInstrumentFactory = new StringedInstrumentFactory();
       stringedInstrumentFactory.makeInstruments();
       stringedInstrumentFactory.objectComprasion(stringedInstrumentFactory.getFactoryBowedList());
        //bowed.useBow();
        //plucked.usePick();
    }


//TODO Change if and case
    /*public static MusicalInstrument getFactoryByKindInstrument(GeneralKind kind) {
        switch (kind) {
            case PERCUSSION:
                return new factory.PercussionInstrumentFactory();
            case STRINGED:
                return new StringedInstrumentFactory();
            case WIND:
                return new factory.WindInstrumentFactory();
            case REED:
                return new factory.ReedInstrumentFactory();
            default:
                throw new RuntimeException("Unsupported kind of instrument " + kind);
        }
    }*/
}
