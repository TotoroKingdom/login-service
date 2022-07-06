package com.totoro.domain.model;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.totoro.common.constant.HttpStatus;
import lombok.Getter;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 返回成功消息
     * @return 成功消息
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功消息
     * @param msg 返回内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg, null);
    }

    private static AjaxResult success(String msg, Object data) {
        return new AjaxResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public AjaxResult(int code, String msg, Object data) {
        super.put(MsgCode.CODE_TAG.getCode(), code);
        super.put(MsgCode.MSG_TAG.getCode(), msg);
        if (ObjectUtil.isNotNull(data)) {
            super.put(MsgCode.DATA_TAG.getCode(), data);
        }
    }

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
