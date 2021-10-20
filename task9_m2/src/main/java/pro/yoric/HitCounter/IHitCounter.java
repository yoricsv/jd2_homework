package pro.yoric.HitCounter;

import java.io.IOException;

public interface IHitCounter
{
    int  getCalls() throws IOException;
    void setCall()  throws IOException;
}
