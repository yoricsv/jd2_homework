package pro.yoric.HitCounter;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IDataController
{
    int     getInfo() throws IOException;
    boolean setInfo() throws IOException;
}
