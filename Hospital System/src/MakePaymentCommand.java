
public class MakePaymentCommand implements Command {
	MedicalSystem ms;
	String patientName;
	TreatmentDatabase td;
	MedicineDatabase md;

	public MakePaymentCommand(MedicalSystem ms) {
		this.ms = ms;
		patientName = ms.patientNow.getName();
		td = ms.treatmentDatabase;
		md = ms.medicineDatabase;
	}

	public String getDescription() {
		return "Make Payment";
	}

	public void execute() {
		Treatment current = td.findTreatment(patientName);
		if (current == null) {
			System.out.println("Cannot find this treatment in database.");
		} else {
			System.out.println("The total price is " + td.findTreatmentPrice(patientName, md));

		}

	}
}
