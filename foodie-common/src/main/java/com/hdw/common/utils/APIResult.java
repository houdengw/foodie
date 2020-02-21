package com.hdw.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @Title: APIResult.java
 * @Package com.imooc.utils
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 * 
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * 				556: 用户qq校验异常
 * @Copyright: Copyright (c) 2020
 * @Company: www.imooc.com
 * @author 慕课网 - 风间影月
 * @version V1.0
 */
public class APIResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    
    @JsonIgnore
    private String ok;	// 不使用

    public static APIResult build(Integer status, String msg, Object data) {
        return new APIResult(status, msg, data);
    }

    public static APIResult build(Integer status, String msg, Object data, String ok) {
        return new APIResult(status, msg, data, ok);
    }
    
    public static APIResult ok(Object data) {
        return new APIResult(data);
    }

    public static APIResult ok() {
        return new APIResult(null);
    }
    
    public static APIResult errorMsg(String msg) {
        return new APIResult(500, msg, null);
    }
    
    public static APIResult errorMap(Object data) {
        return new APIResult(501, "error", data);
    }
    
    public static APIResult errorTokenMsg(String msg) {
        return new APIResult(502, msg, null);
    }
    
    public static APIResult errorException(String msg) {
        return new APIResult(555, msg, null);
    }
    
    public static APIResult errorUserQQ(String msg) {
        return new APIResult(556, msg, null);
    }

    public APIResult() {

    }

    public APIResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public APIResult(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public APIResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	public enum Status{
        /**
         * 成功
         */
        SUCCESS(200,"OK"),

        /**
         * 未授权的请求
         */
        NO_AUTHORITY(403, "No Authority"),
        /**
         * 失败的请求
         */
        BAD_REQUEST(400, "Bad Request"),
        /**
         * 未找到
         */
        NOT_FOUND(404, "Not Found"),
        /**
         * 系统未知错误
         */
        INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
        /**
         * 参数校验未通过
         */
        NOT_VALID_PARAM(40005, "Not valid Params"),
        /**
         * 不支持的操作方法
         */
        NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
        /**
         * 未登录
         */
        NOT_LOGIN(50000, "Not Login");

        private int code;
        private String msg;

        Status(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

}
