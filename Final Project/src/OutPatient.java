import java.util.Scanner;

public class OutPatient extends Patient{
	
	String department;
	String dischargeDate;
	String patientType = "Out Patient";
	
	public OutPatient() {
		while(!this.done) {
			this.getPatientDetails();
		}
		this.setPatientType(patientType);
		this.getOutPatientDetails();
	}
	
	public void getOutPatientDetails() {
		//this.getPatientDetails();
		
		Scanner userInput2 = new Scanner(System.in);
		
		while(true) {
			System.out.println("Start filling the information, enter 'q' to cancelled this attempt");
			System.out.println("Please enter the department: ");
			String Input2 = userInput2.nextLine();
			if(Input2.equals("q")) {
				System.out.println("This attempt has been cancelled. ");
				continue;
			}
			this.setDepartment(Input2);

			System.out.println("Please enter the discharge date: MM/DD/YYYY ");
			Input2 = userInput2.nextLine();
			if(Input2.equals("q")) {
				System.out.println("This attempt has been cancelled. ");
				continue;
			}
			this.setDischargeDate(Input2);
			break;
		}		
		//userInput2.close();
	}
	
	public void setOutPatientDetails(String name, String patientId, int age, String gender, String address,
					String contactNumber, String registrationDate, String doctorName, String department) {
		this.setName(name);
		this.setPatientId(patientId);
		this.setAge(age);
		this.setGender(gender);
		this.setAddress(address);
		this.setContactNumber(contactNumber);
		this.setRegistrationDate(registrationDate);
		this.setDoctorName(doctorName);
		this.setDepartment(department);
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
		System.out.println("Patient ID: " + this.getPatientId());
		System.out.println("Patient Type: " + this.getPatientType());
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Address: " + this.getAddress());
		System.out.println("Contact Number: " + this.getContactNumber());
		System.out.println("Registration Date: " + this.getRegistrationDate());
		System.out.println("Doctor: " + this.getDoctorName());
		System.out.println("Insurance Policy ID: " + this.getInsurancePolicyID());
		System.out.println("Department: " + this.getDepartment());
		System.out.println("Discharge Date: " + this.getDischargeDate());
	}
}
