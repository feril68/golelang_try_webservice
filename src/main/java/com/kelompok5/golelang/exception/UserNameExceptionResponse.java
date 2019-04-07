package com.kelompok5.golelang.exception;

public class UserNameExceptionResponse {

    private String userName;

    public UserNameExceptionResponse(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
