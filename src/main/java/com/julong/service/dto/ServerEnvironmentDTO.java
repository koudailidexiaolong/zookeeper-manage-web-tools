package com.julong.service.dto;

import org.springframework.core.env.StandardEnvironment;

import com.julong.environment.ServerEnvironmentEnum;

/**
 * 服务信息
 * @author julong
 * @date 2021年12月3日 下午3:10:35
 * @desc 
 */
public class ServerEnvironmentDTO {

	/**
	 * 系统名称
	 * @author julong
	 * @date 2021年12月2日 下午8:43:08
	 */
	private String catalinaUseNaming;
	
	/**
	 * 运行的目录
	 * @author julong
	 * @date 2021年12月2日 下午8:43:18
	 */
	private String catalinaHome;
	/**
	 * 运行的目录
	 * @author julong
	 * @date 2021年12月2日 下午8:43:25
	 */
	private String catalinaBase;
	
	
	public ServerEnvironmentDTO(StandardEnvironment environment) {
		super();
		this.catalinaUseNaming = environment.getProperty(ServerEnvironmentEnum.CATALINA_USENAMING_KEY.value());
		this.catalinaHome = environment.getProperty(ServerEnvironmentEnum.CATALINA_HOME_KEY.value());
		this.catalinaBase = environment.getProperty(ServerEnvironmentEnum.CATALINA_BASE_KEY.value());
	}
	
	public ServerEnvironmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCatalinaUseNaming() {
		return catalinaUseNaming;
	}
	public void setCatalinaUseNaming(String catalinaUseNaming) {
		this.catalinaUseNaming = catalinaUseNaming;
	}
	public String getCatalinaHome() {
		return catalinaHome;
	}
	public void setCatalinaHome(String catalinaHome) {
		this.catalinaHome = catalinaHome;
	}
	public String getCatalinaBase() {
		return catalinaBase;
	}
	public void setCatalinaBase(String catalinaBase) {
		this.catalinaBase = catalinaBase;
	}
	@Override
	public String toString() {
		return "ServerEnvironmentDTO [catalinaUseNaming=" + catalinaUseNaming + ", catalinaHome=" + catalinaHome
				+ ", catalinaBase=" + catalinaBase + "]";
	}
	
	
	
}
