/**
 * Base class for health professionals, encapsulating common attributes and behaviors of all health practitioners
 * This class serves as the top-level of the inheritance hierarchy, providing a generic structure for all specific health professional types
 */
public class HealthProfessional {
    // Required instance variables: ID (numbers only), name
    private int id;
    private String name;
    // Additional relevant instance variable: Professional qualification certificate number
    // Used to store the unique certification ID of the health professional (e.g., medical license number)
    private String qualificationId;

    // Default constructor
    // Initializes all attributes to default values when no parameters are provided
    public HealthProfessional() {
        this.id = 0;          // Default ID: 0 (represents unassigned)
        this.name = "Unknown";// Default name: "Unknown"
        this.qualificationId = "N/A"; // Default qualification: "Not Applicable"
    }

    // Parameterized constructor: Initializes all instance variables
    // Allows setting specific values for ID, name, and qualification ID during object creation
    public HealthProfessional(int id, String name, String qualificationId) {
        this.id = id;
        this.name = name;
        this.qualificationId = qualificationId;
    }

    // Getter methods: Provide access to private instance variables (encapsulation principle)
    public int getId() {
        return id;
    }

    // Setter method: Allow modifying the ID (with validation potential for future expansion)
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(String qualificationId) {
        this.qualificationId = qualificationId;
    }

    // Method to print all instance variables
    // Displays the basic information of the health professional in a readable format
    public void printDetails() {
        System.out.println("Health Professional ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Qualification ID: " + qualificationId);
    }
}