package task1;

import java.io.IOException;

public class Main {
    private static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();        
    }

    public static void main(String[] args) {
        CheckList cl = new CheckList();
        BatteryManager bm = new BatteryManager();

        // Get questions from user and add or remove questions from the checlist and answer questions once
        cl.nextAction();
        cl.answerQuestions();
        
        // Get the batteries from the user and find the best one
        bm.addBattery();
        bm.printBatteries();
        bm.findBestBattery();

        // Re-answer until all questions are answered "Yes"
        while (!cl.isAllTrue()) {
            cl.answerQuestions();
        }
        System.out.println("Match Ready!");
   }
}