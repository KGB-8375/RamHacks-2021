package com.njbdk.Carmax;

//import statements
import java.util.ArrayList;
import java.util.List;

//class to create carParts
class CarPart {
    private boolean isWorking = true; //if the part is working
    private String name; //name of part
    
    //constructor that sets name
    public CarPart(String name) {
        this.name = name;
    }

    //setter to change name
    //returns void
    public void setWorking(boolean working) {
        this.isWorking = working;
    }

    //getter to check if the part is working
    //returns boolean true if working
    public boolean isWorking() {
        return this.isWorking;
    }

    //getter to return name
    //returns String name
    public String name() {
        return this.name;
    }
}

//Class to contruct a car
public class Carmax {
    private List<CarPart> carParts = new ArrayList<CarPart>(); //makes list for carParts

    //constructor to add all car parts
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

    /*search method to determine if (and where) the car part is in the list
     * returns int x if the string is found and -1 if not
     */ 
    public int searchForIndex(String partName){
        int x = -1;
        String a;
        if(carParts.isEmpty() == false) { //checks if list is empty
            for(int i = 0; i < carParts.size(); i ++){
                a = carParts.get(i).name(); //gets the name of every part in list
                if (a.compareTo(partName) == 0)
                    return (x=i); // returns index if found
            }
        }
        System.out.println("Car part does not exist");  
        return x; //tells user that car part is not in list
    }

    /*method to determine how broken a car is 
     * returns double representationof how close to being fixed a car is
     */ 
    public double carProgress() {
        int broken = 0;

        for(int i = 0; i < carParts.size(); i++) {
            if(carParts.get(i).isWorking() == false) {
                broken++; //finds number of broken parts
            }
        }

        return (carParts.size() - broken) / (double) carParts.size(); //calculates percent of broken parts as a double
    }

    /*method to find all the broken parts in a car
     * returns String of all the parts that are broken
     */ 
    public String brokenParts() {
        String notworking = "";
        for(int i = 0; i < carParts.size(); i++){
            if (notworking == "" && carParts.get(i).isWorking() == false) {
                  notworking += carParts.get(i).name(); //if list is empty, add the name of first broken part
            }
            else if (carParts.get(i).isWorking() == false){
                notworking += ", " + carParts.get(i).name(); //if an entry has already been made to the list of broken parts, add a comma and space
            }
        }
        return notworking; //return a string of all the broken parts
    }

    //method to get the object from the list based on the name
    public CarPart getPart(String name) {
        return carParts.get(searchForIndex(name));
    }
}

//main class to run the program and test methods
//public class Main {
/*main method
 *@returns void
 */ 
/*    public static void main(String[] args){
        Carmax carmax = new Carmax(); //creates new Car/carmax object
        System.out.println("Index of Windshield: " + carmax.searchForIndex("Windshield")); //find index of Windshield
        CarPart windshield = carmax.getPart("Windshield"); //finds windshield object 
        windshield.setWorking(false); //set windshield to not working
        System.out.printf("Progress: %.0f%%\n", carmax.carProgress() * 100.0); //displays progress as a percentage
        System.out.println("Parts not working: " + carmax.brokenParts()); //displays all the parts that are not working
    }
}*/