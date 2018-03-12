package UI;

public interface IWeightHandler {
    //Needs some sort of socket interfacing
    //See CDIO2Ref->socket package

    int getWeight();
    int tare();
    void showError();
    void showText(String msg);
    void clearText();
    void getInput(String msg);

    //Exclusively for testing with the emulator
    void overrideWeight();
    void exit();
}
