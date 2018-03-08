package UI;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class WeightHandler implements IWeightHandler{
    String curIP;
    public WeightHandler(){
        curIP = "localhost"; //TODO make ip dynamic
    }


    @Override
    public int getWeight() {
        try (Socket socket = new Socket( curIP ,8000)) {
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
        try (Socket socket = new Socket(curIP, 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            pw.println("T");
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
        try (Socket socket = new Socket(curIP, 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);

            pw.println("D \"ERROR\"");
            pw.flush();

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
    public void showText(String msg) {
        try (Socket socket = new Socket(curIP, 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);

            pw.println("P111 \"" + msg +"\"");
            pw.flush();

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
    public void clearText() {
        try (Socket socket = new Socket(curIP, 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);

            pw.println("DW");
            pw.flush();

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
    public String getInput(String msg) {
        try (Socket socket = new Socket( curIP ,8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String in = "         ";

            pw.println("RM20 8 \""+msg+"\" \" \" \"&3\"");
            pw.flush();

            while(!in.substring(0,6).equals("RM20 A")){
                in = reader.readLine();
            }

            String subStr = in.substring(8,in.length()-1);
            return subStr;
            //socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void overrideWeight(int grams) {
        try (Socket socket = new Socket(curIP, 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);

            pw.println("B \""+grams+"\"");
            pw.flush();

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
    public void exit() {
        try (Socket socket = new Socket(curIP, 8000)) {
            OutputStream sos = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(sos);

            pw.println("Q");
            pw.flush();

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
