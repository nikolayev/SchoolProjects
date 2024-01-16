//Custom class that represents a possible answer to a question in the game
//Alexander Nikolayev 01/16/2024
public class Answer {
    private final String text;
    private final boolean correct;

    //Constructor (R.2.1)
    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    //Accessor (R.2.2)
    public boolean isCorrect() {
        return correct;
    }

    //Accessor (R.2.2)
    public String getText() {
        return text;
    }
}
