//Custom class that represents the result of checking the user's answer for correctness
//It combines the correct answer with the information whether the user's answer was correct or not to display on UI.
public class CheckedAnswer {
    private final Answer correctAnswer;
    private final boolean isCorrect;

    //Constructor
    public CheckedAnswer(Answer correctAnswer, boolean isCorrect) {
        this.correctAnswer = correctAnswer;
        this.isCorrect = isCorrect;
    }

    //Accessor
    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    //Accessor
    public boolean isCorrect() {
        return isCorrect;
    }
}
