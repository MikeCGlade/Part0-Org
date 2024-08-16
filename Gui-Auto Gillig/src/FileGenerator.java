import java.io.File;
import java.io.IOException; 

public class FileGenerator {

    //Generates a file with given name. 
    void generateFile(String fileName, String directory){
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
