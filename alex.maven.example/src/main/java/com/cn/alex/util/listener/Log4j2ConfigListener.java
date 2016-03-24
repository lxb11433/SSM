package com.cn.alex.util.listener;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 当spring 容器将所有的bean都初始化完成后，执行该程序
 * @ClassName: Log4j2ConfigListener    
 * @Description: TODO   
 * @author: sun.yang    
 * @date: 2015年10月12日 下午2:43:09    
 * @version: V1.0
 */
@Component
public class Log4j2ConfigListener{

	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(
					classLoader.getResource("log4j2.xml").getFile());
			URL url;
			try {
				url = file.toURI().toURL();
				// 改变系统参数,默认log4j2的配置文件是在src目录下
				System.setProperty("log4j.configurationFile", url.toString());
				// 重新初始化Log4j2的配置上下文
				LoggerContext context = (LoggerContext) LogManager
						.getContext(false);
				context.reconfigure();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

}
