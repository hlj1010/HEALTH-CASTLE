import java.util.Scanner;

public class AddNewTreatmentCommand implements Command {
	MedicalSystem medicalSystem;

	public AddNewTreatmentCommand(MedicalSystem medicalSystem) {
		this.medicalSystem = medicalSystem;
	}

	public String getDescription() {
		return "Add New Treatment";
	}

	public void execute() {
		Scanner user = new Scanner(System.in);
		System.out.println("Please enter patient name");
		String patientName = user.nextLine();
		medicalSystem.treatmentDatabase.addTreatment(
				new Treatment(patientName, medicalSystem.doctorNow.name, new InPatientInfo(), new OutPatientInfo()));
	}
}
