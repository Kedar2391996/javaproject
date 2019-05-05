import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class A_Chat_Server 
{
    //one arraylist for connection information and second for current users logged in //
    public static ArrayList<Socket> ConnectionArray=new ArrayList<>();
    public static ArrayList<String> CurrentUsers=new ArrayList<>();
    
    public static void main(String args[]) throws Exception
    {
        try
        {
            final int port=444;
            ServerSocket Server=new ServerSocket(port);
            System.out.println("Waiting for Clients...");
            
            while(true)
            {
                Socket SOCK=Server.accept();
                ConnectionArray.add(SOCK);
                System.out.println("Client Connected from:" +SOCK.getLocalAddress().getHostName());
                
                AddUserName(SOCK);
                
                A_Chat_Server_Return CHAT=new A_Chat_Server_Return(SOCK);
                Thread X=new Thread(CHAT);
                X.start();
            }
        }
        catch(Exception e){System.out.println(e);}
    }
    
    public static void AddUserName(Socket X)throws IOException
    {
        Scanner INPUT=new Scanner(X.getInputStream());
        String UserName=INPUT.nextLine();
        CurrentUsers.add(UserName);
        
        for(int i=1;i<= A_Chat_Server.ConnectionArray.size();i++)
        {
            Socket TEMP_SOCK=(Socket) A_Chat_Server.ConnectionArray.get(i-1);
            PrintWriter OUT=new PrintWriter(TEMP_SOCK.getOutputStream());
            OUT.println("#?!" +CurrentUsers);
            OUT.flush();
        }
    }
    
}
