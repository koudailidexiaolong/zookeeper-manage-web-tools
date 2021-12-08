package com.julong.service;

import com.julong.service.dto.JavaEnvironmentDTO;
import com.julong.service.dto.JvmEnvironmentDTO;
import com.julong.service.dto.ServerEnvironmentDTO;
import com.julong.service.dto.SystemEnvironmentDTO;
import com.julong.service.dto.UserEnvironmentDTO;

/**
 * 环境变量获取接口
 * @author julong
 * @date 2021年12月2日 下午9:13:46
 * @desc 
 */
public interface EnvironmentService {

	/**
	 * 获取系统属性版本属性信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月2日 下午9:13:59
	 * @desc
	 */
	public abstract SystemEnvironmentDTO getSystemEnvironment() throws Exception;
	
	/**
	 * 获取系统用户信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月2日 下午10:19:57
	 * @desc
	 */
	public abstract UserEnvironmentDTO getUseEnvironment() throws Exception;
	
	/**
	 * 服务信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月3日 下午3:21:58
	 * @desc
	 */
	public abstract ServerEnvironmentDTO getServerEnvironment() throws Exception;
	
	/**
	 * java配置信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月3日 下午3:28:27
	 * @desc
	 */
	public abstract JavaEnvironmentDTO getJavaEnvironment() throws Exception;
	
	/**
	 * jvm 属性信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月3日 下午3:35:17
	 * @desc
	 */
	public abstract JvmEnvironmentDTO getJvmEnvironment() throws Exception;
	
}
