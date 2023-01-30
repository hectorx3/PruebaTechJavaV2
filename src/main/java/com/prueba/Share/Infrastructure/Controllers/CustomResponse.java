package com.prueba.Share.Infrastructure.Controllers;

public class CustomResponse<T> {
    private final String statusCode;
    private final String msg;
    private final T data;

    public CustomResponse(String statusCode, String msg, T data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CustomResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
