package com.julong.environment;

/**
 * 启动服务信息
 * @author julong
 * @date 2021年12月2日 下午9:44:58
 * @desc 
 */
public enum ZookeeperEnvironmentEnum {
	/**
	 * zookeeper 版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	ZOOKEEPER_VERSION_KEY("zookeeper.version"),
	
	/**
	 * 空闲内存
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	OS_MEMORY_FREE_KEY("os.memory.free"),
	/**
	 * 内存使用大小
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	OS_MEMORY_TOTAL_KEY("os.memory.total"),
	/**
	 * 最大内存
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	OS_MEMORY_MAX_KEY("os.memory.max");
	
	
	private final String name;
	
	ZookeeperEnvironmentEnum(String name){
		this.name = name;
	}
	
	public String value() {
		return this.name;
	}
	
}
