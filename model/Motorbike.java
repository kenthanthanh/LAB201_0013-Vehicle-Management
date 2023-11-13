public class Motorbike extends Vehicle {
    private String speed;
    private String requiresLicense;
    public Motorbike(String id, String name, String color, double price, String brand, String speed,
            String requiresLicense) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.requiresLicense = requiresLicense;
    }
    public String getSpeed() {
        return speed;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
    public String getRequiresLicense() {
        return requiresLicense;
    }
    public void setRequiresLicense(String requiresLicense) {
        this.requiresLicense = requiresLicense;
    }
    


    
}
