package pro.yoric.parser;

import java.util.Hashtable;
import java.util.Map;

public class BrowserDetection
{
    public BrowserDetection (UAString clientName)
    {
        this.uaStringContent = clientName;
    }

//    @Override
//    public int hashCode() {
//        return uaStringContent == null ? 0 : uaStringContent.hashCode();
//    }
    @Override
    public String toString()
    {
        return String.valueOf(uaStringContent);
    }

    public final UAString uaStringContent;

    public String detect(String agentContent)
    {
        return agentContent;
    }


}
