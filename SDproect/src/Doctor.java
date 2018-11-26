import java.util.Scanner;

public abstract class Doctor {
	String doctorName;
	String doctorID;
	int age;
	String gender;
	String address;
	String contactNumber;
	String registrationDate;
	String department;
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void getDoctorDetails() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Start filling the information. To cancel this attempt please enter 'q'.");
		System.out.println("please enter the name: ");
		String Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			return;
		}
		this.setDoctorName(Input);

		System.out.println("Please enter the ID: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			return;
		}
		this.setDoctorID(Input);

		while (true) {
			System.out.println("Please enter the age: ");
			Input = userInput.nextLine();
			if(Input.equals("q")) {
				System.out.println("This attempt has been cancelled.");
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
				return;
			}
			if (isNumeric(Input) &&((Integer.parseInt(Input) == 1)||(Integer.parseInt(Input) == 2))){
				this.setGender(Integer.parseInt(Input));
				break;
			} else {
				System.out.println("The input is invalid. Please enter again.");
			}
		}
		

		System.out.println("Please enter the address: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			return;
		}
		this.setAddress(Input);

		System.out.println("Please enter the contact number: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			return;
		}
		this.setContactNumber(Input);

		System.out.println("Please enter the registration date: MM/DD/YYYY ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			return;
		}
		this.setRegistrationDate(Input);


		System.out.println("Please enter the department: ");
		Input = userInput.nextLine();
		if(Input.equals("q")) {
			System.out.println("This attempt has been cancelled.");
			return;
		}
		this.setDepartment(Input);
		
	
		// userInput.close();
	}

	public static boolean isNumeric(String str) {
		for (char a : str.toCharArray()) {
			if (!Character.isDigit(a))
				return false;
		}
		return true;
	}
	
	public void printDoctorDetails() {
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Doctor Details:");
		System.out.println("----------------");
		System.out.println("Name: " + this.getDoctorName());
		System.out.println("ID: " + this.getDoctorID());
		System.out.println("Department: " + this.getDepartment());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Address: " + this.getAddress());
		System.out.println("Contact Number: " + this.getContactNumber());
		System.out.println("Registration Date: " + this.getRegistrationDate());
	}
}
