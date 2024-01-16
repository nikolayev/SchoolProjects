//Custom class that represents a specific answer to question provided by the user as opposed to any possible answer (Answer)
//Used to keep track of correct and incorrect user answers to calculate a score and the number of correct and incorrect answers
public class UserAnswer {
    private final Question question;
    private final boolean correct;

    //Constructor
    public UserAnswer(Question question, boolean correct) {
        this.question = question;
        this.correct = correct;
    }

    //Accessor
    public Question getQuestion() {
        return question;
    }

    //Accessor
    public boolean getCorrectUserAnswer() {
        return correct;
    }
}
