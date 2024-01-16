import java.util.List;

public class Question {
    private final String text;
    private final int difficulty;
    private final List<Answer> answers;

    public Question(String text, int difficulty, List<Answer> answers) {
        this.text = text;
        this.difficulty = difficulty;
        this.answers = answers;
    }

    public int getCorrectAnswerIndex() {
        for (int i = 0; i < answers.size(); i++) {
            Answer checkedAnswer = answers.get(i);
            if (checkedAnswer.isCorrect()) {
                return i;
            }
        }
        return -1;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
