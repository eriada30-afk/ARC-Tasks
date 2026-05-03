package task1;

import java.util.ArrayList;

public class CheckList {
    private ArrayList<CheckListItem> checkList = new ArrayList<>();

    public void addQuestions() {
        System.out.print("How many questions do you have? ");
        int questionNum = InputScanner.scanner.nextInt();
        InputScanner.scanner.nextLine();
        for(int i = 0 ; i < questionNum ; i++){
            System.out.print("Enter a question(" + (i+1) + "/" + questionNum + "): ");
            String question = InputScanner.scanner.nextLine();
            CheckListItem item = new CheckListItem(question);
            checkList.add(item);
        }
    }

    public void answerQuestions() {
        System.out.println("\nNow let's answer the questions.");
        for(int i = 0 ; i < checkList.size() ; i++) {
            CheckListItem item = checkList.get(i);
            if (item.getAnswer() == false) {
                boolean answer = getAnswerFromUser(item.getQuestion());
                item.setAnswer(answer);
            }
        }
        printAnswers();
    }

    public void printAnswers() {
        System.out.println("");
        for(int i = 0 ; i < checkList.size() ; i++) {
            String answer = "";
            if (checkList.get(i).getAnswer()) {
                answer = "Yes";
            } else {
                answer = "No";
            }
            System.out.println(checkList.get(i).getQuestion() + "/" + answer);
        }
    }

    public boolean getAnswerFromUser(String question) {
        while(true) {
            System.out.print(question + " (Y/N): ");
            String answer = InputScanner.scanner.nextLine().toLowerCase();
            if (answer.equals("y")) {
                return true;
            } else if (answer.equals("n")) {
                return false;
            } else {
                System.out.println("You must enter 'Y' or 'N' as an answer.");
            }
        }
    }

    public boolean isAllTrue() {
        for (int i = 0; i < checkList.size(); i++) {
            if (checkList.get(i).getAnswer() == false) {
                return false;
            }
        }
        return true;
    }
}
