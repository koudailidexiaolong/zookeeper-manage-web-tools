package com.julong.utils;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.ExistsBuilder;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.framework.api.GetDataBuilder;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.julong.configuration.ZookeeperConfiguration;

/**
 * zookeeper 工具类
 * @author julong
 * @date 2021年12月8日 下午5:36:42
 * @desc 
 */
public class ZookeeperUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ZookeeperUtil.class);
	
	public static CuratorFramework curatorFramework = null;
	
	
	/**
	 * 连接zookeeper
	 * @return
	 * @author julong
	 * @date 2021年12月4日 下午5:16:26
	 * @desc
	 */
	public static boolean connectionZookeeper(ZookeeperConfiguration zookeeperConfiguration){
		logger.info("【zookeeper工具类】-连接zookeeper开始");
		try {
			//baseSleepTimeMs  maxRetries
			ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(zookeeperConfiguration.zookeeperProperties().getBaseSleepTimeMs(),zookeeperConfiguration.zookeeperProperties().getMaxRetries());
			curatorFramework =  zookeeperConfiguration.curatorFramework(retryPolicy, null);
			if(null != curatorFramework){
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			logger.error("【zookeeper工具类】-连接zookeeper失败:{}",e);
			return false;
		}
		return false;
	}

	/**
	 * 获取连接状态
	 * @return
	 * @author julong
	 * @date 2021年12月4日 下午6:18:18
	 * @desc
	 */
	public static boolean isConnection(){
		boolean started = false;
		try {
			started = curatorFramework.getZookeeperClient().blockUntilConnectedOrTimedOut();
			logger.info("【zookeeper工具类】-连接zookeeper状态：{}",started);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			logger.error("【zookeeper工具类】-检测zookeeper连接状态异常：{}",e);
		}
		return started;
	}
	
	/**
	 * 检测是否存在节点
	 * @param path
	 * @return
	 * @author julong
	 * @date 2021年12月6日 下午1:29:01
	 * @desc
	 */
	public static Stat checkExists(String path){
		logger.info("【zookeeper工具类】-检测zookeeper是否存在此节点输入参数path：{}",path);
		ExistsBuilder builder = curatorFramework.checkExists();
		Stat stat = null;
		try {
			stat = builder.forPath(path);
			return stat;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			logger.error("【zookeeper工具类】-检测zookeeper是否存在此节点发生异常",e);
		}
		return stat;
	}
	
	
	/**
	 * 获取节点信息
	 * @param path
	 * @return
	 * @author julong
	 * @date 2021年12月7日 下午9:02:36
	 * @desc
	 */
	@SuppressWarnings("deprecation")
	public static List<String> getChildrenPath(String path){
		try {
			boolean started = curatorFramework.isStarted();
			logger.info("【zookeeper工具类】-连接zookeeper状态：{}",started);
			if(started){
				GetChildrenBuilder childrenBuilder = curatorFramework.getChildren();
				List<String> nodePath = childrenBuilder.forPath(path);
				return nodePath;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			logger.error("【zookeeper工具类】-查询zookeeper节点列表发生异常：{}",e);
		}
		
		return null;
	}
	
	/**
	 * 查询节点数据值
	 * @param path
	 * @return
	 * @author julong
	 * @date 2021年12月7日 下午9:05:35
	 * @desc
	 */
	@SuppressWarnings("deprecation")
	public static byte[] getData(String path){
		try {
			boolean started = curatorFramework.isStarted();
			logger.info("【zookeeper工具类】-连接zookeeper状态：{}",started);
			if(started){
				GetDataBuilder dataBuilder = curatorFramework.getData();
				byte[] bytes = dataBuilder.forPath(path);
				return bytes;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			logger.error("【zookeeper工具类】-查询zookeeper节点列表发生异常：{}",e);
		}
		
		return null;
	}
	
	/**
	 * 关闭连接
	 * @return
	 * @author julong
	 * @date 2021年12月4日 下午5:18:34
	 * @desc
	 */
	public static boolean closeZookeeper(){
		//判断当前连接是否为空
		if(curatorFramework != null){
			//关闭连接
			curatorFramework.close();
			// 对象销毁
			curatorFramework = null;
		}
		return true;
	}
}
