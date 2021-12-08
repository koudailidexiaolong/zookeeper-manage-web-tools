package com.julong.service;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;

import com.julong.configuration.ZookeeperProperties;
import com.julong.service.dto.ZookeeperEnvironmentDTO;
import com.julong.service.dto.ZookeeperNodeDTO;

/**
 * zookeeper 业务处理类
 * @author julong
 * @date 2021年12月4日 上午9:35:34
 * @desc 
 */
public interface ZookeeperService {

	/**
	 * 获取默认配置
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月4日 上午10:16:33
	 * @desc
	 */
	public abstract ZookeeperProperties getDefault() throws Exception;
	
	/**
	 * 获取zookeeper 连接对象
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月4日 下午5:24:17
	 * @desc
	 */
	public abstract CuratorFramework connectionZookeeper() throws Exception;
	
	/**
	 * 获取zookeeper客户端版本信息
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月4日 下午5:24:34
	 * @desc
	 */
	public abstract ZookeeperEnvironmentDTO getZookeeperEnvironment() throws Exception;	
	
	
	
	/**
	 * 关闭zookeeper 
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月4日 下午11:57:32
	 * @desc
	 */
	public abstract boolean closeZookeeper() throws Exception;
	
	/**
	 * zookeeper 是否连接正常
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月5日 上午12:01:47
	 * @desc
	 */
	public abstract boolean zookeeperIsConnectioned() throws Exception;
	
	/**
	 * 检查节点是否存在
	 * @param nodePath
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月7日 上午10:24:03
	 * @desc
	 */
	public abstract Stat checkZookeeperNodeExist(String nodePath) throws Exception;
	
	/**
	 * 获取节点数据
	 * @param nodePath
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月7日 下午9:11:04
	 * @desc
	 */
	public abstract String getZookeeperNodeData(String nodePath) throws Exception;
	
	
	/**
	 * 查询zookeeper 节点列表
	 * @param path
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月5日 下午9:08:49
	 * @desc
	 */
	public abstract List<ZookeeperNodeDTO> selectZookeeperPath(String path) throws Exception;
	
}
