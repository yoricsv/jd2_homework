# [jd2_homework *(Enterprise homeworks)*][goBack] > Reminder: for tests
[goBack]: ../../README.md

<!-- ---------------------------------- * Navigation * ---------------------------------- -->

### The code I have to use in the unit tests:
```java

    IHitCounter iHitCounter = new HitCounter();
    FileInstance checkPath  = FileInstance.getInstance();


    out.println(
        "The Path from WEB.XML BEFORE: "                + getWebXmlPath()               + "<br/>"+
        "The servlet absolute path BEFORE: "            + getAbsolutePath()             + "<br/><br/>"+

        "Prepared path to init: "                       + setInitParam()                + "<br/><br/>"+
        "Check BEFORE return throw try/catch: "         + stateBefore                   + "<br/><br/>"+
        "Check AFTER return throw try/catch: "          + state                         + "<br/><br/>"+

        "The Path from WEB.XML AFTER: "                 + getWebXmlPath()               + "<br/>"+
        "The servlet absolute path AFTER: "             + getAbsolutePath()             + "<br/><br/>"+

        "The Path before Instance (initFilePath): " + checkPath.getInstancePath()   + "<br/>"+
        "The Path after Instance (realFilePath): "      + checkPath.getPath()           + "<br/>"
    );


    private String setInitParam()
    {
        absoluteAppPath    = this.getServletConfig().getServletContext().getRealPath("");
        path               = this.getServletConfig().getInitParameter("WEB_FILE_PATH");
        initFilePath   = absoluteAppPath + path;

        File file = new File(initFilePath + "visits.dat");

        checkReturn(file);

//            return file.getParentFile().mkdirs()
//            && file.createNewFile();
        if (file.canRead()
        && file.canWrite())
            state = "<br/>>>>>>  After creation: Can The file read? - "  + file.canRead() +
                    "<br/>>>>>>  After creation: Can The file write? - " + file.canWrite();

        return initFilePath;//file.getPath();

        /* NIO */
//        Path path = Paths.get(initFilePath + "visits.dat"); //"data/logging.properties"
//        Path path = Paths.get(initFilePath);//"data/subdir"
//
//        boolean pathExists =
//            Files.exists(
//                path,
//                LinkOption.NOFOLLOW_LINKS
//            );
//
//        try
//        {
//            Path newDir = Files.createDirectory(path);
//        }
//        catch(FileAlreadyExistsException e)
//        {
//            logger.warn(e.toString(), e);
//        }
//        catch (IOException e)
//        {
//            logger.trace(e.toString(), e);
//        }
//        return initFilePath ;

    }

    public String checkBefore(File file)
    {
        if (   file.canRead()
            && file.canWrite())
            return stateBefore =
                "<br/>>>>>> Before creation: Can The file read? - "  + file.canRead() +
                "<br/>>>>>> Before creation: Can The file write? - " + file.canWrite();
        return stateBefore = ">>> The File doesn't exist! IT'S RIGHT!!!!";
    }

    public boolean checkReturn(File file)
    {
        checkBefore(file);
        try
        {
            return     file.getParentFile().mkdirs()
                    && file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }


    public String getWebXmlPath()  {return path;}
    public String getAbsolutePath(){return absoluteAppPath;}
    private String path, initFilePath, absoluteAppPath, stateBefore, state;


    private static final Logger logger =
        LoggerFactory
        .getLogger(
            HitCounterServlet.class
    );
    private      InitialContext initialContext   = null;

```