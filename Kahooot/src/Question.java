import java.util.List;

//Custom class that represents the quiz question in the game
//Alexander Nikolayev 01/16/2024
public class Question {

    //Sets up data types (R.1)
    private final String text;
    private final int difficulty;
    private final List<Answer> answers;

    //Constructor (R.2.1)
    public Question(String text, int difficulty, List<Answer> answers) {
        this.text = text;
        this.difficulty = difficulty;
        this.answers = answers;
    }

    //Accessor (R.2.2)
    //Calculates the index of the correct answer in the list of all possible answers
    //Pre-condition: You must have possible answers, and one of them must be correct
    //Post-condition: Accessor / none
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
