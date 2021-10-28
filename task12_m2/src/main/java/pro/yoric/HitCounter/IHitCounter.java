package pro.yoric.HitCounter;

import java.io.IOException;

public interface IHitCounter
{
    String getCalls() throws IOException;
    String getCallsImagePath() throws IOException;
    void   setCall()  throws IOException;
}
