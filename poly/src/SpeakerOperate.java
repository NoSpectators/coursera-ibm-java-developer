public class SpeakerOperate {
    public static void main(String[] args) {
        // it must be switchable array because the two classes (Fan and SmartSpeaker) implement switchable interface.
        Switchable switchables[] = new Switchable[2];

        // Create instances of SmartSpeaker and Fan 
        SmartSpeaker sp = new SmartSpeaker(); // SmartSpeaker implements Switchable, Connectable, and Volume interfaces
        Fan f = new Fan(); // Fan implements Switchable and Adjustable interfaces

        // populate switchables array with fan and smartspeaker instances 
        switchables[0] = sp; // Add SmartSpeaker to the array
        switchables[1] = f; // Add Fan to the array
        
        // loop through the array and turn each bulb on and off
        for (int i = 0; i < switchables.length; i++) {
            switchables[i].turnOn();  
            switchables[i].turnOff();
        }
         
        // Turn on the SmartSpeaker directly
        sp.turnOn(); // calls the turnOn() method of SmartSpeaker class
        sp.turnOff(); // calls the turnOff() method of the SmartSpeaker class directly

        // Decrease the speed of Fan by casting to Adjustable
        // why this casting has to occur: even though switchabes[1] = f, once f goes into the array, it can 
        // no longer call decrease()--it effectively only satisfies the switchable interface.  
        ((Adjustable) switchables[1]).decrease(); // cast switchables[1] (Fan) to Adjustable to call decrease()

        // Connect the SmartSpeaker to the network (must cast it to Connectable!! for the reason stated above)
        ((Connectable) switchables[0]).connect(); // cast switchables[0] (SmartSpeaker) to Connectable to call connect() 
    }
}
