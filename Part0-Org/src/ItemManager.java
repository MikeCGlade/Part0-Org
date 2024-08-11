public class ItemManager {

    /* 
     * This class will be primarily used to print item information as well as create or delete items.
     * This will utilize the file editor class to save the item information
     */

    public int quantity = 0;
    public String binLocation = null;

    public Item newItem(String companyPartName, String fsiPartName, int price) {
        Item item = new Item(companyPartName, fsiPartName, price);
        return item; 
    }

}
