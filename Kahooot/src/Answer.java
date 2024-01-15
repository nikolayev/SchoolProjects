public class Answer {
    private final String text;
    private final boolean correct;

    public Answer(String text, boolean correct){
        this.text = text;
        this.correct = correct;
    }

    public boolean isCorrect(){
        return correct;
    }

    public String getText() {
        return text;
    }
}
