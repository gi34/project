import java.util.Scanner;
public class consultationSystem {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        function data=new function();
        int choice,Age,ID;
        boolean flag=true;
        String name,disease,advice;
 
        
        while (flag==true) {
            System.out.println("===Consultation System===");
            System.out.println("1 - add record\n2 - update record\n3 - delete record\n4 - search\n5 - display record\n6 - exit");
            System.out.print("Enter your choice: ");
            choice=input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the name: ");
                    name=input.next()+input.nextLine();
                    System.out.print("Enter the ID: ");
                    ID=input.nextInt();
                    System.out.print("Enter the age: ");
                    Age=input.nextInt();
                    disease = data.determineDisease();
                    advice=data.Advise(disease);
                    System.out.println(advice);
                    data.addRecord(name, ID, Age, disease, advice);
                    System.out.println("The record has been added sucessfully.");
                    System.out.println("");
                    break;
                case 2:                
                    data.updateRecord();
                    System.out.println("");
                    break;
                case 3:
                    data.deleteRecord();
                    System.out.println("");
                    break;
                case 4:
                    data.searchRecord();
                    System.out.println("");
                    break;
                case 5:
                    data.displayRecord();
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("Thank you for using consultation system.It is encourage to visit a doctor and rest well.");
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid number. Please choose again.");
                    break;
            }
        }
    }
}



    
    