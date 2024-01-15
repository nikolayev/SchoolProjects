import java.util.ArrayList;
import java.util.List;
public class Game {
    private final List<Question> gameQuestions;
    private final List<UserAnswer> userAnswers = new ArrayList<>();
    private int questionIndex = -1;

    public Game(List<Question> questions) {
        this.gameQuestions = questions;
    }

    public Question getNextQuestion(){
        questionIndex++;
        return gameQuestions.get(questionIndex);
    }
    public boolean checkAnswer(int answerIndex){
        Question currentQuestion = gameQuestions.get(questionIndex);
        int correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
        boolean isCorrect = correctAnswerIndex == answerIndex;
        UserAnswer useranswer = new UserAnswer(currentQuestion, isCorrect);
        userAnswers.add(useranswer);
        return correctAnswerIndex == answerIndex;
    }

    public int getScore(){
        int totalScore = 0;
        for(int i=0;i<userAnswers.size();i++){
            UserAnswer userAnswer = userAnswers.get(i);
            int difficulty = userAnswer.getQuestion().getDifficulty();
            boolean correct = userAnswer.getCorrectUserAnswer();
            if(correct){
                totalScore += 100*difficulty;
            }
        }
        return totalScore;
    }

}
