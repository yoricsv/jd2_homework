# jd2_homework *(Enterprise homeworks)*

## Module 2, Task 11:

Create a servlet that will detect by the content of the User-Agent which browser the user is using and display a message like "Hello Firefox user".

---

## CONTENTS:

* [web.xml template][5] structure

---

### Requirements:


| **Development Kits** | **Version** |
| ---------------------: | :------------ |
|              OpenJDK | v.11        |
|         Apache Maven | v.3.6.3     |
|        Apache Tomcat | v.10.0.11   |

### Used plugins:


|          **Plugins** | **Version**    |
| ---------------------: | :--------------- |
|  jakarta.servlet-api | v.5.0.0        |
|     maven-war-plugin | v.3.3.1        |
| tomcat7-maven-plugin | v.2.2          |
|    junit-jupiter-api | v.5.8.1        |
|                junit | v.4.13.2       |
|            slf4j-api | v.2.0.0-alpha1 |

## Compile and Deploy

> **NOTE**: Don't forget to set environment variables before compiling! (See: [Maven configuration][1])

1. To compile and build the project see: [Build project via Maven][2]
2. Run your browser
3. Copy the link below:

```url
http://localhost:8080/ui
```

4. Paste it into the address bar
5. Click the "Go" button or press `[Enter]`

---

### The result:

![Result][3]
<br/>

## Project UML Class Diagram

<!-- ![UML Class Diagram][4] -->

---

<!--
* [Maven configuration][1]
* [Build project via Maven][2]
* ![Result][3]
* ![UML Class Diagram][4]
* [web.xml template][5]
-->

[1]: https://github.com/yoricsv/001_JMaven_/blob/master/res/read/Maven_Configuration.md
[2]: https://github.com/yoricsv/002_JMvnWebapp_/blob/master/README.md
[3]: res/img/task10_mod2_01.png
[7]: res/img/UMLHitCounterServlet.png
[8]: res/read/web.xml_template_structure.md
