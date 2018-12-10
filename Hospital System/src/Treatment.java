import java.util.Hashtable;

public class Treatment {
	Hashtable<String, Double> medicineTaken = new Hashtable<String, Double>();
	String patientName;
	String doctorName;
	InPatientInfo ininfo;
	OutPatientInfo outinfo;

	public Treatment(String patientName, String doctorName, InPatientInfo ininfo, OutPatientInfo outinfo) {
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.ininfo = ininfo;
		this.outinfo = outinfo;
	}

	public String getPatientName() {
		return patientName;
	}

	public String getDoctorName() {
		return patientName;
	}

	public InPatientInfo getInPatientInfo() {
		return ininfo;
	}

	public OutPatientInfo getOutPatientInfo() {
		return outinfo;
	}

	public void addMedicineTaken(String medicineID, Double quantity) {
		Double current = medicineTaken.get(medicineID) == null ? 0 : medicineTaken.get(medicineID);
		medicineTaken.put(medicineID, current + quantity);
	}
}
