# jd2_homework *(Enterprise homeworks)*

## Module 2, Task 9:
Make a simple servlet that counts the number of visits.
Each time the servlet is called, the counter should increase,
information about the number of visits should be displayed on
the page and stored in a file.

---

### Requirements:
**Development Kits** | **Version**
--: | :--
OpenJDK | v.11
Apache Maven | v.3.6.3
Apache Tomcat | v.10.0.11

### Used plugins
**Plugins** | **Version**
--: | :--
jakarta.servlet-api | v.5.0.0
maven-war-plugin | v.3.3.1
tomcat7-maven-plugin | v.2.2

## Compile and Deploy
> **NOTE**: Don't forget to set environment variables before compiling! (See: [Maven configuration][1])

1. To compile and build the project see: [Build project via Maven][2]
2. Run your browser
3. Copy the link below:

``` url
http://localhost:8080/app/task9m2
``` 
4. Paste it into the address bar
5. Click the "Go" button or press `[Enter]`

<!--### The result:
![Result][3]-->

### The list of variables that work in **web.xml**:
**Variable** | **Value example**  
--- | :--
`${java.home}` | C:\Users\Yoric\OneDrive\Desctop\001_PROJECTS_\001_Java_Projects_\env\OpenJDK_v.11
`${os.name}` | Windows 10
`${os.version}` | 10
`${os.arch}` | amd 64
`${file.separator}` | \ or /
`${path.separator}` | ;
`${line.separator}` | [*space*]
`${java.version}` | 11
`${java.vendor}` | Oracle Corporation
`${java.vendor.url}` | http://java.oracle.com/
`${java.class.version}` | 55.0
`${java.specification.version}` | 11
`${java.specification.vendor}` | Oracle Corporation
`${java.specification.name}` | Java Platform API Specification
`${java.vm.specification.version}` | 11
`${java.vm.specification.vendor}` | Oracle Corporation
`${java.vm.specification.name}` | Java Virtual Machine Specification
`${java.vm.version}` | 11+28
`${java.vm.vendor}` | Oracle Corporation
`${java.vm.name}` | OpenJDK 64-Bit Server VM

### web.xml structure template:
```xml
<?xml version    = "1.0"
      encoding   = "UTF-8"
?>

<web-app xmlns              = "http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://xmlns.jcp.org/xml/ns/javaee
                               http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version = "4.0"
>
    <!-- First data transfer method  -->
    <context-param>
        <param-name>ContextVariableName</param-name>    <!-- KEY -->
        <param-value>ContextVariableValue</param-value> <!-- VALUE -->
    </context-param>

    <servlet>
        <servlet-name>servletName</servlet-name>
        <servlet-class>packageName.servletName</servlet-class>
        <!-- Second data transfer method  -->
        <init-param>
           <param-name>ServletVariableName</param-name>    <!-- KEY -->
           <param-value>ServletVariableValue</param-value> <!-- VALUE -->
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>servletName</servlet-name>  <!-- SHOULD BE THE SAME AS IN THE servlet-name -->
        <url-pattern>/urlPattern</url-pattern>    <!-- URL TO CALL THE SERVLET -->
    </servlet-mapping>

    <!-- Third data transfer method  -->
    <env-entry>
        <env-entry-name>EnvironmentVariableName</env-entry-name>        <!-- KEY -->
        <env-entry-value>EnvironmentVariableValue</env-entry-value>     <!-- VALUE -->
        <env-entry-type>java.lang.dataTypeOfTheValue</env-entry-type>   <!-- DATA TYPE -->
    </env-entry>

</web-app>
```

# EXAMPLES:
## Set Path via **context-param** *(general settings for each servlet)*:

```xml
    <context-param>
        <param-name>CONTEXT_PATH</param-name>
        <param-value>${catalina.base}/WEB-INF/classes/data/visit.dat</param-value>
    </context-param>
```
To get the context parameters of the servlet might use to the next method:
### Get the result as a HashMap:
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

### *Get the result as a Property Object:*
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
### Set Path via environment entry:
```xml
    <env-entry>
        <env-entry-name>ENV_FILE_PATH</env-entry-name>
        <env-entry-value>/resources/data/visits.dat</env-entry-value>
        <env-entry-type>java.lang.String</env-entry-type>
    </env-entry>
```
## Examples How we can specified of the path:
```xml
<param-name>_PATH</param-name>

<param-value>/WEB-INF/classes/data/visits.dat</param-value>
<param-value>/resources/data/visits.dat</param-value>
<param-value>http://localhost:8080/app/resources/data/visits.dat</param-value>
<param-value>${catalina.base}${file.separator}webapps${file.separator}app${file.separator}visits.dat</param-value>
<param-value>C:\\JavaProjects\\jd2_homework\\task9_m2\\src\\main\\resources\\data\\visits.dat</param-value>
```

<!--
* [Maven configuration][1]
* [Build project via Maven][2]
-->

[1]: https://github.com/yoricsv/001_JMaven_/blob/master/res/read/Maven_Configuration.md
[2]: https://github.com/yoricsv/002_JMvnWebapp_/blob/master/README.md
[3]: tmp/img/task8_mod2.png