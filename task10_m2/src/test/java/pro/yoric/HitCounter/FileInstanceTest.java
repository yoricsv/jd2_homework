package pro.yoric.HitCounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FileInstanceTest
{
    FileInstance iFileInstance;

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
    }

    public FileInstanceTest()
        throws  ClassNotFoundException,
                InvocationTargetException,
                IllegalAccessException,
                NoSuchMethodException
    {
        Class <?>    className  = Class.forName("pro.yoric.HitCounter.IFileInstance");
        Method       getMethod  = className.getDeclaredMethod("getFile");
        IFileInstance _fileTest = (FileInstance) getMethod.invoke(null);

        Assertions.assertNull(_fileTest.getFile());
    }

    @Test
    public void testInstance() {
        Assertions.assertNotNull(iFileInstance);
    }

    @org.junit.After
    public void tearDown()
            throws Exception
    {
    }

}
