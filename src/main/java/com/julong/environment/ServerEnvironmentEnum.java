package com.julong.environment;

/**
 * 启动服务信息
 * @author julong
 * @date 2021年12月2日 下午9:44:58
 * @desc 
 */
public enum ServerEnvironmentEnum {
	/**
	 * 系统名称
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	CATALINA_USENAMING_KEY("catalina.useNaming"),
	
	/**
	 * 运行的目录
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	CATALINA_HOME_KEY("catalina.home"),
	/**
	 * 运行的目录
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	CATALINA_BASE_KEY("catalina.base");
	
	
	private final String name;
	
	ServerEnvironmentEnum(String name){
		this.name = name;
	}
	
	public String value() {
		return this.name;
	}
	
}
