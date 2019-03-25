import javax.servlet.http.Cookie;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(8189)) {
            int i = 1;
            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawning" + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
            //wait for
            /*try(Socket incoming = s.accept()){
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                try(Scanner in = new Scanner(inputStream, "UTF-8"))
                {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
                    out.println("Hello! ");
                    boolean done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("Echo:" + line);
                        if (line.trim().equals("BYE"))
                            done = true;
                    }
                }
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    class ThreadedEchoHandler implements Runnable{
        private Socket incoming;

        public ThreadedEchoHandler(Socket incomingSocket){
            incoming = incomingSocket;
        }

        public void run(){
            try(InputStream inputStream = incoming.getInputStream();
            OutputStream outputStream = incoming.getOutputStream()){
                Scanner in = new Scanner(inputStream, "UTF-8");
                PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
                out.println("Hello! \n");
                boolean done = false;
                while (!done && in.hasNextLine()){
                    String line = in.nextLine();
                    line = line.toUpperCase();
                    out.println("Echo:" + line);
                    if (line.trim().equals("BYE"))
                        done = true;
            }
            }catch (IOException e){
                e.printStackTrace();
        }
    }
}
