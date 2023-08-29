/*Name:Lam Hui Shan
Matric:293384
*/
public class StudentOperation {
    
    private Student[] list;
    
    public StudentOperation(){//create an array list
        list =new Student[5];
    }
    
    public Double calculateBMI(double height,double weight){
        double bmi =0;
        bmi=weight/(height*height);
        return bmi;
    }
    
    public String getStatusBMI(double bmi){
        String status="";
        if(bmi>35.0)
            status = ("Severly Obese");
        else if(bmi>=30.1 && bmi<=35.0)
            status = "Moderately Obese";
        else if(bmi>=25.1 && bmi<=30.0)
            status="Overweight";
        else if(bmi>=18.6 && bmi<=25)
            status="Normal weight";
        else if (bmi>=16.0 && bmi<=18.5)
            status="Underweight";
        else
            status="Severely Underweight";
        return status;
    }
    
    public void saveRecord(int i,Student stud){//add record into array of object
        list[i]=stud;
    }
    
    public String readAllrecord(){
        String read="";
            for(int i=0;i<list.length;i++){
            if(list[i]!=null&&list[i].getMatric()!=0)
                read+=list[i].getName()+"\t"+list[i].getMatric()+"\t"+list[i].getProgram()+"\t"+list[i].getUniversity()+"\t"+list[i].getHeight()+"\t"+list[i].getWeight()+"\t"+String.format("%.2f", list[i].getbmi())+"\t"+list[i].getStatus()+"\n";
            }
        return read;
    }
    
    public Student searchRecord(int target){
        Student record = null;
        boolean found=false;
        for(int i=0;i<list.length;i++){
            if(list[i]!=null&&target==list[i].getMatric()){
                record=list[i];
                found=true;
                return record;
            }
        }
        return null;
    }
    
    public String updateRecord(String name,int matric,double height, double weight, double bmi,String program, String university,String status){
        boolean found=false;
        for(int i=0;i<list.length;i++){
            if(list[i]!=null&&matric==list[i].getMatric()){
                list[i]=new Student(name, matric, status, university, program, weight, height, bmi);
                found=true;
            }
        }
        if(found==true)
            return "The record has been updated.";
        else
            return "No record is found.";
    }
}
