/**
 * Subclass for cardiologists, inheriting from HealthProfessional
 * Adds attributes and behaviors specific to cardiologists (e.g., subspecialty, years of experience)
 * Illustrates how subclasses can extend the base class to represent specialized health professional types
 */
public class Cardiologist extends HealthProfessional {
    // Unique instance variable 1: Subspecialty in cardiology
    // Stores the specific field of cardiology the doctor specializes in (e.g., interventional cardiology)
    private String subspecialty;
    // Unique instance variable 2: Years of professional experience
    // Represents the number of years the cardiologist has been practicing
    private int yearsOfExperience;

    // Default constructor
    // Initializes parent class attributes and sets subclass attributes to default values
    public Cardiologist() {
        super(); // Call parent class's default constructor
        this.subspecialty = "General Cardiology"; // Default: General cardiology practice
        this.yearsOfExperience = 0; // Default: 0 years (new practitioner)
    }

    // Parameterized constructor: Initializes all instance variables (including parent class attributes)
    // Combines parent class and subclass attributes for comprehensive object initialization
    public Cardiologist(int id, String name, String qualificationId, String subspecialty, int yearsOfExperience) {
        super(id, name, qualificationId); // Initialize parent class attributes
        this.subspecialty = subspecialty;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getter and Setter methods for subclass-specific attributes
    public String getSubspecialty() {
        return subspecialty;
    }

    public void setSubspecialty(String subspecialty) {
        this.subspecialty = subspecialty;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    // Override the parent class's printDetails() method
    // Displays both common attributes (from parent class) and cardiologist-specific attributes
    @Override
    public void printDetails() {
        System.out.println("=== Health Professional Type: Cardiologist ===");
        super.printDetails(); // Reuse parent class logic to print common attributes
        System.out.println("Subspecialty: " + subspecialty);
        System.out.println("Years of Experience: " + yearsOfExperience + " years");
        System.out.println(); // Add blank line for readability
    }
}
