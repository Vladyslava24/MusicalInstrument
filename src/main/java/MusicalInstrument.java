import enums.GeneralKind;
import enums.Material;
import enums.Subspecies;

public abstract class MusicalInstrument {
    protected String name;
    protected String soundSource;
    private boolean resonatorPresence;
    private Material instrumentMaterial;

    public MusicalInstrument() {
    }

    public MusicalInstrument(String name, String soundSource, boolean resonatorPresence, Material instrumentMaterial) {
        this.name = name;
        this.soundSource = soundSource;
        this.resonatorPresence = resonatorPresence;
        this.instrumentMaterial = instrumentMaterial;
    }

    //public abstract void makeBase(String instrumentMaterial);

    public abstract void generateSound(String kind);


    public String getSoundSource() {
        return soundSource;
    }

    public void setSoundSource(String soundSource) {
        this.soundSource = soundSource;
    }

    public boolean isResonatorPresence() {
        return resonatorPresence;
    }

    public void setResonatorPresence(boolean resonatorPresence) {
        this.resonatorPresence = resonatorPresence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getInstrumentMaterial() {
        return instrumentMaterial;
    }

    public void setInstrumentMaterial(Material instrumentMaterial) {
        this.instrumentMaterial = instrumentMaterial;
    }
}
