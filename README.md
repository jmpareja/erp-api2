# ERP-API

## Overview

A simple API that exposes employee information contained in a JSON-formatted file.

This is not a REST API due to the absence of links in the JSON output. This limitation is set since
the required API methods does not include create/edit/delete operations - only view/search/sort.

## Implementation Details

This implementation uses Spring Boot and Spring framework(web,jpa). For the database, H2 is used which is an in-memory DB storage.

The input file [employee.json](https://github.com/jmpareja/erp-api2/blob/main/src/main/resources/static/employee.json) contains an array of Employee information structured as JSON.

```json
[
    {
        "name": "Vaughan",
        "joindate": "10/19/2017",
        "age": 23,
        "company": "Praesent Luctus Foundation",
        "email": "tempus.scelerisque.lorem@egestasblandit.co.uk",
        "phone": "1-365-251-2279",
        "salary": 4754,
        "address": {
            "street": "4428 Proin Rd.",
            "city": "Verrayes",
            "zipcode": "7251"
        }
    },
    ...
]
```

The module [FasterXML/Jackson](https://github.com/FasterXML/jackson) is used to parse the JSON file and map to POJO.

## API Methods

##### Fetch entire employee list

URL: api/employees

Using terminal:

```
$ curl http://localhost:8080/api/employees | json_pp
```

Sample output:
```
[
   {
      "address" : {
         "city" : "Verrayes",
         "street" : "4428 Proin Rd.",
         "zipcode" : "7251"
      },
      "age" : 23,
      "company" : "Praesent Luctus Foundation",
      "email" : "tempus.scelerisque.lorem@egestasblandit.co.uk",
      "joindate" : "2017-10-19",
      "name" : "Vaughan",
      "phone" : "1-365-251-2279",
      "salary" : 4754
   },
   {
      "address" : null,
      "age" : 23,
      "company" : "Sociis Natoque Penatibus Institute",
      "email" : "sem.semper@adipiscinglacus.org",
      "joindate" : "2017-08-16",
      "name" : "Caleb",
      "phone" : "1-910-363-5471",
      "salary" : 4017
   },
]
```


##### Fetch entire employee list sorted in ascending order based on specified field in URL
 URL: api/sorted/{field}
 
Using terminal:

```
$ curl http://localhost:8080/api/sorted/name | json_pp
```



##### Fetch an employee list with applied filter of 'less than specified age'
 URL: api/younger/than/25
 
 Using terminal:

```
$ curl http://localhost:8080/api/younger/than/25 | json_pp
```


## Running

##### Using Maven

```
$ ./mvnw spring-boot:run
```

##### Using eclipse IDE

Right-click project, Run As Spring Boot App.

