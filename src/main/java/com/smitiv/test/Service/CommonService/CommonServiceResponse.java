package com.smitiv.test.Service.CommonService;


public abstract class CommonServiceResponse {

    public  boolean SUCCESSFUL = true;
    public String message;


    public CommonServiceResponse() {

    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
