# CodeLineEstimator
This tool can estimate the lines of code in multiple source files. Given list of input files and language as input request it can return the following :  
1) Number of blank lines
2) Number of lines with comments (including multi line comments)
3) Number of lines with code
4) Total number of lines in the files
5) Classify and return the line counts as imports, packages, variable declarations etc.

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
localhost:8080

# Request
1) It accepts JSON. Put this in Body in raw JSON format in postman.
2) It takes two parameters : language and filePath
3) language : Pass the language used in source code as String
4) filePath : It is a list of filePaths which you need to scan
5) Below is a sample of JSON request for 2 Java files

{  
    "language": "Java",  
    "filePath": [  
        "C:\\Users\\prave\\Documents\\Spring_Workspace\\CodeLineEstimator\\src\\main\\resources\\Javainput1.txt",  
        "C:\\Users\\prave\\Documents\\Spring_Workspace\\CodeLineEstimator\\src\\main\\resources\\Javainput2.txt"  
    ]  
}  

NOTE : \\ is used if path is in windows OS. In Linux or Mac use /

# Response
Below is a smple JSON response body

{  
    "blankLines": 38,  
    "commentLines": 12,  
    "codeLines": {  
        "totalLines": 100,  
        "importLines": 11,  
        "variableDeclarationLines": 8  
    }  
}  

# NOTES
1) A line counts as a comment only if it has no other code.
2) Defination of variable for the sake of project is if a code line contains data types listed in respective language file in utility module and has an "=" after that.(eg: int i = 0 etc) but for this it will ignore cases like int i;


