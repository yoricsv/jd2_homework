package pro.yoric.HitCounter;

import java.io.IOException;

public interface IDataController
{
    int  getInfo()             throws IOException;
    void setInfo(int newValue) throws IOException;
}
