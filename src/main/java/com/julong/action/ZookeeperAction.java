package com.julong.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.julong.configuration.ZookeeperProperties;
import com.julong.service.EnvironmentService;
import com.julong.service.ZookeeperService;
import com.julong.service.dto.JavaEnvironmentDTO;
import com.julong.service.dto.JvmEnvironmentDTO;
import com.julong.service.dto.ServerEnvironmentDTO;
import com.julong.service.dto.SystemEnvironmentDTO;
import com.julong.service.dto.UserEnvironmentDTO;
import com.julong.service.dto.ZookeeperEnvironmentDTO;
import com.julong.service.dto.ZookeeperNodeDTO;

/**
 * zookeeper 页面处理类
 * @author julong
 * @date 2021年12月7日 上午9:51:52
 * @desc 
 */
@Controller
public class ZookeeperAction {

	private static final Logger logger = LoggerFactory.getLogger(ZookeeperAction.class);

	@Autowired
	private EnvironmentService systemEnvironmentServiceImpl;
	
	@Autowired 
	private ZookeeperService zookeeperServiceImpl;
	
	/**
	 * 系统首页入口
	 * @param model
	 * @return
	 * @author julong
	 * @date 2021年12月7日 上午9:51:33
	 * @desc
	 */
	@RequestMapping(value = {"","/","/zookeeper"})
	public ModelAndView zookeeper(Model model) {
		try {
			logger.info("【zookeeper】-主入口的方法");
			//系统属性
			SystemEnvironmentDTO systemEnvironment = this.systemEnvironmentServiceImpl.getSystemEnvironment();
			model.addAttribute("systemEnvironment", systemEnvironment);
			// 用户属性
			UserEnvironmentDTO userEnvironment = this.systemEnvironmentServiceImpl.getUseEnvironment();
			model.addAttribute("userEnvironment", userEnvironment);
			//  服务属性
			ServerEnvironmentDTO serverEnvironment = this.systemEnvironmentServiceImpl.getServerEnvironment();
			model.addAttribute("serverEnvironment", serverEnvironment);
			//java 属性
			JavaEnvironmentDTO javaEnvironment = this.systemEnvironmentServiceImpl.getJavaEnvironment();
			model.addAttribute("javaEnvironment", javaEnvironment);
			// jvm 属性
			JvmEnvironmentDTO jvmEnvironment = this.systemEnvironmentServiceImpl.getJvmEnvironment();
			model.addAttribute("jvmEnvironment", jvmEnvironment);
			//读取zokeeper 默认连接信息
			ZookeeperProperties zookeeperProperties = this.zookeeperServiceImpl.getDefault();
			model.addAttribute("zookeeperProperties", zookeeperProperties);
			
			ZookeeperEnvironmentDTO zookeeperEnvironment = this.zookeeperServiceImpl.getZookeeperEnvironment();
			model.addAttribute("zookeeperEnvironment", zookeeperEnvironment);
			
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			logger.error("【zookeeper】-查询初始化参数出现异常：{}",e);
		}
		return new ModelAndView("/index");
	}
	

	/**
	 * 打开新连接的方法
	 * @param model
	 * @param connectString
	 * @return
	 * @author julong
	 * @date 2021年12月4日 下午5:20:00
	 * @desc
	 */
	@RequestMapping(value = {"/zookeeperIndex"})
	public ModelAndView zookeeperIndex(Model model,String connectString) {
		model.addAttribute("connectString", connectString);
		logger.info("【zookeeper】-打开zookeeper页面：{}",connectString);
		return new ModelAndView("/zookeeper-index");
	}
	
