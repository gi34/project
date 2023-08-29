/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.programmingproject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Supervisor extends User{
        public Supervisor(){
            
        }
        

        @Override
        public boolean Login(String matric, String password) throws IOException {
        boolean login=false;
        File inFile = new File("registration.txt");
        Scanner reader= new Scanner(inFile);
        String line;
            while ((line = reader.nextLine())!= null){
                String[] parts = line.split("\\s+"); 
                if (parts.length == 2) {
                    String Username = parts[0];
                    String Password = parts[1];

                    if (Username.equals(matric) && Password.equals(password)) {
                        login=true;
                        return login;
                    }
        
                }
            }
        return login;
        }
        
        //setters
        public void setfinalReport(Student stud,double finalReport){
            stud.setfinalReport(finalReport);
        }
        
    
    }
