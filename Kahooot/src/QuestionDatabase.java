import java.util.List;

//Stores question information separate from the application logic
//Sample questions, in the future can be replaced with a file or a real database
public class QuestionDatabase {
    public List<Question> getQuestions() {
        //This is a list of questions, each containing a list of possible answers (Don't cheat)
        List<Question> questions = List.of(
            new Question("Which Java type represents whole numbers?", 1, List.of(
                new Answer("String", false),
                new Answer("double", false),
                new Answer("int", true),
                new Answer("float", false))),
            new Question("Which loop uses indices?", 2, List.of(
                new Answer("for", true),
                new Answer("while", false),
                new Answer("Enhanced for", false))),
            new Question("Java is Object oriented.", 1, List.of(
                new Answer("true", true),
                new Answer("false", false))),
            new Question("What is the return value of (true || false)?", 2, List.of(
                new Answer("true", true),
                new Answer("false", false),
                new Answer("1", false),
                new Answer("Yes", false))),
            new Question("What is the size of a 'char' in Java?", 2, List.of(
                new Answer("8 bits", false),
                new Answer("16 bits", true),
                new Answer("32 bits", false),
                new Answer("64 bits", false))),
            new Question("Which method is called when a Java program starts?", 1, List.of(
                new Answer("init()", false),
                new Answer("run()", false),
                new Answer("main()", true),
                new Answer("start()", false))),
            new Question("What is the default value of a boolean variable in Java?", 3, List.of(
                new Answer("true", false),
                new Answer("null", false),
                new Answer("0", false),
                new Answer("false", true))),
            new Question("Which keyword is used to inherit a class in Java?", 3, List.of(
                new Answer("super", false),
                new Answer("implements", false),
                new Answer("extends", true),
                new Answer("this", false))),
            new Question("Which data type represents 'no value'?", 2, List.of(
                new Answer("void", true),
                new Answer("none", false),
                new Answer("empty", false),
                new Answer("nada", false))),
            new Question("1+1", 3, List.of(
                new Answer("1", false),
                new Answer("3", false),
                new Answer("11", false),
                new Answer("10", true)))
        );

        return questions;
    }
}