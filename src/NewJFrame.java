import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class NewJFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private Thread curSession = null;

	public NewJFrame() {
		initComponents();
	}

	//used to center the window, paste it somewhere under initcomponents
	/*Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation((screen.width-532)/2,(screen.height-278)/4);*/
	//title
	//setTitle("WirelessTunes - Alpha " + Main.version + " © Ben Cwik");
	private void initComponents() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screen.width-532)/2,(screen.height-278)/4);
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        connectConsole = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WirelessTunes - Alpha " + Main.version + " © Ben Cwik");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("wtlogo.jpg"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("GMail Address:");

        userNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userNameFieldKeyReleased(evt);
            }
        });

        jLabel2.setFont(jLabel1.getFont());
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setText("Password:");

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(userNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 11));
        jButton1.setForeground(new java.awt.Color(255, 153, 0));
        jButton1.setText("Connect");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 11));
        jButton2.setForeground(new java.awt.Color(255, 153, 0));
        jButton2.setText("Need Help?");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 2, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        connectConsole.setFont(new java.awt.Font("Lucida Console", 0, 12));
        connectConsole.setForeground(new java.awt.Color(51, 255, 0));
        
        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 153, 0));
        jButton3.setText("Options");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(connectConsole, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(connectConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        //start initialize components using settings
        userNameField.setText(Main.address);
        jPasswordField1.setText(Main.pw);
        if(Main.autoLogin){
        	//make sure they are valid
        	if(Main.saveAddress && Main.savePassword){
        		jButton1MousePressed(null);
        	}
        }
        //end of initializing with settings
        pack();
    }
	
	
	//Events
	private void jButton2MousePressed(java.awt.event.MouseEvent evt) {
		System.out.println("Help clicked");
		System.out.flush();
	}

	private void jButton1MousePressed(java.awt.event.MouseEvent evt) {
		if(curSession == null || (curSession != null && !curSession.isAlive())){
			String p="";
			char[] u = jPasswordField1.getPassword();
			for(char c: u){
				p +=c;
			}
			Runnable r = new WTSession(userNameField.getText(),p);
			curSession = new Thread(r);
			curSession.start();
		}else{
			System.out.println("Session is already running, cannot start two sessions at the same time");
		}
	}

	private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {
		if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Enter")){
			jButton1MousePressed(null);
		}
	}

	private void userNameFieldKeyReleased(java.awt.event.KeyEvent evt) {
		if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Enter")){
			jButton1MousePressed(null);
		}
	}
	
	private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {
		if(jButton1.isEnabled()){
			jButton1.setBackground(new java.awt.Color(120, 120, 120));
		}
    }

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {
        jButton1.setBackground(new java.awt.Color(102, 102, 102));
    }

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {
        jButton2.setBackground(new java.awt.Color(120, 120, 120));
    }

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {
        jButton2.setBackground(new java.awt.Color(102, 102, 102));
    }
    
    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {
    	jButton3.setBackground(new java.awt.Color(120, 120, 120));
    }

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {
    	jButton3.setBackground(new java.awt.Color(102, 102, 102));
    }

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionsGUI().setVisible(true);
            }
        });
    }


	// Variables declaration - do not modify
    private static javax.swing.JLabel connectConsole;
	private static javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private static javax.swing.JPasswordField jPasswordField1;
	private static javax.swing.JTextField userNameField;
	// End of variables declaration
	
	//sets the text that users can see
	public static void setConsoleText(String text, boolean isError){
		if(isError){
			connectConsole.setForeground(new java.awt.Color(255, 0, 0));
		}else{
			connectConsole.setForeground(new java.awt.Color(51, 255, 0));
		}
		connectConsole.setText(text);
	}
	
	//colors and enables certain fields based on connection
	public static void setFieldsEnabled(boolean enabled){
		if(enabled){
			jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
		}else{
			jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
		}
		userNameField.setEnabled(enabled);
		jPasswordField1.setEnabled(enabled);
		jButton1.setEnabled(enabled);
	}
	
	//updates the main address and password
	public static void updateAddressPassword(){
		Main.address = userNameField.getText();
		String p="";
		char[] u = jPasswordField1.getPassword();
		for(char c: u){
			p +=c;
		}
		Main.pw = p;
	}

}
