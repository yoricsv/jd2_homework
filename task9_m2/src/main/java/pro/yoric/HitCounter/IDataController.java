package pro.yoric.HitCounter;

import java.io.IOException;

public interface IDataController
{
           String getInfo ()             throws IOException;
             void setInfo (int newValue) throws IOException;
    static   void reset   () {};
}
