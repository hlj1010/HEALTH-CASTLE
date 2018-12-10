import java.util.Scanner;
import java.util.regex.Pattern;

public class AddMedicineCommand implements Command {
	MedicalSystem ms;

	public AddMedicineCommand(MedicalSystem ms) {
		this.ms = ms;
	}

	public String getDescription() {
		return "Add/modify Medicine";
	}

	public void execute() {// String medicineID, String medicineName, Double price, Double quantity
		Scanner user = new Scanner(System.in);
		System.out.println("Please enter the medicine name");
		String medicineName = user.nextLine();
		System.out.println("Please enter the medicine ID");
		String medicineID = user.nextLine();
		if (ms.medicineDatabase.findMedicineName(medicineID).equals(medicineName)) {
			System.out.println("This medicine is in the database. Start modifying");
			while (true) {
				System.out.println("Please enter the medicine price");
				String price = user.nextLine();

				if (isDouble(price)) {
					double mprice = Double.parseDouble(price);
					ms.medicineDatabase.getMedicine(medicineID).setPrice(mprice);
					break;
				} else {
					System.out.println("Price invalid! Please Enter price in double type!");
				}
			}
			while (true) {
				System.out.println("Please enter the medicine quantity");
				String quantity = user.nextLine();
				if (isDouble(quantity)) {
					double mquantity = Double.parseDouble(quantity);
					ms.medicineDatabase.getMedicine(medicineID).setQuantity(mquantity);
					break;
				} else {
					System.out.println("Price invalid! Please Enter price in double type!");
				}

			}

		} else {
			double mprice, mquantity;
			System.out.println("This medicine is not in the database.");
			while (true) {
				System.out.println("Please enter the medicine price");
				String price = user.nextLine();

				if (isDouble(price)) {
					mprice = Double.parseDouble(price);
					break;
				} else {
					System.out.println("Price invalid! Please Enter price in double type!");
				}
			}
			while (true) {
				System.out.println("Please enter the medicine quantity");
				String quantity = user.nextLine();
				if (isDouble(quantity)) {
					mquantity = Double.parseDouble(quantity);
					break;
				} else {
					System.out.println("Price invalid! Please Enter price in double type!");
				}
			}
			ms.medicineDatabase.addMedicine(medicineID, medicineName, mprice, mquantity);
		}

	}

	private boolean isDouble(String str) {
		if (null == str || "".equals(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}
}
