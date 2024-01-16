//Custom class that represents the result of checking the user's answer for correctness
//It combines the correct answer with the information whether the user's answer was correct or not to display on UI.
public class CheckedAnswer {

    // Using final primitive and object data types (R.1)
    private final Answer correctAnswer;
    private final boolean isCorrect;

    // Constructor initializing the fields (R.2.1)
    //Alexander Nikolayev 01/16/2024
    public CheckedAnswer(Answer correctAnswer, boolean isCorrect) {
        this.correctAnswer = correctAnswer;
        this.isCorrect = isCorrect;
    }

    // Accessor methods returning field values (R.2.2)
    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
