package UI;

public interface IConsoleUI {
    public void clearDisplay();
    public void showMessage(String msg);
    public int getInteger(String msg);
    public String getString(String msg);
}
