package pro.yoric.parser;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.*;

public class SessionHandler
{
    public SessionHandler(HttpServletRequest req)
    {
        session = req.getSession();

        session.getLastAccessedTime();

        session.setMaxInactiveInterval(86400);
        session.setMaxInactiveInterval(-1);
    }

    public void addKeyValue (String key, String value)
    {
        session.setAttribute("key", value);
    }

    public String getValue (String key)
    {
        return (String) session.getAttribute(key);
    }

    private List<String> getAllKeyValueList(HttpSession session)
    {
        List<String> sessionList = new ArrayList<>();

        Enumeration<String> keys = session.getAttributeNames();

        while(keys.hasMoreElements())
        {
            sessionList.add(keys.nextElement());
        }

        return sessionList;
    }

    private final HttpSession session;
}
