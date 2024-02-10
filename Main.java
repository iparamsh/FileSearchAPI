import java.net.DatagramPacket;
import java.util.*;
public class Main {
    public static void main (String [] args){
        //testing things here
        Date startDate = new Date(123, 05,30);
        Date endDate = new Date(122, 05,30);
        SeachRequest seachRequest = new SeachRequest.Builder().startPath("C:\\metasploit").maxSize(10).minSize(5).build();
        FileSearchAPI fileSearchAPI = new FileSearchAPI();
        List <FileInfo> list = new ArrayList<>();
        try {
            list = fileSearchAPI.fileSearch(seachRequest);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }

        for (FileInfo file : list){
            System.out.println("Path: " + file.getPath() + " Name: " + file.getFileName() + " Last mod date: " + file.getLastModifiedDate().toString() + " Last creation Date: " + file.getLastCreationDate().toString() + " Size: " + file.getSize());
        }
    }
}
