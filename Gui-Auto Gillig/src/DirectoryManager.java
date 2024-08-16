import java.io.File;

public class DirectoryManager {

    private String directoryName = "Items";
    String userName = System.getProperty("user.name");
    String directory = "src//Items"; 

    public DirectoryManager(){}

    public DirectoryManager(String directoryName) {
        this.directoryName = directoryName;
    }
    
    void createDirectory(){

        // Define the directory path for Items
        File itemDirectory = new File(directory);
        
        // Check if the directory exists
        if (!itemDirectory.exists()){
            itemDirectory.mkdirs();
        }else{
            System.out.println("Directory already exists");
        }

    }

    //Gets the directory
    String getDirectory() {
        return directory + "//";
    }
}