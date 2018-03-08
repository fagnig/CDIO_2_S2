package UI;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class WeightHandler implements IWeightHandler{
    public WeightHandler(){

    }


    @Override
    public int getWeight() {
        try (Socket socket = new Socket("localhost", 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            pw.println("S");
            pw.flush();
            String in = reader.readLine();

            String subStr = in.substring(in.length()-7,in.length()-2);
            String subStr2 = subStr.charAt(0) + subStr.substring(2);
            return Integer.parseInt(subStr2);

            //socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int tare() {
        try (Socket socket = new Socket("localhost", 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            pw.println("S");
            pw.flush();
            String in = reader.readLine();

            String subStr = in.substring(in.length()-7,in.length()-2);
            String subStr2 = subStr.charAt(0) + subStr.substring(2);
            return Integer.parseInt(subStr2);

            //socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void showError() {
        try (Socket socket = new Socket("localhost", 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            pw.println("S");
            pw.flush();
            String in = reader.readLine();

            String subStr = in.substring(in.length()-7,in.length()-2);
            String subStr2 = subStr.charAt(0) + subStr.substring(2);

            //socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void showText() {

    }

    @Override
    public void clearText() {

    }

    @Override
    public void getInput() {

    }

    @Override
    public void overrideWeight() {

    }

    @Override
    public void exit() {

    }
}
