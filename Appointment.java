/**
 * Appointment class, storing patient appointment information, time slots, and the corresponding doctor object
 * Utilizes polymorphism to support appointments with any HealthProfessional subclass (e.g., GP, Cardiologist)
 */
public class Appointment {
    // Patient information: Name and mobile phone number (required for appointment identification)
    private String patientName;
    private String patientMobile;
    // Appointment time slot (formatted as "HH:MM", e.g., "08:30", "14:15")
    private String timeSlot;
    // Corresponding doctor object (supports polymorphism: accepts any subclass of HealthProfessional)
    private HealthProfessional doctor;

    // Default constructor
    // Initializes all attributes to default values (unassigned state)
    public Appointment() {
        this.patientName = "Unknown";
        this.patientMobile = "N/A";
        this.timeSlot = "N/A";
        this.doctor = new HealthProfessional(); // Default: Generic health professional
    }

    // Parameterized constructor: Initializes all instance variables
    // Ensures all necessary appointment information is set during object creation
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    // Getter and Setter methods (encapsulation: control access to private attributes)
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public HealthProfessional getDoctor() {
        return doctor;
    }

    public void setDoctor(HealthProfessional doctor) {
        this.doctor = doctor;
    }

    // Method to print all appointment information
    // Displays patient details, time slot, and doctor information (via polymorphism)
    public void printAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Appointment Time Slot: " + timeSlot);
        System.out.println("Attending Doctor Information:");
        // Polymorphic call: Executes the printDetails() method of the specific doctor type (GP/Cardiologist)
        doctor.printDetails();
    }
}