
public class PatientFactory {

	public Patient createPatient(String patientType) {

		Patient newPatient = null;

		if (patientType.toLowerCase().equals("admit")) {
			return new InPatient();
		} else

		if (patientType.toLowerCase().equals("discharge")) {
			return new OutPatient();
		} else

			return newPatient;
	}

}
