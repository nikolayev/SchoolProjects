public class UserAnswer {
    private final Question question;
    private final boolean correct;

    public UserAnswer(Question question, boolean correct) {
        this.question = question;
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean getCorrectUserAnswer() {
        return correct;
    }
}
