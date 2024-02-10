# File Search API
File Search API allows you to search for files withing your computer, you can specify things like Date, size, name, start path

# How to use
Craete a searh request (utilizes builder pattern) 

ex:

SeachRequest seachRequest = new SeachRequest.Builder().startPath("C:\\metasploit").maxSize(10).minSize(5).build();

then put it into the fileSearchAPI function and it returns a List<> of FileInfo which contains name, path, size, creationDate, lastModifiedDate
