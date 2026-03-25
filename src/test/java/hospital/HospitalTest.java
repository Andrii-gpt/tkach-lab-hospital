package hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {

    private Hospital hospital;
    private Doctor doctor1;
    private Doctor doctor2;
    private Patient patient1;

    @BeforeEach
    void setUp() {
        hospital = new Hospital();
        doctor1 = new Doctor(1, "Ivan", "Cardiologist");
        doctor2 = new Doctor(2, "Petro", "Surgeon");
        patient1 = new Patient(1, "Anna", 20);

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
    }

    @Test
    void testAddDoctor() {
        Doctor doctor3 = new Doctor(3, "Olena", "Therapist");
        hospital.addDoctor(doctor3);

        assertEquals(3, hospital.getAllDoctors().size());
    }

    @Test
    void testFindDoctorsBySpecialization() {
        List<Doctor> result = hospital.findDoctorsBySpecialization("Cardiologist");

        assertEquals(1, result.size());
        assertEquals(doctor1, result.get(0));
    }

    @Test
    void testBookAppointmentSuccess() {
        assertTrue(hospital.bookAppointment(1, 1));
    }

    @Test
    void testRemovePatientById() {
        boolean removed = hospital.removePatientById(1);

        assertTrue(removed);
        assertEquals(0, hospital.getAllPatients().size());
    }
}