import java.util.Hashtable;

public class Treatment {
	Hashtable<String, Double> medicineTaken = new Hashtable();
	String patientName;
	String patientID;
	public Treatment(String patientName, String patientID){
		//this.medicineTaken = medicineTaken;
		this.patientName = patientName;
		this.patientID = patientID;
	}
	
	public void addMedicineTaken(String medicineID, Double quantity) 
	{
		medicineTaken.put(medicineID, quantity);
	}
	
}
