package com.app.core.session;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.Map;

/**
 * 用户会话对象<br>
 * 存储会话基本字段，如果需要额外存储登录用户信息，可以传入自定义用户对象：T user
 * 
 * 用户session中考虑增加给在线用户信息提示功能
 * 
 * @param <T>
 * @since v#{version}
 * @author zhangxf
 * @created 2015年12月15日 下午3:24:27
 */
public class UserSession extends BaseUserSession<LoginUser>  {
    private static final long         serialVersionUID = -3043076971908383473L;

    private String                    errorCode;
    private String                    signKey;
    /**
     * 是否为初始密码，如果是初始密码，需要提醒修改
     */
    private Integer                   isInitialPass;
    /**
     * 允许的偏差时间
     */
    private int                       deviationTime;
    /**
     * 第三方平台ID
     */
    private String                    thirdUserId;
    /**
     * 钉钉用户corpId
     */
    private String                    corpId;
    /**
     * 用户所属货柜
     */
    private Long                      shelfId;
    /**
     * 用户所属货柜
     */
    private String                    shelfName;
    /**
     * app端登录唯一标示
     */
    private String                    token;
    /**
     * 头像
     */
    private String                    headPic;
    /**
     * 用户权限resouce
     */
    private List       userResouce;

    /**
    * 用户角色
    */
    private List<Map<String, String>> roles;
    /**
     * 用户城市
     */
    private List<Map<String, String>> cities;
    /**超级管理员*/
    private boolean                   isSupperAdmin    = false;
    /**
     *手机号
     */
    private String                    phone;
    /**
     *用户统一id
     */
    private String                    uniqueUserId;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getUniqueUserId() {
        return uniqueUserId;
    }

    public void setUniqueUserId(String uniqueUserId) {
        this.uniqueUserId = uniqueUserId;
    }

    public boolean isSupperAdmin() {
        return isSupperAdmin;
    }

    public void setSupperAdmin(boolean isSupperAdmin) {
        this.isSupperAdmin = isSupperAdmin;
    }

    public List getUserResouce() {
        return userResouce;
    }

    public void setUserResouce(List userResouce) {
        this.userResouce = userResouce;
    }

    public List<Map<String, String>> getRoles() {
        return roles;
    }

    public void setRoles(List<Map<String, String>> roles) {
        this.roles = roles;
    }

    public List<Map<String, String>> getCities() {
        return cities;
    }

    public void setCities(List<Map<String, String>> cities) {
        this.cities = cities;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getIsInitialPass() {
        return isInitialPass;
    }

    public void setIsInitialPass(Integer isInitialPass) {
        this.isInitialPass = isInitialPass;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public int getDeviationTime() {
        return deviationTime;
    }

    public void setDeviationTime(int deviationTime) {
        this.deviationTime = deviationTime;
    }

    public String getThirdUserId() {
        return thirdUserId;
    }

    public void setThirdUserId(String thirdUserId) {
        this.thirdUserId = thirdUserId;
    }

    public Long getShelfId() {
        return shelfId;
    }

    public void setShelfId(Long shelfId) {
        this.shelfId = shelfId;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
