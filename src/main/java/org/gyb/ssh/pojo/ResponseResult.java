package org.gyb.ssh.pojo;

public class ResponseResult {
    private int code;
    private String msg;
    private Object data;

    public ResponseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static ResponseResult of(int code,String msg,Object data){
        return new ResponseResult(code,msg,data);
    }

    public static ResponseResult of(Exception e){
        String msg;
        if(e.getMessage()!= null)
            msg = e.getMessage();
        else msg = e.toString();
        return new ResponseResult(500,msg,null);
    }

    public static ResponseResult ok(Object data){
        return of(200,"successful!",data);
    }
    public static ResponseResult ok(String msg ,Object data){
        return of(200,msg,data);
    }
    public static ResponseResult error(Object data){
        return of(500,"failed!",null);
    }
    public static ResponseResult error(String msg, Object data){
        return of(500,"failed!",data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
