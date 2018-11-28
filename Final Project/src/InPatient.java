import java.util.Scanner;

public class InPatient extends Patient {

	String admitDate;
	String wardNumber;
	String roomNumber;
	String bedNumber;
	String patientType = "In Patient";

	public InPatient() {
		while(!this.done) {
			this.getPatientDetails();
		}
		this.setPatientType(patientType);
		this.getInPatientDetails();
	}

	public void getInPatientDetails() {
		Scanner userInput1 = new Scanner(System.in);
		while(true) {
			System.out.println("Start filling the information, enter 'q' to cancelled this attempt");
			System.out.println("Enter Admit Date: ");
			String Input1 = userInput1.nextLine();
			if(Input1.equals("q")) {
				System.out.println("This attempt has been cancelled. ");
				continue;
			}
			this.setAdmitDate(Input1);

			System.out.println("Enter Ward Number: ");
			Input1 = userInput1.nextLine();
			if(Input1.equals("q")) {
				System.out.println("This attempt has been cancelled. ");
				continue;
			}
			this.setWardNumber(Input1);

			System.out.println("Enter Room Number: ");
			Input1 = userInput1.nextLine();
			if(Input1.equals("q")) {
				System.out.println("This attempt has been cancelled. ");
				continue;
			}
			this.setRoomNumber(Input1);

			System.out.println("Enter Bed Number: ");
			Input1 = userInput1.nextLine();
			if(Input1.equals("q")) {
				System.out.println("This attempt has been cancelled. ");
				continue;
			}
			this.setBedNumber(Input1);
			break;
			
		}
		// userInput1.close();
	}

	public void setInPatientDetails(String name, String patientId, int age, String gender, String address,
			String contactNumber, String registrationDate, String doctorName, String admitDate, String wardNumber,
			String roomNumber, String bedNumber) {
		this.setName(name);
		this.setPatientId(patientId);
		this.setAge(age);
		this.setGender(gender);
		this.setAddress(address);
		this.setContactNumber(contactNumber);
		this.setRegistrationDate(registrationDate);
		this.setDoctorName(doctorName);
		this.setAdmitDate(admitDate);
		this.setWardNumber(wardNumber);
		this.setRoomNumber(roomNumber);
		this.setBedNumber(bedNumber);
	}

	public String getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}

	public String getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(String wardNumber) {
		this.wardNumber = wardNumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
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
		System.out.println("Admit Date: " + this.getAdmitDate());
		System.out.println("Ward Number: " + this.getWardNumber());
		System.out.println("Room Number: " + this.getRoomNumber());
		System.out.println("Bed Number: " + this.getBedNumber());
	}
}
