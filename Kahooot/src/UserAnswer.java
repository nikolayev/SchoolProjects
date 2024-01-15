public class UserAnswer {
    private Question question;
    private boolean correct;

    public UserAnswer(Question question, boolean correct){
        this.question = question;
        this.correct = correct;
    }

    public Question getQuestion(){
        return question;
    }

    public boolean getCorrectUserAnswer(){
        return correct;
    }

}
