package com.smitiv.test.Service.GetStudentDetailById;

import com.smitiv.test.Domain.Student;
import com.smitiv.test.Service.CommonService.CommonServiceResponse;

public class GetStudentByIdResponse extends CommonServiceResponse {
    private Student student;

    public GetStudentByIdResponse(Student student) {
        this.student = student;
    }

    public GetStudentByIdResponse() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
