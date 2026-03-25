package hospital;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    public void exportDoctors(List<Doctor> doctors, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (Doctor doctor : doctors) {
            writer.write(doctor.getId() + "," + doctor.getName() + "," + doctor.getSpecialization());
            writer.newLine();
        }

        writer.close();
    }

    public List<Doctor> importDoctors(String fileName) throws IOException {
        List<Doctor> doctors = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String specialization = parts[2];

            doctors.add(new Doctor(id, name, specialization));
        }

        reader.close();
        return doctors;
    }

    public void exportPatients(List<Patient> patients, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (Patient patient : patients) {
            writer.write(patient.getId() + "," + patient.getName() + "," + patient.getAge());
            writer.newLine();
        }

        writer.close();
    }

    public List<Patient> importPatients(String fileName) throws IOException {
        List<Patient> patients = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int age = Integer.parseInt(parts[2]);

            patients.add(new Patient(id, name, age));
        }

        reader.close();
        return patients;
    }
}
