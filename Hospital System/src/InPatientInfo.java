import java.util.Scanner;

public class InPatientInfo {
	String doctorName;
	String admitDate;
	String wardNumber;
	String roomNumber;
	String bedNumber;

	public InPatientInfo() {

	}

	public InPatientInfo(String doctorName, String admitDate, String wardNumber, String roomNumber, String bedNumber) {
		this.doctorName = doctorName;
		this.admitDate = admitDate;
		this.wardNumber = wardNumber;
		this.roomNumber = roomNumber;
		this.bedNumber = bedNumber;
	}

	public void getInPatientDetails() {
		Scanner userInput1 = new Scanner(System.in);
		System.out.println("Enter DoctorName: ");
		String Input1 = userInput1.nextLine();
		this.setDoctorName(Input1);

		System.out.println("Enter Admit Date: ");
		Input1 = userInput1.nextLine();
		this.setAdmitDate(Input1);

		System.out.println("Enter Ward Number: ");
		Input1 = userInput1.nextLine();
		this.setWardNumber(Input1);

		System.out.println("Enter Room Number: ");
		Input1 = userInput1.nextLine();
		this.setRoomNumber(Input1);

		System.out.println("Enter Bed Number: ");
		Input1 = userInput1.nextLine();
		this.setBedNumber(Input1);
		// userInput1.close();
	}

	public void setInPatientDetails(String doctorName, String admitDate, String wardNumber, String roomNumber,
			String bedNumber) {
		this.setDoctorName(doctorName);
		this.setAdmitDate(admitDate);
		this.setWardNumber(wardNumber);
		this.setRoomNumber(roomNumber);
		this.setBedNumber(bedNumber);
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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
		System.out.println("Doctor Name: " + this.getDoctorName());
		System.out.println("Admit Date: " + this.getAdmitDate());
		System.out.println("Ward Number: " + this.getWardNumber());
		System.out.println("Room Number: " + this.getRoomNumber());
		System.out.println("Bed Number: " + this.getBedNumber());
	}
}