	/**
	 * 连接zookeeper 的方法
	 * @param connectString
	 * @return
	 * @author julong
	 * @date 2021年12月4日 下午5:20:16
	 * @desc
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = {"/zookeeperConnection"})
	@ResponseBody
	public Map<String,Object> zookeeperConnection(String connectString) {
		logger.info("【zookeeper】-连接zookeeper");
		Map<String,Object> maps = new HashMap<String,Object>();
		boolean zookeeperConnectioned = false; 
		String zookeeperAddress = "";
		try {
			CuratorFramework curatorFramework = this.zookeeperServiceImpl.connectionZookeeper();
			if(curatorFramework != null){
				zookeeperConnectioned = curatorFramework.isStarted();
				logger.info("【zookeeper】-连接zookeeper状态：{}",zookeeperConnectioned);
				zookeeperAddress = curatorFramework.getZookeeperClient().getCurrentConnectionString();
			}else{
				logger.info("【zookeeper】-连接zookeeper失败！对象为空");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			maps.put("zookeeperConnectioned", false);
			logger.error("【zookeeper】-连接zookeeper发生异常：{}",e);
		}finally{
			maps.put("zookeeperConnectioned", zookeeperConnectioned);
			maps.put("zookeeperAddress", zookeeperAddress);
		}
		return maps;
	}
	
	/**
	 * 关闭zookeeper 
	 * @return
	 * @author julong
	 * @date 2021年12月4日 下午10:51:40
	 * @desc
	 */
	@RequestMapping(value = {"/closeZookeeper"})
	@ResponseBody
	public Map<String,Object> closeZookeeper() {
		logger.info("【zookeeper】-关闭zookeeper");
		Map<String,Object> maps = new HashMap<String,Object>();
		boolean zookeeperclosed = false; 
		try {
			zookeeperclosed = this.zookeeperServiceImpl.closeZookeeper();
			logger.info("【zookeeper】-关闭zookeeper连接返回结果：{}",zookeeperclosed);
			maps.put("zookeeperclosed", zookeeperclosed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			logger.error("【zookeeper】-关闭zookeeper发生异常：{}",e);
		}finally{
			maps.put("zookeeperclosed", zookeeperclosed);
		}
		return maps;
	}
	
	/**
	 * 检测zookeeper连接状态 
	 * @return
	 * @author julong
	 * @date 2021年12月4日 下午11:07:31
	 * @desc
	 */
	@RequestMapping(value = {"/checkZookeeperStatus"})
	@ResponseBody
	public Map<String,Object> checkZookeeperStatus() {
		logger.info("【zookeeper】-检测zookeeper连接状态");
		Map<String,Object> maps = new HashMap<String,Object>();
		boolean zookeeperConnectioned = false; 
		try {
			zookeeperConnectioned = this.zookeeperServiceImpl.zookeeperIsConnectioned();
			logger.info("【zookeeper】-检测zookeeper连接状态：{}",zookeeperConnectioned);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			maps.put("zookeeperConnectioned", false);
			logger.error("【zookeeper】-关闭zookeeper发生异常：{}",e);
		}finally{
			maps.put("zookeeperConnectioned", zookeeperConnectioned);
		}
		return maps;
	}
	
	
	/**
	 * 查询节点列表
	 * @param path
	 * @return
	 * @author julong
	 * @date 2021年12月5日 下午10:10:27
	 * @desc
	 */
	@RequestMapping(value = {"/selectZookeeperNodeList"})
	@ResponseBody
	public Map<String,Object> selectZookeeperNodeList(String nodePath) {
		logger.info("【zookeeper】-根据nodePath查询zookeeper节点:{}",nodePath);
		Map<String,Object> maps = new HashMap<String,Object>();
		boolean zookeeperConnectioned = false; 
		try {
			zookeeperConnectioned = this.zookeeperServiceImpl.zookeeperIsConnectioned();
			logger.info("【zookeeper】-检测zookeeper连接状态：{}",zookeeperConnectioned);
			if(zookeeperConnectioned){
				List<ZookeeperNodeDTO> zookeeperNodeList =  this.zookeeperServiceImpl.selectZookeeperPath(nodePath);
				maps.put("zookeeperNodeList", zookeeperNodeList);
			}
			maps.put("zookeeperConnectioned", false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			maps.put("zookeeperConnectioned", false);
			logger.error("【zookeeper】-查询zookeeper节点发生异常：{}",e);
		}finally{
			maps.put("zookeeperConnectioned", zookeeperConnectioned);
		}
		return maps;
	}
	
	/**
	 * 检测zookeeper节点是否存在并获取对象信息
	 * @param nodePath
	 * @return
	 * @author julong
	 * @date 2021年12月7日 上午10:33:08
	 * @desc
	 */
	@RequestMapping(value = {"/checkZookeeperNodeExist"})
	@ResponseBody
	public Map<String,Object> checkZookeeperNodeExist(String nodePath) {
		logger.info("【zookeeper】-检测zookeeper节点信息输入参数：{}",nodePath);
		Map<String,Object> maps = new HashMap<String,Object>();
		Stat stat = null; 
		String data = null;
		boolean zookeeperConnectioned = false; 
		try {
			zookeeperConnectioned = this.zookeeperServiceImpl.zookeeperIsConnectioned();
			logger.info("【zookeeper】-检测zookeeper连接状态：{}",zookeeperConnectioned);
			if(zookeeperConnectioned){
				stat = this.zookeeperServiceImpl.checkZookeeperNodeExist(nodePath);
				data = this.zookeeperServiceImpl.getZookeeperNodeData(nodePath);
			}
			maps.put("data", data);
			maps.put("stat", stat);
			logger.info("【zookeeper】-检测zookeeper是否存在：{}",stat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			maps.put("zookeeperConnectioned", false);
			logger.error("【zookeeper】-关闭zookeeper发生异常：{}",e);
		}finally{
			maps.put("zookeeperConnectioned", zookeeperConnectioned);
		}
		return maps;
	}
	
}
