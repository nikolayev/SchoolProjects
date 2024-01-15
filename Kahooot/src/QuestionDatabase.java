import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;

public class QuestionDatabase {
    public ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<Question>();
        String questionText1 = "Best Letter?";
        ArrayList<Answer> answers1 = new ArrayList<Answer>();
            String answerText11 = "A";
            Answer answer11 = new Answer(answerText11, true);
            String answerText12 = "B";
            Answer answer12 = new Answer(answerText12, false);
            String answerText13 = "C";
            Answer answer13 = new Answer(answerText13, false);
            String answerText14 = "D";
            Answer answer14 = new Answer(answerText14, false);
            answers1.add(answer11);
            answers1.add(answer12);
            answers1.add(answer13);
            answers1.add(answer14);
        Question question1 = new Question(questionText1, 1, answers1);
        questions.add(question1);

        String questionText2 = "Best Number?";
        ArrayList<Answer> answers2 = new ArrayList<Answer>();
        String answerText21 = "1";
        Answer answer21 = new Answer(answerText21, false);
        String answerText22 = "2";
        Answer answer22 = new Answer(answerText22, false);
        String answerText23 = "3";
        Answer answer23 = new Answer(answerText23, true);
        String answerText24 = "4";
        Answer answer24 = new Answer(answerText24, false);
        answers2.add(answer21);
        answers2.add(answer22);
        answers2.add(answer23);
        answers2.add(answer24);
        Question question2 = new Question(questionText2, 2, answers2);
        questions.add(question2);

        String questionText3 = "What do you call a variable that holds a whole number?";
        ArrayList<Answer> answers3 = new ArrayList<Answer>();
        String answerText31 = "double";
        Answer answer31 = new Answer(answerText31, false);
        String answerText32 = "integer";
        Answer answer32 = new Answer(answerText32, true);
        String answerText33 = "String";
        Answer answer33 = new Answer(answerText33, false);
        String answerText34 = "idk";
        Answer answer34 = new Answer(answerText34, false);
        answers3.add(answer31);
        answers3.add(answer32);
        answers3.add(answer33);
        answers3.add(answer34);
        Question question3 = new Question(questionText3, 3, answers3);
        questions.add(question3);

        String questionText4 = "Who are you?";
        ArrayList<Answer> answers4 = new ArrayList<Answer>();
        String answerText41 = "Me";
        Answer answer41 = new Answer(answerText41, false);
        String answerText42 = "You";
        Answer answer42 = new Answer(answerText42, false);
        String answerText43 = "Them";
        Answer answer43 = new Answer(answerText43, false);
        String answerText44 = "Us";
        Answer answer44 = new Answer(answerText44, true);
        answers4.add(answer41);
        answers4.add(answer42);
        answers4.add(answer43);
        answers4.add(answer44);
        Question question4 = new Question(questionText4, 1, answers4);
        questions.add(question4);

        return questions;
    }
}