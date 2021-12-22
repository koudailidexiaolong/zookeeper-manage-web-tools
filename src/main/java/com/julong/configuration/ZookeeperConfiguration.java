package com.julong.configuration;

import org.apache.curator.RetryPolicy;
import org.apache.curator.ensemble.EnsembleProvider;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class ZookeeperConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(ZookeeperConfiguration.class);

	@Autowired(required = false)
	private EnsembleProvider ensembleProvider;

	@Bean
	public ZookeeperProperties zookeeperProperties() {
		return new ZookeeperProperties();
	}
	
	/**
	 * 使用curator 创建zookeeper 连接
	 * @param retryPolicy 重试策略,内建有四种重试策略
	 * @param properties
	 * @return
	 * @throws Exception
	 * @author julong
	 * @date 2021年12月2日 下午5:22:51
	 * @desc
	 */
	public CuratorFramework curatorFramework(RetryPolicy retryPolicy, ZookeeperProperties properties) throws Exception {
		CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
		if(null == properties){
			if(logger.isInfoEnabled()){
				logger.info("zookeeper配置：加载配置文件中的配置properties");
			}
			properties = this.zookeeperProperties();
		}
		if (this.ensembleProvider != null) {
			builder.ensembleProvider(this.ensembleProvider);
		} else {
			builder.connectString(properties.getConnectString());
		}
		
		if(null == retryPolicy){
			if(logger.isInfoEnabled()){
				logger.info("zookeeper配置：加载配置文件中的配置retryPolicy");
			}
			retryPolicy = this.exponentialBackoffRetry(properties);
		}
		CuratorFramework curator = builder.retryPolicy(retryPolicy).build();
		curator.start();
		if(logger.isTraceEnabled()){
			logger.trace("blocking until connected to zookeeper for " + properties.getBlockUntilConnectedWait() + properties.getBlockUntilConnectedUnit());
		}
		boolean connection = curator.blockUntilConnected(properties.getBlockUntilConnectedWait(), properties.getBlockUntilConnectedUnit());
		if(logger.isTraceEnabled()){
			logger.trace("connected to zookeeper：{}",connection);
		}
		if(connection == false){
			curator = null;
		}
		return curator;
	}

	@Bean
	@ConditionalOnMissingBean
	public RetryPolicy exponentialBackoffRetry(ZookeeperProperties properties) {
		return new ExponentialBackoffRetry(properties.getBaseSleepTimeMs(),
				properties.getMaxRetries(),
				properties.getMaxSleepMs());
	}

}
