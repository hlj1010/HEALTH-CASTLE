public class RemoteControl {
	Command[] Commands;

	public RemoteControl(int n) {
		Commands = new Command[n];

		Command noCommand = new NoCommand();
		for (int i = 0; i < n; i++) {
			Commands[i] = noCommand;
		}
	}

	public void setCommand(int slot, Command onCommand) {
		Commands[slot] = onCommand;
	}

	public void ButtonWasPushed(int slot) {
		Commands[slot].execute();
	}

	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		for (int i = 0; i < Commands.length; i++) {
			stringBuff.append("[Option " + (i + 1) + "] " + Commands[i].getDescription() + "    " + "\n");
		}
		return stringBuff.toString();
	}
}