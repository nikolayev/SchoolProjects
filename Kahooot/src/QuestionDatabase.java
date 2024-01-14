import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;

public class QuestionDatabase {
    public ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<Question>();
        String questionText1 = "Best Letter?";
        ArrayList<Answer> answers1 = new ArrayList<Answer>();
            String answerText11 = "A";
            Answer answer11 = new Answer(answerText11, false);
            String answerText12 = "B";
            Answer answer12 = new Answer(answerText12, false);
            String answerText13 = "C";
            Answer answer13 = new Answer(answerText13, false);
            String answerText14 = "D";
            Answer answer14 = new Answer(answerText14, true);
            answers1.add(answer11);
            answers1.add(answer12);
            answers1.add(answer13);
            answers1.add(answer14);
        Question question1 = new Question(questionText1, 0, answers1);

        return questions;
    }
}