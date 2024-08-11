import java.io.File;
import java.io.IOException; 

public class FileGenerator {

    private final String fileName; 
    private final String directory;

    public FileGenerator(String fileName, String directory) {
        this.fileName = fileName;
        this.directory = directory;
    }

    //Generates a file with given name. 
    void generateFile(){
        try {
            File file = new File(directory + fileName + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println("Error Occured when generating file");
            e.printStackTrace();
        }
    }

}
