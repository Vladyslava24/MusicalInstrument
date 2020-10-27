import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class StringedInstrumentFactory {
    private int amountBowed;
    private int amountPlucked;
    List<BowedInstrument> bowedInstrumentList;
    List<BowedInstrument> factoryBowedList;
    List<BowedInstrument> factoryPluckedList;

    public StringedInstrumentFactory() {
    }

    public int generateRandomNumber(int min, int max) {
        int number = (int) (min + Math.random() * (max - min + 1)) * 1;
        return number;
    }

    public void makeInstruments(){
        BowedInstrument bowedInstrument = new BowedInstrument();
        bowedInstrumentList = new ArrayList<>();
        bowedInstrumentList = bowedInstrument.initInstrument();
        factoryBowedList = new ArrayList<>();
        int collectionSize = 0;
        while(collectionSize < bowedInstrumentList.size()) {
            BowedInstrument instrument = bowedInstrumentList.get(collectionSize);
            int randomAmount = generateRandomNumber(5, 11);
            System.out.println("Random number: " + randomAmount);
            int counter = 0;
            while (counter < randomAmount) {
                factoryBowedList.add(instrument);
                counter++;
            }
            counter = 0;
            collectionSize++;
        }
        collectionIterate(factoryBowedList);
    }

    public void collectionIterate(List<BowedInstrument> factoryList){
        ListIterator<BowedInstrument> listIterator = factoryList.listIterator();
        int count = 1;
        while (listIterator.hasNext()){
            BowedInstrument nextInstrument = listIterator.next();
            System.out.println("Instrument #"+ count+ "\n"+ BowedInstrument.stringRepresentation(nextInstrument)+"\n\n");
            count++;
        }
        System.out.println(factoryList.size());
    }

    public void objectComprasion(List<BowedInstrument> factoryList){
        int indexObj1 = generateRandomNumber(0, factoryList.size()-1);
        int indexObj2 = generateRandomNumber(0, factoryList.size()-1);
        BowedInstrument obj1 = factoryList.get(indexObj1);
        BowedInstrument obj2 = factoryList.get(indexObj2);
        System.out.println(BowedInstrument.stringRepresentation(obj1));
        System.out.println(BowedInstrument.stringRepresentation(obj2));
        if(obj1.equals(obj1)){
            System.out.println("Same objects");
        } else {
            System.out.println("Different objects");
        }
        if(obj1.equals(obj2)){
            System.out.println("Same objects");
        } else {
            System.out.println("Different objects");
        }
        if(obj1.hashCode() == obj1.hashCode()){
            System.out.println("Maybe, same objects");
        } else {
            System.out.println("Different objects exactly");
        }
        if(obj1.hashCode() == obj2.hashCode()){
            System.out.println("Maybe, same objects");
        } else {
            System.out.println("Different objects exactly");
        }
    }

    public void generateSound(String kind) {
        if ("BOWED".equals(kind)) {
            //getBowed();
        } else if ("PLUCKED".equals(kind)) {
            //getPlucked();
        }
        throw new RuntimeException("Unsupported kind of instrument: " + kind);
    }

    public int calculateInstrumentAmount(List<BowedInstrument> bowedFactoryList){
        return bowedFactoryList.size();
    }

    public int calculateInstrumentAmount(List<BowedInstrument> bowedFactoryList,
                                         List<PluckedInstrument> pluckedFactoryList){
        return bowedFactoryList.size()+ pluckedFactoryList.size();
    }



    public int getAmountBowed() {
        return amountBowed;
    }

    public int getAmountPlucked() {
        return amountPlucked;
    }

    public List<BowedInstrument> getBowedInstrumentList() {
        return bowedInstrumentList;
    }

    public List<BowedInstrument> getFactoryBowedList() {
        return factoryBowedList;
    }

    public List<BowedInstrument> getFactoryPluckedList() {
        return factoryPluckedList;
    }
}
