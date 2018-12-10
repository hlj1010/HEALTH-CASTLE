public class OutPatientRegisterCommand implements Command {
	MedicalSystem ms;

	public OutPatientRegisterCommand(MedicalSystem ms) {
		this.ms = ms;
	}

	public String getDescription() {
		return "Patient discharge Registration";
	}

	public void execute() {
		Treatment current = ms.treatmentDatabase.findTreatment(ms.patientNow.getName());
		if (current == null) {
			System.out.println("Cannot find treatment for this patient.");
			return;
		}
		OutPatientInfo outinfo = ms.treatmentDatabase.findTreatment(ms.name).outinfo;
		if (outinfo.valid()) {
			System.out.println("You have  already discharged from hospital.");
			return;
		}
		ms.treatmentDatabase.findTreatment(ms.name).outinfo.getOutPatientDetails();
		System.out.println("Discharge register successfully!");
	}

}
