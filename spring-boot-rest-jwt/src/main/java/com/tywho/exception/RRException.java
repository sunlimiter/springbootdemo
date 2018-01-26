package com.tywho.exception;

/**
 * Created by lty on 2018/1/25/0025.
 */
public class RRException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;
    private int code = 500;

    public RRException(String msg) {
        super(msg);
        this.message = msg;
    }

    public RRException(String msg, Throwable e) {
        super(msg, e);
        this.message = msg;
    }

    public RRException(String msg, int code) {
        super(msg);
        this.message = msg;
        this.code = code;
    }

    public RRException(String msg, int code, Throwable e) {
        super(msg, e);
        this.message = msg;
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
