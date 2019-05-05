
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abc
 */
public class A_Chat_Client implements Runnable
{
    Socket SOCK;
    Scanner INPUT;
    Scanner SEND=new Scanner(System.in);
    PrintWriter OUT;
    
    public A_Chat_Client(Socket X)
    {
        this.SOCK=X;
    }

    

    public  void SEND(String X) 
    {
       OUT.println(Client_GUI.UserName+": "+X);
       OUT.flush();
       Client_GUI.TF_Message.setText("");
        
    }

    void DISCONNECT() throws Exception 
    {
         A_Chat_Server.CurrentUsers.remove(Client_GUI.UserName);
        OUT.println(Client_GUI.UserName+ " has disconnected ");
        OUT.flush();
        SOCK.close();
        JOptionPane.showMessageDialog(null, "you disconnected");
        System.exit(0);
    }

    @Override
    public void run() {
      
        try
        {
            try{
                INPUT=new Scanner(SOCK.getInputStream());
                OUT=new PrintWriter(SOCK.getOutputStream());
                OUT.flush();
                CheckStream();
            }
            finally
            {
                SOCK.close();
            
            }
        
        }
        catch(Exception X){System.out.println(X);}
    }
    
    public void RECEIVE()
    {
        if(INPUT.hasNext())
        {
            String MESSAGE=INPUT.nextLine();
            if(MESSAGE.contains("#?!"))
            {
                String TEMP1=MESSAGE.substring(3);
                        TEMP1=TEMP1.replace("[", "");
                        TEMP1=TEMP1.replace("]", "");
                        
                String[] CurrentUsers=TEMP1.split(",");
                
                Client_GUI.JL_ONLINE.setListData(CurrentUsers);
            }
            else
            {
                Client_GUI.TA_CONVERSATION.append(MESSAGE +"\n");
            }
        }
    
    }

    private void CheckStream()
    {
        while(true)
        {
            RECEIVE();
        }
    }
    
}
