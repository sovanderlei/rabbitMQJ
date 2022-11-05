package com.ms.rabbitMQJ.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson; 
import com.ms.rabbitMQJ.modal.TbOrderSel; 
import com.ms.rabbitMQJ.service.RabbitMQSender;
import com.ms.rabbitMQJ.service.RabbitMQSendmsn; 

public class RabbitmqController {
 
	private static String sPath = "D:\\Developer\\portfolio\\temp\\jsonfile\\";

	@Autowired
	RabbitMQSender rabbitMQSender;
	
	public static void main(String[] args) {
		 
		
		
	}
	
	/*CONTROLE SEND MESSAGE RABBITMQL*/
	
	public void MonitoringSendMessageRabbitMQ() { 
		List<String> fileList = new ArrayList<String>();
		
		//CreateFileJson(sPath); 
		 
		
		while (true) {

			try {
				
		        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		        System.out.println("Start send message rabbitmq  -> "+dtf.format(LocalDateTime.now())); 
		        fileList = findAllFilesInFolder(sPath);
		        if(fileList != null && fileList.size() > 0) {
		        	ProcessFile(fileList);
		        } 
		        System.out.println("End send message rabbitmq  -> "+dtf.format(LocalDateTime.now()));		       
				 
				Thread.sleep(60000);
				// Thread.sleep(60000);

			} catch (InterruptedException e) {
				 System.out.println(e.getMessage());
			}

		}
 
		
	}
	 
	private static void CreateFileJson(String pathstr) {
		 
		File f = new File(pathstr);
		if (!f.isDirectory()) {
			f.mkdirs();
		}
	 
		try {
			
			for (int i = 1; i < 20; i++) {
				 
				TbOrderSel data = new TbOrderSel();
				data.setId(i);
				data.setIdSalesMan(1);
				data.setIdCompany(1);
				data.setIdCustomer(1);
				data.setNameCustomer("Customer 00"+i);
			    data.setIdProduct(1);
			    data.setNameProduct("Produto 00"+i);
			    data.setTaxCouponNumber("1234567890");
			    data.setEmail("sovanderlei@hotmail.com");
			    data.setBarcode("1234567890");
			    data.setQrcode("1234567890");
			    data.setGoal(100.0);
			    data.setGoalAchieved(0.0);
			    data.setGoalValue(0.0);
			    data.setUnitQuantity(2.0);
			    data.setSoldValue(10.0);
			    data.setTotal(20.0);
			    // LocalDate.now()
			    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			    data.setCreatedDate( date );
			    data.setUpdatedDate(date);
			    data.setStatus("sold");
			    data.setActive("YES"); 
					  
				String json = new Gson().toJson(data); 
				String sNameFile = "TbOrderSel0"+i+".json";
				 
				FileWriter writer = new FileWriter(pathstr+sNameFile);
				writer.write(json);
				writer.close();
			
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private static List<String> findAllFilesInFolder(String spathFile) {
		
		List<String> fileList = new ArrayList<String>();
		 
		File folder = new File(spathFile);
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				
				fileList.add(file.getName());
				//System.out.println(file.getName());
			} else {
				findAllFilesInFolder(spathFile);
			}
		}
		
		return fileList;
		
	}	
	
	private static void ProcessFile(List<String> fileList )  {
		Gson gson = new Gson();
		 
        for (int i = 0; i < fileList.size(); i++) {
            String pathFile = sPath+"\\"+fileList.get(i);
            
        	File existingFile = new File(pathFile); 
        	if (existingFile.exists() && existingFile.isFile()) {
        		
	            try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
	            	
	            	TbOrderSel ordersel = gson.fromJson(br, TbOrderSel.class); 
	            	System.out.println("File send file name -> "+fileList.get(i));
	            	SendMessageRabbitMQ(ordersel); 
	            	//if(i == 1) {break;}
	            	 
	            	
	            } catch (FileNotFoundException e) { 
	    			e.printStackTrace();
	    		} catch (IOException e) { 
	    			e.printStackTrace();
	    		} 
	            
            	//delete file
            	try {
					Thread.sleep(2000);
					existingFile.delete();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
    		
        	}
    		
            
        }
       
		
	}
	
	private static void SendMessageRabbitMQ(TbOrderSel ordersel) {
		
		try { 
			 
			//RabbitMQSendmsn.Sendermsn(" mensagem teste 01 ");
			//RabbitMQSendmsn.Sendermsn(" mensagem teste 01 ");
			//RabbitMQSendmsn.Sendermsn(" mensagem teste 01 "); 
			
			//TbOrderSel objecto = new TbOrderSel();
			//objecto.setId(100);
			//objecto.setNameCustomer("vanderlei Soares 000"+100); 
			RabbitMQSendmsn.sendJsonObject(ordersel);
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*FIM CONTROLE SEND MESSAGE RABBITMQL*/
	
	/*CONTROLE GET MESSAGE RABBITMQL*/
	
	public void MonitoringGetMessageRabbitMQ() {
		ArrayList<String> listRetorn = null;  
		while (true) {

			try {
 
				listRetorn = new ArrayList<String>();
				listRetorn = RabbitMQSendmsn.GetMessage();
				if(listRetorn != null && listRetorn.size() > 0) {
					saveDataBase(listRetorn);
				}
				
				Thread.sleep(60000);

			} catch (InterruptedException e) {
				 System.out.println(e.getMessage());
			}

		}

	}
	
	public static void saveDataBase(ArrayList<String> listRetorn) {
		
		if(listRetorn != null && listRetorn.size() > 0) {
			for (String item : listRetorn) {
				//loop and save data to database
				System.out.println(item);
			}
		}
		
		
	}
	
	/*FIM CONTROLE GET MESSAGE RABBITMQL*/
	
	
	

}
