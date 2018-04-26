package com.app.common;

/**
 * @author zhangxf
 * @created 2015年10月24日 下午3:51:43
 * @since v#{version}
 */
public enum ResultCode {
    SUCCESS("200", "成功"),
    DEFAULT_ERROR("1000", "系统出错, 请联系管理员!"),
    ERROR("1001", "系统出错,错误未知!"),
    PARAM_ERROR("1002", "提交参数异常, 请联系管理员!"),
    SERVER_INNER_ERROR("1003", "请求错误，服务器内部发生异常！请联系管理员!"),
    SESSION_EXPIRE("1004", "未登录或会话已过期, 请重新登录!"),
    ILLEGAL_ACCESS("1005", "无权限,非法访问!"),
    OTHER_LOGIN("1006", "账号异常: 您的账号在异地同时登录！"),
    NO_BIND_PHONR("1007", "未绑定手机号！"),
    AUTH_FAILED("1008", "授权失败！"),
    RECORD_NOT_EXSIT("5001", "不存在此记录!"),
    DATA_SAVE_ERROR("5002", "保存出错!"),
    PARAM_VALIDATE_ERROR("5003", "输入参数不正确！"),
    PARAM_VALIDATE_ERROR_TIP("5003", "请填写正确的必填项"),
    URL_NOT_FOUND("5004", "访问的地址不存在!"),
    STR_FAILED("444", "FAILED"),
    CREDIT_AUTHENTICATION_FAIL("1009", "信用授权失败"),
    NOT_SUPPORTED_CHANNEL("1010", "不支持此渠道购买"),

    LACK_PARAM_ERROR("REPORT1000","缺少必要参数"),
    DATE_INTERVAL_ERROR("REPORT1001","日期区间错误"),
    SYS_UNKNOW_ERRROR("REPORT1002","系统未知异常"),
    MAX_BD_NUM_ERROR("REPORT1003","最多选择20人！"),
    //参数互斥
    PARAM_MUTEX_ERROR("REPORT1004","全国、战区、城市和人员的查询参数只能选择其一！"),
    ILLEGAL_ACCESS_ERROR("REPORT1005","无权访问"),
    BEGIN_TIME_ERROR("REPORT1006","起始时间只能选择2018-01-01以后"),
    ENDTIME_EARLIER_BEGINTIME("REPORT1007","结束时间必须大于开始时间"),
    MAX_INTERVAl_ERROR("REPORT1008","时间最大间隔天数为32天"),
    PARAM_CHECK_ERROR("REPORT1009","参数校验错误"),


    //*************************


    ;

    private String code;

    private String msg;

    private ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
