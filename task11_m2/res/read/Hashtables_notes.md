## [002_JMvnWebapp_][DescPrj] > **Web application building**

## <p align=center>[Project][DescPrj] | [Building][AutoBld] | [Installing][AutoInst] <br/> [Web-app][WebBld] | [Modularity][Module] | [Dependency][DepMng]</p>

<!--
* [Project description][DescPrj]
* [Project build automation][AutoBld]
* [Project setup automation][AutoInst]
* [Web application building][WebBld]
* [Project modularity][Module]
* [Dependency management][DepMng]
-->

[DescPrj]: ../../README.md
[AutoBld]: Maven_BuildAutomation.md
[AutoInst]: Maven_SetupAutomation.md
[WebBld]: Maven_WebApplication.md
[Module]: Maven_ModularityProject.md
[DepMng]: Maven_DependencyManagement.md

---
<br/>
<!-- ---------------------------------- * Navigation * ---------------------------------- -->

# <p align=center><i>Project name:</i> "<b>Hashtables</b>"</p>

```java
 public static Responder match(String agentString)
    {

        String browserName;

        // Use iterator
        Iterator<Map.Entry<Pattern, String>> it = patterns.getIterator();
        while (it.hasNext())
        {
            Map.Entry<Pattern, String> entry = it.next();
            Matcher matcher = entry.getKey().matcher(agentString);

            browserName = patterns.getPatterns().getOrDefault(entry.getKey(), "Unknown browser");
        }

        // Use Enumeration Set
        while (patterns.getPatternEnumKey().hasMoreElements())
        {
            Pattern key     = patterns.getPatternEnumKey().nextElement();
            Matcher matcher = key.matcher(agentString);
            if (!matcher.find()) return null;
        }

        // Use Lambda
//        patterns.getPatterns().forEach((k, v) -> k.getClass().getName().matcher(agentString).matches() ? null : v.getClass().getName());
    }
```
### BrowserPattern.java
```java
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

        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(^Chromium)/(\\d+)(.*)(CrMo|CriOS|Chrome)/(\\d+)(.*)$"
                )
            ),
            "Google Chrome browser user"
        );
        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(Chromium)/(\\d+)(.*)$"
                )
            ),
            "Chromium browser user"
        );
        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(Edg?)/(\\d+)(.*)$"
                )
            ),
            "Microsoft Edge browser user"
        );
        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)([MS]?IE|IEMobile|Trident)(.*)rv(.*)$"
                )
            ),
            "Internet Explorer user"
        );
        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(Opera(.Tablet|.Mobi|.Mini)?|OPR)(.*)$"
                )
            ),
            "Opera browser user"
        );
        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(YaBrowser)/(\\d+)(.*)$"
                )
            ),
            "Yandex Browser user"
        );

        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(Navigator|Netscape6)/(\\d+)(.*)$"
                )
            ),
            "user of the Netscape Navigator browser"
        );
        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(Safari)/(\\d+)(.*)$"
                )
            ),
            "Apple Safari browser user"
        );
        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(UC(.)?Browser|UCWEB)(.*)$"
                )
            ),
            "UC Browser user"
        );
        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(OneBrowser)/(\\d+)(.*)$"
                )
            ),
            "user of ONE browser"
        );
        patterns.put(
            Pattern.compile(
                Pattern.quote(
                    "(.*)(Chimera|SeaMonkey|Camino)/(\\d+)(.*)$"
                )
            ),
            "SeaMonkey Browser user"
        );

        this.patternEnumKey   = patterns.keys();           // make pattern as enumeration keys
        this.patternsIterator = patterns.entrySet().iterator();
    }

    public static BrowserPatterns getInstance()
    {
        return instance;
    }

    public Enumeration<Pattern> getPatternEnumKey()
    {
        return this.patternEnumKey;
    }

    public Iterator<Map.Entry<Pattern, String>> getIterator()
    {
        return this.patternsIterator;
    }

//    @Override                                                       // IMPORTANT! Need to solve hashtable collisions
//    public boolean equals(Object object)
//    {
//        if (object == this)
//            return true;
//
//        if (!(object instanceof Responder))
//            return false;
//
//        Responder responderObject = (Responder) object;
//
//        return responderObject.getName().equals(this.browserName);
//    }
//
//    @Override                                                       // IMPORTANT! Need to solve hashtable collisions
//    public int hashCode()
//    {
//        return browserName.hashCode();
//    }

    Hashtable<Pattern, String> getPatterns()
    {
        return this.patterns;
    }

    private static final BrowserPatterns            instance = new BrowserPatterns();
    private        final Hashtable<Pattern, String> patterns;
    private        final Enumeration<Pattern>       patternEnumKey;
    private        final Iterator<Map.Entry<Pattern, String>> patternsIterator;
}
```


```java
String input =
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Seamonkey/23.23 Gecko/20100101 Firefox/95.0";

Matcher matcher =
    Pattern.compile(
        Pattern.quote(
            "(.*)(^Seamonkey)/(\\d+)(.*)(Firefox|MozillaDeveloperPreview)(.*Tablet\\sbrowser)?/(\\d+)(.*)$"
        )
    ).matcher(input);

//            Matcher matcher = pattern.matcher(input);

if(matcher.matches())
    req.setAttribute("uas", "IS FIREFOX");
else
    req.setAttribute("uas", "IS SEAMONKEY");
```

```java

//    public Responder parse(String agentString)
//    {
//        if (agentString == null) return null;
//
//        Responder agent;

//        for (BrowserPatterns p : patterns)
//        {
//            if ((agent = p.match(agentString)) != null)
//                return agent;
//        }
//        return Responder.UNKNOWN;
//    }

//    public Responder match(String agentString)
//    {
//        String browserIs = null;
//
//        Matcher matcher = pattern.matcher(agentString);
//
//        if (!matcher.find())
//        {
//            return null;
//        }
//
//        for (BrowserPatterns p : patterns)
//            if ((agent = p.match(agentString)) != null)
//                return agent.getName();

//        family = familyReplacement;

//        return family == null ? null : new BrowserPatterns(family);
//    }
```