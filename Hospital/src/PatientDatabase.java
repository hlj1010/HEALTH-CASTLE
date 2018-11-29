import java.util.Hashtable;

public class PatientDatabase {
	Hashtable<Integer, PatientDescription> patientList;
	public static PatientDatabase instance;
	int count = 0;

	public static synchronized PatientDatabase getInstance() {
		if (instance != null) {
			System.out.println("Patient Database already exists");
		}
		if (instance == null) {
			instance = new PatientDatabase();
			System.out.println("Constructing Patient Database.");
		}

		return instance;
	}

	public void addPatient(PatientDescription patient) {
		patientList.put(count, patient);
		count = count + 1;
	}

	public Boolean validation(String patientID) {
		HashtableIterator iterator = new HashtableIterator(patientList);
		Boolean valid = false;
		while (iterator.hasNext()) {
			PatientDescription current = (PatientDescription) iterator.next();
			if (current != null) {
				// System.out.println("Patient: " + current.patientId);
				if (current.patientId.equals(patientID)) {
					valid = true;
					break;
				} else {
					System.out.println("Cannot find the patient.");
					valid = false;
				}
			}
		}
		return valid;
	}

	public PatientDescription findPatient(String patientID) {
		PatientDescription current = null;
		HashtableIterator iterator = new HashtableIterator(patientList);
		while (iterator.hasNext()) {
			current = (PatientDescription) iterator.next();
			if (current.patientId.equals(patientID))
				break;
		}
		return current;
	}

	public PatientDescription findOldPatient(String name, String birthday) {
		PatientDescription current = null;
		HashtableIterator iterator = new HashtableIterator(patientList);
		while (iterator.hasNext()) {
			current = (PatientDescription) iterator.next();
			if (current.name.equals(name) && current.birthday.equals(birthday))
				break;
		}
		return current;
	}
}
