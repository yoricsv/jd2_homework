package pro.yoric.parser;

public class Responder
{
    public Responder(String browserName)
    {
        this.browserName = browserName;
    }

    public String getName()
    {
        return this.browserName;
    }

    @Override
    public String toString()
    {
        return String.valueOf(browserName == null ? "" : getName());
    }

    @Override                                                       // IMPORTANT! Need to solve hashtable collisions
    public boolean equals(Object object)
    {
        if (object == this)
            return true;

        if (!(object instanceof Responder))
            return false;

        Responder responderObject = (Responder) object;

        return responderObject.getName().equals(this.browserName);
    }

    @Override                                                       // IMPORTANT! Need to solve hashtable collisions
    public int hashCode()
    {
        return browserName == null ? 0 : browserName.hashCode();
    }

    public        final String    browserName;
    public static final Responder UNKNOWN = new Responder("Unknown browser");
}
