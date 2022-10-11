package model;

import lombok.Data;

@Data
public class ResponseData {
    private int statusCode;
    private boolean isSuccess;
    private String messsage;
    private Object data;
}