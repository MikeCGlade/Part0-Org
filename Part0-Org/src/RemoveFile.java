import java.io.File;

public class RemoveFile {
    void deleteFile(String fileName, String directory){
        File file = new File(directory + fileName + ".txt");
        if (file.delete()){
            System.out.println("Deleted the file: " + file.getName());
        }else{
            System.out.println("Failed to delete the file: " + file.getName());
        }
    }
}
