
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abc
 */
public class A_Chat_Server_Return implements Runnable
{
    Socket SOCK;
    private Scanner INPUT;
    public PrintWriter OUT;
    String MESSAGE="";

    public A_Chat_Server_Return(Socket X) {
        this.SOCK = X;
    }
    
    public void CheckConnection() throws IOException
    {
        if(!SOCK.isConnected())
        {
            for(int i=1;i<=A_Chat_Server.ConnectionArray.size();i++)
            {
                if(A_Chat_Server.ConnectionArray.get(i)==SOCK)
                {
                    A_Chat_Server.ConnectionArray.remove(i);
                }
            }
            
            for(int i=1;i<=A_Chat_Server.ConnectionArray.size();i++)
            {
                Socket TEMP_SOCK=(Socket)A_Chat_Server.ConnectionArray.get(i-1);
                PrintWriter TEMP_OUT=new PrintWriter(TEMP_SOCK.getOutputStream());
                TEMP_OUT.println(TEMP_SOCK.getLocalAddress().getHostName() +"discontinued");
                TEMP_OUT.flush();
                //show discontinued at server
                System.out.println(TEMP_SOCK.getLocalAddress().getHostName()+"discontinued");
            }
        }
    }

    @Override
    public void run()
    {
        try
        {
            try
            {
                INPUT=new Scanner(SOCK.getInputStream());
                OUT=new PrintWriter(SOCK.getOutputStream());
                
                while(true)
                {
                    CheckConnection();
                    if(!INPUT.hasNext())
                    {
                        return;
                    }
                    MESSAGE=INPUT.nextLine();
                    
                    System.out.println("Client said"+MESSAGE);
                    
                    for(int i=1;i<=A_Chat_Server.ConnectionArray.size();i++)
                    {
                        Socket TEMP_SOCK=(Socket)A_Chat_Server.ConnectionArray.get(i-1);
                        PrintWriter TEMP_OUT=new PrintWriter(TEMP_SOCK.getOutputStream());
                        TEMP_OUT.println(MESSAGE);
                        TEMP_OUT.flush();
                        System.out.println("Sent to" +TEMP_SOCK.getLocalAddress().getHostName());
                        
                    }//CLOSE FOR LOOP
                }//CLOSE WHILE LOOP
                        
            }//CLOSE INNER TRY
            finally
            {
                SOCK.close();
            }
        }//CLOSE OUTER TRY
        catch(Exception e){System.out.println(e);}
       
    }
    
}
