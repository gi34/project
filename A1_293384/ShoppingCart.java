import java.util.Scanner;
public class ShoppingCart{
    private Product[]products;
    int counter=0;
    
    Scanner input=new Scanner(System.in);
    public ShoppingCart(){
        products =new Product[20];
    }
    
    public void addProduct(Product product){  
        products[counter]=new Product();
        
        System.out.print("Enter the product name: ");
        String productName=input.next()+input.nextLine();
        System.out.print("Enter the product ID: ");
        int productId=input.nextInt();
        System.out.print("Enter the price: ");
        double price=input.nextDouble();
        System.out.print("Enter the quantity:");
        int quantity=input.nextInt();
        
        product.setPrice(price);
        product.setProductId(productId);
        product.setProductName(productName);
        product.setQuantity(quantity);
        
        products[counter]=product;
        
        System.out.println("The product has been added sucessfully.");
        counter++;
    }
    
    public void removeProduct(int productId){
    
        for(int i=0;i<products.length;i++)
        {
            if(productId==products[i].productId &&products[i]!=null)
            {
                products[i]=null;
                System.out.print("The product has been deleted.");
                break;
            }
            else
            {
                System.out.println("No product was found.");
                break;
            }
        }
    }
    
    public void displayProducts(){
        System.out.printf("%10s\t%15s\t\t%10s\t%8s","Product ID","Product name","price(RM)","quantity");
        System.out.println("");
        System.out.println("____________________________________________________________________");
        for(int i=0; i<counter; i++) 
        {
            if(products[i]!=null)
            {
                Product product=products[i];
                System.out.printf("%10s\t%15s\t\t%10s\t%8s",product.getProductId(),product.getProductName(),product.getPrice(),product.getQuantity());
                System.out.println("");
            }
        }
        System.out.println();
    }
    
    public double calculateTotalPrice(){
        double total=0;
        for(int i=0;i<counter;i++)
        {
            if(products[i]!=null)
            {
                total+=products[i].getPrice()*products[i].getQuantity();
            }
        }
        return total;
    }
}