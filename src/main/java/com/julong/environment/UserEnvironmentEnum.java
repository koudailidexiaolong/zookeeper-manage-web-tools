package com.julong.environment;

/**
 * 系统用户信息
 * @author julong
 * @date 2021年12月2日 下午9:44:30
 * @desc 
 */
public enum UserEnvironmentEnum {
	
	/**
	 * 用户名称
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	USER_NAME_KEY("user.name"),
	
	/**
	 * 用户语言
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	USER_LANGUAGE_KEY("user.language"),
	
	/**
	 * 用户国家
	 * @author julong
	 * @date 2021年12月2日 下午9:35:17
	 */
	USER_COUNTRY_KEY("user.country"),
	
	/**
	 * 用户时区
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	USER_TIMEZONE_KEY("user.timezone"),
	
	/**
	 * 用户工作目录
	 * @author julong
	 * @date 2021年12月2日 下午9:34:52
	 */
	USER_DIR_KEY("user.dir"),
	
	/**
	 * 用户目录
	 * @author julong
	 * @date 2021年12月2日 下午9:34:31
	 */
	USER_HOME_KEY("user.home");
	
	private final String name;
	
	UserEnvironmentEnum(String name){
		this.name = name;
	}
	
	public String value() {
		return this.name;
	}
	
}
