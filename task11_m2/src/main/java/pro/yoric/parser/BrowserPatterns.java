package pro.yoric.parser;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class BrowserPatterns
{
    private BrowserPatterns()
    {
        this.patterns = new Hashtable<>();

        String[] browserPpatterns = {
            "(.*)(^Seamonkey)/(\\d+)(.*)(Firefox|MozillaDeveloperPreview)(.*Tablet\\sbrowser)?/(\\d+)(.*)$",
            "(.*)(^Chromium)/(\\d+)(.*)(CrMo|CriOS|Chrome)/(\\d+)(.*)$",
            "(.*)(Chromium)/(\\d+)(.*)$",
            "(.*)(Edg?)/(\\d+)(.*)$",
            "(.*)([MS]?IE|IEMobile|Trident)(.*)rv(.*)$",
            "(.*)(Opera(.Tablet|.Mobi|.Mini)?|OPR)(.*)$",
            "(.*)(YaBrowser)/(\\d+)(.*)$",
            "(.*)(Navigator|Netscape6)/(\\d+)(.*)$",
            "(.*)(Safari)/(\\d+)(.*)$",
            "(.*)(UC(.)?Browser|UCWEB)(.*)$",
            "(.*)(OneBrowser)/(\\d+)(.*)$",
            "(.*)(Chimera|SeaMonkey|Camino)/(\\d+)(.*)$"
        };
        String[] browserRealName = {
            "user of the Mozilla Firefox browser",
            "Google Chrome browser user",
            "Chromium browser user",
            "Microsoft Edge browser user",
            "Internet Explorer user",
            "Opera browser user",
            "Yandex Browser user",
            "user of the Netscape Navigator browser",
            "Apple Safari browser user",
            "UC Browser user",
            "user of ONE browser",
            "SeaMonkey Browser user"
        };

        for (String k: browserPpatterns)
            for (String v: browserRealName)
            {
                PatternHandler pairs = new PatternHandler(k,v);

                patterns.put(pairs.getCompiledPattern(), pairs.getReference());
            }

        this.patternEnumKeys  = patterns.keys();                                    // make pattern as enumeration keys
        this.patternsIterator = patterns.entrySet().iterator();
    }

    public static BrowserPatterns getInstance()
    {
        return instance;
    }

    public Enumeration<Pattern> getPatternEnumKeys()
    {
        return this.patternEnumKeys;
    }

    public Iterator<Map.Entry<Pattern, String>> getIterator()
    {
        return this.patternsIterator;
    }

    Hashtable<Pattern, String> getPatterns()
    {
        return this.patterns;
    }

    private static final BrowserPatterns               instance = new BrowserPatterns();
    private final Hashtable<Pattern, String>           patterns;
    private final Enumeration<Pattern>                 patternEnumKeys;
    private final Iterator<Map.Entry<Pattern, String>> patternsIterator;
}