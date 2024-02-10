import java.util.*;

class FileInfo{
    private final long size;
    private final Date lastModifiedDate;
    private final Date lastCreationDate;
    private final String fileName;
    private final String path;

    public FileInfo (long size, Date lastModifiedDate, Date lastCreationDate, String fileName, String path){
        this.size = size;
        this.lastCreationDate = lastCreationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.fileName = fileName;
        this.path = path;
    }

    public long getSize(){
        return size;
    }
    public Date getLastModifiedDate(){
        return lastModifiedDate;
    }

    public Date getLastCreationDate(){
        return lastCreationDate;
    }

    public String getFileName(){
        return fileName;
    }

    public String getPath(){
        return path;
    }
}