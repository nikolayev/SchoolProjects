public class CheckedAnswer {
    private final Answer checkedAnswer;
    private final boolean isCorrect;

    public CheckedAnswer(Answer checkedAnswer, boolean isCorrect) {
        this.checkedAnswer = checkedAnswer;
        this.isCorrect = isCorrect;
    }

    public Answer getCheckedAnswer() {
        return checkedAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
