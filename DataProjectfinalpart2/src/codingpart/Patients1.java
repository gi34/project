/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codingpart;

/**
 *
 * @author USER
 */
public class Patients1 {
    private String name;
    private String symptom;
    private String disease;

    public Patients1(String name,String symptom,String disease){
    this.name = name;
    this.symptom = symptom;
    this.disease = disease;
    }
    public String getName(){
        return name;
    }

    public String getSymptom(){
        return symptom;
    }
    public void setSymptom(String symptom){
        this.symptom = symptom;
    }
    public String getDisease(){
        return disease;
    }
    public void setDisease(String disease){
        this.disease = disease;
    }
    public String toString(){
        return "Name: " + name + "\nSymptoms: " + symptom + "\nDisease: " + disease ;
    }
}
