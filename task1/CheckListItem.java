package task1;

public class CheckListItem {

    private String question;
    private boolean answer;

    public CheckListItem(String question) {
        this.question = question;
        this.answer = false;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return this.question;
    }

    public boolean getAnswer() {
        return this.answer;
    }
}
