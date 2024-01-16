import java.util.List;

//Custom class that represents the quiz question in the game
public class Question {
    private final String text;
    private final int difficulty;
    private final List<Answer> answers;

    //Constructor
    public Question(String text, int difficulty, List<Answer> answers) {
        this.text = text;
        this.difficulty = difficulty;
        this.answers = answers;
    }

    //Accessor
    //Calculates the index of the correct answer in the list of all possible answers
    public int getCorrectAnswerIndex() {
        for (int i = 0; i < answers.size(); i++) {
            Answer checkedAnswer = answers.get(i);
            if (checkedAnswer.isCorrect()) {
                return i;
            }
        }
        return -1;
    }

    //Accessor
    public int getDifficulty() {
        return difficulty;
    }

    //Accessor
    public String getText() {
        return text;
    }

    //Accessor
    public List<Answer> getAnswers() {
        return answers;
    }
}
