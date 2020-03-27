# smitiv
Smitiv test

API 1: /createStudent
Sample request :
{
	"name":"anubhav",
	"age":27,
	"gender":"male",
	"rollNumber":1,
	"phoneNumber":"8123860237",
	"address":"bangalore"
}
Sample Response:
{
    "SUCCESSFUL": true,
    "message": "Successfully saved student info",
    "id": 1
}


API 2: /getStudentDetailById/{id}
Sample Request: {id} as path variable

Sample Response:
{
    "SUCCESSFUL": true,
    "message": "Success :",
    "student": {
        "id": 1,
        "name": "anubhav",
        "age": 27,
        "gender": "male",
        "rollNumber": 1,
        "phoneNumber": "8123860237",
        "address": "bangalore"
    }
}
