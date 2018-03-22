package com.igindex.mqconfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.websystique.spring")
@Import({MessageConfiguration.class})
public class AppConfig {
	//Put Other Application configuration here.
}
