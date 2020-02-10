package ua.ejc.vitaliy.javagamemvc;

public class JavaGame {
    public static void main(String[] args) {
        Model playerModel = new Model();
        View playerView = new View();
        Controller controller = new Controller(playerModel, playerView);
        controller.startGame(0, 100, 10);

    }
}
