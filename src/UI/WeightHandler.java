package UI;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class WeightHandler {
    public WeightHandler(){
        try (Socket socket = new Socket("localhost", 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            pw.println("RM20 4 INDTAST");
            pw.flush();
            String in = reader.readLine();
            System.out.println(in);

            //socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
