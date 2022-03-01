# CodeLineEstimator
This tool can estimate the lines of code in multiple source files. Given list of input files and language as input request it can return the following :  
1) Number of blank lines
2) Number of lines with comments (including multi line comments)
3) Number of lines with code
4) Total number of lines in the files
5) Classify and return the line counts as imports, variable declarations etc.

# Features
1) It supports multiple programming language syntax (eg Java, C, Javascript etc).
2) It supports extensibility : we can add new languages and syntaxes.
3) Supports Multiple Syntaxes.
4) Supports multiple files and gives total for an entire source tree.

# Set up and Running
1)Just clone the repository and import the file as a maven project in STS(Spring Tool Suite), IntelliJ or Eclipse etc which supports spring.  
2) run mvn clean install from terminal to build it once.  
3) Run as Spring Boot Application.  
4) The service will start in URL: localhost:8080  
5) Make client request with postman as shown below.  

# URL
For Postman/Rest Client Request : http://localhost:8080  
For Browser UI : http://localhost:8080/ui

# Request
1) It accepts JSON. Put this in Body in raw JSON format in postman.
2) It takes two parameters : language and filePath
3) language : Pass the language used in source code as String
4) filePath : It is a list of filePaths which you need to scan
5) Below is a sample of JSON request for 2 Javascript files with postman

![image](https://user-images.githubusercontent.com/22210454/156249544-1014c22e-eb1c-4591-bd7b-3a633f44a154.png)

The same can also be tested with browser. Go to http://localhost:8080/ui

![image](https://user-images.githubusercontent.com/22210454/156249965-892ab7cb-cee0-47fe-9af9-0629b762b8d9.png)

Just select language from the dropdown and copy paste filePath in the box. Click Submit to see response


NOTE : \\ is used if path is in windows OS. In Linux or Mac use /

# Response
Below is a smple JSON response body with postman

![image](https://user-images.githubusercontent.com/22210454/156249690-875933e2-5b3f-47e0-941a-1cf1406a956c.png) 

Pic below shows the response obtained with browser UI
![image](https://user-images.githubusercontent.com/22210454/156250454-9affeab7-6ec2-4299-b436-e301377dbf21.png)


# NOTES
1) A line counts as a comment only if it has no other code.
2) Defination of variable for the sake of project is if a code line contains data types listed in respective language file in utility module and has an "=" after that.(eg: int i = 0 etc) but for this it will ignore cases like int i;
3) The browser UI currently only supports one code file at a time, but with postman we can retrieve result for multiple code files.

