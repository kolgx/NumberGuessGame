import tools.UnitTool;

import java.util.Arrays;
import java.util.Scanner;

public class GameView extends UnitTool {
    private Scanner scanner;
    private GameControler unit;
    public void init(){
        scanner = new Scanner(System.in);
        unit = new GameControler();
        print("Game Init!\nHow Much Digits You Want Play?\n");
        unit.setDigits(scanner.nextInt());
        print("Get It! Your Play's Digits Will be "+unit.getDigits()+"\n");
    }
    public void start(){
        print("Game Start!!!\n");
        unit.setAnswer();
        do{
            unit.setTimes();
            print("Game Time "+unit.getTimes()+"\nPlace Input Your Guess Numbber:\n");
            unit.setInput(scanner.nextInt());
        }while (!unit.isGameOver());
    }
    public boolean moreAgain(){
        print("Would you like to play game again?\n");
        return scanner.next().contentEquals("Y");
    }
    static void showFail(int r,int w, int[] put){
        print("Sorry! You Number "+ Arrays.toString(put) +" is Wrong!\nYou have "+r+" number Completed!\n"+
                "You have "+w+" number in Worng Location!\nPlase try again!\n");
    }
    static void showSuccess(int time, int[] answer){
        print("Congratulations !!!\nYou successful guess right password: "+Arrays.toString(answer)+
                "!\nYou total play "+time+" times!\n");
    }
    static void showRepeat(int number, int time){
        print("Tips: The true answer have "+number+" number repeat "+time+" time.\n");
    }
}
