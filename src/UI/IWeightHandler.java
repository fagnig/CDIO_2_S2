package UI;

public interface IWeightHandler {
    int getWeight();
    int tare();
    void showError();
    void showText();
    void clearText();
    void getInput();

    void overrideWeight();
    void exit();
}
