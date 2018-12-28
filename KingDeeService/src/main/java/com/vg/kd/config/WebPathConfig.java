package com.vg.kd.config;

 
import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.vg.kd.KingDeeServiceApplication;

//暂时禁用，目录放在 原 static下面 @Configuration
public class WebPathConfig  implements WebMvcConfigurer{
	
	protected final static Logger logger = LoggerFactory.getLogger(KingDeeServiceApplication.class);
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		ApplicationHome home = new ApplicationHome(WebPathConfig.class);
		File jarFile = home.getSource();
		String path="file:"+jarFile.getParentFile().toString()+"/static/";
		logger.info(path);
		
		 registry.addResourceHandler("/config/**").addResourceLocations( path);// 为什么不行

		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	 
}
