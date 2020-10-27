package enums;

public enum ResonatorsAmount {
    ABSENT(0),
    SMALL(1),
    MEDIUM(5),
    BIG(10);

    private int resonatorAmount;
    public static final int MAX_AMOUNT = 50;

    ResonatorsAmount(int resonatorAmount) {
        this.resonatorAmount = resonatorAmount;
    }

    public boolean resonatorAbsence(){
        return getResonatorAmount() == 0;
    }

    public void defineTypeOfAmount(){
        if(getResonatorAmount()<5){
            System.out.println("Instrument has small amount of resonators");
        } else if (getResonatorAmount()>=5 && getResonatorAmount()<10){
            System.out.println("Instrumet has medium amount of resonators");
        } else if (getResonatorAmount()>=10 && getResonatorAmount()<= MAX_AMOUNT){
            System.out.println("Instrumet has big amount of resonators");
        } else {
            //Define type of exception and throw it
           // throw new RuntimeException();
        }
    }

    public int getResonatorAmount() {
        return resonatorAmount;
    }

    public void setResonatorAmount(int resonatorAmount) {
        this.resonatorAmount = resonatorAmount;
    }
}
