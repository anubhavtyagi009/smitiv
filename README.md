# smitiv
Smitiv test

API 1: POST - /createStudent
Sample request :
{
	"name":"anubhav",
	"age":27,
	"gender":"male",
	"rollNumber":1,
	"phoneNumber":"8123860237",
	"address":"bangalore"
}

NOTE: age,name,gender,rollNumber,phoneNUmber are the mandatory fields

Sample Response:
{
    "SUCCESSFUL": true,
    "message": "Successfully saved student info",
    "id": 1
}

--------------------------------------------------------------------------------------------------------------------------------------

API 2: GET - /getStudentDetailById/{id}
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

--------------------------------------------------------------------------------------------------------------------------------------

API 3: PUT - /updateStudent
Sample Request: 
{
	"id":1,
	"name":"anubhav",
	"age":27,
	"gender":"male",
	"rollNumber":1,
	"phoneNumber":"8123860217",
	"address":"delhi"
}
NOTE: id,age,name,gender,rollNumber,phoneNUmber are the mandatory fields

Sample Response:
{
    "SUCCESSFUL": true,
    "message": "Successfully updated the  student info",
    "id": 1
}
