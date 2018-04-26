package com.gxm.crm.util;

import com.google.protobuf.MessageOrBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 调用外部GRPC接口日志记录类
 *
 * @author 路飞
 * @version GRpcLogUtils.java, 2018/3/6 下午6:14
 */
public class GRpcLogUtils {
    private static final Logger logger = LoggerFactory.getLogger(GRpcLogUtils.class);

    /**
     * 请求完成后后记录耗时、返回值
     * @param log
     * @param time
     * @param cls
     * @param methodName
     * @param result
     * @param params
     */
    public static void finish(Logger log, long time, Class cls, String methodName,
                              MessageOrBuilder result, MessageOrBuilder params) {
        log.info("【GRPC请求结束】 耗时:{} ms, 调用类:[{}], 接口:[{}], 参数:[{}], 返回值:[{}]", time, cls.getName(),
            methodName, params, result);

    }

    /**
     * 请求失败后记录耗时以及错误信息
     * @param log
     * @param time
     * @param message
     * @param cls
     * @param methodName
     * @param t
     * @param params
     */
    public static void error(Logger log, long time, String message, Class cls, String methodName,
                             Throwable t, MessageOrBuilder params) {
        log.error("【GRPC请求失败】{} 耗时: {} ms, 错误:[{}], 调用类:[{}], 接口:[{}], 参数:[{}]", message, time,
            t.toString(), cls.getName(), methodName, params);
        log.error("【GRPC请求失败】", t);
    }

}
