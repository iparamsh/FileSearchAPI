import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

class FileSearchAPI {
    private List<FileInfo> result = new ArrayList<>(); // list of results
    private StringBuilder stringBuilder; // use SB to get best Time Complexity

    // file search
    public List<FileInfo> fileSearch(SeachRequest seachRequest) throws Exception {
        // if start path was not specified it will equal to the disk C:\
        if (seachRequest.getStartPath().equals("")) {
            seachRequest.setStartPath("C:\\");
        }

        // creates a File instance and adds on the top of the stack
        File file = new File(seachRequest.getStartPath());
        Stack<File> stack = new Stack<>();
        stack.push(file);

        // Explanation: file becomes the top of the stack and stack pops
        // it gets the list of the files and goes through them. if its a folder it goes
        // on the top of the stack
        // if its a file, it will try to add it to the results
        while (!stack.isEmpty()) {
            file = stack.pop();
            File[] files = file.listFiles();
            for (File tempFile : files) {
                if (tempFile.isDirectory()) {
                    stack.push(tempFile);
                } else {
                    addFileIfAplicable(tempFile, seachRequest);
                }
            }
        }

        return result;
    }

    // adds the file to the results if it applies
    private void addFileIfAplicable(File file, SeachRequest seachRequest) throws Exception {
        Path path = file.toPath(); // get path
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class); // get attributes
        stringBuilder = new StringBuilder(); // initialize new SB
        stringBuilder.append(file.getAbsolutePath() + ", "); // add path to SB
        if (!seachRequest.getFileName().equals("")) { // checks if name needs to get checked
            if (!file.getName().contains(seachRequest.getFileName())) { // if file does not contain a string dont continue
                return;
            }
        }
        long fileSize = attr.size() / 1000; // convert from bytes to kb
        if (seachRequest.getMinSize() != 0 && fileSize < seachRequest.getMinSize()) {
            return;
        }
        if (seachRequest.getMaxSize() != 0 && fileSize > seachRequest.getMaxSize()) {
            return;
        }
        FileTime fileTime = attr.creationTime();
        // LocalDateTime localDateTime = LocalDateTime.ofInstant(fileTime.toInstant(),
        // ZoneId.systemDefault());
        Date fileCreationDate = Date.from(fileTime.toInstant());

        fileTime = attr.lastModifiedTime();
        Date fileLastModifiedDate = Date.from(fileTime.toInstant());

        if (seachRequest.getMinCreationDate() != null && fileCreationDate.before(seachRequest.getMinCreationDate())) {
            return;
        }

        if (seachRequest.getMaxCreationDate() != null && fileCreationDate.after(seachRequest.getMaxCreationDate())) {
            return;
        }

        if (seachRequest.getMinLastModifiedDate() != null && fileLastModifiedDate.before(seachRequest.getMinLastModifiedDate())) {
            return;
        }

        if (seachRequest.getMaxCreationDate() != null && fileLastModifiedDate.after(seachRequest.getMaxLastModifiedDate())) {
            return;
        }
        result.add(new FileInfo(fileSize, fileLastModifiedDate, fileCreationDate, file.getName(), file.getPath()));
    }
}
