/**
 * Subclass for general practitioners, inheriting from HealthProfessional
 * Adds attributes and behaviors specific to general practitioners (e.g., special medical interests)
 * Demonstrates the inheritance principle by extending the base class and adding subclass-specific features
 */
public class GeneralPractitioner extends HealthProfessional {
    // Unique instance variable for general practitioners: Areas of special medical interest
    // Stores the specific medical fields the GP specializes in (e.g., family medicine, pediatrics)
    private String[] specialInterests;

    // Default constructor
    // Initializes parent class attributes via super() and sets subclass attribute to default
    public GeneralPractitioner() {
        super(); // Calls the default constructor of the parent class (HealthProfessional)
        this.specialInterests = new String[]{"General Medicine"}; // Default: General medical practice
    }

    // Parameterized constructor: Initializes all instance variables (including parent class attributes)
    // Passes parent class attributes to the parent constructor via super(), then initializes subclass-specific attributes
    public GeneralPractitioner(int id, String name, String qualificationId, String[] specialInterests) {
        super(id, name, qualificationId); // Initialize parent class attributes
        this.specialInterests = specialInterests; // Initialize subclass-specific attribute
    }

    // Getter and Setter methods for subclass-specific attribute
    public String[] getSpecialInterests() {
        return specialInterests;
    }

    public void setSpecialInterests(String[] specialInterests) {
        this.specialInterests = specialInterests;
    }

    // Override the printDetails() method from the parent class
    // Adds subclass-specific information (special interests) to the parent class's detail output
    @Override
    public void printDetails() {
        System.out.println("=== Health Professional Type: General Practitioner ===");
        super.printDetails(); // Calls the parent class's print method to display common attributes
        // Print the array of special interests in a user-friendly format
        System.out.print("Special Interests: ");
        for (int i = 0; i < specialInterests.length; i++) {
            if (i > 0) {
                System.out.print(", "); // Add comma separator between multiple interests
            }
            System.out.print(specialInterests[i]);
        }
        System.out.println("\n"); // Add blank line for readability
    }
}
