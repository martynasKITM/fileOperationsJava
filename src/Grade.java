public class Grade {
    private String subject;
    private double score;

    public Grade(String subject, double score){
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public double getScore() {
        return score;
    }
}
