
public class Medicine {

	String medicineID;
	String medicineName;
	Double price;
	Double quantity;

	public Medicine(String medicineID, String medicineName, Double price, Double quantity) {
		this.medicineName = medicineName;
		this.medicineID = medicineID;
		this.price = price;
		this.quantity = quantity;
	}

	public String getID() {
		return medicineID;
	}

	public String getName() {
		return medicineName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
}
