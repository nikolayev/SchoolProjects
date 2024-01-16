//Custom class that represents a possible answer to a question in the game
public class Answer {
    private final String text;
    private final boolean correct;

    //Constructor
    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    //Accessor
    public boolean isCorrect() {
        return correct;
    }

    //Accessor
    public String getText() {
        return text;
    }
}
