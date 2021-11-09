package pro.yoric.parser;

import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BrowserPatterns
{
    public BrowserPatterns(
            Pattern pattern,
            String browserRealName
        )
    {
        this.pattern         = pattern;
        this.browserRealName = browserRealName;
    }

    private Map<String, String> patterns = new Hashtable<>();
//    patterns.put("(Edg?)/(\\d+)(.*)$", "Microsoft Edge");
//    patterns.put("(Edg?)/(\\d+)(.*)$", "Mozilla Firefox");
//    patterns.put("(Edg?)/(\\d+)(.*)$", "Google Chrome");
//    patterns.put("(Edg?)/(\\d+)(.*)$", "Chromium");
//    patterns.put("(Edg?)/(\\d+)(.*)$", "Internet Explorer");
//    patterns.put("(Edg?)/(\\d+)(.*)$", "Apple Safari");
//    patterns.put("(Edg?)/(\\d+)(.*)$", "Opera");
//    patterns.put("(Edg?)/(\\d+)(.*)$", "Seamonkey");
//    patterns.put("(Edg?)/(\\d+)(.*)$", "Internet Explorer");

    public UAString match(String agentString)
    {
        String family   = null;
        Matcher matcher = pattern.matcher(agentString);

        if (!matcher.find())
            return null;
        return family == null ? null : new UAString(family);
    }

    private final Pattern pattern;
    private final String  browserRealName;
}
//{
//    browserRealName:'SeaMonkey/Camino'
//    -regex:'(Chimera|SeaMonkey|Camino)/(\d+)\.(\d+)\.?([ab]?\d+[a-z]*)?'
//
//    browserRealName:'Firefox'
//    -regex:'(Firefox)/(\d+)\.(\d+)(a\d+[a-z]*)'
//    -regex:'(Firefox)/(\d+)\.(\d+)\.(\d+)'
//    -regex:'(Firefox)/(\d+)\.(\d+)(pre|[ab]\d+[a-z]*)?'
//    -regex:'(Firefox)/(\d+)\.(\d+)(b\d+[a-z]*)'
//    -regex:'(Firefox)-(?:\d+\.\d+)?/(\d+)\.(\d+)(a\d+[a-z]*)'
//    -regex:'(Firefox)-(?:\d+\.\d+)?/(\d+)\.(\d+)(b\d+[a-z]*)'
//    -regex:'(Firefox).*Tablet browser (\d+)\.(\d+)\.(\d+)'
//    -regex:'(MozillaDeveloperPreview)/(\d+)\.(\d+)([ab]\d+[a-z]*)?'
//
//    browserRealName:'Netscape'
//    -regex:'(Navigator)/(\d+)\.(\d+)\.(\d+)'
//    -regex:'(Navigator)/(\d+)\.(\d+)([ab]\d+)'
//    -regex:'(Netscape6)/(\d+)\.(\d+)\.?([ab]?\d+)?'
//
//    browserRealName:'Opera'
//    -regex:'(Opera Tablet).*Version/(\d+)\.(\d+)(?:\.(\d+))?'
//    -regex:'(Opera)/.+Opera Mobi.+Version/(\d+)\.(\d+)'
//    -regex:'(Opera)/(\d+)\.(\d+).+Opera Mobi'
//    -regex:'Opera Mobi.+(Opera)(?:/|\s+)(\d+)\.(\d+)'
//    -regex:'Opera Mobi'
//    -regex:'(Opera Mini)(?:/att)?/(\d+)\.(\d+)'
//    -regex:'(Opera)/9.80.*Version/(\d+)\.(\d+)(?:\.(\d+))?'
//    -regex:'(?:Mobile Safari).*(OPR)/(\d+)\.(\d+)\.(\d+)'
//    -regex:'(?:Chrome).*(OPR)/(\d+)\.(\d+)\.(\d+)'
//
//    browserRealName:'Swiftfox'
//    -regex:'(Firefox)/(\d+)\.(\d+)\.(\d+(?:pre)?) \(Swiftfox\)'
//    -regex:'(Firefox)/(\d+)\.(\d+)([ab]\d+[a-z]*)? \(Swiftfox\)'
//
//    browserRealName:'Google Chrome'
//    -regex:'(CrMo)/(\d+)\.(\d+)\.(\d+)\.(\d+)'
//    -regex:'(CriOS)/(\d+)\.(\d+)\.(\d+)\.(\d+)'
//    -regex:'(Chrome)/(\d+)\.(\d+)\.(\d+)\.(\d+) Mobile'
//
//    browserRealName:'Chromium'
//    -regex:'(Chromium|Chrome)/(\d+)\.(\d+)\.(\d+)'
//    -regex:'(Chromium|Chrome)/(\d+)\.(\d+)'
//
//    browserRealName:'UC Browser'
//    -regex:'(UCBrowser)[ /](\d+)\.(\d+)\.(\d+)'
//    -regex:'(UC Browser)[ /](\d+)\.(\d+)\.(\d+)'
//    -regex:'(UC Browser|UCBrowser|UCWEB)(\d+)\.(\d+)\.(\d+)'
//
//    browserRealName:'ONE Browser'
//    -regex:'(OneBrowser)/(\d+).(\d+)'
//
//    browserRealName:'WebKit Nightly'
//    -regex:'(AppleWebKit)/(\d+)\.?(\d+)?\+ .* Safari'
//
//    browserRealName:'Safari'
//    -regex:'(Version)/(\d+)\.(\d+)(?:\.(\d+))?.*Safari/'
//    -regex:'(Safari)/\d+'
//
//    browserRealName:'Microsoft Internet Explorer'
//    -regex:'Trident(.*)rv.(\d+)\.(\d+)'
//    -regex:'([MS]?IE) (\d+)\.(\d+)'
//    -regex:'(MSIE) (\d+)\.(\d+).*XBLWP7'
//    -regex:'(IEMobile)[ /](\d+)\.(\d+)'
//
//    browserRealName:'Yandex Browser'
//    -regex:'(YaBrowser)/(\d+)\.(\d+)\.(\d+)'
//}