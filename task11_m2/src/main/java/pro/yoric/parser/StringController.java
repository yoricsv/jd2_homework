package pro.yoric.parser;

public class StringController
{
    public StringController(){}

    public StringController(String userAgentContext)
    {
        if(!userAgentContext.isEmpty())
            this.userAgentString = userAgentContext;
        else
            this.userAgentString = Responder.UNKNOWN.getName();
    }

    private String getUserAgentString()
    {
        return this.userAgentString;
    }

    public String parse(String agentString)
    {
        if (   agentString == null
            || agentString.isEmpty())
            return "From StringController check null or empty";//Responder.UNKNOWN.getName();

        return BrowserDetection.match(agentString).getName();
    }

    private String userAgentString;
}
