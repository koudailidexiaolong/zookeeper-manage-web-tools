package com.julong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.Environment;
import org.apache.zookeeper.Environment.Entry;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julong.configuration.ZookeeperConfiguration;
import com.julong.configuration.ZookeeperProperties;
import com.julong.environment.ZookeeperEnvironmentEnum;
import com.julong.service.ZookeeperService;
import com.julong.service.dto.ZookeeperEnvironmentDTO;
import com.julong.service.dto.ZookeeperNodeDTO;
import com.julong.utils.ZookeeperUtil;

/**
 * zookeeper 业务处理类
 * @author julong
 * @date 2021年12月4日 上午9:35:34
 * @desc 
 */
@Service
public class ZookeeperServiceImpl implements ZookeeperService {

	private static final Logger logger = LoggerFactory.getLogger(ZookeeperServiceImpl.class);
	@Autowired
	private ZookeeperConfiguration zookeeperConfiguration;
	
	
	/**
	 * 获取默认配置
	 * @return ZookeeperProperties
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月4日 上午10:16:33
	 * @desc
	 */
	@Override
	public ZookeeperProperties getDefault() throws Exception {
		// TODO Auto-generated method stub
		if(logger.isDebugEnabled()){
			logger.debug("【zookeeper】-获取zookeeper 默认配置信息");
		}
		return this.zookeeperConfiguration.zookeeperProperties();
	}

	
	/**
	 * 获取zookeeper 连接对象
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月4日 下午5:24:17
	 * @desc
	 */
	@Override
	public CuratorFramework connectionZookeeper() throws Exception {
		// TODO Auto-generated method stub
		if(logger.isDebugEnabled()){
			logger.debug("【zookeeper】-创建zookeeper连接");
		}
		if(ZookeeperUtil.curatorFramework == null){
			boolean connection = ZookeeperUtil.connectionZookeeper(this.zookeeperConfiguration);
			logger.info("【zookeeper】-创建zookeeper连接connection：{}",connection);
		}
		return ZookeeperUtil.curatorFramework;
	}


