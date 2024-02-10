import java.util.*;

class SeachRequest {
    private final long minSize;
    private final long maxSize;
    private final Date minLastModifiedDate;
    private final Date maxLastModifiedDate;
    private final Date minCreationDate;
    private final Date maxCreationDate;
    private final String fileName;
    private String startPath;

    public static class Builder {
        private long minSize = 0;
        private long maxSize = 0;
        private Date minLastModifiedDate = null;
        private Date maxLastModifiedDate = null;
        private Date minCreationDate = null;
        private Date maxCreationDate = null;
        private String fileName = "";
        private String startPath = "";


        public Builder minSize(long size){
            this.minSize = size;
            return this;
        }

        public Builder maxSize(long size){
            this.maxSize = size;
            return this;
        }

        public Builder minLastModificationDate(Date date){
            this.minLastModifiedDate = date;
            return this;
        }

        public Builder maxLastModificationDate(Date date){
            this.maxLastModifiedDate = date;
            return this;
        }

        public Builder minCreationDate(Date date){
            this.minCreationDate = date;
            return this;
        }

        public Builder maxCreationDate(Date date){
            this.maxCreationDate = date;
            return this;
        }

        public Builder fileName (String name){
            this.fileName = name;
            return this;
        }

        public SeachRequest build(){
            return new SeachRequest(this);
        }

        public Builder startPath(String path){
            this.startPath = path;
            return this;
        }
    } 
    
    private SeachRequest(Builder builder){
        this.minSize = builder.minSize;
        this.maxSize = builder.maxSize;
        this.minLastModifiedDate = builder.minLastModifiedDate;
        this.maxLastModifiedDate = builder.maxLastModifiedDate;
        this.minCreationDate = builder.minCreationDate;
        this.maxCreationDate = builder.maxCreationDate;
        this.fileName = builder.fileName;
        this.startPath = builder.startPath;
    }

    public void setStartPath(String path){
        this.startPath = path;
    }

    public String getFileName(){
        return this.fileName;
    }

    public long getMinSize(){
        return this.minSize;
    }

    public long getMaxSize(){
        return this.maxSize;
    }

    public Date getMinLastModifiedDate(){
        return this.minLastModifiedDate;
    }

    public Date getMaxLastModifiedDate(){
        return this.maxLastModifiedDate;
    }

    public Date getMinCreationDate(){
        return this.minCreationDate;
    }

    public Date getMaxCreationDate(){
        return this.maxCreationDate;
    }

    public String getStartPath (){
        return startPath;
    }
}