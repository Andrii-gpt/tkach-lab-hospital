package hospital;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();


    public void addDoctor(Doctor doctor) {
        if (doctor != null && getDoctorById(doctor.getId()) == null) {
            doctors.add(doctor);
        }
    }

    public void addPatient(Patient patient) {
        if (patient != null && getPatientById(patient.getId()) == null) {
            patients.add(patient);
        }
    }


    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors);
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }


    public boolean updateDoctor(int id, String newName, String newSpecialization) {
        Doctor doctor = getDoctorById(id);

        if (doctor == null) {
            return false;
        }

        doctor.setName(newName);
        doctor.setSpecialization(newSpecialization);
        return true;
    }

    public boolean updatePatient(int id, String newName, int newAge) {
        Patient patient = getPatientById(id);

        if (patient == null) {
            return false;
        }

        patient.setName(newName);
        patient.setAge(newAge);
        return true;
    }


    public boolean removeDoctorById(int id) {
        Doctor doctor = getDoctorById(id);

        if (doctor == null) {
            return false;
        }

        doctors.remove(doctor);
        return true;
    }

    public boolean removePatientById(int id) {
        Patient patient = getPatientById(id);

        if (patient == null) {
            return false;
        }

        patients.remove(patient);
        return true;
    }


    public List<Doctor> findDoctorsBySpecialization(String specialization) {
        List<Doctor> result = new ArrayList<>();

        for (Doctor doctor : doctors) {
            if (doctor.hasSpecialization(specialization)) {
                result.add(doctor);
            }
        }

        return result;
    }

    public boolean bookAppointment(int doctorId, int patientId) {
        Doctor doctor = getDoctorById(doctorId);
        Patient patient = getPatientById(patientId);

        return doctor != null && patient != null;
    }
}