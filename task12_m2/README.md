# jd2_homework *(Enterprise homeworks)*

## Module 2, Task 12:
Modify the HitCounter from task 9 so that the quantity is not displayed as numbers, but displayed as an image.

---
<!--
## CONTENTS:
* [web.xml template][5] structure
* [Variables in web.xml][6]
* [Set context parameters][7] via web.xml *(Examples)*
* [Creating directories via servlet][8]
* [Operation with the files][9]

---
-->
### Requirements:
**Development Kits** | **Version**
--: | :--
OpenJDK | v.11
Apache Maven | v.3.6.3
Apache Tomcat | v.10.0.11

### Used plugins:
**Plugins** | **Version**
--: | :--
jakarta.servlet-api | v.5.0.0
maven-war-plugin | v.3.3.1
tomcat7-maven-plugin | v.2.2
junit-jupiter-api | v.5.8.1
junit | v.4.13.2
slf4j-api | v.2.0.0-alpha1

## Compile and Deploy
> **NOTE**: Don't forget to set environment variables before compiling! (See: [Maven configuration][1])

1. To compile and build the project see: [Build project via Maven][2]
2. Run your browser
3. Copy the link below:

``` url
http://localhost:8080/app/task12m2
``` 
4. Paste it into the address bar
5. Click the "Go" button or press `[Enter]`

---

### The result:
![Result][3]

## Project UML Class Diagram
![UML Class Diagram][4]

---

<!--
* [Maven configuration][1]
* [Build project via Maven][2]
* ![Result][3]
* ![UML Class Diagram][4]
* [web.xml template][5]
* [Variables in web.xml][6]
* [Set context parameters][7]
* [Creating directories via servlet][8]
* [Operation with the files][9]
-->

[1]: https://github.com/yoricsv/001_JMaven_/blob/master/res/read/Maven_Configuration.md
[2]: https://github.com/yoricsv/002_JMvnWebapp_/blob/master/README.md
[3]: res/img/task9_mod2.png
[4]: res/img/UMLHitCounterServlet.png
[5]: res/read/web.xml_template_structure.md
[6]: res/read/web.xml_variables.md 
[7]: res/read/web.xml_set_context_parameters.md
[8]: res/read/creating_dirs_via_servlet.md
[9]: res/read/work_with_files_in_java.md