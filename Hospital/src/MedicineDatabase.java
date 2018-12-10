import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MedicineDatabase {
	Hashtable<Integer, Medicine> medicineList;
	int count = 0;
	public static MedicineDatabase instance;

	public MedicineDatabase() {
		medicineList = new Hashtable();
		addMedicine("A1000", "Tylenol Cold&Flue", 4.97, 100.0);
		addMedicine("A1001", "Paracetamol", 8.98, 100.0);
		addMedicine("A1002", "Aspirin", 7.99, 100.0);
		addMedicine("A1003", "Aspirin", 9.99, 100.0);
		addMedicine("A1004", "Aleve", 6.58, 100.0);
	}

	public static synchronized MedicineDatabase getInstance() {
		if (instance != null) {
			System.out.println("Medicine Database already exists");
		}
		if (instance == null) {
			instance = new MedicineDatabase();
			System.out.println("Constructing Medicine Database.");
		}

		return instance;
	}

	public void addMedicine(String medicineID, String medicineName, double price, double quantity) {
		Medicine medicine = new Medicine(medicineID, medicineName, price, quantity);
		medicineList.put(count, medicine);
		count = count + 1;
	}

	public Medicine getMedicine(String medicineID) {
		Medicine med = null;

		Iterator<Entry<Integer, Medicine>> iter = medicineList.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, Medicine> entry = (Map.Entry<Integer, Medicine>) iter.next();
			Medicine medicine = entry.getValue();
			if (medicine.getID().equals(medicineID)) {
				med = medicine;
			}
		}
		return med;
	}

	public void quantityChange(String medicineID, double quantityUse) {
		Iterator<Integer> iterator = medicineList.keySet().iterator();
		while (iterator.hasNext()) {
			int key = (int) iterator.next();
			Medicine value = medicineList.get(key);
			if (value.getID().equals(medicineID)) {
				value.quantity = value.quantity - quantityUse;
			}
		}

	}

	public void print(HashtableIterator iterator) {
		System.out.println("--------MedicineList-------");
		while (iterator.hasNext()) {
			Medicine medicine = (Medicine) iterator.next();
			System.out.print(medicine.getID() + ", ");
			System.out.print(medicine.getName() + " -- ");
			System.out.println(medicine.getPrice());
		}
	}

	public String findMedicineName(String medicineID) {
		String medicineName = "Null";

		Iterator<Entry<Integer, Medicine>> iter = medicineList.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, Medicine> entry = (Map.Entry<Integer, Medicine>) iter.next();
			Medicine medicine = entry.getValue();
			if (medicine.getID().equals(medicineID)) {
				medicineName = medicine.getName();
			}
		}
		return medicineName;
	}

	public Double findMedicineQuantity(String medicineID) {

		Double medicineQuantity = 0.0;

		Iterator<Entry<Integer, Medicine>> iter = medicineList.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, Medicine> entry = (Map.Entry<Integer, Medicine>) iter.next();
			Medicine medicine = entry.getValue();
			if (medicine.getID().equals(medicineID)) {
				medicineQuantity = medicine.getQuantity();
			}
		}

		return medicineQuantity;
	}

	public Double findMedicine(String medicineID, Double quantity) {
		Iterator<Entry<Integer, Medicine>> iter = medicineList.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, Medicine> entry = (Map.Entry<Integer, Medicine>) iter.next();
			Medicine medicine = entry.getValue();
			if (medicine.getID() == medicineID) {
				return medicine.getPrice() * quantity;
			}
		}
		return (double) 0;
	}

	public void setPrice(Double price, Medicine medicine) {
		medicine.setPrice(price);
	}
}
