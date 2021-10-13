package pro.yoric.HitCounter;

import java.io.IOException;

public class HitCounter
    implements IHitCounter
{
    IDataController transfer = new DataController();

    @Override
    public void setVisit()
        throws IOException
    {
        visitsCounter = transfer.getInfo();
        transfer.setInfo(++visitsCounter);
    }

    @Override
    public int getVisits()
        throws IOException
    {
        return transfer.getInfo();
    }

    @Override
    public void doInitParam(String initValue)
    {
        transfer.doInit(initValue);
    }

    private int visitsCounter = 0;
}
