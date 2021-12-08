package com.julong.service.dto;

import org.apache.zookeeper.Environment;

public class ZookeeperEnvironmentDTO {

	
	/**
	 * zookeeper 版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	private String zookeeperVersion;
	
	/**
	 * 空闲内存
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	private String osMemoryFree;
	/**
	 * 内存使用大小
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	private String osMemoryTotal;
	/**
	 * 最大内存
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	private String osMemoryMax;
	
	public ZookeeperEnvironmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getZookeeperVersion() {
		return zookeeperVersion;
	}
	public void setZookeeperVersion(String zookeeperVersion) {
		this.zookeeperVersion = zookeeperVersion;
	}
	public String getOsMemoryFree() {
		return osMemoryFree;
	}
	public void setOsMemoryFree(String osMemoryFree) {
		this.osMemoryFree = osMemoryFree;
	}
	public String getOsMemoryTotal() {
		return osMemoryTotal;
	}
	public void setOsMemoryTotal(String osMemoryTotal) {
		this.osMemoryTotal = osMemoryTotal;
	}
	public String getOsMemoryMax() {
		return osMemoryMax;
	}
	public void setOsMemoryMax(String osMemoryMax) {
		this.osMemoryMax = osMemoryMax;
	}
	@Override
	public String toString() {
		return "ZookeeperEnvironmentDTO [zookeeperVersion=" + zookeeperVersion + ", osMemoryFree=" + osMemoryFree
				+ ", osMemoryTotal=" + osMemoryTotal + ", osMemoryMax=" + osMemoryMax + "]";
	}
	
	
	
	
}
