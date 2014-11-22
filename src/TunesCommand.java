import javax.mail.Message;

public class TunesCommand {
	private String cmd;
	private String args;

	public TunesCommand(String cmdIn, String argsIn) {
		cmd = cmdIn;
		args = argsIn;
		execute();
	}

	public TunesCommand(Message msg) {
		args = "";
		if (parseMessage(msg)) {
			execute();
		}
	}

	private void execute() {
		try {
			String exCmd = "cmd /c \"" + System.getProperty("user.dir") + "\\"
					+ cmd + ".js\" " + args;
			Runtime.getRuntime().exec(exCmd);
			System.out.println("Executed " + cmd + args);
		} catch (Exception e) {
			System.out.println("Problem executing system command");
			e.printStackTrace();
		}
	}

	// Looks through message for commands and builds commands
	private boolean parseMessage(Message msg) {
		try {
			// Checking body for commands
			String newLine = ""; // newLine represents the character sequence
			// for a new line
			newLine += (char) 13;
			newLine += (char) 10;
			String content = msg.getContent().toString();
			String[] lines = content.split(newLine);
			String[] formattedContent = { "" };
			int i;
			for (String s : lines) {
				content = s;
				content = content.toLowerCase();
				content = content.trim();
				formattedContent = content.split(" ");
				i = 0;
				for (i = 0; i < formattedContent.length; i++) {
					for (String str : Main.commands) {
						if (formattedContent[i].contains(str)) {
							System.out.println("Found " + str + " command");
							cmd = str;
							while (i + 1 < formattedContent.length) {
								args = args + " " + formattedContent[i + 1];
								i++;
							}
							return true;
						}
					}
				}
			}
			// Checking subject for commands
			content = msg.getSubject();
			if (content != null) {
				content = content.toLowerCase();
				content = content.trim();
				formattedContent = content.split(" ");
				i = 0;
				for (i = 0; i < formattedContent.length; i++) {
					for (String str : Main.commands) {
						if (formattedContent[i].contains(str)) {
							System.out.println("Found " + str + " command");
							cmd = str;
							while (i + 1 < formattedContent.length) {
								args = args + " " + formattedContent[i + 1];
								i++;
							}
							if (args.length() == 0) {
								args = null;
							}
							return true;
						}
					}
				}
			}
			// No commands were found so try to execute play command with
			// whatever they sent
			System.out
					.println("No commands found, attempting to play message anyways");
			cmd = "play";
			//attempts to play the first line of the msg body
			args = "" + msg.getContent().toString().split(newLine)[0];
			return true;
		} catch (Exception e) {
			System.out.println("Error processing message");
			e.printStackTrace();
		}
		return false;
	}

}
