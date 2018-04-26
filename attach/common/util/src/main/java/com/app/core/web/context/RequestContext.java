package com.app.core.web.context;

import com.app.core.session.UserSession;

import java.util.HashMap;
import java.util.Map;

/**
 * request 全局请求会话<br>
 * 用户存储用户相关信息
 * 
 * @since v#{version}
 * @author zhangxf
 * @created 2015年10月24日 下午10:14:58
 */
@SuppressWarnings("all")
public final class RequestContext {

	private final static String LOGIN_USER_KEY = "login.user";
	private final static String LOGIN_USER_ID_KEY = "login.user.id";
	private final static String LOGIN_USER_NAME_KEY = "login.user.name";
	private final static String USER_ID_KEY = "user.id";
	private final static String USER_ORG_ID_KEY = "user.org.id";
	private final static String USER_ORG_CODE_KEY = "user.org.code";
	private final static String HTTP_REQUEST_KEY = "http.request";
	private final static String HTTP_RESPONSE_KEY = "http.response";

	private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

	private static Map getThreadLocalMap() {
		Map map = (Map) threadLocal.get();
		if (map == null) {
			map = new HashMap();
		}
		return map;
	}

	public static void setOrganId(Long id) {
		Map map = getThreadLocalMap();
		map.put(RequestContext.USER_ORG_ID_KEY, id);
		threadLocal.set(map);
	}

	public static Long getOrganId() {
		Object object = getThreadLocalMap().get(RequestContext.USER_ORG_ID_KEY);
		if (object == null)
			return null;

		return Long.valueOf(object.toString());
	}

	public static void setOrganCode(String orgCode) {
		Map map = getThreadLocalMap();
		map.put(RequestContext.USER_ORG_CODE_KEY, orgCode);
		threadLocal.set(map);
	}

	public static String getOrganCode() {
		Object object = getThreadLocalMap().get(RequestContext.USER_ORG_CODE_KEY);
		if (object == null)
			return null;

		return object.toString();
	}

	public static void setUserId(Long id) {
		Map map = getThreadLocalMap();
		map.put(RequestContext.USER_ID_KEY, id);
		threadLocal.set(map);
	}

	public static Long getUserId() {
		Object object = getThreadLocalMap().get(RequestContext.USER_ID_KEY);
		if (object == null)
			return null;

		return Long.valueOf(object.toString());
	}

	public static void setLoginUserId(Long id) {
		Map map = getThreadLocalMap();
		map.put(RequestContext.LOGIN_USER_ID_KEY, id);
		threadLocal.set(map);
	}

	public static Long getLoginUserId() {
		Object object = getThreadLocalMap().get(RequestContext.LOGIN_USER_ID_KEY);
		if (object == null)
			return null;

		return Long.valueOf(object.toString());
	}

	public static void setUserSession(Object user) {
		Map map = getThreadLocalMap();
		map.put(RequestContext.LOGIN_USER_KEY, user);
		threadLocal.set(map);
	}

	public static UserSession getUserSession() {
		return (UserSession) getThreadLocalMap().get(RequestContext.LOGIN_USER_KEY);
	}

	public static String getLoginUserName() {
		return (String) getThreadLocalMap().get(RequestContext.LOGIN_USER_NAME_KEY);
	}

	public static void setLoginUserName(String username) {
		Map map = getThreadLocalMap();
		map.put(RequestContext.LOGIN_USER_NAME_KEY, username);
		threadLocal.set(map);
	}

	public static void clearVariable() {
		threadLocal.remove();
	}
}