	@Override
	public ZookeeperEnvironmentDTO getZookeeperEnvironment() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("【zookeeper】-读取zookeeper默认参数配置");
		ZookeeperEnvironmentDTO zookeeperEnvironment = new ZookeeperEnvironmentDTO();
		List<Entry> list = Environment.list();
		for (Entry entry:list) {
			if(entry.getKey().equals(ZookeeperEnvironmentEnum.ZOOKEEPER_VERSION_KEY.value())){
				zookeeperEnvironment.setZookeeperVersion(entry.getValue());
			}
			if(entry.getKey().equals(ZookeeperEnvironmentEnum.OS_MEMORY_FREE_KEY.value())){
				zookeeperEnvironment.setOsMemoryFree(entry.getValue());
			}
			if(entry.getKey().equals(ZookeeperEnvironmentEnum.OS_MEMORY_MAX_KEY.value())){
				zookeeperEnvironment.setOsMemoryMax(entry.getValue());
			}
			if(entry.getKey().equals(ZookeeperEnvironmentEnum.OS_MEMORY_TOTAL_KEY.value())){
				zookeeperEnvironment.setOsMemoryTotal(entry.getValue());
			}
		}
		return zookeeperEnvironment;
	}

	/**
	 * 关闭zookeeper 
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月4日 下午11:57:32
	 * @desc
	 */
	@Override
	public boolean closeZookeeper() throws Exception {
		// TODO Auto-generated method stub
		ZookeeperUtil.closeZookeeper();
		if(ZookeeperUtil.curatorFramework == null){
			logger.info("【zookeeper】-关闭zookeeper连接成功！");
			return true;
		}else{
			logger.info("【zookeeper】-关闭zookeeper连接失败！");
			return false;
		}
	}

	/**
	 * zookeeper 是否连接正常
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月5日 上午12:01:47
	 * @desc
	 */
	@Override
	public boolean zookeeperIsConnectioned() throws Exception {
		// TODO Auto-generated method stub
		if(ZookeeperUtil.curatorFramework != null){
			logger.info("【zookeeper】-连接对象不为空 判断zookeeper 连接状态！");
			return ZookeeperUtil.isConnection();
		}
		return false;
	}

	/**
	 * 查询zookeeper 节点列表
	 * @param path
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月5日 下午9:08:49
	 * @desc
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<ZookeeperNodeDTO> selectZookeeperPath(String path) throws Exception {
		// TODO Auto-generated method stub
		logger.info("【zookeeper】-查询路径：{}",path);
		List<ZookeeperNodeDTO> zookeeperNodeList = new ArrayList<ZookeeperNodeDTO>();
		if(ZookeeperUtil.curatorFramework != null){
			if(ZookeeperUtil.curatorFramework.isStarted()){
				//调用获取节点的方法
				zookeeperNodeList = this.selectZookeeperNode(path); 
				return zookeeperNodeList;
			}
		}
		logger.info("【zookeeper】-没有连接到zookeeper 服务端");
		return zookeeperNodeList;
	}


	/**
	 * 查询节点列表
	 * @param path
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月7日 上午12:18:05
	 * @desc
	 */
	private List<ZookeeperNodeDTO> selectZookeeperNode(String path) throws Exception{
		List<ZookeeperNodeDTO> zookeeperNodeList = new ArrayList<ZookeeperNodeDTO>();
		List<ZookeeperNodeDTO> childrenNode = new ArrayList<ZookeeperNodeDTO>();
		logger.info("【zookeeper】-递归查询输入参数：{}",path);
		//判断是否为跟节点
		if("/".equals(path)){
			ZookeeperNodeDTO zookeeperNodeDTO = new ZookeeperNodeDTO();
			zookeeperNodeDTO.setTitle("root");
			zookeeperNodeDTO.setId(path);
			zookeeperNodeDTO.setChildren(childrenNode);
			zookeeperNodeDTO.setSpread(Boolean.TRUE);
			zookeeperNodeList.add(zookeeperNodeDTO);
		}
		//获取节点
		List<String> nodePath = ZookeeperUtil.getChildrenPath(path);
		//如果当前节点为空 则返回
		if(nodePath == null || nodePath.size() == 0){
			return zookeeperNodeList;
		}
		
		//如果查询到 为列表模式 进行遍历 
		for (int i = 0; i < nodePath.size(); i++) {
			String childrenPath = path + "/" + nodePath.get(i);
			childrenPath = childrenPath.replaceAll("//", "/");
			logger.debug("【zookeeper】-递归到的数据节点：{}",childrenPath);
			ZookeeperNodeDTO zookeeperNodeDTO = new ZookeeperNodeDTO();
			zookeeperNodeDTO.setTitle(nodePath.get(i));
			zookeeperNodeDTO.setId(childrenPath);
			childrenNode.add(zookeeperNodeDTO);
		}
		//递归实现循环读取
		getZookeeperNode(childrenNode);

		return zookeeperNodeList;
	}

	
	/**
	 * 递归查询
	 * @param zookeeperNodeList
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月7日 上午12:18:17
	 * @desc
	 */
	private List<ZookeeperNodeDTO> getZookeeperNode(List<ZookeeperNodeDTO> zookeeperNodeList) throws Exception{
		for (int i = 0; i < zookeeperNodeList.size(); i++) {
			ZookeeperNodeDTO zookeeperNode = zookeeperNodeList.get(i);
			String parentPath = zookeeperNode.getId();
			logger.info("【zookeeper】-当前节点的全路径：{}",parentPath);
			//获取节点
			List<String> nodePath = ZookeeperUtil.getChildrenPath(parentPath);
			//判断当前节点是否存在子节点
			if(null == nodePath || nodePath.size() == 0){
				continue;
			}
			List<ZookeeperNodeDTO> childrenNodeList = new ArrayList<ZookeeperNodeDTO>();
			//如果查询到 为列表模式 进行遍历 
			for (int j = 0; j < nodePath.size(); j++) {
				//将节点加入到 当前对象中
				String childrenPath = parentPath + "/" + nodePath.get(j);
				childrenPath = childrenPath.replaceAll("//", "/");
				if(logger.isDebugEnabled()){
					logger.debug("【zookeeper】-递归到的数据节点组装childrenPath：{}",childrenPath);
				}
				ZookeeperNodeDTO grandson = new ZookeeperNodeDTO();
				if(logger.isDebugEnabled()){
					logger.debug("【zookeeper】-递归到的数据节点名称：{}",nodePath.get(j));
				}
				grandson.setTitle(nodePath.get(j));
				grandson.setId(childrenPath);
				childrenNodeList.add(grandson);
			}
			if(childrenNodeList.size() > 0){
				zookeeperNode.setChildren(childrenNodeList);
				this.getZookeeperNode(childrenNodeList);
			}
		}
		return zookeeperNodeList;
	}

	/**
	 * 检查节点是否存在
	 * @param nodePath
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月7日 上午10:24:03
	 * @desc
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Stat checkZookeeperNodeExist(String nodePath) throws Exception {
		// TODO Auto-generated method stub
		logger.info("【zookeeper】-查询路径：{}",nodePath);
		if(ZookeeperUtil.curatorFramework != null){
			if(ZookeeperUtil.curatorFramework.isStarted()){
				Stat stat = ZookeeperUtil.checkExists(nodePath);
				return stat;
			}
		}
		logger.info("【zookeeper】-没有连接到zookeeper 服务端");
		return null;
	}

	/**
	 * 获取节点数据
	 * @param nodePath
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月7日 下午9:11:04
	 * @desc
	 */
	@Override
	public String getZookeeperNodeData(String nodePath) throws Exception {
		// TODO Auto-generated method stub
		logger.info("【zookeeper】-查询路径：{}",nodePath);
		if(ZookeeperUtil.curatorFramework != null){
			if(ZookeeperUtil.curatorFramework.isStarted()){
				byte[] bytes = ZookeeperUtil.getData(nodePath);
				if(bytes != null){
					return StringUtils.toString(bytes, "utf-8");
				}
			}
		}
		logger.info("【zookeeper】-没有连接到zookeeper 服务端");
		return null;
	}
	
	
	
	
}
