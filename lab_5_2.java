class SmartDevice {
    protected String deviceName;
    protected String location;
    protected boolean status;

    public SmartDevice(String deviceName, String location, boolean status) {
        this.deviceName = deviceName;
        this.location = location;
        this.status = status;
    }

    public void togglePower() {
        status = !status;
        System.out.println(deviceName + " power is now " + (status ? "ON" : "OFF"));
    }

    public void displayStatus() {
        System.out.println("Device: " + deviceName);
        System.out.println("Location: " + location);
        System.out.println("Power Status: " + (status ? "ON" : "OFF"));
    }
}

class Thermostat extends SmartDevice {
    private double temperature;

    public Thermostat(String deviceName, String location, boolean status, double temperature) {
        super(deviceName, location, status);
        this.temperature = temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.println(deviceName + " temperature set to " + temperature + "°C");
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature: " + temperature + "°C");
    }
}

class SecurityCamera extends SmartDevice {
    private boolean recording;

    public SecurityCamera(String deviceName, String location, boolean status, boolean recording) {
        super(deviceName, location, status);
        this.recording = recording;
    }

    public void toggleRecording() {
        recording = !recording;
        System.out.println(deviceName + " recording is now " + (recording ? "ON" : "OFF"));
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Recording: " + (recording ? "ON" : "OFF"));
    }
}

public class lab_5_2 {
    public static void main(String[] args) {
        
        Thermostat thermostat = new Thermostat("Living Room Thermostat", "Living Room", true, 22.5);
        SecurityCamera camera = new SecurityCamera("Entrance Camera", "Front Door", true, true);

        System.out.println("=== Initial Device Status ===");
        thermostat.displayStatus();
        System.out.println();
        camera.displayStatus();
        System.out.println();

        System.out.println("=== Using Unique Methods ===");
        thermostat.setTemperature(24.0);
        camera.toggleRecording();
        System.out.println();

        System.out.println("=== Updated Device Status ===");
        thermostat.displayStatus();
        System.out.println();
        camera.displayStatus();
        System.out.println();

        System.out.println("=== Toggling Power ===");
        thermostat.togglePower();
        camera.togglePower();
        System.out.println();

  
        System.out.println("=== Polymorphism: Display All Devices ===");
        SmartDevice[] devices = {thermostat, camera};
        for (SmartDevice device : devices) {
            device.displayStatus();  
            System.out.println();
        }
    }
}
