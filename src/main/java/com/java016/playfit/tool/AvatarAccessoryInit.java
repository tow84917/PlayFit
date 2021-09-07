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

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class AvatarAccessoryInit {

	public static void main(String[] args) {

		String[][] accessory = null;

//		讀所有檔案
		File folder = new File("src/main/resources/static/images/Avatar/Accessory");
//		System.out.println(folder.listFiles().length);
		
		// 產生 document factory、builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		
		for (File file : folder.listFiles()) {
			
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
				accessory = new String[svgPathClass.getLength()][2];
				
				for(int i = 0 ; i < accessory.length ; i++) {
					for (int j = 0; j < 2; j++) {
						// 給class
						if (j == 0) {
							accessory[i][j] = svgPathClass.item(i).getNodeValue();						
						}
						// 給path
						if (j == 1) {
							accessory[i][j] = svgPathD.item(i).getNodeValue();						
						}
					}
				}
				
				System.out.println(Arrays.deepToString(accessory));
				
				// insert Accessory to sql(之後寫)
				
				
				System.out.println("建立成功");
			} catch (Exception e) {
				System.out.println("建立失敗");
				e.printStackTrace();
			}
		}

	}

}
