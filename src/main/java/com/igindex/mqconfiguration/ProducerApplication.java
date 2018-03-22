package com.igindex.mqconfiguration;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.igindex.service.FileUploadService;

public class ProducerApplication {
	static final Logger LOG = LoggerFactory.getLogger(ProducerApplication.class);
    
    private static AtomicInteger id = new AtomicInteger();
     
    public static void main(String[] args){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);
  
        /*FileUploadService fileUploadService = (FileUploadService) context.getBean("fileUploadService");
         
         
        Product product = getProduct();
        LOG.info("Application : sending order {}", product);
        *///fileUploadService.sendProduct(product);
         
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        ((AbstractApplicationContext)context).close();
    }
}
