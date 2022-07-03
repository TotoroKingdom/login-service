package com.totoro.domain.model;

import lombok.Getter;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public AjaxResult(int code, String msg) {
        super.put(MsgCode.CODE_TAG.getCode(), code);
        super.put(MsgCode.MSG_TAG.getCode(), msg);
    }

    /**
     * 操作消息提醒基础码: code.状态码 , msg.返回内容 ,data.数据对象
     */
    public enum MsgCode {

        /**
         * 状态码
         */
        CODE_TAG("code"),

        /**
         * 数据对象
         */
        DATA_TAG("data"),

        /**
         * 返回内容
         */
        MSG_TAG("msg");

        @Getter
        private String code;


        MsgCode(String code) {
            this.code = code;
        }
    }


}
