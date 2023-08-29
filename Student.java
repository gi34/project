/*Name:Lam Hui Shan
Matric:293384
*/
    public class Student{
        private String name,status,university,program;
        private int matric;
        private double weight,height,bmi;
        
        public Student(String name,int matric, String status, String university, String program, double weight, double height, double bmi){
            this.name=name;
            this.matric=matric;
            this.status=status;
            this.university=university;
            this.bmi=bmi;
            this.height=height;
            this.weight=weight;
            this.program=program;
        }
        public String getName(){
            return name;
        }
        public int getMatric(){
            return matric;
        }
        public String getStatus(){
            return status;
        }
        public String getUniversity(){
            return university;
        }
        public String getProgram(){
            return program;
        }
        public double getWeight(){
            return weight;
        }
        public double getHeight(){
            return height;
        }
       
        public double getbmi(){
            return bmi;
        }
    
}
