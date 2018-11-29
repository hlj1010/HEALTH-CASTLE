import java.util.Scanner;

public class InPatientInfo {
	String admitDate;
	String wardNumber;
	String roomNumber;
	String bedNumber;

	public void getInPatientDetails() {
		Scanner userInput1 = new Scanner(System.in);
		System.out.println("Enter Admit Date: ");
		String Input1 = userInput1.nextLine();
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

	public void setInPatientDetails(String admitDate, String wardNumber, String roomNumber, String bedNumber) {
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
		System.out.println("Admit Date: " + this.getAdmitDate());
		System.out.println("Ward Number: " + this.getWardNumber());
		System.out.println("Room Number: " + this.getRoomNumber());
		System.out.println("Bed Number: " + this.getBedNumber());
	}
}
