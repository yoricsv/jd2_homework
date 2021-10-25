# [jd2_homework *(Enterprise homeworks)*][goBack] > Creating files and directories via The Servlet
[goBack]: ../../README.md

<!-- ---------------------------------- * Navigation * ---------------------------------- -->

## Create folders and file via I/O
```java
// to get the file path via the servlet, the code setInitParam() method
// must be in the init() method of the servlet
private void setInitParam()
{
    String absoluteAppPath = this.getServletConfig().getServletContext().getRealPath("");
    String path            = this.getServletConfig().getInitParameter("WEB_FILE_PATH");
    String initFilePath    = absoluteAppPath + path;

    instanceFileAndDirectories(initFilePath);
}

public File instanceFileAndDirectories(String path)
{
    try
    {
        filePointer = new File(path + FILE_NAME);

        if(checkAccessToFile(filePointer))
        {
            BufferedWriter fbw =
                new BufferedWriter(
                    new FileWriter(filePointer)
                );

            fbw.write(String.valueOf("... some text ..."));

            fbw.flush();
            fbw.close();

            return getFile();
        }
        else
            instanceFault();
    }
    catch (IOException e)
    {
        logger.error(e.toString(), e);
    }
}

private boolean checkAccessToFile(File filePtr)
{
    if(filePtr.exists())
        return     filePtr.canRead()
                && filePtr.canWrite();
    else
    {
        try
        {
            return     filePtr.getParentFile().mkdirs()
                    && filePtr.createNewFile()
                    && filePtr.canRead()
                    && filePtr.canWrite();
        }
        catch (IOException e)
        {
            logger.trace(e.toString(), e);
        }
    }
    return false;
}

public File getFile() {return this.filePointer;}

private static final String FILE_NAME   = "visits.dat";
private              File   filePointer = null;
```
