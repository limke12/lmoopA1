import java.util.ArrayList;
import java.util.Iterator;

/**
 * Main class containing all functional implementations required by the assignment
 * Divided into two core parts:
 * 1. Part 3: Using classes and objects (create and display health professional objects)
 * 2. Part 5: Managing appointment collections (create, print, cancel appointments)
 */
public class AssignmentOne {
    // Static ArrayList to store all appointments (globally accessible within the class)
    // Uses ArrayList for dynamic storage (supports adding/removing appointments)
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // Part 3 – Using classes and objects (as required by the assignment brief)
        System.out.println("==================== Part 3: Using Classes and Objects ====================");
        // Create 3 General Practitioner objects (meets Part 3 requirement of 3 GP instances)
        GeneralPractitioner gp1 = new GeneralPractitioner(
                1001, "Dr. Emily Davis", "MED-GP-001",
                new String[]{"Family Medicine", "Pediatrics", "Chronic Disease Management"}
        );
        GeneralPractitioner gp2 = new GeneralPractitioner(
                1002, "Dr. Michael Brown", "MED-GP-002",
                new String[]{"Geriatrics", "Preventive Medicine", "Mental Health"}
        );
        GeneralPractitioner gp3 = new GeneralPractitioner(
                1003, "Dr. Sarah Wilson", "MED-GP-003",
                new String[]{"Adolescent Medicine", "Women's Health", "Travel Medicine"}
        );

        // Create 2 Cardiologist objects (meets Part 3 requirement of 2 non-GP health professional instances)
        Cardiologist cardio1 = new Cardiologist(
                2001, "Dr. James Anderson", "MED-CARD-001",
                "Interventional Cardiology", 12 // 12 years of experience in interventional cardiology
        );
        Cardiologist cardio2 = new Cardiologist(
                2002, "Dr. Lisa Thompson", "MED-CARD-002",
                "Electrophysiology", 8 // 8 years of experience in cardiac electrophysiology
        );

        // Print details of all health professionals (uses overridden printDetails() methods)
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        cardio1.printDetails();
        cardio2.printDetails();

        // Required separator line (as specified in Part 3 of the assignment brief)
        System.out.println("------------------------------");

        // Part 5 – Collection of appointments (as required by the assignment brief)
        System.out.println("==================== Part 5: Collection of Appointments ====================");
        // Create 4 appointments (2 with GPs, 2 with Cardiologists – meets Part 5 requirements)
        createAppointment("John Smith", "0412345678", "08:30", gp1);
        createAppointment("Emma Watson", "0487654321", "10:15", gp2);
        createAppointment("Michael Johnson", "0423456789", "14:00", cardio1);
        createAppointment("Sophia Lee", "0498765432", "16:30", cardio2);

        // Print all existing appointments (demonstrates the printExistingAppointments() method)
        System.out.println("=== All Appointments After Creation ===");
        printExistingAppointments();

        // Cancel an appointment (uses patient mobile number as the identifier – meets Part 5 requirement)
        String cancelMobile = "0487654321"; // Mobile number of the appointment to cancel
        System.out.println("=== Canceling Appointment for Mobile: " + cancelMobile + " ===");
        cancelBooking(cancelMobile);

        // Print appointments again (demonstrates the updated collection after cancellation)
        System.out.println("=== All Appointments After Cancellation ===");
        printExistingAppointments();

        // Required separator line (as specified in Part 5 of the assignment brief)
        System.out.println("------------------------------");
    }

    /**
     * Creates a new appointment and adds it to the collection
     * Supports all HealthProfessional subclasses via polymorphism (flexible for future extensions)
     * Includes data validation: Ensures all required information is not empty (prevents invalid appointments)
     *
     * @param patientName Name of the patient (cannot be empty)
     * @param patientMobile Mobile number of the patient (cannot be empty)
     * @param timeSlot Appointment time slot (cannot be empty)
     * @param doctor Corresponding doctor object (cannot be null)
     */
    public static void createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        // Data validation: Check if all required fields are valid (non-null and non-empty)
        if (patientName == null || patientName.trim().isEmpty() ||
                patientMobile == null || patientMobile.trim().isEmpty() ||
                timeSlot == null || timeSlot.trim().isEmpty() ||
                doctor == null) {
            System.out.println("Error: All appointment details are required. Appointment not created.");
            return; // Exit method if validation fails (no invalid appointment added)
        }

        // Create appointment object and add to the ArrayList
        Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointmentList.add(newAppointment);
        System.out.println("Appointment created successfully for patient: " + patientName);
    }

    /**
     * Prints all existing appointments in the collection
     * If no appointments exist, displays a message to indicate the empty state
     */
    public static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No existing appointments found.\n");
            return;
        }

        // Iterate through the ArrayList and print each appointment's details
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("--- Appointment " + (i + 1) + " ---"); // Add appointment number for clarity
            appointmentList.get(i).printAppointmentDetails();
        }
    }

    /**
     * Cancels an appointment using the patient's mobile number
     * Uses Iterator for safe removal of elements from the ArrayList during iteration
     * If the mobile number is not found, displays an error message
     *
     * @param patientMobile Mobile number of the patient whose appointment to cancel
     */
    public static void cancelBooking(String patientMobile) {
        // Use Iterator to avoid ConcurrentModificationException when removing elements
        Iterator<Appointment> iterator = appointmentList.iterator();
        boolean isFound = false; // Flag to track if the appointment is found

        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            // Check if the current appointment's patient mobile matches the target
            if (appointment.getPatientMobile().equals(patientMobile)) {
                iterator.remove(); // Safely remove the appointment from the collection
                System.out.println("Successfully canceled appointment for mobile: " + patientMobile);
                isFound = true;
                break; // Exit loop once the appointment is canceled (assumes one mobile = one appointment)
            }
        }

        // If no appointment matches the mobile number, display error
        if (!isFound) {
            System.out.println("Error: No appointment found with mobile number: " + patientMobile);
        }
        System.out.println(); // Add blank line for readability
    }
}
