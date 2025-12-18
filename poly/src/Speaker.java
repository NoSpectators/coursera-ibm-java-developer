// interface for devices that can be turned on/off
interface Switchable {
    void turnOn();
    void turnOff();
}

// interface for devices with brightness settings
interface Adjustable {
    void increase();
    void decrease();
}

// interface for devices with volume settings
interface Volume {
    void increaseVol();
    void decreaseVol();
}

// interface for devices that connect to a network
interface Connectable {
    void connect();
    void disconnect();
}

// SmartSpeaker class implementing all three interfaces
class SmartSpeaker implements Switchable, Connectable, Volume {
    private boolean isOn = false;
    private int volume = 50; // default volume
    private boolean isConnected = false;

    // Switchable methods
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("SmartSpeaker is turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("SmartSpeaker is turned OFF.");
    }

    // Volume methods
    @Override 
    public void increaseVol() {
        if (this.volume < 100) {
            this.volume += 10;
            System.out.println("Volume increased to " + this.volume + "%.");
        } else {
            System.out.println("Volume is already at maximum");
        }
    }

    @Override
    public void decreaseVol() {
        if (this.volume > 0) {
            this.volume -= 10;
            System.out.println("Volume decreased to " + this.volume + "%.");
        }
    }

    // Connectable methods
    @Override
    public void connect() {
        isConnected = true;
        System.out.println("SmartSpeaker is connected to the network.");
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("SmartSpeaker is disconnected from the network.");
    }
}

// Fan implementing two interfaces
class Fan implements Switchable, Adjustable {
    private boolean isOn = false;
    private int speed = 50; // default speed 

    // Switchable methods
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Fan is turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Fan is turned OFF.");
    }
   
    // Adjustable methods
    @Override 
    public void increase() {
        if (this.speed < 100) {
            this.speed += 10;
            System.out.println("Speed increased to " + this.speed + "%.");
        } else {
            System.out.println("Speed is already at maximum");
        }
    }

    @Override
    public void decrease() {
        if (this.speed > 0) {
            this.speed -= 10;
            System.out.println("Speed decreased to " + this.speed + "%.");
        }
    } 
}
