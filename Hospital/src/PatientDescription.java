import java.util.Scanner;

public class PatientDescription {
	private static PatientDescription instance;
	String name;
	String patientId;
	String birthday;
	int age;
	String gender;
	String address;
	String contactNumber;
	String registrationDate;
	String insurancePolicyID;
	boolean quit = false;

	public PatientDescription() {

	}

	public static synchronized PatientDescription getInstance() {
		if (instance == null) {
			instance = new PatientDescription();
		}
		return instance;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
		if (type == 1) {
			gender = "male";
		}
		if (type == 2) {
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

	public String getInsurancePolicyID() {
		return insurancePolicyID;
	}

	public void setInsurancePolicyID(String insurancePolicyID) {
		this.insurancePolicyID = insurancePolicyID;
	}

	public void getPatientDetails() {
		Scanner userInput = new Scanner(System.in);
		while (true) {
			System.out.println("Start filling the information. To restart this attempt please enter 'q'.");
			System.out.println("please enter the name: ");
			String Input = userInput.nextLine();
			if (Input.equals("q")) {
				System.out.println("This attempt has been cancelled. ");
				continue;
			}
			this.setName(Input);

			System.out.println("Please enter the ID: ");
			Input = userInput.nextLine();
			if (Input.equals("q")) {
				System.out.println("This attempt has been cancelled.");
				continue;
			}
			this.setPatientId(Input);

			System.out.println("Please enter the birthday: MM/DD/YYYY");
			Input = userInput.nextLine();
			if (Input.equals("q")) {
				System.out.println("This attempt has been cancelled.");
				continue;
			}
			this.setBirthday(Input);

			while (true) {
				System.out.println("Please enter the age: ");
				Input = userInput.nextLine();
				if (Input.equals("q")) {
					System.out.println("This attempt has been cancelled.");
					quit = true;
					break;
				}
				if (isNumeric(Input)) {
					this.setAge(Integer.parseInt(Input));
					break;
				} else {
					System.out.println("Age should be valid integer. Please enter again.");
				}
			}
			if (quit)
				continue;

			while (true) {
				System.out.println("Please select the gender: 1: Male; 2: Female ");
				Input = userInput.nextLine();
				if (Input.equals("q")) {
					System.out.println("This attempt has been cancelled.");
					quit = true;
					break;
				}
				if ((Integer.parseInt(Input) == 1) || (Integer.parseInt(Input) == 2)) {
					this.setGender(Integer.parseInt(Input));
					break;
				} else {
					System.out.println("The input is invalid. Please enter again.");
				}
			}
			if (quit)
				continue;

			System.out.println("Pelase enter the ddress: ");
			Input = userInput.nextLine();
			if (Input.equals("q")) {
				System.out.println("This attempt has been cancelled.");
				continue;
			}
			this.setAddress(Input);

			System.out.println("Please enter the contact number: ");
			Input = userInput.nextLine();
			if (Input.equals("q")) {
				System.out.println("This attempt has been cancelled.");
				continue;
			}
			this.setContactNumber(Input);

			System.out.println("Please enter the registration date: ");
			Input = userInput.nextLine();
			if (Input.equals("q")) {
				System.out.println("This attempt has been cancelled.");
				continue;
			}
			this.setRegistrationDate(Input);

			System.out.println("Please enter the Insurance Policy ID: ");
			Input = userInput.nextLine();
			if (Input.equals("q")) {
				System.out.println("This attempt has been cancelled.");
				continue;
			}
			this.setInsurancePolicyID(Input);
			System.out.println("New patient information has been saved!");
			break;
		}

	}

	public static boolean isNumeric(String str) {
		for (char a : str.toCharArray()) {
			if (!Character.isDigit(a))
				return false;
		}
		return true;
	}

	public PatientDescription(String name, String patientId, String birthday, int age, String gender, String address,
			String contactNumber, String registrationDate, String insurancePolicyID) {
		this.name = name;
		this.patientId = patientId;
		this.birthday = birthday;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.contactNumber = contactNumber;
		this.registrationDate = registrationDate;
		this.insurancePolicyID = insurancePolicyID;
	}

	public void printPatientDetails() {
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Patient Details:");
		System.out.println("----------------");
		System.out.println("Patient ID: " + this.getPatientId());
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Birthday: " + this.getBirthday());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Address: " + this.getAddress());
		System.out.println("Contact Number: " + this.getContactNumber());
		System.out.println("Registration Date: " + this.getRegistrationDate());
		System.out.println("Insurance Policy ID: " + this.getInsurancePolicyID());
	}
}
