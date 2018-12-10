import java.util.Hashtable;

public class DoctorDatabase {
	Hashtable<Integer, Doctor> doctorList;
	public static DoctorDatabase instance;
	int count = 0;

	public DoctorDatabase() {
		doctorList = new Hashtable<Integer, Doctor>();
		addDoctor(new Doctor("Rui Zhu", "902830782", 25, "Male", "Fit", "111-1111-1111", "12345", "Emergency"));
	}

	public static synchronized DoctorDatabase getInstance() {
		if (instance != null) {
			System.out.println("Doctor Database already exists");
		}
		if (instance == null) {
			instance = new DoctorDatabase();
			System.out.println("Constructing Patient Database.");
		}

		return instance;
	}

	public void addDoctor(Doctor doctor) {
		doctorList.put(count, doctor);
		count = count + 1;
	}

	public Doctor findDoctor(String doctorId) {
		Doctor doctorNow = null;
		HashtableIterator iterator = new HashtableIterator(doctorList);
		while (iterator.hasNext()) {
			Doctor doctor = (Doctor) iterator.next();
			if (doctor.doctorId.equals(doctorId)) {
				doctorNow = doctor;
				break;
			}
		}
		return doctorNow;
	}

	public Doctor doctorLogin(String doctorId, String password) {
		Doctor doctor = null;
		HashtableIterator iterator = new HashtableIterator(doctorList);
		while (iterator.hasNext()) {
			Doctor curr = (Doctor) iterator.next();
			if (curr.doctorId.equals(doctorId) && curr.password.equals(password)) {
				doctor = curr;
				break;
			}
		}
		return doctor;
	}
}
