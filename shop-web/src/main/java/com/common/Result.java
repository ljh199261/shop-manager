package com.common;


/**
 * 返回信息封装
 */
public class Result {
    private String messege;
    private String code;
    private boolean status;
    private Object data;

    public Result(String messege,String code,boolean status){
        this.code = code;
        this.messege = messege;
        this.status = status;
    }

    public Result(String code,boolean status){
        this.code = code;
        this.status = status;
    }

    public Result(){

    }

    public static Result build(){
        return new Result("200",true);
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
