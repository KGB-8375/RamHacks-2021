import java.util.ArrayList;
import java.util.List;

class CarPart {
    private boolean isWorking = true;
    private String name;
    
    public CarPart(String name) {
        this.name = name;
    }

    public void setWorking(boolean working) {
        this.isWorking = working;
    }

    public boolean isWorking() {
        return this.isWorking;
    }

    public String name() {
        return this.name;
    }
}

class Carmax {
    private List<CarPart> carParts = new ArrayList<CarPart>();

    public Carmax() {
        carParts.add(new CarPart("Brakes"));
        carParts.add(new CarPart("Tail Lights"));
        carParts.add(new CarPart("Head Lights"));
        carParts.add(new CarPart("Engine"));
        carParts.add(new CarPart("Windshield"));
        carParts.add(new CarPart("ABS"));
        carParts.add(new CarPart("Airbags"));
        carParts.add(new CarPart("AC"));
        carParts.add(new CarPart("Spark Plugs"));
        carParts.add(new CarPart("Oil Filter"));
        carParts.add(new CarPart("Battery"));
        carParts.add(new CarPart("Wheel Axle"));
        carParts.add(new CarPart("Fuel Guage"));
        carParts.add(new CarPart("Odometer"));
        carParts.add(new CarPart("Radio"));
        carParts.add(new CarPart("Antenna Setup"));
        carParts.add(new CarPart("Turn Signals"));
        carParts.add(new CarPart("Starter"));
        carParts.add(new CarPart("Horn"));
        carParts.add(new CarPart("Suspension"));
        carParts.add(new CarPart("Tires"));
        carParts.add(new CarPart("Fuses"));
        carParts.add(new CarPart("Performance Chip"));
        carParts.add(new CarPart("Alternator"));
        carParts.add(new CarPart("Door Locks"));
        carParts.add(new CarPart("Bumper"));
        carParts.add(new CarPart("Hood"));
        carParts.add(new CarPart("Doors"));
        carParts.add(new CarPart("Radiator"));
        carParts.add(new CarPart("General Exterior"));
        carParts.add(new CarPart("Interior"));
    }

    public int searchForIndex(String partName){
        int x = -1;
        String a;
        if(carParts.isEmpty() == false) {
            for(int i = 0; i < carParts.size(); i ++){
                a = carParts.get(i).name(); 
                if (a.compareTo(partName) == 0)
                    return (x=i);
                if (x != -1)
                    return x;
            }
        }
        System.out.println("Car part does not exist");  
        return -1;
    }

    public double carProgress() {
        int broken = 0;

        for(int i = 0; i < carParts.size(); i++) {
            if(carParts.get(i).isWorking() == false) {
                broken++;
            }
        }

        return (carParts.size() - broken) / (double) carParts.size();
    }

    public String brokenParts() {
        String notworking = "";
        for(int i = 0; i < carParts.size(); i++){
            if (notworking == "" && carParts.get(i).isWorking() == false) {
                  notworking += carParts.get(i).name();
            }
            else if (carParts.get(i).isWorking() == false){
                notworking += ", " + carParts.get(i).name();
            }
        }
        return notworking;
    }

    public CarPart getPart(String name) {
        return carParts.get(searchForIndex(name));
    }
}

public class Main {
    public static void main(String[] args){
        Carmax carmax = new Carmax();
        System.out.println("Index of Windshield: " + carmax.searchForIndex("Windshield"));
        CarPart windshield = carmax.getPart("Windshield");
        windshield.setWorking(false);
        System.out.printf("Progress: %.0f%%\n", carmax.carProgress() * 100.0);
        System.out.println("Parts not working: " + carmax.brokenParts());
    }
}

