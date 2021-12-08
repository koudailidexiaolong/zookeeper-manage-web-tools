package com.julong.environment;

/**
 * jvm 信息
 * @author julong
 * @date 2021年12月2日 下午9:44:21
 * @desc 
 */
public enum JvmEnvironmentEnum {
	/**
	 * vm 名称
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	JAVA_VM_NAME_KEY("java.vm.name"),
	
	/**
	 * vm 信息
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	JAVA_VM_INFO_KEY("java.vm.info"),
	
	/**
	 * vm版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	JAVA_VM_VERSION_KEY("java.vm.version"),
	/**
	 * vm厂商
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	JAVA_VM_VENDOR_KEY("java.vm.vendor"),
	/**
	 * vm 版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	JAVA_VM_SPECIFICATION_VERSION_KEY("java.vm.specification.version");
	
	
	private final String name;
	
	JvmEnvironmentEnum(String name){
		this.name = name;
	}
	
	public String value() {
		return this.name;
	}
	
}
