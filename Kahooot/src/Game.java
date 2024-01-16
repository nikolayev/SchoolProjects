import java.util.ArrayList;
import java.util.List;

//This is a custom type that contains main game logic
//Alexander Nikolayev 01/16/2024
public class Game {

    // Using List data type to store questions (R.1)
    private final List<Question> gameQuestions;
    private final List<UserAnswer> userAnswers = new ArrayList<>();
    private int questionIndex = -1;

    // Constructor (R.2.1)
    public Game(List<Question> questions) {
        this.gameQuestions = questions;
    }

    //This is an accessor and mutator
    //Advances the game to the next-question
    // Next question logic (R.2.2, R.3 - Decision-making)
    public Question getNextQuestion() {
        questionIndex++;
        return gameQuestions.get(questionIndex);
    }

    //CheckAnswer checks if the user answer is correct, and stores that information,
    // and returns information about the correctness of the result
    // Checking the answer (R.2.3 - Non-void method, R.3)
    public CheckedAnswer checkAnswer(int answerIndex) {
        Question currentQuestion = gameQuestions.get(questionIndex);
        int correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
        boolean isCorrect = correctAnswerIndex == answerIndex;
        UserAnswer useranswer = new UserAnswer(currentQuestion, isCorrect);
        userAnswers.add(useranswer);
        Answer correctAnswer = currentQuestion.getAnswers().get(correctAnswerIndex);
        return new CheckedAnswer(correctAnswer, isCorrect);
    }

    //Accessor
    //Calculates the current score of the game, giving previously provided answer
    //Always recalculates
    // Calculate score (R.2.3 - Non-void method with parameters)
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

    // Other accessor methods
    //Calculates the number of correct answers by the player
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

    //Accessor
    //Checks if there are more questions left in the game
    //Implemented to provide a stopping condition for the game
    public boolean hasMoreQuestions() {
        return questionIndex < gameQuestions.size() - 1;
    }

    //Accessor
    public int getQuestionCount() {
        return gameQuestions.size();
    }
}
