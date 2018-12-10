
public class NewPatientRegisterCommand implements Command {
	MedicalSystem ms;

	public NewPatientRegisterCommand(MedicalSystem ms) {
		this.ms = ms;
	}

	public String getDescription() {
		return "Create New Patient";
	}

	public void execute() {
		PatientDescription current = ms.patientdatabase.findOldPatient(ms.name, ms.birth);
		if (current == null) {
			System.out.println("The patient is new here.");
			current = new PatientDescription();
			current.getPatientDetails();
			ms.patientdatabase.addPatient(current);
		} else {
			System.out.println("The patient is existed.");
			ms.patientID = current.getPatientId();
		}
		ms.patientNow = current;
	}
}
