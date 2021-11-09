package pro.yoric.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class UAStringParser
{
    public UAStringParser(List<BrowserPatterns> patterns)
    {
        this.patterns = patterns;
    }

    public static UAStringParser fromList(List<Map<String,String>> configList)
    {
        List<BrowserPatterns> configPatterns = new ArrayList<BrowserPatterns>();

        for (Map<String, String> configMap : configList)
            configPatterns.add(UAStringParser.patternFromMap(configMap));

        return new UAStringParser(configPatterns);
    }

    public UAString parse(String agentString)
    {
        if (agentString == null)
            return null;

        UAString agent;
        for (BrowserPatterns p : patterns)
            if ((agent = p.match(agentString)) != null)
                return agent;

        return new UAString("Other");
    }

    protected static BrowserPatterns patternFromMap(Map <String, String> configMap)
    {
        String regex = configMap.get("regex");

        if (regex == null)
            throw new IllegalArgumentException("User agent is missing regex");


        return (new BrowserPatterns(Pattern.compile(regex), configMap.get("family_replacement")));
    }

    private final List<BrowserPatterns> patterns;
}
