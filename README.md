# Mindex Java Coding Challenge - Juan Patino
## Notes
Thank you for providing me with this coding challenge! I wanted to provide some context for each task, although not much is needed.

### Task 1:
* The endpoint for this task is a GET endpoint `getReportingStructure`
  * `localhost:8080/employee/getReportingStructure/{employeeId}`
* I created comprehensive tests in `ReportingStructureTest.java`

### Task 2:
* The endpoints for this task are POST and GET endpoints, respectively:
  * `localhost:8080/employee/compensation`
  * `localhost:8080/employee/compensation/{id}`
* A compensation has a JSON schema of 
```json
{
  "type":"Compensation",
  "properties": {
    "employee": {
      "type": "Employee"
    },
    "salary": {
      "type": "int"
    },
    "effectiveDate": {
      "type": "String"
    }
  }
}
```

# Thank you!