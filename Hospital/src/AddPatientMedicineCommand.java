import java.util.Scanner;

public class AddPatientMedicineCommand implements Command {
	MedicalSystem ms;

	public AddPatientMedicineCommand(MedicalSystem ms) {
		this.ms = ms;
	}

	public String getDescription() {
		return "Modify Patient's Medicine";
	}

	public void execute() {
		while (true) {
			Scanner user = new Scanner(System.in);
			System.out.println("Please enter the patient name");
			String patientName = user.nextLine();
			Treatment current = ms.treatmentDatabase.findTreatment(patientName);
			if (current == null) {
				System.out.println("Cannot find the treatment.");
				continue;
			}
			System.out.println("Please enter the medicine ID");
			String medicineId = user.nextLine();
			double total = ms.medicineDatabase.findMedicineQuantity(medicineId);
			System.out.println("Please enter the quantity adding to the patient");
			double quantity = Double.parseDouble(user.nextLine());
			if (quantity > total) {
				System.out.println("This medicine is not enough in store.");
				break;
			} else {
				ms.treatmentDatabase.findTreatment(patientName).addMedicineTaken(medicineId, quantity);
				ms.medicineDatabase.quantityChange(medicineId, quantity);
				System.out.println("Medicine adds successfully.");
				break;
			}

		}
	}
}
