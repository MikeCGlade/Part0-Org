import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int userInput = 0;

    public static void main(String[] args){

        /*Debugging Below*/
        Scanner scanner = new Scanner(System.in); 

        //Item array list
        ArrayList<Item> items = new ArrayList<Item>(); 

        ItemManager itemManager = new ItemManager(); 

        // Create a new directory named "Items" 
        DirectoryManager directoryManager = new DirectoryManager();
        directoryManager.createDirectory();

        while (userInput != 4){

            System.out.print("\033[H\033[2J");
            System.out.println("[-------------------------]");
            System.out.println("| Welcome to Auto-GILLIG! |");
            System.out.println("[-------------------------]");
            System.out.println();
            System.out.println("Options are Listed Down Below: ");
            System.out.println();
            
            System.out.println("Option 1: Enter 1 to add new items!");
            System.out.println("Option 2: Enter 2 to edit existing items!");
            System.out.println("[PRIMARY] Option: Enter 3 to Begin Paperwork!");
            System.out.println("Option 4: Enter 4 to close program!");
            System.out.println();
            
            System.out.println("Enter an option to begin (1-4): ");
            userInput = scanner.nextInt();

            switch (userInput){
                case 1:

                    System.out.print("\033[H\033[2J");
                    System.out.println("[--------------]");
                    System.out.println("| Auto-GILLIG! |");
                    System.out.println("[--------------]");
                    System.out.println();
                    System.out.println("Please enter Gillig's part name: ");
                    String companyPartName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Please enter FSI's part name: ");
                    String fsiPartName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Please enter the price per box: ");
                    int price = scanner.nextInt();
                    items.add(itemManager.newItem(companyPartName, fsiPartName, price)); 

                    FileGenerator fileGenerator = new FileGenerator(companyPartName, directoryManager.getDirectory()); 
                    fileGenerator.generateFile();

                    try {
                        FileWriter fileWriter = new FileWriter(directoryManager.getDirectory() + companyPartName + ".txt", true); 
                        BufferedWriter writer = new BufferedWriter(fileWriter); 
                        writer.write(companyPartName + "\n");
                        writer.write(fsiPartName + "\n");
                        writer.write(Integer.toString(price) + "\n");
                        writer.close(); 

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.println("[--------------]");
                    System.out.println("| Auto-GILLIG! |");
                    System.out.println("[--------------]");
                    System.out.println();

                    for (int i = 0; i < items.size(); i++){
                        System.out.println(items.get(i).fsiPartName);
                    }

                    try {
                        long start = System.currentTimeMillis();
                        System.out.println("Sleeping...");
                        Thread.sleep(2000);
                        long end = System.currentTimeMillis();
                        System.out.println("Awake! Slept for " + (end - start) + " milliseconds.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.println("[--------------]");
                    System.out.println("| Auto-GILLIG! |");
                    System.out.println("[--------------]");
                    // Begin paperwork code here
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.println("[--------------]");
                    System.out.println("| Auto-GILLIG! |");
                    System.out.println("[--------------]");
                    System.out.println();
                    System.out.println("Program Exiting...");

                    System.out.println("Thank you for using Auto-GILLIG.");
        
                    System.out.println("Program Terminated.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break; 
            }
            

        }

        scanner.close();

    }

    
}