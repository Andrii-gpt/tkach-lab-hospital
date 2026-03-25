package hospital;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HospitalService {

    private final DataService dataService;

    public HospitalService(DataService dataService) {
        this.dataService = dataService;
    }

    public void exportDoctorsSortedByName(Hospital hospital, String fileName) throws IOException {
        List<Doctor> doctors = new ArrayList<>(hospital.getAllDoctors());
        doctors.sort(Comparator.comparing(Doctor::getName));
        dataService.exportDoctors(doctors, fileName);
    }

    public void exportPatientsSortedByAge(Hospital hospital, String fileName) throws IOException {
        List<Patient> patients = new ArrayList<>(hospital.getAllPatients());
        patients.sort(Comparator.comparingInt(Patient::getAge));
        dataService.exportPatients(patients, fileName);
    }

    public List<Doctor> importDoctors(String fileName) throws IOException {
        return dataService.importDoctors(fileName);
    }

    public List<Patient> importPatients(String fileName) throws IOException {
        return dataService.importPatients(fileName);
    }
}