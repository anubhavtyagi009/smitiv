package com.smitiv.test.Service.UpdateStudent;

import com.smitiv.test.Service.CommonService.CommonServiceResponse;

public class UpdateStudentResponse extends CommonServiceResponse {
    private Long id;

    public UpdateStudentResponse(Long id) {
        this.id = id;
    }

    public UpdateStudentResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
