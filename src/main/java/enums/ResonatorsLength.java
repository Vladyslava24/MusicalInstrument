package enums;

public enum  ResonatorsLength {
    SHORT(10.56),
    MEDIUM(25.89),
    LONG(50.55);

    private double length;


    ResonatorsLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}
