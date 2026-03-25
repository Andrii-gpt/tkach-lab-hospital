package hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HospitalServiceTest {

    private DataService mockDataService;
    private HospitalService hospitalService;
    private Hospital hospital;

    @BeforeEach
    void setUp() {
        mockDataService = mock(DataService.class);
        hospitalService = new HospitalService(mockDataService);

        hospital = new Hospital();
        hospital.addDoctor(new Doctor(1, "Ivan", "Cardiologist"));
        hospital.addDoctor(new Doctor(2, "Anna", "Surgeon"));

        hospital.addPatient(new Patient(1, "Petro", 30));
        hospital.addPatient(new Patient(2, "Olha", 20));
    }

    @Test
    void testExportDoctorsSortedByName() throws IOException {
        hospitalService.exportDoctorsSortedByName(hospital, "doctors.csv");

        verify(mockDataService, times(1)).exportDoctors(anyList(), eq("doctors.csv"));
    }

    @Test
    void testExportPatientsSortedByAge() throws IOException {
        hospitalService.exportPatientsSortedByAge(hospital, "patients.csv");

        verify(mockDataService, times(1)).exportPatients(anyList(), eq("patients.csv"));
    }

    @Test
    void testImportDoctorsUsingMock() throws IOException {
        List<Doctor> mockDoctors = List.of(
                new Doctor(1, "Ivan", "Cardiologist")
        );

        when(mockDataService.importDoctors("doctors.csv")).thenReturn(mockDoctors);

        List<Doctor> result = hospitalService.importDoctors("doctors.csv");

        assertEquals(1, result.size());
        assertEquals("Ivan", result.get(0).getName());
    }

    @Test
    void testImportPatientsUsingMock() throws IOException {
        List<Patient> mockPatients = List.of(
                new Patient(1, "Olha", 20)
        );

        when(mockDataService.importPatients("patients.csv")).thenReturn(mockPatients);

        List<Patient> result = hospitalService.importPatients("patients.csv");

        assertEquals(1, result.size());
        assertEquals("Olha", result.get(0).getName());
    }
}