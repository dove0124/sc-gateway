package cn.springcloud.book.dataservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author: andy chu
 * @description : 配置信息
 */
@Component
//@ConfigurationProperties(prefix = "cn.springcloud.book")
@RefreshScope
public class DataConfig {

	@Value("${cn.springcloud.book.defaultUser}")
    private String defaultUser;

	public String getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(String defaultUser) {
		this.defaultUser = defaultUser;
	}

	@Value("${spring.application.name}")
	private String applicationName;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Value("${server.port}")
	private String port;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
