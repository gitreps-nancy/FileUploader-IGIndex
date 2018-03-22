package com.igindex.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.igindex.model.Order;
import com.igindex.mqconfiguration.MessageSender;

@Service("fileService")
public class FileUploadService {

	public static final String SAVE_LOCATION = "C:/Temp/";
	static final Logger LOG = LoggerFactory.getLogger(FileUploadService.class);
    
	
	@Autowired
    MessageSender messageSender;
	 
    public boolean saveFile(MultipartFile multipartFile){
        boolean result = false;
        //set the saved location and create a directory location
        String fileName  = multipartFile.getOriginalFilename();
        String location = SAVE_LOCATION;
        File pathFile = new File(location);
        //check if directory exist, if not, create directory
        if(!pathFile.exists()){
            pathFile.mkdir();
        }
 
        //create the actual file
        pathFile = new File(location + fileName);
        //save the actual file
        try {
            multipartFile.transferTo(pathFile);
            result = true;
            
            ObjectMapper objectMapper = new XmlMapper();
            List<Order> orderList = objectMapper.readValue(StringUtils.toEncodedString(Files.readAllBytes(Paths.get(location + fileName)), StandardCharsets.UTF_8),  
            		new TypeReference<List<Order>>(){});
            orderList.forEach(order ->{
            	System.out.println(order);
            	//send each of the object to Active MQ
            	LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                LOG.info("Application : sending order request {}", order);
                messageSender.sendMessage(order);
                LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            	            	
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
