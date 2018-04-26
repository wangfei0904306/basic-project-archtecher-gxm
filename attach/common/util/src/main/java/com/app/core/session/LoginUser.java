package com.app.core.session;

/**
 * ClassName: LoginUser <br/>
 * Description: 用户登录账号表 <br/>
 */
public class LoginUser {
	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 登录用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 账号状态1正常2锁定3删除
	 */
	private Integer status;
	/**
	 * 用户类型-预留  3:app端登录
	 */
	private Integer userType;
	
	/**
     * 工作地城市
     */
    private String baseCity;
    /**
     * 工作地城市码
     */
    private String baseCityCode;
    /**
     * 层级
     */
    private String jobLevel;

	/**
	 * Getter method for <tt>id</tt>.
	 *
	 * @return value of id
	 */

	public Long getId() {
		return id;
	}

	/**
	 * Setter method for <tt>id</tt>.
	 *
	 * @param id value to be assigned to id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(String jobLevel) {
        this.jobLevel = jobLevel;
    }

    public String getBaseCity() {
        return baseCity;
    }

    public void setBaseCity(String baseCity) {
        this.baseCity = baseCity;
    }

    public String getBaseCityCode() {
        return baseCityCode;
    }

    public void setBaseCityCode(String baseCityCode) {
        this.baseCityCode = baseCityCode;
    }

    public LoginUser() {
	}

	public LoginUser(long id) {
		this.id = id;
	}

	/**
	 * 昵称
	 */
	public LoginUser setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	/**
	 * 昵称
	 */
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * 登录用户名
	 */
	public LoginUser setUsername(String username) {
		this.username = username;
		return this;
	}

	/**
	 * 登录用户名
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * 密码
	 */
	public LoginUser setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 账号状态1正常2锁定3删除
	 */
	public LoginUser setStatus(Integer status) {
		this.status = status;
		return this;
	}

	/**
	 * 账号状态1正常2锁定3删除
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * 用户类型-预留
	 */
	public LoginUser setUserType(Integer userType) {
		this.userType = userType;
		return this;
	}

	/**
	 * 用户类型-预留
	 */
	public Integer getUserType() {
		return this.userType;
	}
}