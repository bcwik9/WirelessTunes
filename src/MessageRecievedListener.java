import javax.mail.Message;
import javax.mail.event.MessageCountAdapter;
import javax.mail.event.MessageCountEvent;

public class MessageRecievedListener extends MessageCountAdapter {

	public MessageRecievedListener() {
	}

	public void messagesAdded(MessageCountEvent ev) {
		Message[] msgs = ev.getMessages();
		System.out.println("Message recieved (" + msgs.length + ")");
		for (Message msg : msgs) {
			try {
				//Check if sender is in array of allowed users (if enabled)
				if (!Main.checkSender || (Main.checkSender && Main.acceptEmailFrom.indexOf(msg.getFrom()[0].toString()) != -1)) {
					new TunesCommand(msg);
				}else{
					System.out.println("Ignoring email recieved from unknown user");
				}
			} catch (Exception e1) {
				System.out.println("Error during retrieval of new messages");
				e1.printStackTrace();
			}
		}
	}
}
