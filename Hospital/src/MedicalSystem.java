import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MedicalSystem {
	Boolean valid = false;
	String name;
	String birth;
	PatientDescription patientNow;
	Doctor doctorNow;
	InPatientInfo inpatientNow = new InPatientInfo();
	OutPatientInfo outpatientNow = new OutPatientInfo();
	String patientID;
	String doctorId;
	String password;
	Treatment treatmentNow;
	public static MedicalSystem instance;
	DoctorDatabase doctordatabase = DoctorDatabase.getInstance();
	PatientDatabase patientdatabase = PatientDatabase.getInstance();
	MedicineDatabase medicineDatabase = MedicineDatabase.getInstance();
	TreatmentDatabase treatmentDatabase = TreatmentDatabase.getInstance();

	public static synchronized MedicalSystem getInstance() {
		if (instance != null) {
			System.out.println("Medical System already exists");
		}
		if (instance == null) {
			instance = new MedicalSystem();
			System.out.println("new Medical System is constructed.");
		}

		return instance;
	}

	public void checkValid(TreatmentDatabase treatmentDatabase) {
		valid = false;
		while (valid == false) {
			System.out.println("Enter Patient ID:");
			Scanner scanner = new Scanner(System.in);
			patientID = scanner.next();
			valid = treatmentDatabase.validation(patientID, medicineDatabase);
			if (valid.equals(false)) {
				System.out.println("PatientID not found, Enter again!");
			}
		}
	}

	public void displayTreatment(TreatmentDatabase treatmentDatabase) {
		treatmentNow = treatmentDatabase.findTreatment(patientID);
		System.out.println("Receipt for patient");
		PatientDescription p = patientdatabase.findPatient(patientID);
		System.out.println("Patient name:" + p.getName() + "      Doctor name:" + treatmentNow.getDoctorName());
		Iterator<Entry<String, Double>> iter = treatmentNow.medicineTaken.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Double> entry = (Map.Entry<String, Double>) iter.next();
			String medicineID = entry.getKey();
			Double quantity = entry.getValue();
			System.out.println(medicineID + "    " + medicineDatabase.findMedicineName(medicineID) + "    " + quantity);
		}
	}

	public void displayPrice(TreatmentDatabase treatmentDatabase) {
		System.out.println("Total price is: $" + treatmentDatabase.findTreatmentPrice(patientID, medicineDatabase));
	}

	public void payment(TreatmentDatabase treatmentDatabase, String type) {
		if (type.equals("debit")) {
			boolean isCardValid = false;
			String debitcardNumberString = null;

			System.out.println("Enter Debit Card Number:");
			Scanner scanner = new Scanner(System.in);

			debitcardNumberString = scanner.next();

			if (isCardValid = validateCard(debitcardNumberString)) {
				System.out.println("Debit card valid.");
			} else {
				System.out.println("Debit card invalid.");
			}

			while (!isCardValid) {
				System.out.println("Enter Debit Card Number:");
				Scanner scanner1 = new Scanner(System.in);

				debitcardNumberString = scanner1.next();

				if (isCardValid = validateCard(debitcardNumberString)) {
					System.out.println("Debit card valid.");
					return;
				} else {
					System.out.println("Debit card invalid.");
				}
			}
		}

		else if (type.equals("credit")) {
			boolean isCardValid = false;
			String creditcardNumberString = null;

			System.out.println("Enter Credit Card Number:");
			Scanner scanner = new Scanner(System.in);

			creditcardNumberString = scanner.next();

			if (isCardValid = validateCard(creditcardNumberString)) {
				System.out.println("Credit card valid.");
				return;
			} else {
				System.out.println("Credit card invalid.");
			}

			while (!isCardValid) {
				System.out.println("Enter Credit Card Number:");
				Scanner scanner1 = new Scanner(System.in);

				creditcardNumberString = scanner1.next();

				if (isCardValid = validateCard(creditcardNumberString)) {
					System.out.println("Credit card valid.");
					return;
				} else {
					System.out.println("Credit card invalid.");
				}
			}
		}

		else if (type.equals("cash")) {
			System.out.print("Enter cash you received:");
			Scanner scanner = new Scanner(System.in);
			String cash = scanner.next();
			double money = Double.valueOf(cash) - treatmentDatabase.findTreatmentPrice(patientID, medicineDatabase);
			System.out.println("You should give patient: $" + String.format("%.2f", money));
		}
	}

	public boolean validateCard(String cardNumber) {
		try {
			// double number = Double.parseDouble(cardNumber);
			int number = Integer.parseInt(cardNumber);
		} catch (NumberFormatException numforex) {
			return false;
		}

		return true;
	}

	public void inventoryChange(TreatmentDatabase treatmentDatabase, MedicineDatabase medicineDatabase,
			MedicalSystem medicalSystem) {
		treatmentNow = treatmentDatabase.findTreatment(patientID);
		Iterator<Entry<String, Double>> iter = treatmentNow.medicineTaken.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Double> entry = (Map.Entry<String, Double>) iter.next();
			String medicineID = entry.getKey();
			Double quantity = entry.getValue();
			medicineDatabase.quantityChange(medicineID, quantity);
			System.out.println(medicineID + "    " + medicineDatabase.findMedicineQuantity(medicineID));
		}
	}

	public boolean doctorLogin(String doctorId, String password) {
		Doctor current = doctordatabase.doctorLogin(doctorId, password);
		if (current == null) {
			System.out.println("The ID or password is wrong. Please try again.");
			return false;
		} else {
			System.out.println("Login successfully.");
			doctorNow = current;
			return true;
		}
	}

}
