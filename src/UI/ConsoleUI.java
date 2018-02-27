package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements IConsoleUI {

	Scanner sc = new Scanner(System.in);
	@Override
	public void clearDisplay() {
		System.out.flush();

	}

	@Override
	public void showMessage(String msg) {
		System.out.println(msg);

	}

	@Override
	public int getInteger(String msg) {
		while(true){
			try{
				System.out.println(msg);
				int i = sc.nextInt();
				sc.nextLine();
				return i;
			}
			catch(InputMismatchException e){
				System.out.println("forkert input");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}


	}

	@Override
	public String getString(String msg) {
		String temp = "";
		while(true){
			try{
				System.out.println(msg);
				temp = sc.nextLine();
				return temp;
			}
		 	catch(Exception e){
				e.printStackTrace();
			}	
		}
		
	}
}
