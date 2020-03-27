package com.smitiv.test.Service.CreateStudent;

import com.smitiv.test.Service.CommonService.CommonServiceResponse;

public class CreateStudentResponse extends CommonServiceResponse {
    private Long id;

    public CreateStudentResponse() {
    }

    public CreateStudentResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
