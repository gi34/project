/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.programmingproject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Coordinator extends User{
        
        public Coordinator(){
           
        }

        @Override
        public boolean Login(String user, String password) throws IOException {
        boolean login=false;
        File inFile = new File("registration.txt");
        Scanner reader= new Scanner(inFile);
        String line;
            while ((line = reader.nextLine())!= null){
                String[] parts = line.split("\\s+"); 
                if (parts.length == 2) {
                    String Username = parts[0];
                    String Password = parts[1];

                    if (Username.equals(user) && Password.equals(password)) {
                        login=true;
                        return login;
                    }
        
                }
            }
        return login;
        }
        
        public void settotal(Student stud,double totalMark){
            stud.settotalMark(totalMark);
        }
        
        public void setEvaluator(Student stud,String evaluator){
           stud.setEvaluator(evaluator);
        }
        public void setGrade(Student stud, String grade){
            stud.setGrade(grade);
        }
        
        public void setPointer(Student stud,double pointer){
            stud.setPointer(pointer);
        }
    }


    


    
    
