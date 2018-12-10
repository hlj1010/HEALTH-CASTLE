import java.util.Scanner;

public class HCS {
	public static void main(String[] args) {
		MedicalSystem medicalSystem = MedicalSystem.getInstance();

		Scanner userInput = new Scanner(System.in);
		System.out.println("-------------------------------------");
		System.out.println("--Welcome to the Health Care System--");
		while (true) {
			System.out.println("-------------------------------------");
			System.out.println("Please select mode:");
			System.out.println("[Option 1] Patient");
			System.out.println("[Option 2] Doctor");
			String input = userInput.nextLine();
			if (input.equals("1")) {// patient mode
				System.out.println("Please enter your name");
				medicalSystem.name = userInput.nextLine();
				System.out.println("Please enter your birth date (MM/DD/YYYY)");
				medicalSystem.birth = userInput.nextLine();
				NewPatientRegisterCommand newpatient = new NewPatientRegisterCommand(medicalSystem);
				newpatient.execute();

				System.out.println("------------------------------");
				System.out.println("Please select the action:");

				InPatientRegisterCommand inpatient = new InPatientRegisterCommand(medicalSystem);
				OutPatientRegisterCommand outpatient = new OutPatientRegisterCommand(medicalSystem);
				MakePaymentCommand makepayment = new MakePaymentCommand(medicalSystem);
				RemoteControl remotecontrol = new RemoteControl(3);

				remotecontrol.setCommand(0, inpatient);
				remotecontrol.setCommand(1, outpatient);
				remotecontrol.setCommand(2, makepayment);
				System.out.println(remotecontrol.toString());
				String option = userInput.nextLine();
				// remoteControl
				remotecontrol.ButtonWasPushed(Integer.parseInt(option) - 1);
				System.out.println("Back to the home page.");
			}
			if (input.equals("2")) {// doctor mode
				System.out.println("Please enter your doctor ID and password");
				System.out.println("Doctor ID:");
				medicalSystem.doctorId = userInput.nextLine();
				System.out.println("Password:");
				medicalSystem.password = userInput.nextLine();
				boolean valid = medicalSystem.doctorLogin(medicalSystem.doctorId, medicalSystem.password);
				if (!valid)
					continue;
				medicalSystem.doctorNow = medicalSystem.doctordatabase.findDoctor(medicalSystem.doctorId);
				RemoteControl remotecontrol = new RemoteControl(4);

				CheckPatientCommand checkpatient = new CheckPatientCommand(medicalSystem);
				AddMedicineCommand addmedicine = new AddMedicineCommand(medicalSystem);
				AddNewTreatmentCommand addtreatment = new AddNewTreatmentCommand(medicalSystem);
				AddPatientMedicineCommand addpatientmedicine = new AddPatientMedicineCommand(medicalSystem);
				System.out.println("------------------------------");
				System.out.println("Please select the action:");
				remotecontrol.setCommand(0, checkpatient);
				remotecontrol.setCommand(1, addmedicine);
				remotecontrol.setCommand(2, addtreatment);
				remotecontrol.setCommand(3, addpatientmedicine);
				System.out.println(remotecontrol.toString());
				String option = userInput.nextLine();
				remotecontrol.ButtonWasPushed(Integer.parseInt(option) - 1);
				System.out.println("Back to the home page.");
			}

		}

	}
}
