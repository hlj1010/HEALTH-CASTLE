import java.util.Scanner;

public abstract class Patient {
	String name;
	String patientId;
	int age;
	String gender;
	String address;
	String contactNumber;
	String registrationDate;
	String insurancePolicyID;
	String doctorName;
	String patientType;
	boolean done = false;
	boolean quit = false;
	public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setGender(int type) {
		if(type == 1) {
			gender = "male";
		}
		if(type == 2) {
			gender = "female";
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getInsurancePolicyID() {
		return insurancePolicyID;
	}

	public void setInsurancePolicyID(String insurancePolicyID) {
		this.insurancePolicyID = insurancePolicyID;
	}

	public void getPatientDetails() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Start filling the information. To cancel this attempt please enter 'q'.");
		System.out.println("please enter the name: ");
		String Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			quit = true;
			return;
		}
		this.setName(Input);

		System.out.println("Please enter the ID: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			quit = true;
			return;
		}
		this.setPatientId(Input);

		while (true) {
			System.out.println("Please enter the age: ");
			Input = userInput.nextLine();
			if(Input.equals("q")) {
				System.out.println("This attempt has been cancelled.");
				quit = true;
				return;
			}
			if (isNumeric(Input)) {
				this.setAge(Integer.parseInt(Input));
				break;
			} else {
				System.out.println("Age should be valid integer. Please enter again.");
			}
		}

		while (true) {
			System.out.println("Please select the gender: 1: Male; 2: Female ");
			Input = userInput.nextLine();
			if(Input.equals("q")) {
				System.out.println("This attempt has been cancelled.");
				quit = true;
				return;
			}
			if (isNumeric(Input) &&((Integer.parseInt(Input) == 1)||(Integer.parseInt(Input) == 2))){
				this.setGender(Integer.parseInt(Input));
				break;
			} else {
				System.out.println("The input is invalid. Please enter again.");
			}
		}

		System.out.println("Pelase enter the ddress: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			quit = true;
			return;
		}
		this.setAddress(Input);

		System.out.println("Please enter the contact number: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			quit = true;
			return;
		}
		this.setContactNumber(Input);

		System.out.println("Please enter the registration date: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			quit = true;
			return;
		}
		this.setRegistrationDate(Input);

		System.out.println("Please enter the doctor's name: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			quit = true;
			return;
		}
		this.setDoctorName(Input);

		System.out.println("Please enter the Insurance Policy ID: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			quit = true;
			return;
		}
		this.setInsurancePolicyID(Input);
		done = true;

		// userInput.close();
	}

	public static boolean isNumeric(String str) {
		for (char a : str.toCharArray()) {
			if (!Character.isDigit(a))
				return false;
		}
		return true;
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
	}
}
