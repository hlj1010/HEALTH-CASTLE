public class InPatientResigterCommand implements Command {
	InPatientInfo inInfo;

	public InPatientResigterCommand(InPatientInfo inInfo) {
		this.inInfo = inInfo;
	}

	public void execute() {
		inInfo.getInPatientDetails();
	}
}
