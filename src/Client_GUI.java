
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abc
 */
public class Client_GUI extends javax.swing.JFrame {
    
     private static A_Chat_Client ChatClient;
     public static String UserName="Anonymous";
     
      public static JFrame LogInWindow=new JFrame();
        public static JTextField TF_UserNameBox=new JTextField(20);
        private static final JButton B_ENTER=new JButton();
        private static JPanel P_LogIn=new JPanel();
         

    public static void Initialize() {
        B_SEND.setEnabled(false);
        B_DISCONNECT.setEnabled(false);
        B_CONNECT.setEnabled(true);
    }
    
     public static void BuildLogInWindow()
    {
        LogInWindow.setTitle("what is your name?");
        LogInWindow.setSize(400,400);
        LogInWindow.setLocation(250, 200);
        LogInWindow.setResizable(false);
        P_LogIn=new JPanel();
     //   P_LogIn.add(L_EnterUserName);
        P_LogIn.add(TF_UserNameBox);
        P_LogIn.add(B_ENTER);
        B_ENTER.setLabel("ENTER");
        LogInWindow.add(P_LogIn);
        
        Login_Action();
        LogInWindow.setVisible(true);
        
        
    }
     public static void MainWindow_Action() 
    {
        B_SEND.addActionListener((ActionEvent e) -> {
            ACTION_B_SEND();
        });
    B_DISCONNECT.addActionListener((ActionEvent e) -> 
    {
        ACTION_B_DISCONNECT();
        });
    
        B_CONNECT.addActionListener((ActionEvent e) -> {
            BuildLogInWindow();
        });
        
    }

    private static void ACTION_B_SEND() {
        
       
         
          if(!TF_Message.getText().equals(""))
        {
            ChatClient.SEND(TF_Message.getText());
            TF_Message.requestFocus();
        }
       
    }

    private static void ACTION_B_DISCONNECT() {
        
          try
       {
           ChatClient.DISCONNECT();
       }
       catch(Exception e){}
        
    }

    private static void Login_Action() {
        B_ENTER.addActionListener((ActionEvent e) -> {
            ACTION_B_ENTER();
        });
       
    }

    private static void ACTION_B_ENTER() {
        
         if(!TF_UserNameBox.getText().equals(""))
        {
            UserName=TF_UserNameBox.getText().trim();
         //   L_LoggedInAsBox.setText(UserName);
            A_Chat_Server.CurrentUsers.add(UserName);

            LogInWindow.setVisible(false);
            B_SEND.setEnabled(true);
            B_DISCONNECT.setEnabled(true);
            B_CONNECT.setEnabled(false);
            TF_LoggedUserNameBox.setEditable(false);
            TF_LoggedUserNameBox.setText(UserName);
            Connect();
        }
        else
        {JOptionPane.showMessageDialog(null,"please enter a name");}
    }

    /**
     * Creates new form Client_GUI
     */
    public Client_GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TF_Message = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TF_LoggedUserNameBox = new javax.swing.JTextField();
        B_CONNECT = new javax.swing.JButton();
        B_DISCONNECT = new javax.swing.JButton();
        B_SEND = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_CONVERSATION = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        JL_ONLINE = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Message");

        jLabel2.setText("Currently Logged In");

        TF_LoggedUserNameBox.setEditable(false);

        B_CONNECT.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        B_CONNECT.setText("CONNECT");

        B_DISCONNECT.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        B_DISCONNECT.setText("DISCONNECT");

        B_SEND.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        B_SEND.setText("SEND");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Logged In Users");

        TA_CONVERSATION.setColumns(20);
        TA_CONVERSATION.setRows(5);
        jScrollPane1.setViewportView(TA_CONVERSATION);

        jScrollPane2.setViewportView(JL_ONLINE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TF_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B_SEND, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B_CONNECT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B_DISCONNECT))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_LoggedUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(B_SEND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TF_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TF_LoggedUserNameBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(B_CONNECT, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(B_DISCONNECT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     */
     public static void Connect() 
        {
       try {
           final int PORT=444;
           final String HOST="";
           Socket SOCK=new Socket(HOST,PORT);
           System.out.println("you connected to"+HOST);
           
           ChatClient =new A_Chat_Client(SOCK);
           //send name to add to "online" list
           PrintWriter OUT=new PrintWriter(SOCK.getOutputStream());
           OUT.println(UserName);
           OUT.flush();
           
           Thread X=new Thread((Runnable) ChatClient);
           X.start();
       } 
       catch (IOException ex) {
           System.out.println(ex);
           JOptionPane.showMessageDialog(null,"Server not responding");
           System.exit(0);
       }
        }
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
          //  new Client_GUI().setVisible(true);
        
            // Initialize();
           //  MainWindow_Action();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton B_CONNECT;
    private static javax.swing.JButton B_DISCONNECT;
    private static javax.swing.JButton B_SEND;
    public static javax.swing.JList JL_ONLINE;
    public static javax.swing.JTextArea TA_CONVERSATION;
    private static javax.swing.JTextField TF_LoggedUserNameBox;
    public static javax.swing.JTextField TF_Message;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
