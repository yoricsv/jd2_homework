package pro.yoric.HitCounter;

import java.io.IOException;

public interface IHitCounter
{
    int  getVisits() throws IOException;
    void setVisit()  throws IOException;
    void doInitParam(String initValue);
}
