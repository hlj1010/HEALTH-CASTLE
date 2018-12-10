
public class CheckPatientCommand implements Command {
	MedicalSystem medicalSystem;

	public String getDescription() {
		return "Check Patient";
	}

	public CheckPatientCommand(MedicalSystem medicalSystem) {
		this.medicalSystem = medicalSystem;
	}

	public void execute() {
		medicalSystem.treatmentDatabase.printPatient(medicalSystem.doctorNow.name);
	}
}
