package com.julong.environment;

/**
 * 操作系统信息
 * @author julong
 * @date 2021年12月2日 下午9:44:58
 * @desc 
 */
public enum SystemEnvironmentEnum {
	/**
	 * 系统名称
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	SYSTEM_OS_NAME_KEY("os.name"),
	
	/**
	 * 系统架构
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	SYSTEM_OS_ARCH_KEY("os.arch"),
	
	/**
	 * 系统补丁版本
	 * @author julong
	 * @date 2021年12月2日 下午10:39:53
	 */
	SYSTEM_SUN_OS_PATCH_LEVEL_KEY("sun.os.patch.level"),
	
	/**
	 * 系统版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	SYSTEM_OS_VERSION_KEY("os.version");
	
	
	private final String name;
	
	SystemEnvironmentEnum(String name){
		this.name = name;
	}
	
	public String value() {
		return this.name;
	}
	
}
