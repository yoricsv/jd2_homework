# [jd2_homework *(Enterprise homeworks)*][goBack] > web.xml Template structure
[goBack]: ../../README.md

<!-- ---------------------------------- * Navigation * ---------------------------------- -->

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

# SHORT Description:
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

---