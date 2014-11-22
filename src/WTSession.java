import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;


public class WTSession implements Runnable{
	
	private String username, pwd;
	
	public WTSession(String usr, String p){
		username = usr;
		pwd = p;
		if(!username.contains("@gmail.com")){
			username += "@gmail.com";
		}
	}

	public void run() {
		NewJFrame.setFieldsEnabled(false);
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		Runnable r = new Counter("Connecting...",false);
		Thread count = new Thread(r);
		Store store = null;
		try {
			Session session = Session.getDefaultInstance(props, null);
			store = (IMAPStore) session.getStore("imaps");
			count.start();
			store.connect("imap.gmail.com", username, pwd);
			//save new connection info
			NewJFrame.updateAddressPassword();
			Main.saveCurrentSettings();
			count.stop();
			NewJFrame.setConsoleText("Connected! Waiting for commands...", false);
			IMAPFolder inbox = (IMAPFolder) store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
			MessageRecievedListener listener = new MessageRecievedListener();
			inbox.addMessageCountListener(listener);
			System.out.println("Started checking for new mail...");
			while (true) {
				inbox.idle();
				Thread.sleep(1000);
				System.out.println("idle");
				System.out.flush();
			}
		} catch(AuthenticationFailedException e1){
			if(e1.getMessage().contains("IMAP")){
				NewJFrame.setConsoleText("Enable IMAP in your GMail account", true);
				System.out.println("imap is not enabled in google account");
			}else{
				NewJFrame.setConsoleText("Check username / password", true);
				System.out.println("wrong username/pwd");
			}
		} catch(FolderClosedException e2){
			//not sure if this will reconnect sucessfully or not
			try {
				store.close();
			} catch (Exception e) {}
			run();
		} catch (Exception e){
			if(pwd.equals("")){
				System.out.println("no password provided");
				NewJFrame.setConsoleText("No password was entered",true);
			}else{
				NewJFrame.setConsoleText("Check internet connection", true);
				System.out.println("other error (possibly lost internet connection?)");
			}
		}
		NewJFrame.setFieldsEnabled(true);
		count.stop();
	}

}
