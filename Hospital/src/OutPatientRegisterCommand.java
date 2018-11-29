public class OutPatientRegisterCommand implements Command {
	OutPatientInfo outInfo;

	public OutPatientRegisterCommand(OutPatientInfo outInfo) {
		this.outInfo = outInfo;
	}

	public void execute() {
		outInfo.getOutPatientDetails();
	}

}
