public class InPatientRegisterCommand implements Command {
	MedicalSystem ms;

	public InPatientRegisterCommand(MedicalSystem ms) {
		this.ms = ms;
	}

	public String getDescription() {
		return "Patient Admission Registration";
	}

	public void execute() {
		if (ms.treatmentDatabase.findTreatment(ms.patientNow.getName()) != null) {
			System.out.println("This patient has been admitted.");
			return;
		}
		ms.inpatientNow.getInPatientDetails();
		Treatment cur = new Treatment(ms.patientNow.getName(), ms.inpatientNow.getDoctorName(), ms.inpatientNow,
				ms.outpatientNow);
		ms.treatmentDatabase.addTreatment(cur);
		System.out.println("Admission registerd successfully!");
	}
}
