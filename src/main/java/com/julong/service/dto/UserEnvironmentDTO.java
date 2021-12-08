package com.julong.service.dto;

import org.springframework.core.env.StandardEnvironment;

import com.julong.environment.UserEnvironmentEnum;

public class UserEnvironmentDTO {

	/**
	 * 用户名称
	 * @author julong
	 * @date 2021年12月2日 下午10:18:28
	 */
	private String userName;
	
	/**
	 * 用户语言
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	private String userLanguage;
	
	/**
	 * 用户国家
	 * @author julong
	 * @date 2021年12月2日 下午9:35:17
	 */
	private String userCountry;
	
	/**
	 * 用户时区
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	private String userTimezone;
	
	/**
	 * 用户工作目录
	 * @author julong
	 * @date 2021年12月2日 下午9:34:52
	 */
	private String userDir;
	
	/**
	 * 用户目录
	 * @author julong
	 * @date 2021年12月2日 下午9:34:31
	 */
	private String userHome;
	
	
	

	public UserEnvironmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEnvironmentDTO(StandardEnvironment environment) {
		super();
		this.userName = environment.getProperty(UserEnvironmentEnum.USER_NAME_KEY.value());
		this.userLanguage =  environment.getProperty(UserEnvironmentEnum.USER_LANGUAGE_KEY.value());
		this.userCountry =  environment.getProperty(UserEnvironmentEnum.USER_COUNTRY_KEY.value());
		this.userTimezone =  environment.getProperty(UserEnvironmentEnum.USER_TIMEZONE_KEY.value());
		this.userDir =  environment.getProperty(UserEnvironmentEnum.USER_DIR_KEY.value());
		this.userHome =  environment.getProperty(UserEnvironmentEnum.USER_HOME_KEY.value());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLanguage() {
		return userLanguage;
	}

	public void setUserLanguage(String userLanguage) {
		this.userLanguage = userLanguage;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getUserTimezone() {
		return userTimezone;
	}

	public void setUserTimezone(String userTimezone) {
		this.userTimezone = userTimezone;
	}

	public String getUserDir() {
		return userDir;
	}

	public void setUserDir(String userDir) {
		this.userDir = userDir;
	}

	public String getUserHome() {
		return userHome;
	}

	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}

	@Override
	public String toString() {
		return "UserEnvironmentDTO [userName=" + userName + ", userLanguage=" + userLanguage + ", userCountry="
				+ userCountry + ", userTimezone=" + userTimezone + ", userDir=" + userDir + ", userHome=" + userHome
				+ "]";
	}
	
	
}
