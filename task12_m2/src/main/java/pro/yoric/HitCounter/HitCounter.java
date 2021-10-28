package pro.yoric.HitCounter;

import java.io.IOException;

public class HitCounter
    implements IHitCounter
{
    IDataController     transfer  = new DataController();
    IGraphicsController imageFile = new GraphicsController();

    @Override
    public String getCalls()
        throws IOException
    {
        return transfer.getInfo();
    }

    @Override
    public String getCallsImagePath()
        throws IOException
    {
        return imageFile.changeImageText(transfer.getInfo()).getName();
    }

    @Override
    public void setCall()
        throws IOException
    {
        int newAmountHits = Integer.parseInt(transfer.getInfo()) + 1;
        transfer.setInfo(newAmountHits);
    }
}
