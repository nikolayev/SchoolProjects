import java.util.List;
import java.util.ArrayList;

public class Question {
    private String text;
    private int difficulty;
    private List<Answer> answers = new ArrayList<>();

    public Question(String text, int difficulty, List<Answer> answers){
        this.text = text;
        this.difficulty = difficulty;
        this.answers = answers;
    }

    public int getCorrectAnswerIndex(){
        for(int i=0;i<answers.size();i++){
            Answer checkedAnswer = answers.get(i);
            if(checkedAnswer.isCorrect()){
                return i;
            }
        }
        return -1;
    }

    public int getDifficulty(){
        return difficulty;
    }
}
