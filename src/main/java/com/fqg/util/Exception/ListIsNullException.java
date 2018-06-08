package com.fqg.util.Exception;

public class ListIsNullException extends RuntimeException{
    private String errorCode;
    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ListIsNullException(String message, String errorCode, String message1) {
        super(message);
        this.errorCode = errorCode;
        this.message = message1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
