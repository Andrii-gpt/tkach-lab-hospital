package hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    private Patient adultPatient;
    private Patient childPatient;

    @BeforeEach
    void setUp() {
        adultPatient = new Patient(1, "Anna", 20);
        childPatient = new Patient(2, "Oleh", 15);
    }

    @Test
    void testIsAdultTrue() {
        assertTrue(adultPatient.isAdult());
    }

    @Test
    void testIsAdultFalse() {
        assertFalse(childPatient.isAdult());
    }
}