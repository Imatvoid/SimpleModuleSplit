package com.example.splitmodule.simple.exception;

/**
 * 所有统一异常码均定义在此!
 */
public enum ErrorCodeEnum {

    PERMISSION_ERROR("没有权限", "EC-1000", "没有权限"),
    ILLEGAL_ERROR("参数异常", "EC-3301", "参数异常, 原因:%s"),
    SYSTEM_ERROR("系统异常", "EC-4500", "系统异常"),
    SEND_ALARM_MAIL_ERROR("系统异常", "EC-4501", "报警邮件发送异常"),
    RPC_ERROR("系统异常", "EC-4502", "调用外部服务异常, 原因:%s"),
    DATA_CONVERT_ERROR("系统异常", "EC-4503", "数据转换异常, 原因:%s"),
    UNKNOWN_ERROR("未知异常", "EC-5000", "未知异常"),
    ;
    /**
     * 统一异常码
     * e,g.
     */
    private String code;
    /**
     * 错误描述
     */
    private String desc;

    /**
     * 错误信息（可带占位符）
     */
    private String placeholderLayout;

    ErrorCodeEnum(String desc, String code, String placeholderLayout) {
        this.desc = desc;
        this.code = code;
        this.placeholderLayout = placeholderLayout;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getPlaceholderLayout() {
        return this.placeholderLayout;
    }


}
