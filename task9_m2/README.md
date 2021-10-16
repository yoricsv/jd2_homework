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

<!--
* [Maven configuration][1]
* [Build project via Maven][2]
-->

[1]: https://github.com/yoricsv/001_JMaven_/blob/master/res/read/Maven_Configuration.md
[2]: https://github.com/yoricsv/002_JMvnWebapp_/blob/master/README.md
[3]: tmp/img/task8_mod2.png