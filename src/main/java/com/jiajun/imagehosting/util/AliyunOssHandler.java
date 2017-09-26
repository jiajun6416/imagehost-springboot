package com.jiajun.imagehosting.util;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;

/**
 * aliyun oss操作 
 * @Date 2017/09/06 16时
 */
@Component
@ConfigurationProperties(prefix="oss")
public class AliyunOssHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(AliyunOssHandler.class);
	
	private String accessKeyId;
	private String accessKeySecret;
    private String endpoint;
    private String bucketName;
	private int maxConnections;
	private int timeoutSecond;
	private String domain;
    
    private OSSClient ossClient;
    
    @PostConstruct
    public void initClient() {
    	ClientConfiguration conf = new ClientConfiguration();
    	conf.setMaxConnections(maxConnections);
    	conf.setSocketTimeout(timeoutSecond*1000);
    	ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret, conf);
    }
    
    @PreDestroy
    public void destoryClient() {
    	ossClient.shutdown();
    }
    
    
    public String uploadFile(String path, String uniqueName, InputStream inputStream ) {
    	if(logger.isInfoEnabled()) {
    		logger.info("Uploading image {} to oss", path+uniqueName);
    	}
    	String key = path + uniqueName;
    	try {
			ossClient.putObject(bucketName, key, inputStream);
		} catch (OSSException | ClientException e) {
			throw e;
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	return domain+key;
    }

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	public void setTimeoutSecond(int timeoutSecond) {
		this.timeoutSecond = timeoutSecond;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
    
    
}
