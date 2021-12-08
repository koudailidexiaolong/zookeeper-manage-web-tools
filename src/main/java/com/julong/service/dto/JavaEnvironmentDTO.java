package com.julong.service.dto;

import org.springframework.core.env.StandardEnvironment;

import com.julong.environment.JavaEnvironmentEnum;

public class JavaEnvironmentDTO {

	/**
	 * java 版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	private String javaVersion;
	
	/**
	 * java 版本
	 * @author julong
	 * @date 2021年12月2日 下午9:24:01
	 */
	private String javaSpecificationVersion;
	
	/**
	 * java 编译版本
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	private String javaClassVersion;
	
	/**
	 * ext 目录
	 * @author julong
	 * @date 2021年12月2日 下午9:43:48
	 */
	private String javaExtDirs;
	
	/**
	 * java 安装目录
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	private String javaHome;
	
	/**
	 * java 厂商
	 * @author julong
	 * @date 2021年12月2日 下午9:21:31
	 */
	private String javaVendor;
	
	/**
	 * java 临时文件存储位置
	 * @author julong
	 * @date 2021年12月2日 下午9:30:38
	 */
	private String javaIoTmpdir;

	
	
	
	public JavaEnvironmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JavaEnvironmentDTO(StandardEnvironment environment) {
		super();
		this.javaVersion = environment.getProperty(JavaEnvironmentEnum.JAVA_VERSION_KEY.value());
		this.javaSpecificationVersion = environment.getProperty(JavaEnvironmentEnum.JAVA_SPECIFICATION_VERSION_KEY.value());
		this.javaClassVersion = environment.getProperty(JavaEnvironmentEnum.JAVA_CLASS_VERSION_KEY.value());
		this.javaExtDirs = environment.getProperty(JavaEnvironmentEnum.JAVA_EXT_DIRS_KEY.value());
		this.javaHome = environment.getProperty(JavaEnvironmentEnum.JAVA_HOME_KEY.value());
		this.javaVendor = environment.getProperty(JavaEnvironmentEnum.JAVA_VENDOR_KEY.value());
		this.javaIoTmpdir = environment.getProperty(JavaEnvironmentEnum.JAVA_IO_TMPDIR_KEY.value());
	}



	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getJavaSpecificationVersion() {
		return javaSpecificationVersion;
	}

	public void setJavaSpecificationVersion(String javaSpecificationVersion) {
		this.javaSpecificationVersion = javaSpecificationVersion;
	}

	public String getJavaClassVersion() {
		return javaClassVersion;
	}

	public void setJavaClassVersion(String javaClassVersion) {
		this.javaClassVersion = javaClassVersion;
	}

	public String getJavaExtDirs() {
		return javaExtDirs;
	}

	public void setJavaExtDirs(String javaExtDirs) {
		this.javaExtDirs = javaExtDirs;
	}

	public String getJavaHome() {
		return javaHome;
	}

	public void setJavaHome(String javaHome) {
		this.javaHome = javaHome;
	}

	public String getJavaVendor() {
		return javaVendor;
	}

	public void setJavaVendor(String javaVendor) {
		this.javaVendor = javaVendor;
	}

	public String getJavaIoTmpdir() {
		return javaIoTmpdir;
	}

	public void setJavaIoTmpdir(String javaIoTmpdir) {
		this.javaIoTmpdir = javaIoTmpdir;
	}

	@Override
	public String toString() {
		return "JavaEnvironmentDTO [javaVersion=" + javaVersion + ", javaSpecificationVersion="
				+ javaSpecificationVersion + ", javaClassVersion=" + javaClassVersion + ", javaExtDirs=" + javaExtDirs
				+ ", javaHome=" + javaHome + ", javaVendor=" + javaVendor + ", javaIoTmpdir=" + javaIoTmpdir + "]";
	}
	
	
}
