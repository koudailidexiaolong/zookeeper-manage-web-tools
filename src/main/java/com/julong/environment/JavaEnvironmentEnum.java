package com.julong.environment;

/**
 * java 信息
 * @author julong
 * @date 2021年12月2日 下午9:44:37
 * @desc 
 */
public enum JavaEnvironmentEnum {
	/**
	 * java 版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	JAVA_VERSION_KEY("java.version"),
	
	/**
	 * java 版本
	 * @author julong
	 * @date 2021年12月2日 下午9:24:01
	 */
	JAVA_SPECIFICATION_VERSION_KEY("java.specification.version"),
	
	/**
	 * java 编译版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	JAVA_CLASS_VERSION_KEY("java.class.version"),
	
	/**
	 * ext 目录
	 * @author julong
	 * @date 2021年12月2日 下午9:43:48
	 */
	JAVA_EXT_DIRS_KEY("java.ext.dirs"),
	
	/**
	 * java 安装目录
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	JAVA_HOME_KEY("java.home"),
	
	/**
	 * java 厂商
	 * @author julong
	 * @date 2021年12月2日 下午9:21:31
	 */
	JAVA_VENDOR_KEY("java.vendor"),
	
	/**
	 * java 临时文件存储位置
	 * @author julong
	 * @date 2021年12月2日 下午9:30:38
	 */
	JAVA_IO_TMPDIR_KEY("java.io.tmpdir");

	
	private final String name;
	
	JavaEnvironmentEnum(String name){
		this.name = name;
	}
	
	public String value() {
		return this.name;
	}
	
}
