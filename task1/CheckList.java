package task1;

import java.util.ArrayList;

public class CheckList {
    private ArrayList<CheckListItem> checkList = new ArrayList<>();
    int questionNum = 0;

    // Adds questions to checklist
    public void addQuestions() {
        if (questionNum < 3) {
            while (questionNum < 3) {
                System.out.println("\nThe number of questions must be minimum 3. ");
                System.out.print("How many questions do you have? ");
                if (InputScanner.scanner.hasNextInt()) {
                    questionNum = InputScanner.scanner.nextInt();
                    InputScanner.scanner.nextLine();
                } else {
                    System.out.println("\nPlease enter a valid number.");
                    InputScanner.scanner.nextLine();
                }
            }
        } else {
            while (true) {
                System.out.print("\nHow many questions do you have? ");
                if (InputScanner.scanner.hasNextInt()) {
                    questionNum = InputScanner.scanner.nextInt();
                    InputScanner.scanner.nextLine();
                    break;
                } else {
                    System.out.println("\nPlease enter a valid number.");
                    InputScanner.scanner.nextLine();
                }
            }
        }
        
        for(int i = 0 ; i < questionNum ; i++){
            System.out.print("Enter a question(" + (i+1) + "/" + questionNum + "): ");
            String question = InputScanner.scanner.nextLine();
            CheckListItem item = new CheckListItem(question);
            checkList.add(item);
        }
    }

    // Removes questions from checklist
    public void removeQuestions() {
        int removedQ = 0;
        System.out.println("");
        for (int i = 0; i < checkList.size(); i++) {
            System.out.println((i + 1) + ". " + checkList.get(i).getQuestion());
        }
        while (true) {
            System.out.println("Which question would you like to remove? ");
            System.out.print("Enter the question's number: ");
            if (InputScanner.scanner.hasNextInt()) {
                removedQ = InputScanner.scanner.nextInt();
                InputScanner.scanner.nextLine();
                break;
            } else {
                System.out.println("\nPlease enter a valid number. ");
                InputScanner.scanner.nextLine();
            }
        }
        checkList.remove(removedQ-1);
        System.out.println("");
        for (int i = 0; i < checkList.size(); i++) {
            System.out.println((i + 1) + ". " + checkList.get(i).getQuestion());
        }
    }

    // Asks the user what to do next. Add questions, remove questions, continue
    public void nextAction() {
        int action = 0;
        while (true) {
            System.out.println("\nChoose one: 1-Add questions, 2-Remove questions, 3-Continue");
            System.out.print("Your choice: ");
            if (InputScanner.scanner.hasNextInt()) {
                action = InputScanner.scanner.nextInt();
                InputScanner.scanner.nextLine();
            } else {
                System.out.println("You have to enter a valid NUMBER. ");
                InputScanner.scanner.nextLine();
                continue;
            }
            if (action == 1) {
                addQuestions();
            } else if (action == 2) {
                if (checkList.size() == 0) {
                    System.out.println("You can't remove anything.");
                } else {
                    removeQuestions();
                }
            } else if (action == 3) {
                if (checkList.size() < 3) {
                    System.out.println("You must at least have 3 questions.");
                    continue;
                }
                break;
            } else {
                System.out.println("Please enter 1, 2 or 3.");
            }
        }
    }

    // Asks user the questions and adds the answers to checklist
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

    // Prints the questions and answers
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

    // Gets the answer from user
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

    // Checks if all the answers are "Yes"
    public boolean isAllTrue() {
        for (int i = 0; i < checkList.size(); i++) {
            if (checkList.get(i).getAnswer() == false) {
                return false;
            }
        }
        return true;
    }
}