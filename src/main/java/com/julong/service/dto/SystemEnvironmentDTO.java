package com.julong.service.dto;

import org.springframework.core.env.StandardEnvironment;

import com.julong.environment.SystemEnvironmentEnum;

/**
 * 系统信息
 * @author julong
 * @date 2021年12月2日 下午8:42:29
 * @desc 
 */
public class SystemEnvironmentDTO {

	/**
	 * 系统名称
	 * @author julong
	 * @date 2021年12月2日 下午8:39:44
	 */
	public String osName;
	/**
	 * 系统架构
	 * @author julong
	 * @date 2021年12月2日 下午8:39:52
	 */
	public String osArch;
	/**
	 * 系统版本
	 * @author julong
	 * @date 2021年12月2日 下午8:39:59
	 */
	public String osVersion;
	
	/**
	 * 系统补丁版本
	 * @author julong
	 * @date 2021年12月2日 下午10:40:48
	 */
	public String osPatchLevel;
	
	
	public SystemEnvironmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SystemEnvironmentDTO(StandardEnvironment environment) {
		this.osName = environment.getProperty(SystemEnvironmentEnum.SYSTEM_OS_NAME_KEY.value());
		this.osArch = environment.getProperty(SystemEnvironmentEnum.SYSTEM_OS_ARCH_KEY.value());
		this.osVersion = environment.getProperty(SystemEnvironmentEnum.SYSTEM_OS_VERSION_KEY.value());
		this.osPatchLevel = environment.getProperty(SystemEnvironmentEnum.SYSTEM_SUN_OS_PATCH_LEVEL_KEY.value());
	}



	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public String getOsArch() {
		return osArch;
	}
	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getOsPatchLevel() {
		return osPatchLevel;
	}

	public void setOsPatchLevel(String osPatchLevel) {
		this.osPatchLevel = osPatchLevel;
	}

	@Override
	public String toString() {
		return "SystemEnvironmentDTO [osName=" + osName + ", osArch=" + osArch + ", osVersion=" + osVersion
				+ ", osPatchLevel=" + osPatchLevel + "]";
	}
	
	
	
}
