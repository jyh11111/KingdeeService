package com.vg.kd;

 
import java.io.File;
import java.io.FileNotFoundException;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.system.ApplicationHome;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;

 

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableTransactionManagement //允许事务处理
//@MapperScan("com.vg.kd.mapper")配置文件中中设置了扫描，这里就不用了
//@ComponentScan(basePackages = {
//        "com.vg.kd.config",
//        "com.vg.kd.controller",
//        "com.vg.kd.service"})
public class KingDeeServiceApplication {
	protected final static Logger logger = LoggerFactory.getLogger(KingDeeServiceApplication.class);
	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(KingDeeServiceApplication.class, args);
		logger.info("系统已启动");
		
//		ApplicationHome home = new ApplicationHome(KingDeeServiceApplication.class);
//		File jarFile = home.getSource();
//		logger.info(jarFile.getParentFile().toString());
//		
		//获取跟目录
//		File path = new File(ResourceUtils.getURL("classpath:").getPath());
//		if(!path.exists()) path = new File("");
//		System.out.println("path:"+path.getAbsolutePath());

	}
}
