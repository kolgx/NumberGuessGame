import tools.UnitTool;

public class Main extends UnitTool {
    public static void main(String[] args) {
        GameView game = new GameView();
        print("Wellcom Come!!!\n");
        do{
            game.init();
            game.start();
        }while (game.moreAgain());
        print("Game Over !\n");
    }
}
