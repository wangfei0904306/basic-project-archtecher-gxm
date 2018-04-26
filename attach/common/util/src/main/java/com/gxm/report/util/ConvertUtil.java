/*
 * GuoXiaoMei.com Inc.
 * Copyright (c) 2017-2017 All Rights Reserved.
 */
package com.gxm.report.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据转换工具类。
 *
 * @author 圣手书生
 * @version ConvertUtil.java, 15/11/2017 9:19 PM
 */
public class ConvertUtil {

    private static final Logger log = LoggerFactory.getLogger(ConvertUtil.class);

    /**
     * 解析KP联系方式 
     * 1.优先获取手机号
     * 2.其次获取座机号
     * 
     * @param   details     KP表details字段
     * @return  可用的联系方式
     * */
    public static String paresPhone(String details) {
        if (StringUtils.isBlank(details)) {
            return "";
        }

        String phone = "";
        try {
            JSONObject json = JSON.parseObject(details);
            phone = json.getString("mobile");
            if (StringUtils.isBlank(phone)) {
                phone = json.getString("telephone");
            }
            if (StringUtils.isBlank(phone)) {
                phone = json.getString("phone");
            }
        } catch (Exception e) {
            log.error("KP联系方式解析异常！", e);
        }
        if (phone == null) {
            phone = "";
        }
        return phone;
    }

}
