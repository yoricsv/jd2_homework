# [jd2_homework *(Enterprise homeworks)*][goBack] > web.xml Set context param *(Examples)*
[goBack]: ../../README.md

<!-- ---------------------------------- * Navigation * ---------------------------------- -->


# EXAMPLES:
## Set Path via **context-param** *(general settings for each servlet)*:

```xml
    <context-param>
        <param-name>CONTEXT_PATH</param-name>
        <param-value>${catalina.base}/webapps/${artifactId}/data/visit.dat</param-value>
    </context-param>
```
To get the context parameters of the servlet might use to the next method:
### To get the result as a HashMap:
> ***NOTE***: We can add a ServletContext object here as a parameter.<br/>Everywhere, instead of the getServletConfig() method, use an instance of the ServletContext class
{
```java
private Map <String, String> getContextParam()
{
    Enumeration<String> initParams =
        getServletConfig()
        .getInitParameterNames();

    Map <String, String> paramMap = new HashMap<>();

    while (initParams.hasMoreElements())
    {
        String paramName = initParams.nextElement();

        if (    paramName != null
            && !paramName.isEmpty()
        )
            paramMap.put(
                paramName,
                getServletConfig()
                .getInitParameter(name)
            );
    }

    return paramMap;
}
```

### *To get the result as a Property Object:*
> ***NOTE***: The parameter can be removed here.<br/>Everywhere, instead of the context, use the getServletConfig() method
```java
private Properties getContextParam(ServletContext context)
{
    Properties          properties = new Properties();
    Enumeration<String> initParams = context.getInitParameterNames();

    while (initParams.hasMoreElements())
    {
        String paramName = initParams.nextElement();

        if (    paramName != null
            && !paramName.isEmpty()
        )
            properties.put(
                paramName,
                context
                .getInitParameter(paramName)
            );
    }
    return properties;
}
```

*To show:*
```java
private void showContext(HttpServletResponse resp)
    throws IOException
{
    PrintWriter out    = resp.getWriter();
    Enumeration <String> initParamNames =
        getServletConfig()
        .getInitParameterNames();

    while (initParamNames.hasMoreElements())
    {
        String param = initParamNames.nextElement();

        out.println(
            "[ "  + param +
            " = " + getServletConfig()
                    .getInitParameter(param) +
            " ]\n"
        );
    }
}
``` 
---
<br/>

### Set Path via servlet init-param (for spacified servlet):

```xml

<servlet>
    <servlet-name>HitCounterServlet</servlet-name>
    <servlet-class>pro.yoric.HitCounter.HitCounterServlet</servlet-class>

    <init-param>
        <param-name>WEB_FILE_PATH</param-name>
        <param-value>/WEB-INF/classes/data/visits.dat</param-value>
    </init-param>

</servlet>
<servlet-mapping>
<servlet-name>HitCounterServlet</servlet-name>
<url-pattern>/task9m2</url-pattern>
</servlet-mapping>
```
### To get the result as a String:
```java
String webFilePath = this.getServletConfig().getInitParameter("WEB_FILE_PATH");
```
---
<br/>

### Set Path via environment entry:
```xml
    <env-entry>
        <env-entry-name>ENV_FILE_PATH</env-entry-name>
        <env-entry-value>/resources/data/visits.dat</env-entry-value>
        <env-entry-type>java.lang.String</env-entry-type>
    </env-entry>
```
### To get the result as a String:
> ***NOTE***: May throw a naming exception, use try/catch to catch this 
```java
try
{
    initialContext = new InitialContext();
    return  (String)initialContext.lookup("java:comp/env/ENV_FILE_PATH");
}
catch (NamingException e)
{
    logger.debug(e.toString(), e);
}
```

## Examples: How we can specified of the path:
```xml
<param-name>_PATH</param-name>

<!-- RELATIVE PATH (for nix systems and servers)-->
<param-value>WEB-INF/classes/data/visits.dat</param-value>

<!-- RELATIVE AND VARIABLES (all OS)-->
<param-value>resources${file.separator}data${file.separator}visits.dat</param-value>

<!-- URL ABSOLUTE (for server)-->
<param-value>http://localhost:8080/app/resources/data/visits.dat</param-value>

<!-- SYSTEM VARIABLES (all OS)-->
<param-value>${catalina.base}${file.separator}webapps${file.separator}${artefactId}${file.separator}visits.dat</param-value>

<!-- HARDCODE (for Windows)-->
<param-value>C:\\JavaProjects\\Tomcat_v.10\\webapps\\app\\resources\\data\\visits.dat</param-value>
```

---