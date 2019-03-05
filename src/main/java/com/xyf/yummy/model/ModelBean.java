package com.xyf.yummy.model;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 16:25
 * @Package: com.xyf.yummy.model
 */
public class ModelBean {
    private int code;
    //1-成功 0-失败
    private String msg;
    private List<?> list;
    private Object object;

    public ModelBean() {
    }

    public ModelBean(int code, String msg, Object object, List<?> list) {
        this.code = code;
        this.msg = msg;
        this.object = object;
        this.list = list;
    }
    public ModelBean(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
        this.list = null;
    }
    public ModelBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.object = null;
        this.list = null;
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

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
