
import java.util.Scanner;

class function{
    Scanner input=new Scanner(System.in);
    int counter=1;
    Record[]records;
    int ID, Age;
    String name,disease;
    boolean found=false;
    
    public function(){
        records=new Record[100];
        
    }
    public void addRecord(String name, int ID,int Age,String disease,String advice){
        records[counter-1]=new Record(name,ID,Age,disease,advice);
        counter++;
    }
    
    public void updateRecord(){
        System.out.print("Enter the ID: ");
        ID=input.nextInt();

        for(int i=0;i<counter;i++){
            Record record=records[i];
            if(record!=null && ID == record.getID())
            {
                System.out.print("Enter the new name: ");
                name=input.next()+input.nextLine();
                System.out.print("Enter the new ID: ");
                ID=input.nextInt();
                System.out.print("Enter the new age: ");
                Age=input.nextInt();
                disease= determineDisease();
                String advice= Advise(disease);
                System.out.println(advice);

                record.setName(name);
                record.setAge(Age);
                record.setID(ID);
                record.setDisease(disease);
                
                System.out.println("The record has been updated sucessfully.");
                found=true;
            }
            if(found==false){
                System.out.println("No record found.");
            }
        }
    }
    
    public void deleteRecord(){
        boolean status = true;
        System.out.print("Enter the ID: ");
        ID=input.nextInt();
        for(int i=0;i<records.length;i++){
            Record record=records[i];
            if(record!=null && ID==record.getID()){
                records[i]=null;
                System.out.println("The record has been deleted.");
                status=false;
            }
        }
        if(status==true){
            System.out.println("No record found. ");
        }
        
    }
    
    public void searchRecord(){
        boolean status=true;
        System.out.print("Enter the ID: ");
        int searchID=input.nextInt();
        System.out.println("===Records===");
        
        System.out.printf("%4s\t\t%14s\t\t%3s\t\t%-50s%-150s","ID","Name","Age","Disease","Advice");
        System.out.println("");
        for(int i=0;i<counter;i++){
            Record record=records[i];
            if(record!=null && searchID == record.getID()){
                System.out.printf("%4d\t\t%14s\t\t%3d\t\t%-50s%-150s%n",record.getID(),record.getName(),record.getAge(),record.getDisease(),record.getAdvice());
                System.out.println("");
                status=false;
                
                }
            }
            if(status==true){
                System.out.println("No record found");
            }
        }
    
   
    public void displayRecord() {
        System.out.println("===Records===");
        System.out.printf("%4s\t\t%14s\t\t%3s\t\t%-50s%-150s%n","ID","Name","Age","Disease","Advice");
        for(int i=0; i<counter; i++) {
            Record record = records[i];
            if(record != null) {
                System.out.printf("%4s\t\t%14s\t\t%3d\t\t%-50s%-150s%n",record.getID(), record.getName(), record.getAge(),record.getDisease(),record.getAdvice());
            }
        }
    }
    
    public String determineDisease(){
        
        System.out.println("Please type Y or N for the following symptoms");
        System.out.print("Body aches: ");
        char body=input.next().charAt(0);
        System.out.print("Cough: ");
        char cough=input.next().charAt(0);
        System.out.print("Fatigue: ");
        char fatigue=input.next().charAt(0);
        System.out.print("Itchy eyes: ");
        char itchy=input.next().charAt(0);
        System.out.print("Fever: ");
        char fever=input.next().charAt(0);
        System.out.print("Diarrhoea: ");
        char  diarrhoea=input.next().charAt(0);
        System.out.print("Sore throat: ");
        char sore=input.next().charAt(0);
        System.out.print("Loss of taste or smell: ");
        char loss=input.next().charAt(0);
        System.out.print("");
        
        if((body=='y'||body == 'Y') && (cough=='y'||cough=='Y')&& (fatigue=='y'||fatigue=='Y')&&(fever=='y'||fever=='Y')&&(diarrhoea=='y'||diarrhoea=='Y')&&(sore=='y'||sore=='Y')){
            disease="flu";
        }
        
        else if((cough=='y'||cough=='Y')&& (fatigue=='y'||fatigue=='Y')&&(fever=='y'||fever=='Y')&&(loss=='y'||loss=='Y')){
            disease="covid";
        }
        
        else if((body=='y'||body == 'Y') && (cough=='y'||cough=='Y')&& (fatigue=='y'||fatigue=='Y')&&(sore=='y'||sore=='Y')){
            disease="cold";
        }
        
        else if((cough=='y'||cough=='Y')&&(itchy=='y'||itchy=='Y')){
            disease="allergies";
        }
        
        else{
            disease="Unable to determine the disease.";
        }
        
        System.out.println("Your disease: "+ disease);

        return disease;
    }

    public String Advise(String disease){
        System.out.println("====Advice====");
        
        if(disease =="flu"){
            return ("Stay at home and rest. Avoid close contact with people. Seek for medical care and keep warm.");
        }
        else if(disease=="covid"){
            return ("Stay home and quarantine for at least 5 days. Drink more water and sleep more. Monitor your symptoms, seek for help from professional if getting worse.");
        }
        else if(disease=="allergies"){
            return ("Stay indoor on windy days. Visit a doctor and get some medicines.");
        }
        else if (disease=="cold"){
            return ("Stay hydrated and get some rest. You may get some medicines to ease the symptoms but be noted that antibiotics will not help.");
        }
        else{
            return ("Please monitor your body for a few days and drink more water. Fail to determine the disease as some symptoms might not appeared yet.");
        }
    }
    
}
