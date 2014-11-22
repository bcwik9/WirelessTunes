import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	//global variables
	public static double version = 1.2;
	public static ArrayList<String> commands = new ArrayList<String>();
	public static ArrayList<String> acceptEmailFrom = new ArrayList<String>();
	public static String address = "";
	public static String pw = "";
	public static boolean checkSender = false;
	public static boolean autoLogin = false;
	public static boolean savePassword=false;
	public static boolean saveAddress=false;

	//MAIN
	public static void main(String[] args) {
		getSettings();
		String[] c = { "play", "stop", "resume", "pause", "volume", "next",
				"previous", "mute", "visual" };
		for (String s : c) {
			commands.add(s);
		}
		// invoke GUI
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new NewJFrame().setVisible(true);
			}
		});
	}
	
	//retrieves settings from "settings.ini" file
	private static void getSettings(){
		try {
			Scanner scanner = new Scanner(new File("settings.ini"));
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine().trim();
				String command,arg = "";
				if (s != null && s.length() > 1) {
					if (s.charAt(0) == '/' && s.charAt(1) == '/') {
						// ignores lines that start with "//"
					} else {
						if(s.contains("=")){
							String[] cmd = s.split("=");
							if(cmd.length == 1){
								command=cmd[0].replaceAll(" ", "");
							}else{
								command=cmd[0].replaceAll(" ","");
								arg=cmd[1].replaceAll(" ","");
							}
							command = command.toLowerCase();
							arg= arg.toLowerCase();
							if(command.equals("defaultaddress")){
								address=arg;
							}else if(command.equals("autologin")){
								autoLogin= Boolean.parseBoolean(arg);
							}else if(command.equals("regintmodel")){
								arg = arg.replaceAll("@", "");
								arg = arg.replaceAll("&", "");
								pw = arg;
							}else if(command.equals("saveaddress")){
								saveAddress=Boolean.parseBoolean(arg);
							}else if(command.equals("savepassword")){
								savePassword=Boolean.parseBoolean(arg);
							}else if(command.equals("filterusers")){
								checkSender = Boolean.parseBoolean(arg);
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("settings.ini could not be found");
		}
	}
	
	//saves the current configuration to settings.ini
	public static void saveCurrentSettings() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("settings.ini")));
			writer.write("//[User Settings]");
			writer.newLine();
			writer.write("Default Address=");
			if(saveAddress){
				writer.write(address);
			}
			writer.newLine();
			writer.write("Save Address="+saveAddress);
			writer.newLine();
			writer.write("Save Password="+savePassword);
			writer.newLine();
			writer.write("Auto Login="+autoLogin);
			writer.newLine();
			writer.newLine();
			writer.write("//[Filter Settings]");
			writer.newLine();
			writer.write("Filter Users="+checkSender);
			writer.newLine();
			writer.newLine();
			writer.write("//do not modify");
			writer.newLine();
			writer.write("regIntModel=");
			if(savePassword){
				writer.write(pw);
			}
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			System.out.println("error saving settings");
			e.printStackTrace();
		}
	}

}
