package task1;

import java.io.IOException;

public class Main {
    private static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();        
    }

    public static void main(String[] args) {
        CheckList cl = new CheckList();
        cl.addQuestions();
        cl.answerQuestions();
        
        BatteryManager bm = new BatteryManager();
        bm.addBattery();
        bm.printBatteries();
        // Battery bestBattery = bm.findBestBattery();
        bm.findBestBattery();

        
        while (!cl.isAllTrue()) {
            cl.answerQuestions();
        }
   }
}