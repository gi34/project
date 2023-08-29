/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.programmingproject;

import java.io.IOException;

/**
 *
 * @author User
 */
public abstract class User {
    protected String name,matric,password;
    
    public User(String name,String matric, String password){
        this.name=name;
        this.matric=matric;
        this.password=password;
    }
    public User(){
        
    }
    
    public abstract boolean Login(String matric, String password) throws IOException;

    public void setName(String name){
        this.name=name;
    }
    public void setMatric(String matric){
        this.matric=matric;
    }
    public void setpass(String password){
        this.password=password;
    }
    

}