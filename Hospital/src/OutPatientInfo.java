import java.util.Scanner;

public class OutPatientInfo {
	String department;
	String dischargeDate;

	public void getOutPatientDetails() {
		Scanner userInput2 = new Scanner(System.in);
		System.out.println("Please enter the department: ");
		if (userInput2.hasNextLine()) {
			this.setDepartment(userInput2.nextLine());
		}
		System.out.println("Please enter Discharge date: ");
		if (userInput2.hasNextLine()) {
			this.setDischargeDate(userInput2.nextLine());
		}

	}

	public void setOutPatientDetails(String department, String dischargeDate) {
		this.setDepartment(department);
		this.setDischargeDate(dischargeDate);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public void printPatientDetails() {
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Patient Details:");
		System.out.println("----------------");
		System.out.println("Department: " + this.getDepartment());
		System.out.println("Discharge date: " + this.getDischargeDate());
	}
}
