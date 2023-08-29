import java.util.Scanner;
public class main
{
    public static void main(String[] args) 
    {
        Scanner input=new Scanner(System.in);
        ShoppingCart cart=new ShoppingCart();
        boolean flag=true;
        
        while(flag==true)
        {
            System.out.println("");
            System.out.println("==== Online Shop ====");
            System.out.println("1. Add a product to the shopping cart");
            System.out.println("2. Remove a product from the shopping cart");
            System.out.println("3. Display the products in the shopping cart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            System.out.println("");    
        
            if(choice==1){
                Product product=new Product();
                cart.addProduct(product);
                System.out.println("");
            }

            else if(choice==2){
                System.out.print("Enter the product ID: ");
                int productId=input.nextInt();
                cart.removeProduct(productId);
                System.out.println("");

            }
            else if(choice==3){
                cart.displayProducts();
                double total=cart.calculateTotalPrice();
                System.out.println("Total: RM" +total);

            }

            else if(choice==4){
                System.out.println("Thank you for using Online Shop");
                flag=false;
                break;
            }
            else{
                System.out.println("Invalid number.Please choose again");
            }
        }
    }
}