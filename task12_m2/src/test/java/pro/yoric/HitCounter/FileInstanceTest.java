package pro.yoric.HitCounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FileInstanceTest
{
    FileInstance iFileInstanceFile;

    @org.junit.Before
    public void resetFileInstanceTest()
            throws SecurityException,
            NoSuchFieldException,
            IllegalArgumentException,
            IllegalAccessException
    {
        Field instance =
                FileInstance
                .class
                .getDeclaredField("instance");

        instance.setAccessible(true);
        instance.set(null, null);

        Assertions.assertNull(FileInstance.getInstance());
//        Assertions.assertNull(FileInstance.getInstance(false));
    }

    public FileInstanceTest()
        throws  ClassNotFoundException,
                InvocationTargetException,
                IllegalAccessException,
                NoSuchMethodException
    {
        Class <?>    className  = Class.forName("pro.yoric.HitCounter.IFileInstance");
        Method       getMethod  = className.getDeclaredMethod("getFile");
//        Method       getMethod  = className.getDeclaredMethod("getFile", boolean.class);
        IFileInstance _fileTest = (FileInstance) getMethod.invoke(null);

        Assertions.assertNull(_fileTest.getFile());
//        Assertions.assertNull(_fileTest.getFile(false));
    }

    @Test
    public void testInstance() {
        Assertions.assertNotNull(FileInstance.getInstance());
//        Assertions.assertNotNull(FileInstance.getInstance(false));
    }

    @org.junit.After
    public void tearDown()
            throws Exception
    {
    }

}
