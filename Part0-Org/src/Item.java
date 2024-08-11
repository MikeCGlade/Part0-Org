public class Item {
    public int quantity = 0;
    public String binLocation = null;
    public String companyPartName;
    public String fsiPartName;
    public int price; 

    // Item's default values
    public Item(String companyPartName, String fsiPartName, int price){
        this.companyPartName = companyPartName;
        this.fsiPartName = fsiPartName;
        this.price = price; 
    }
    
    public Item(String companyPartName, String fsiPartName, int price, int quantity, String binLocation){
        this.quantity = quantity;
        this.binLocation = binLocation;
    }

    // Setters for the default values
    public void setCompanyPartName(String companyPartName){
        this.companyPartName = companyPartName;
    }

    public void setFSIPartName(String fsiPartName){
        this.fsiPartName = fsiPartName;
    }

    public void setPrice(int price){
        this.price = price;
    }

    // Getters for the default values
    public String getCompanyPartName(){
        return companyPartName;
    }

    public String getFSIPartName(){
        return fsiPartName;
    }

    public int getPrice(){
        return price; 
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBinLocation(){
        return binLocation;
    }

    //Quantities and Bin Locations
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setBinLocation(String binLocation){
        this.binLocation = binLocation;
    }
}
