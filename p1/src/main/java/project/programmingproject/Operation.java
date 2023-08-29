package project.programmingproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Operation {

    public ArrayList<Student> studlist = new ArrayList<>();
    Student stud= new Student();
    
    public final void loadDataFromFile() {
        Scanner inputFile;
        try {
            inputFile = new Scanner(new File("studentRegistration.txt"));
            while (inputFile.hasNextLine()) {
                String[] studentData = inputFile.nextLine().split("\t");
                // Parse the data and create a new Student object
                String name = studentData[0];
                String matricNo = studentData[1];
                int semester = Integer.parseInt(studentData[2]);
                String password = studentData[3];
                String project = studentData[4];
                String supervisor = studentData[5];
                String evaluator = studentData[6];
                double proposalMark = Double.parseDouble(studentData[7]);
                double articleMark = Double.parseDouble(studentData[8]);
                double presentationMark = Double.parseDouble(studentData[9]);
                double finalReport = Double.parseDouble(studentData[10]);
                double totalMark = Double.parseDouble(studentData[11]);
                double pointer = Double.parseDouble(studentData[12]);
                String grade = studentData[13];
                String recommendation = studentData[14];

                Student student = new Student(name, matricNo, semester, password, project, supervisor, finalReport, proposalMark, articleMark, presentationMark, totalMark, grade, recommendation, evaluator, pointer);
                studlist.add(student);
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void register(String name, String password, int sem, String matric) throws IOException {

        boolean found = false;
        for (int i = 0; i < studlist.size(); i++) {
            if (studlist.get(i).getmatric().equals(matric)) {
                found = true;
                break;//stop search
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(null, "Student has been registered.");
        } else {
            stud = new Student(name, matric, sem, password);
            studlist.add(stud);
            System.out.println(stud.getmatric() + "pass is " + stud.getpass());
            JOptionPane.showMessageDialog(null, "Registration Succesfully.");
            writeToFile();
            PrintWriter outputFile = new PrintWriter(new FileWriter("registration.txt",true));
            String record=matric+"\t"+password;
            outputFile.println(record);
            outputFile.close();
        }
        
    }

    public boolean deletelist(String matric) throws FileNotFoundException {
        boolean delete = false;
        for (int i = 0; i < studlist.size(); i++) {
            if (stud != null && stud.getmatric().equals(matric)) {
                studlist.remove(stud);
                delete = true;
            }
        }
        writeToFile();
        return delete;
    }

    public Student search(String matric) {
        for (int i = 0; i < studlist.size(); i++) {
            stud = studlist.get(i);
            if (stud != null && stud.getmatric().equals(matric)) {
                return stud;
            }
        }

        return null;
    }

    //register or delete student
    public void writeToFile() throws FileNotFoundException {
        try (PrintWriter outputFile = new PrintWriter(new FileWriter("studentRegistration.txt"))) {
            for (int idx = 0; idx < studlist.size(); idx++) {
                String name = studlist.get(idx).getName();
                String password = studlist.get(idx).getpass();
                String matricNo = studlist.get(idx).getmatric();
                int semester = studlist.get(idx).getSemester();
                String project = studlist.get(idx).getProject();
                String supervisor = studlist.get(idx).getSupervisor();
                String evaluator = studlist.get(idx).getEvaluator();
                String grade = studlist.get(idx).getGrade();
                double totalMark = studlist.get(idx).gettotalMark();
                double finalReport = studlist.get(idx).getfinalReport();
                double proposalMark = studlist.get(idx).getproposalMark();
                double articleMark = studlist.get(idx).getarticleMark();
                double presentationMark = studlist.get(idx).getpresentationMark();
                double pointer = studlist.get(idx).getPointer();
                String recommendation = studlist.get(idx).getRecommendation();

                String studentRecord = String.join("\t", name, matricNo, String.valueOf(semester), password, project, supervisor, evaluator,
                        Double.toString(proposalMark), Double.toString(articleMark), Double.toString(presentationMark), Double.toString(finalReport),
                        Double.toString(totalMark), Double.toString(pointer), grade, recommendation);

                outputFile.println(studentRecord);
            }
            outputFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void updateStudentProject(String matric, String project, String supervisor) throws FileNotFoundException {
        boolean found=true;
        for (int i = 0; i < studlist.size(); i++) {
            if (studlist.get(i).getmatric().equals(matric)) {
                stud=studlist.get(i);
                stud.setProject(project);
                stud.setSuper(supervisor);
                writeToFile();
                JOptionPane.showMessageDialog(null, "Save successful.");
                break; // Exit the method once the student is found and updated
            }
        }
    }

    public double calcTotal(double proposalMark, double presentationMark, double article, double finalReport) {
        double total = proposalMark + presentationMark + article + finalReport;
        return total;
    }

    public String calcGrade(double total) {
        String grade;

        if (total >= 90.0 && total <= 100.0) {
            grade = "A+";
        } else if (total >= 80.0 && total <= 89.9) {
            grade = "A";
        } else if (total >= 75.0 && total <= 79.9) {
            grade = "A-";
        } else if (total >= 70.0 && total <= 74.9) {
            grade = "B+";
        } else if (total >= 65.0 && total <= 69.9) {
            grade = "B";
        } else if (total >= 60.0 && total < 64.9) {
            grade = "B-";
        } else if (total >= 55.0 && total <= 59.9) {
            grade = "C+";
        } else if (total >= 50.0 && total <= 54.9) {
            grade = "C";
        } else if (total >= 45.0 && total <= 49.9) {
            grade = "C-";
        } else if (total >= 40.0 && total <= 44.9) {
            grade = "D+";
        } else if (total >= 35.0 && total <= 39.9) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;

    }

    public double calcPointer(String grade) {
        double pointer;

        switch (grade) {
            case "A+", "A" -> {
                pointer = 4.00;
            }
            case "A-" -> {
                pointer = 3.67;
            }
            case "B+" -> {
                pointer = 3.33;
            }
            case "B-" -> {
                pointer = 2.67;

            }
            case "C+" -> {
                pointer = 2.33;

            }
            case "C-" -> {
                pointer = 1.67;

            }
            case "D+" -> {
                pointer = 1.33;

            }
            case "D" -> {
                pointer = 1.00;

            }

            default -> {
                pointer = 0.00;
            }

        }

        return pointer;

    }
    
   

}
