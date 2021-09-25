public class CarPart{
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

public class Carmax{
    List<CarPart> carParts = new List<CarPart>;
    private int x;

    carParts.add(new CarPart("Brakes"));
    carParts.add(new CarPart("Tail Lights"));
    carParts.add(new CarPart("Head Lights"));
    carParts.add(new CarPart("Engine"));
    carParts.add(new CarPart("Windsheild"));
    carParts.add(new CarPart("ABS"));
    carParts.add(new CarPart("Airbags"));
    carParts.add(new CarPart("AC"));
    carParts.add(new CarPart("Spark Plugs"));
    carParts.add(new CarPart("Oil Filter"));
    carParts.add(new CarPart("Battery"));
    carParts.add(new CarPart("Wheel Axle"))
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

    private int searchForIndex(String partName){
        if(carParts.isEmpty() == false){
            x = indexOf(partName);
            if (x != -1)
                return x;
        }
        else{
            System.out.println("Car part does not exist");
            return -1;
        }     
    }

    private double carProgress() {
        int broken = 0;

        for(int i = 0; i < carParts.size(); i++) {
            if(carParts.get(i).isWorking == false) {
                broken++;
            }
        }

        return (carParts.size() - broken) / (double) carParts.size());
    }

    public static void main(String[] args){
        public Car();
        System.out.println("Index of Windshield: " + searchForIndex("Windshield"));
        System.out.println("Progress: " + carProgress());
        String notworking = "";
        for(i = 0; i < carparts.size(); i++){
            if (notworking == "" && carparts.(isworking) == false){
                  notworking += carparts.get(i);
            }
            else if (carparts.(isworking) == false){
                notworking += ", " + carparts.get(i);
            }
        }
        System.out.print(notworking);
}
}

