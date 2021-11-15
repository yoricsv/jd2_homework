package pro.yoric.parser;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrowserDetection
{
    private static final BrowserPatterns  patterns = BrowserPatterns.getInstance();
    private        final StringController uaStringContent;

    public BrowserDetection(StringController uaStringContent)
    {
        this.uaStringContent = uaStringContent;
    }

    public static Responder match(String agentString)
    {
        String browserName = null;
        Iterator<Map.Entry<Pattern, String>> it = patterns.getIterator();
        while (it.hasNext())
        {
            Map.Entry<Pattern, String> entry = it.next();
            Matcher matcher = entry.getKey().matcher(agentString);

            if(matcher.matches())
                return new Responder(entry.getValue());
//            browserName = patterns.getPatterns().getOrDefault(entry.getKey(), "Unknown browser");
        }

//        while (patterns.getPatternEnumKeys().hasMoreElements())
//        {
//            Pattern key     = patterns.getPatternEnumKeys().nextElement();
//            Matcher matcher = key.matcher(agentString);
//            if (!matcher.find()) return null;
//        }

        return browserName == null ? new Responder("From BrowserDetection last return") /*Responder.UNKNOWN*/ : new Responder(browserName);
    }


    @Override
    public String toString()
    {
        return String.valueOf(uaStringContent);
    }
}
