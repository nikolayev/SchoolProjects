//Custom class that represents a specific answer to question provided by the user as opposed to any possible answer (Answer)
//Used to keep track of correct and incorrect user answers to calculate a score and the number of correct and incorrect answers
//Alexander Nikolayev 01/16/2024
public class UserAnswer {

    // Question object and boolean data type (R.1)
    private final Question question;
    private final boolean correct;

    //Constructor (R.2.1)
    public UserAnswer(Question question, boolean correct) {
        this.question = question;
        this.correct = correct;
    }

    //Accessor (R.2.2)
    public Question getQuestion() {
        return question;
    }

    //Accessor (R.2.2)
    public boolean getCorrectUserAnswer() {
        return correct;
    }
}
