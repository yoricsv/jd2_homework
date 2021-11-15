package pro.yoric.parser;

import java.util.regex.Pattern;

public class PatternHandler
{
    public PatternHandler(String pattern, String reference)
    {
        this.pattern   = pattern;
        this.reference = reference;
    }

    public String getPattern()
    {
        return pattern;
    }

    public Pattern getCompiledPattern()
    {
        return Pattern.compile(Pattern.quote(pattern));
    }

    public String getReference()
    {
        return reference;
    }

    @Override                                                       // IMPORTANT! Need to solve hashtable collisions
    public boolean equals(Object object)
    {
        if (object == this)
            return true;

        if (!(object instanceof PatternHandler))
            return false;

        PatternHandler patternHandlerObject = (PatternHandler) object;

        return patternHandlerObject.getPattern().equals(this.pattern)
            && patternHandlerObject.getPattern().equals(this.reference);
    }

    @Override                                                       // IMPORTANT! Need to solve hashtable collisions
    public int hashCode()
    {
        return (pattern   == null ? 0 : pattern.hashCode())
             + (reference == null ? 0 : reference.hashCode());
    }

    private final String pattern;
    private final String reference;
}
