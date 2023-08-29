class Product {
    int productId;
    private String productName;
    private double price;
    private int quantity;
    
    public void setProductId(int newId){
    productId=newId;
}
    public void setProductName(String newName){
        productName=newName;
    }
    
    public void setPrice(double newPrice){
        price=newPrice;
    }
    
    public void setQuantity(int quan){
        quantity=quan;
    }
    
    public int getProductId(){
        return productId;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    //default constructor with default value
    Product(){
        productId=0;
        productName=null;
        price=0.0;
        quantity=0;
    }
    
    //parameterized constructor
    Product(int newProductId, String newProductName, double newPrice,int newQuantity){
       productId=newProductId;
       productName=newProductName;
       price=newPrice;
       quantity=newQuantity;
        
    }
}
