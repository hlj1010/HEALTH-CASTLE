import java.util.Hashtable;

public class PatientDatabase {
	Hashtable<Integer, PatientDescription> patientList;
	public static PatientDatabase instance;
	int count = 0;

	public PatientDatabase() {
		patientList = new Hashtable<Integer, PatientDescription>();
		addPatient(new PatientDescription("Alice", "2018001", "01/01/1993", 25, "Female", "FIT", "222-2222-2222",
				"11/5/2018", "12345"));
		addPatient(new PatientDescription("Bob", "2018002", "01/02/1993", 25, "Male", "FIT", "333-3333-3333",
				"11/8/2018", "54321"));
	}

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
		PatientDescription find = null;
		HashtableIterator iterator = new HashtableIterator(patientList);
		while (iterator.hasNext()) {
			PatientDescription current = (PatientDescription) iterator.next();
			if (current.name.equals(name) && current.birthday.equals(birthday)) {
				find = current;
				break;
			}
		}
		return find;
	}

}
