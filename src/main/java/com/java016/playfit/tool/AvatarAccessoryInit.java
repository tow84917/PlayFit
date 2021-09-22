package com.java016.playfit.tool;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.java016.playfit.dao.AvatarBodyRepository;
import com.java016.playfit.dao.AvatarClothesRepository;
import com.java016.playfit.dao.AvatarHatRepository;
import com.java016.playfit.model.AvatarBody;
import com.java016.playfit.model.AvatarClothes;
import com.java016.playfit.model.AvatarHat;
import com.java016.playfit.model.BodyType;
import com.java016.playfit.service.BodyTypeService;


@Controller
public class AvatarAccessoryInit {
	
	@Autowired
	BodyTypeService bodyTypeService;
	
	@Autowired
	AvatarBodyRepository avatarBodyRepo;
	
	@Autowired
	AvatarClothesRepository avatarClothesRepo;
	
	@Autowired
	AvatarHatRepository avatarHatRepo;
	
	@RequestMapping("/addAccessory")
	@ResponseBody
	public String addAccessory() {
		
		// 單一配件path
		String[][] accessory = null;

//		讀所有檔案
		File folderBody = new File("src/main/resources/static/images/Avatar/Accessory/Body");
		File folderClothes = new File("src/main/resources/static/images/Avatar/Accessory/Clothes");
		File folderHat = new File("src/main/resources/static/images/Avatar/Accessory/Hat");
		
		File[] fileMdrs = {folderBody, folderClothes, folderHat};
		
		for(File accessoryFolder : fileMdrs) {
			
			// 現在 在哪個資料夾
			String accessoryType = "";
			
			System.out.println(accessoryFolder.getPath());
			
			if (accessoryFolder.getPath().replace("\\", "/")
					.equals("src/main/resources/static/images/Avatar/Accessory/Body")
				) {
				accessoryType = "Body";
			}
			
			if (accessoryFolder.getPath().replace("\\", "/")
					.equals("src/main/resources/static/images/Avatar/Accessory/Clothes")
					) {
				accessoryType = "Clothes";
			}
			
			if (accessoryFolder.getPath().replace("\\", "/")
					.equals("src/main/resources/static/images/Avatar/Accessory/Hat")
					) {
				accessoryType = "Hat";
			}
			
			for(File files : accessoryFolder.listFiles()) {
				
				// 產生 document factory、builder
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = null;
				
				for (File file : files.listFiles()) {
					
					// 取資料夾名稱(對應體型)
					System.out.println(files.getName()); 
					
					// 取對應體型
					BodyType bodyType = bodyTypeService.findByName(files.getName()); 
					
					//新建存取物件
					AvatarBody avatarBody = new AvatarBody();
					AvatarClothes avatarClothes = new AvatarClothes();
					AvatarHat avatarHat = new AvatarHat();
					
					// set Body
					if (accessoryType.equals("Body")) {
						// 設定體型
						avatarBody.setBodyType(bodyType);
						
						// 設定名稱
						avatarBody.setName(file.getName());
						
						// 設定顏色
						avatarBody.setColor(file.getName().split("[_.]")[1]);
					}
					// set Clothes
					if (accessoryType.equals("Clothes")) {
						// 設定體型
						avatarClothes.setBodyType(bodyType);
						
						// 設定名稱
						avatarClothes.setName(file.getName().split("[_.]")[0]);
					}
					// set Hat
					if (accessoryType.equals("Hat")) {
						// 設定體型
						avatarHat.setBodyType(bodyType);
						
						// 設定名稱
						avatarHat.setName(file.getName().split("[_.]")[0]);
						
					}
					
					try (FileInputStream svgInputStream = new FileInputStream(file);) {
			
						builder = factory.newDocumentBuilder();
						Document document = builder.parse(file);
			
						// XPath = XML
						XPathFactory xpf = XPathFactory.newInstance();
						XPath xpath = xpf.newXPath();
						
						// 找 class
						String xpathExpression = "//path/@class";
						
						// for Class
						XPathExpression expression = xpath.compile(xpathExpression);
			
						// Class NodeList
						NodeList svgPathClass = 
								(NodeList) expression.evaluate(document, XPathConstants.NODESET);
			
			//			System.out.println(svgPathClass.item(0).getNodeValue());
			
						// 找 d
						String xpathExpression2 = "//path/@d";
			
						// XPath = XML
						// for Class
						XPathExpression expression2 = xpath.compile(xpathExpression2);
			
						// d NodeList
						NodeList svgPathD = 
								(NodeList) expression2.evaluate(document, XPathConstants.NODESET);
						
			//			System.out.println(svgPathD.item(0).getNodeValue());
						
						// 給陣列長度
						accessory = new String[svgPathD.getLength()][2];
						
						for(int i = 0 ; i < accessory.length ; i++) {
							for (int j = 0; j < 2; j++) {
								// 給class
								if (j == 0) {
									
									if (svgPathClass.item(i) == null) {
										accessory[i][j] = "noClass";
									}else {
										accessory[i][j] = svgPathClass.item(i).getNodeValue();																
									}
									
								}
								// 給path
								if (j == 1) {
									accessory[i][j] = svgPathD.item(i).getNodeValue();						
								}
							}
						}
						
						System.out.println(Arrays.deepToString(accessory));
						
						// insert Accessory to sql
						
						// 存入path_label
						String context = "";
						
						for(int i = 0 ; i < accessory.length ; i++) {
							for (int j = 0; j < 2; j++) {
								// context (% 分隔號)
								context += accessory[i][j] + "%" ;
							}
							context += "\r\n" ;
						}
						
						// 存Body
						if (accessoryType.equals("Body")) {
							avatarBody.setPathLabel(context);
							avatarBodyRepo.save(avatarBody);
						}
						// 存Clothes
						if (accessoryType.equals("Clothes")) {
							avatarClothes.setPathLabel(context);
							avatarClothesRepo.save(avatarClothes);
						}
						// 存Hat
						if (accessoryType.equals("Hat")) {
							avatarHat.setPathLabel(context);
							avatarHatRepo.save(avatarHat);
						}
						
						System.out.println("建立成功");
					} catch (Exception e) {
						System.out.println("建立失敗");
						e.printStackTrace();
					}
				}
			}
		
		}
		return "Test";

	}

}
