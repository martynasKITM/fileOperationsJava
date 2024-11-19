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

        writeStudentsToCsv(students, outputFile); //call method to write data file
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
            bw.write("Name, Subject, Grade, Average");
            bw.newLine();
            for(Student student : students){
                double average = student.calculateAverage();
                String roundedAverages = String.format("%.2f", average);
                for(Grade grade : student.getGrades()){
                    String roundedGrades = String.format("%.2f", grade.getScore());

                    bw.write(student.getName() + "," + grade.getSubject() + "," + roundedGrades + "," + roundedAverages);
                    bw.newLine();
                }
            }
            System.out.println("Data to file has been writen");
        }catch(IOException e){
            System.err.println("error reading file " + e.getMessage());
        }
    }
}