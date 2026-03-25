package hospital;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        DataService dataService = new DataService();
        HospitalService hospitalService = new HospitalService(dataService);

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Оберіть пункт меню: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDoctor(hospital, scanner);
                    break;
                case 2:
                    addPatient(hospital, scanner);
                    break;
                case 3:
                    showAllDoctors(hospital);
                    break;
                case 4:
                    showAllPatients(hospital);
                    break;
                case 5:
                    findDoctorsBySpecialization(hospital, scanner);
                    break;
                case 6:
                    bookAppointment(hospital, scanner);
                    break;
                case 7:
                    updateDoctor(hospital, scanner);
                    break;
                case 8:
                    updatePatient(hospital, scanner);
                    break;
                case 9:
                    removeDoctor(hospital, scanner);
                    break;
                case 10:
                    removePatient(hospital, scanner);
                    break;
                case 11:
                    exportDoctors(hospitalService, hospital, scanner);
                    break;
                case 12:
                    exportPatients(hospitalService, hospital, scanner);
                    break;
                case 13:
                    importDoctors(hospitalService, hospital, scanner);
                    break;
                case 14:
                    importPatients(hospitalService, hospital, scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Програму завершено.");
                    break;
                default:
                    System.out.println("Невірний пункт меню.");
            }

            System.out.println();
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("===== МЕНЮ ЛІКАРНІ =====");
        System.out.println("1. Додати лікаря");
        System.out.println("2. Додати пацієнта");
        System.out.println("3. Показати всіх лікарів");
        System.out.println("4. Показати всіх пацієнтів");
        System.out.println("5. Знайти лікарів за спеціалізацією");
        System.out.println("6. Записати пацієнта на прийом");
        System.out.println("7. Оновити лікаря");
        System.out.println("8. Оновити пацієнта");
        System.out.println("9. Видалити лікаря");
        System.out.println("10. Видалити пацієнта");
        System.out.println("11. Експортувати лікарів у файл");
        System.out.println("12. Експортувати пацієнтів у файл");
        System.out.println("13. Імпортувати лікарів з файлу");
        System.out.println("14. Імпортувати пацієнтів з файлу");
        System.out.println("0. Вийти");
    }

    public static void addDoctor(Hospital hospital, Scanner scanner) {
        System.out.print("Введіть ID лікаря: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введіть ім'я лікаря: ");
        String name = scanner.nextLine();

        System.out.print("Введіть спеціалізацію лікаря: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization);
        hospital.addDoctor(doctor);

        System.out.println("Лікаря додано.");
    }

    public static void addPatient(Hospital hospital, Scanner scanner) {
        System.out.print("Введіть ID пацієнта: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введіть ім'я пацієнта: ");
        String name = scanner.nextLine();

        System.out.print("Введіть вік пацієнта: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Patient patient = new Patient(id, name, age);
        hospital.addPatient(patient);

        System.out.println("Пацієнта додано.");
    }

    public static void showAllDoctors(Hospital hospital) {
        List<Doctor> doctors = hospital.getAllDoctors();

        if (doctors.isEmpty()) {
            System.out.println("Список лікарів порожній.");
            return;
        }

        System.out.println("Список лікарів:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public static void showAllPatients(Hospital hospital) {
        List<Patient> patients = hospital.getAllPatients();

        if (patients.isEmpty()) {
            System.out.println("Список пацієнтів порожній.");
            return;
        }

        System.out.println("Список пацієнтів:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public static void findDoctorsBySpecialization(Hospital hospital, Scanner scanner) {
        System.out.print("Введіть спеціалізацію для пошуку: ");
        String specialization = scanner.nextLine();

        List<Doctor> doctors = hospital.findDoctorsBySpecialization(specialization);

        if (doctors.isEmpty()) {
            System.out.println("Лікарів з такою спеціалізацією не знайдено.");
            return;
        }

        System.out.println("Знайдені лікарі:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public static void bookAppointment(Hospital hospital, Scanner scanner) {
        System.out.print("Введіть ID лікаря: ");
        int doctorId = scanner.nextInt();

        System.out.print("Введіть ID пацієнта: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        boolean success = hospital.bookAppointment(doctorId, patientId);

        if (success) {
            System.out.println("Пацієнта успішно записано на прийом.");
        } else {
            System.out.println("Запис неможливий: лікаря або пацієнта не знайдено.");
        }
    }

    public static void updateDoctor(Hospital hospital, Scanner scanner) {
        System.out.print("Введіть ID лікаря, якого потрібно оновити: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введіть нове ім'я лікаря: ");
        String newName = scanner.nextLine();

        System.out.print("Введіть нову спеціалізацію лікаря: ");
        String newSpecialization = scanner.nextLine();

        boolean success = hospital.updateDoctor(id, newName, newSpecialization);

        if (success) {
            System.out.println("Дані лікаря оновлено.");
        } else {
            System.out.println("Лікаря з таким ID не знайдено.");
        }
    }

    public static void updatePatient(Hospital hospital, Scanner scanner) {
        System.out.print("Введіть ID пацієнта, якого потрібно оновити: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введіть нове ім'я пацієнта: ");
        String newName = scanner.nextLine();

        System.out.print("Введіть новий вік пацієнта: ");
        int newAge = scanner.nextInt();
        scanner.nextLine();

        boolean success = hospital.updatePatient(id, newName, newAge);

        if (success) {
            System.out.println("Дані пацієнта оновлено.");
        } else {
            System.out.println("Пацієнта з таким ID не знайдено.");
        }
    }

    public static void removeDoctor(Hospital hospital, Scanner scanner) {
        System.out.print("Введіть ID лікаря, якого потрібно видалити: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean success = hospital.removeDoctorById(id);

        if (success) {
            System.out.println("Лікаря видалено.");
        } else {
            System.out.println("Лікаря з таким ID не знайдено.");
        }
    }

    public static void removePatient(Hospital hospital, Scanner scanner) {
        System.out.print("Введіть ID пацієнта, якого потрібно видалити: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean success = hospital.removePatientById(id);

        if (success) {
            System.out.println("Пацієнта видалено.");
        } else {
            System.out.println("Пацієнта з таким ID не знайдено.");
        }
    }

    public static void exportDoctors(HospitalService hospitalService, Hospital hospital, Scanner scanner) {
        System.out.print("Введіть назву файлу для експорту лікарів: ");
        String fileName = scanner.nextLine();

        try {
            hospitalService.exportDoctorsSortedByName(hospital, fileName);
            System.out.println("Лікарів успішно експортовано.");
        } catch (IOException e) {
            System.out.println("Помилка експорту лікарів: " + e.getMessage());
        }
    }

    public static void exportPatients(HospitalService hospitalService, Hospital hospital, Scanner scanner) {
        System.out.print("Введіть назву файлу для експорту пацієнтів: ");
        String fileName = scanner.nextLine();

        try {
            hospitalService.exportPatientsSortedByAge(hospital, fileName);
            System.out.println("Пацієнтів успішно експортовано.");
        } catch (IOException e) {
            System.out.println("Помилка експорту пацієнтів: " + e.getMessage());
        }
    }

    public static void importDoctors(HospitalService hospitalService, Hospital hospital, Scanner scanner) {
        System.out.print("Введіть назву файлу для імпорту лікарів: ");
        String fileName = scanner.nextLine();

        try {
            List<Doctor> importedDoctors = hospitalService.importDoctors(fileName);

            for (Doctor doctor : importedDoctors) {
                hospital.addDoctor(doctor);
            }

            System.out.println("Лікарів успішно імпортовано.");
        } catch (IOException e) {
            System.out.println("Помилка імпорту лікарів: " + e.getMessage());
        }
    }

    public static void importPatients(HospitalService hospitalService, Hospital hospital, Scanner scanner) {
        System.out.print("Введіть назву файлу для імпорту пацієнтів: ");
        String fileName = scanner.nextLine();

        try {
            List<Patient> importedPatients = hospitalService.importPatients(fileName);

            for (Patient patient : importedPatients) {
                hospital.addPatient(patient);
            }

            System.out.println("Пацієнтів успішно імпортовано.");
        } catch (IOException e) {
            System.out.println("Помилка імпорту пацієнтів: " + e.getMessage());
        }
    }
}