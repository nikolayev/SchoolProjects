public class CheckedAnswer {
    private final Answer correctAnswer;
    private final boolean isCorrect;

    public CheckedAnswer(Answer correctAnswer, boolean isCorrect) {
        this.correctAnswer = correctAnswer;
        this.isCorrect = isCorrect;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
