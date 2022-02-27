# CodeScanner
It scans any number of code files to estimate line of codes, comments, imports, variable declarations etc

# URL
localhost:8080

# Request
Accepts JSON. Below is a sample of JSON request for 2 Java files
{
    "language": "Java",
    "filePath": [
        "C:\\Users\\prave\\Documents\\Spring_Workspace\\CodeScanner\\src\\main\\resources\\Javainput1.txt",
        "C:\\Users\\prave\\Documents\\Spring_Workspace\\CodeScanner\\src\\main\\resources\\Javainput2.txt"
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

