/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.programmingproject;

import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class Student extends User{
    private int semester;
    private String project,supervisor,recommendation,evaluator,grade;
    private double totalMark,finalReport,proposalMark,articleMark,presentationMark,pointer;

    public Student(String name, String matric, int semester, String pass){
        super(name,matric,pass);
        this.semester=semester;
        
    }
            
    public Student(){
   
    }
    
    public Student(String name, String matric, int semester, String pass,String project, String supervisor,double finalReport,double proposalMark,double articleMark,double presentationMark,double totalMark,String grade,String recommendation,String evaluator,double pointer){//for coordinator
        super(name,matric, pass);
        this.articleMark=articleMark;
        this.finalReport=finalReport;
        this.totalMark=totalMark;
        this.semester=semester;
        this.project=project;
        this.supervisor=supervisor;
        this.proposalMark=proposalMark;
        this.presentationMark=presentationMark;
        this.grade=grade;
        this.recommendation=recommendation;
        this.evaluator=evaluator;
        this.pointer=pointer;
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
   
    
    //getters
    public String getName(){
        return name;
    }
    public String getmatric(){
        return matric;
    }
    public String getpass(){
        return password;
    }
    public int getSemester(){
        return semester;
    }
    public String getProject(){
        return project;
    }
    public String getSupervisor(){
        return supervisor;
    }
    public String getEvaluator(){
        return evaluator;
    }
     public String getRecommendation(){
        return recommendation;
    }
    public double gettotalMark(){
        return totalMark;
    }
    public double getfinalReport(){
        return finalReport;
    }
    public double getproposalMark(){
        return proposalMark;
    }
    public double getarticleMark(){
        return articleMark;
    }
    public double getpresentationMark(){
        return presentationMark;
    }
    public String getGrade(){
        return grade;
    }
    public double getPointer(){
        return pointer;
    }
    
    //setters
    public void setSuper(String supervisor){
        this.supervisor=supervisor;
    }
    public void setProject(String project){
        this.project=project;
    }
    public void setRecom(String recom){
        recommendation=recom;
    }
    public void setEvaluator(String evaluator){
        this.evaluator=evaluator;
    }
    public void settotalMark(double total){
        totalMark=total;
    }
    public void setfinalReport(double finalmark){
        finalReport=finalmark;
    }
    public void setproposal(double proposalmark){
        proposalMark=proposalmark;
    }
    public void setarticle(double article){
        articleMark=article;
    }
    public void setpre(double pre){
        presentationMark=pre;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
   public void setPointer(double pointer) {
       this.pointer=pointer;
   }
   
}
