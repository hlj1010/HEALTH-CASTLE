
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TreatmentDatabase {
	Hashtable treatmentList;
	public static TreatmentDatabase instance;
	int count = 0;
	// public TreatmentDatabase(){
	// treatmentList = new Hashtable();
	// Treatment treatment = new Treatment("Jhon Michael", "A47510969");
	// Treatment treatment1 = new Treatment("Jacky Dianel", "A47510970");
	// Treatment treatment2 = new Treatment("Susan Robert", "A47510971");
	// treatment.addMedicineTaken("A1000",3.0);
	// treatment.addMedicineTaken("A1003",1.0);
	// treatment1.addMedicineTaken("A1002",2.0);
	// treatment2.addMedicineTaken("A1004",4.0);
	// addTreatment(treatment);
	// addTreatment(treatment1);
	// addTreatment(treatment2);
	// }

	public TreatmentDatabase() {
		treatmentList = new Hashtable<Integer, Treatment>();
		addTreatment(new Treatment("Alice", "Rui Zhu", new InPatientInfo("Rui Zhu", "11/11/2018", "100", "1", "2"),
				new OutPatientInfo()));
		addTreatment(new Treatment("Bob", "Rui Zhu", new InPatientInfo("Rui Zhu", "11/15/2018", "100", "2", "5"),
				new OutPatientInfo("Emergency", "11/23/2018")));
	}

	public static synchronized TreatmentDatabase getInstance() {
		if (instance != null) {
			System.out.println("Treatment Database already exists");
		}
		if (instance == null) {
			instance = new TreatmentDatabase();
			System.out.println("Constructing Treatment Database.");
		}

		return instance;
	}

	public void addTreatment(Treatment treatment) {
		treatmentList.put(count, treatment);
		count = count + 1;
	}

	public Boolean validation(String patientID, MedicineDatabase medicineDatabase) {
		HashtableIterator iterator = new HashtableIterator(treatmentList);
		Boolean valid = false;
		while (iterator.hasNext()) {
			Treatment treatment = (Treatment) iterator.next();

			if (treatment != null) {
				System.out.println("treatment1: " + treatment.patientName);
				if (treatment.patientName.equals(patientID)) {
					valid = true;
					break;
				} else {
					valid = false;
				}
			}
		}
		return valid;
	}

	public Treatment findTreatment(String patientName) {
		Treatment treatmentNow = null;
		HashtableIterator iterator = new HashtableIterator(treatmentList);
		while (iterator.hasNext()) {
			Treatment treatment = (Treatment) iterator.next();
			if (treatment.patientName.equals(patientName)) {
				treatmentNow = treatment;
				break;
			}
		}
		return treatmentNow;
	}

	public Double findTreatmentPrice(String patientName, MedicineDatabase medicineDatabase) {
		Double subtotal = 0.0;
		HashtableIterator iterator = new HashtableIterator(treatmentList);
		while (iterator.hasNext()) {
			Treatment treatment = (Treatment) iterator.next();
			if (treatment.patientName.equals(patientName)) {
				Iterator<Entry<String, Double>> iter = treatment.medicineTaken.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry<String, Double> entry = (Map.Entry<String, Double>) iter.next();
					String medicineName = entry.getKey();
					Double quantity = entry.getValue();
					subtotal = subtotal + medicineDatabase.findMedicine(medicineName, quantity);
				}
			}
		}
		return subtotal;
	}

	public void printPatient(String doctorName) {
		Treatment current = null;
		HashtableIterator iterator = new HashtableIterator(treatmentList);
		while (iterator.hasNext()) {
			current = (Treatment) iterator.next();
			if (current.doctorName.equals(doctorName))
				System.out.println("Patient name: " + current.getPatientName());
		}
	}
}
