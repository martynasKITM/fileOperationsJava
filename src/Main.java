import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "students.csv";
        String outputFile = "students_with_grades.csv";

        List<Student> students = readStudentsFromFile(inputFile);
        System.out.println(students);

        for(Student student : students){
            student.addGrade("Math", Math.random() * 100);
            student.addGrade("English", Math.random() * 100);
            student.addGrade("CS", Math.random() * 100);
        }
    }

    private static List<Student> readStudentsFromFile(String filename){
        List<Student> students = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) !=null){
                students.add(new Student(line.trim())); //create students from file
            }
        }catch(IOException e){
            System.err.println("error reading file " + e.getMessage());
        }
        return  students;
    }

    private static void writeStudentsToCsv(List<Student> students, String fileName){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            bw.write("Name, Subject, Grade, Average");git branch -M main
        }catch(IOException e){
            System.err.println("error reading file " + e.getMessage());
        }
    }
}