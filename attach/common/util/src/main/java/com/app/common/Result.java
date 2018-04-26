package com.app.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 公共返回结果封装类
 * 
 * @param <T>
 * @since v#{version}
 * @author zhangxf
 * @created 2015年10月24日 下午4:43:40
 */
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(Result.class);

	public static final String SUCCESS = "200";
	/**
	 * 耗时统计字段
	 */
	private String time;
	// /**
	// * 请求执行结果状态<br>
	// * 添加这个字段是为了更为方便直接的判断是否成功 <br>
	// * false则说明整体请求失败，再获取错误code判断错误类型， <br>
	// * true为成功
	// */
	// private boolean status;
	private String code;
	private String msg;
	private T data;

	/** ------以下为失败消息---------------------------------------- */
	public static <W> Result<W> error() {
		return new Result<W>().setCode(ResultCode.DEFAULT_ERROR.getCode()).setMsg(ResultCode.DEFAULT_ERROR.getMsg());
	}

	public static <W> Result<W> error(String msg) {
		return new Result<W>().setCode(ResultCode.ERROR.getCode()).setMsg(msg);
	}

	public static <W> Result<W> error(String code, String msg) {
		return new Result<W>().setCode(code).setMsg(msg);
	}

	public static <W> Result<W> error(ResultCode code) {
		return new Result<W>().setCode(code.getCode()).setMsg(code.getMsg());
	}

	public static <W> Result<W> error(ResultCode code, W data) {
		return new Result<W>().setCode(code.getCode()).setMsg(code.getMsg()).setData(data);
	}

	public static <W> Result<W> error(W data) {
		return new Result<W>().setCode(ResultCode.ERROR.getCode()).setData(data);
	}

	public static <W> Result<W> error(String code, W data) {
		return new Result<W>().setCode(ResultCode.ERROR.getCode()).setData(data);
	}

	public static <W> Result<W> error(String code, String msg, W data) {
		return new Result<W>().setCode(ResultCode.ERROR.getCode()).setMsg(msg).setData(data);
	}

	/** ------以上为失败消息---------------------------------------- */

	/** ------以下为成功消息---------------------------------------- */
	public static <W> Result<W> success() {
		return new Result<W>().setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getMsg());
	}

	public static <W> Result<W> success(String code, String msg) {
		return new Result<W>().setCode(code).setMsg(msg);
	}

	public static <W> Result<W> success(ResultCode code) {
		return new Result<W>().setCode(code.getCode()).setMsg(code.getMsg());
	}

	public static <W> Result<W> success(ResultCode code, W data) {
		return new Result<W>().setCode(code.getCode()).setMsg(code.getMsg()).setData(data);
	}

	public static <W> Result<W> success(W data) {
		return new Result<W>().setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getMsg()).setData(data);
	}

	public static <W> Result<W> success(String code, W data) {
		return new Result<W>().setCode(code).setData(data);
	}

	public static <W> Result<W> success(String code, String msg, W data) {
		return new Result<W>().setCode(ResultCode.SUCCESS.getCode()).setMsg(msg).setData(data);
	}

	public String getCode() {
		return code;
	}

	public Result<T> setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public Result<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}

	public String getTime() {
		return time;
	}

	public Result<T> setTime(String time) {
		this.time = time;
		return this;
	}

	public String toJson() {
		return JSON.toJSONString(this);
	}

	public void debug() {
		log.info(JSON.toJSONString(this));
	}

	public boolean isSuccess() {
		return ResultCode.SUCCESS.getCode().equals(this.getCode());
	}

    public <R> Result<R> flatMap(Function<T, Result<R>> mapper) {
        if (isSuccess()) {
            return mapper.apply(data);
        } else {
            return Result.error(this.getCode(), this.getMsg());
        }
    }

    public <R> Result<R> map(Function<T, R> mapper) {
        if (isSuccess()) {
            return Result.success(mapper.apply(data));
        } else {
            return Result.error(this.getCode(), this.getMsg());
        }
    }
	
    /**
     * 示例
     *
     * @param args
     * @since v#{version}
     * @author zhangxf
     * @created 2015年10月24日 下午3:50:06
     */
	public static void main(String[] args) {
		Result.success().debug();
		Result.success("自定义成功消息").debug();
		Result.error().debug();
		Result.error("自定义错误消息").debug();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("32", "ee");
		result.put("33", new Date());
		String dd = JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd");
		System.out.println(dd);
	}

}
