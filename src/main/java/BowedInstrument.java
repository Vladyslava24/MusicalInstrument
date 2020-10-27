import enums.Material;
import enums.Resonators;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BowedInstrument extends MusicalInstrument implements Stringed {
    public static final String CHARACTER = "\n";
    private Resonators resonators;
    private String playingWay;
    private String additionalSubject;
    private static final String CHARACTER = "\n";

    public BowedInstrument(){

    }

    public BowedInstrument(String name, String soundSource, boolean resonatorPresence, Material instrumentMaterial, Resonators resonators, String playingWay, String additionalSubject) {
        super(name, soundSource, resonatorPresence, instrumentMaterial);
        this.resonators = resonators;
        this.playingWay = playingWay;
        this.additionalSubject = additionalSubject;
    }

    //TODO make list of constants
    @Override
    public List<BowedInstrument> initInstrument() {
        List<BowedInstrument> bowedList = new ArrayList<>();
                bowedList.add(new BowedInstrument("Violin", "string", true, Material.FIR,
                        Resonators.STRINGED_MEDIUM, "bow", "bow"));
                bowedList.add(new BowedInstrument("Cello", "string", true, Material.CEDAR,
                        Resonators.STRINGED_MEDIUM, "bow","bow"));
                bowedList.add(new BowedInstrument("Double bass", "string", true, Material.CEDAR,
                        Resonators.STRINGED_LONG, "bow","bow"));
        return bowedList;
    }

    public static String stringRepresentation(BowedInstrument bowedInstrument){
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append("Instrument name: ")
                 .append(bowedInstrument.getName())
                 .append(CHARACTER)
                 .append("Sound source: ")
                 .append(bowedInstrument.getSoundSource())
                 .append(CHARACTER)
                 .append("Resonator presence: ")
                 .append(bowedInstrument.isResonatorPresence())
                 .append(CHARACTER)
                 .append("Instrument material: ")
                 .append(bowedInstrument.getInstrumentMaterial().name().toLowerCase())
                 .append(Material.valueOf(bowedInstrument.getInstrumentMaterial().name()))
                 .append("\n")
                 .append("Resonators: ")
                 .append(bowedInstrument.getResonators().name().toLowerCase())
                 .append(", resonators amount: ")
                 .append(Resonators.valueOf(bowedInstrument.getResonators().name()).getResonatorsAmount().getResonatorAmount())
                 .append(", resonators length: ")
                 .append(Resonators.valueOf(bowedInstrument.getResonators().name()).getResonatorsLength().getLength())
                 .append("\n")
                 .append("Playing way: ")
                 .append(bowedInstrument.getPlayingWay())
                 .append("\n")
                 .append("Additional subject: ")
                 .append(bowedInstrument.getAdditionalSubject());
         return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        BowedInstrument instrument = (BowedInstrument) obj;
        return  Objects.equals(name, instrument.name) &&
                Objects.equals(soundSource, instrument.soundSource) &&
                Objects.equals(getInstrumentMaterial(), getInstrumentMaterial()) &&
                Objects.equals(resonators, instrument.resonators) &&
                Objects.equals(playingWay, instrument.playingWay) &&
                Objects.equals(additionalSubject, instrument.additionalSubject);
    }



    @Override
    public void generateSound(String kind) {

    }

    public Resonators getResonators() {
        return resonators;
    }

    public void setResonators(Resonators resonators) {
        this.resonators = resonators;
    }

    public String getPlayingWay() {
        return playingWay;
    }

    public void setPlayingWay(String playingWay) {
        this.playingWay = playingWay;
    }

    public String getAdditionalSubject() {
        return additionalSubject;
    }

    public void setAdditionalSubject(String additionalSubject) {
        this.additionalSubject = additionalSubject;
    }

    @Override
    public String toString() {
        return "BowedInstrument{" +
                "resonators=" + resonators +
                ", playingWay='" + playingWay + '\'' +
                ", additionalSubject='" + additionalSubject + '\'' +
                '}';
    }
}
