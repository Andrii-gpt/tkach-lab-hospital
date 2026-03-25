package hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    private Doctor doctor;

    @BeforeEach
    void setUp() {
        doctor = new Doctor(1, "Ivan", "Cardiologist");
    }

    @Test
    void testHasSpecializationTrue() {
        assertTrue(doctor.hasSpecialization("Cardiologist"));
    }

    @Test
    void testHasSpecializationIgnoreCase() {
        assertTrue(doctor.hasSpecialization("cardiologist"));
    }

    @Test
    void testEqualsById() {
        Doctor anotherDoctor = new Doctor(1, "Petro", "Surgeon");
        assertEquals(doctor, anotherDoctor);
    }
}
