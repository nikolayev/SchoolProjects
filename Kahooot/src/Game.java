import java.util.List;
public class Game {
    private int score;
    private List<Question> gameQuestions;
    private int questionIndex;
    public Game(List<Question> questions) {
        this.gameQuestions = questions;
    }

    public Question getNextQuestion(int questionIndex){
        questionIndex++;
        return gameQuestions.get(questionIndex);
    }
    public boolean checkAnswer(int answerIndex){
        Question currentQuestion = gameQuestions.get(questionIndex);
        int correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
        return correctAnswerIndex == answerIndex;
    }
}
