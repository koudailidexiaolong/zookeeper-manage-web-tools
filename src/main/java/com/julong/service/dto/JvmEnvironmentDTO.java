package com.julong.service.dto;

import org.springframework.core.env.StandardEnvironment;

import com.julong.environment.JvmEnvironmentEnum;

public class JvmEnvironmentDTO {
	/**
	 * vm 名称
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	private String javaVmName;
	
	/**
	 * vm 信息
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	private String javaVmInfo;
	
	/**
	 * vm版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	private String javaVmVersion;
	/**
	 * vm厂商
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	private String javaVmVendor;
	/**
	 * vm 版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	private String javaVmSpecificationVersion;
	
	
	public JvmEnvironmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JvmEnvironmentDTO(StandardEnvironment environment) {
		super();
		this.javaVmName = environment.getProperty(JvmEnvironmentEnum.JAVA_VM_NAME_KEY.value());
		this.javaVmInfo = environment.getProperty(JvmEnvironmentEnum.JAVA_VM_INFO_KEY.value());
		this.javaVmVersion = environment.getProperty(JvmEnvironmentEnum.JAVA_VM_VERSION_KEY.value());
		this.javaVmVendor = environment.getProperty(JvmEnvironmentEnum.JAVA_VM_VENDOR_KEY.value());
		this.javaVmSpecificationVersion = environment.getProperty(JvmEnvironmentEnum.JAVA_VM_SPECIFICATION_VERSION_KEY.value());
	}


	public String getJavaVmName() {
		return javaVmName;
	}
	public void setJavaVmName(String javaVmName) {
		this.javaVmName = javaVmName;
	}
	public String getJavaVmInfo() {
		return javaVmInfo;
	}
	public void setJavaVmInfo(String javaVmInfo) {
		this.javaVmInfo = javaVmInfo;
	}
	public String getJavaVmVersion() {
		return javaVmVersion;
	}
	public void setJavaVmVersion(String javaVmVersion) {
		this.javaVmVersion = javaVmVersion;
	}
	public String getJavaVmVendor() {
		return javaVmVendor;
	}
	public void setJavaVmVendor(String javaVmVendor) {
		this.javaVmVendor = javaVmVendor;
	}
	public String getJavaVmSpecificationVersion() {
		return javaVmSpecificationVersion;
	}
	public void setJavaVmSpecificationVersion(String javaVmSpecificationVersion) {
		this.javaVmSpecificationVersion = javaVmSpecificationVersion;
	}
	@Override
	public String toString() {
		return "JvmEnvironmentDTO [javaVmName=" + javaVmName + ", javaVmInfo=" + javaVmInfo + ", javaVmVersion="
				+ javaVmVersion + ", javaVmVendor=" + javaVmVendor + ", javaVmSpecificationVersion="
				+ javaVmSpecificationVersion + "]";
	}
	
	
	
}
