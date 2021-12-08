package com.julong.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Service;

import com.julong.service.EnvironmentService;
import com.julong.service.dto.JavaEnvironmentDTO;
import com.julong.service.dto.JvmEnvironmentDTO;
import com.julong.service.dto.ServerEnvironmentDTO;
import com.julong.service.dto.SystemEnvironmentDTO;
import com.julong.service.dto.UserEnvironmentDTO;

/**
 * 环境变量获取实现类
 * @author julong
 * @date 2021年12月2日 下午9:14:24
 * @desc 
 */
@Service
public class EnvironmentServiceImpl implements EnvironmentService {
	
	private static final Logger logger = LoggerFactory.getLogger(EnvironmentServiceImpl.class);
	
	@Autowired
	private StandardEnvironment environment;
	
	/**
	 * 获取系统属性版本属性信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月2日 下午9:13:59
	 * @desc
	 */
	@Override
	public SystemEnvironmentDTO getSystemEnvironment() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("【系统参数】-获取系统配置参数");
		return new SystemEnvironmentDTO(this.environment);
	}

	/**
	 * 获取系统用户信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月2日 下午10:19:57
	 * @desc
	 */
	@Override
	public UserEnvironmentDTO getUseEnvironment() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("【系统参数】-获取系统用户配置参数");
		return new UserEnvironmentDTO(this.environment);
	}

	/**
	 * 服务信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月3日 下午3:21:58
	 * @desc
	 */
	@Override
	public ServerEnvironmentDTO getServerEnvironment() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("【系统参数】-获取服务配置参数");
		return new ServerEnvironmentDTO(this.environment);
	}

	/**
	 * java配置信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月3日 下午3:28:27
	 * @desc
	 */
	@Override
	public JavaEnvironmentDTO getJavaEnvironment() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("【系统参数】-获取java配置参数");
		return new JavaEnvironmentDTO(this.environment);
	}

	/**
	 * jvm 属性信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月3日 下午3:35:17
	 * @desc
	 */
	@Override
	public JvmEnvironmentDTO getJvmEnvironment() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("【系统参数】-获取jvm配置参数");
		return new JvmEnvironmentDTO(this.environment);
	}

	
	
}
