package pro.yoric.HitCounter;

import java.io.IOException;

public class HitCounter
    implements IHitCounter
{
    IDataController transfer = new DataController();

    @Override
    public String getCalls() throws IOException
    {
        return transfer.getInfo();
    }

    @Override
    public void setCall() throws IOException
    {
        int newAmountHits = Integer.parseInt(transfer.getInfo()) + 1;
        transfer.setInfo(newAmountHits);
    }
}
