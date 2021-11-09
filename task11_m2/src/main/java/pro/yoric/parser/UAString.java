package pro.yoric.parser;

import java.util.Map;

public class UAString
{
    public UAString(String uaContent)
    {
        this.uaContent = uaContent;
    }

    public static UAString fromMap(Map<String, String> m)
    {
        return new UAString(m.get("family"));
    }

    @Override
    public String toString()
    {
        return String.valueOf(uaContent);
    }

    public final String uaContent;
}
