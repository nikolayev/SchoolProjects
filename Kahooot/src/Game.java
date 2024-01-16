import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Question> gameQuestions;
    private final List<UserAnswer> userAnswers = new ArrayList<>();
    private int questionIndex = -1;

    public Game(List<Question> questions) {
        this.gameQuestions = questions;
    }

    public Question getNextQuestion() {
        questionIndex++;
        return gameQuestions.get(questionIndex);
    }

    public CheckedAnswer checkAnswer(int answerIndex) {
        Question currentQuestion = gameQuestions.get(questionIndex);
        int correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
        boolean isCorrect = correctAnswerIndex == answerIndex;
        UserAnswer useranswer = new UserAnswer(currentQuestion, isCorrect);
        userAnswers.add(useranswer);
        Answer correctAnswer = currentQuestion.getAnswers().get(correctAnswerIndex);
        return new CheckedAnswer(correctAnswer, isCorrect);
    }

    public int getScore() {
        int totalScore = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            UserAnswer userAnswer = userAnswers.get(i);
            int difficulty = userAnswer.getQuestion().getDifficulty();
            boolean correct = userAnswer.getCorrectUserAnswer();
            if (correct) {
                totalScore += 100 * difficulty;
            }
        }
        return totalScore;
    }

    public int getCorrectCount() {
        int correctCount = 0;
        for (UserAnswer userAnswer : userAnswers) {
            boolean correct = userAnswer.getCorrectUserAnswer();
            if (correct) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public boolean hasMoreQuestions() {
        return questionIndex < gameQuestions.size() - 1;
    }

    public int getQuestionCount() {
        return gameQuestions.size();
    }
}
