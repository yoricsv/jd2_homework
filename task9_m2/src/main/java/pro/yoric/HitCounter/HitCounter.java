package pro.yoric.HitCounter;

import java.io.IOException;

public class HitCounter
    implements IHitCounter
{
    IDataController transfer = new DataController();

    @Override
    public void doInit(String initValue)
    {
        transfer.doInit(initValue);
    }

    @Override
    public int getCalls() throws IOException
    {
        return transfer.getInfo();
    }

    @Override
    public void setCall() throws IOException
    {
        int visitsCounter = transfer.getInfo();
        transfer.setInfo(++visitsCounter);
    }
}
