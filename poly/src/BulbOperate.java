public class BulbOperate {
    public static void main(String[] args) {
        // create an array of Switchable objects to hold different types of bulbs
        // it must be switchable array because all three classes implement switchable interface.
        // it's the only interface that satisfies all three classes
        Switchable switchables[] = new Switchable[3];

        // Create instances of SmartBulb, DimmableBulb, and RegularBulb
        SmartBulb sb = new SmartBulb(); // SmartBulb implements Switchable, Adjustable, and Connectable interfaces
        DimmableBulb db = new DimmableBulb(); // DimmableBulb implements Switchable, Adjustable interfaces
        RegularBulb rb = new RegularBulb(); // RegularBulb implements Switchable interface

        // populate switchables array with bulb instances 
        switchables[0] = sb; // Add SmartBulb to the array
        switchables[1] = db; // Add DimmableBulb to the array
        switchables[2] = rb; // Add RegularBulb to the array
        
        // loop through the array and turn each bulb on and off
        for (int i = 0; i < switchables.length; i++) {
            switchables[i].turnOn();  
            switchables[i].turnOff();
        }
         
        // Increase the brightness of the SmartBulb directly
        sb.increase(); // calls the increase() method of SmartBulb class

        // Decrease the brightnes of the DimmableBulb by casting to Adjustable
        // why this casting has to occur: even though switchabes[1] = db, once db goes into the array, it can 
        // no longer call decrease()--it effectively only satisfies the switchable interface.  
        ((Adjustable) switchables[1]).decrease(); // cast switchables[1] (DimmableBulb) to Adjustable to call decrease()

        // Connect the SmartBulb to the network (must cast it to Connectable!! for the reason stated above)
        ((Connectable) switchables[0]).connect(); // cast switchables[0] (SmartBulb) to Connectable to call connect() 
    }
}
