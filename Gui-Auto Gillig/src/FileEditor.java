
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileEditor {

    private DirectoryManager directoryManager; 

    private String fileName;
    private String secondFileName;
    private int quantity;
    private String binLocation;
    private int numberOfBoxes; 

    public FileEditor(){
        directoryManager = new DirectoryManager();  //
    }

    public FileEditor(String fileName, String secondFileName, int quantity){
        this.fileName = fileName;
        this.secondFileName = secondFileName;
        this.quantity = quantity;
    }

    public FileEditor(String fileName, String secondFileName, String quantity, String binLocation, int numberOfBoxes){ 
        this.binLocation = binLocation;
        this.numberOfBoxes = numberOfBoxes;  //
    }

    public void editNewFile(String fileName, String secondFileName, int quantity){
        try {
                FileWriter fileWriter = new FileWriter(directoryManager.getDirectory() + fileName.toUpperCase() + ".txt", true); 
                BufferedWriter writer = new BufferedWriter(fileWriter); 
                writer.write(fileName.toUpperCase() + "\n");
                writer.write(secondFileName.toUpperCase() + "\n");
                writer.write(Integer.toString(quantity) + "\n");
                writer.close(); 

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
