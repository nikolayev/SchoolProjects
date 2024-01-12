import java.util.List;
import java.util.ArrayList;

public class Question {
    private String text;
    private int difficulty;
    public List<Answer> answers = new ArrayList<>();

    public Question(String text, int difficulty, List<Answer> answers){
        this.text = text;
        this.difficulty = difficulty;
        this.answers = answers;
    }
}
