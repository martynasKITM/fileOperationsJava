import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Grade> grades;

    public Student(String name){
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public double calculateAverage(){
        return grades.stream().mapToDouble(Grade::getScore).average().orElse(0.0);
    }

    @Override
    public String toString(){
        return "Studentas: " + name;
    }

    public void addGrade(String subject, double score) {
        grades.add(new Grade(subject, score));
    }
}
