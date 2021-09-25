package com.java016.playfit.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import javax.transaction.Transactional;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.svg2svg.SVGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import com.java016.playfit.dao.AvatarBodyRepository;
import com.java016.playfit.dao.AvatarClothesRepository;
import com.java016.playfit.dao.AvatarHatRepository;
import com.java016.playfit.dao.AvatarRepository;
import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.AvatarBody;
import com.java016.playfit.model.AvatarClothes;
import com.java016.playfit.model.AvatarHat;
import com.java016.playfit.model.BodyType;
import com.java016.playfit.service.AvatarService;

@Service
public class AvatarServiceImpl implements AvatarService {

	@Autowired
	AvatarRepository avatarRepo;

	@Autowired
	AvatarBodyRepository avatarBodyRepo;

	@Autowired
	AvatarHatRepository avatarHatRepo;

	@Autowired
	AvatarClothesRepository avatarClothesRepo;
	
	/**
	 * 依 Id 找 Avatar
	 */
	@Override
	public Avatar getAvatarById(Integer id) {
		return avatarRepo.getById(id);
	}
	
	/**
	 * 儲存 Avatar 
	 */
	@Transactional
	@Override
	public Avatar saveAvatar(Avatar avatar) {
		return avatarRepo.save(avatar);
	}
	
	/**
	 * 找 Avatar Body
	 */
	@Override
	public AvatarBody getAvatarBody(String color, BodyType type) {
		return avatarBodyRepo.findByColorAndType(color, type.getId());
	}
	
	/**
	 * 找 Avatar Hat
	 */
	@Override
	public AvatarHat getAvatarHat(BodyType type, String name) {
		return avatarHatRepo.findByNameAndType(name, type.getId());
	}
	
	/**
	 * 找 Avatar Clothes
	 */
	@Override
	public AvatarClothes getAvatarClothes(BodyType type, String name) {
		return avatarClothesRepo.findByNameAndType(name, type.getId());
	}
	
	/**
	 * 更新Avatar 配件資料
	 */
	@Override
	@Transactional
	public void updateAvatarAccessory(Avatar userAvatar, 
			BodyType bodyType, String color, 
			String clothesName, String hatName) {
		
		// 更新AvatarBody
		AvatarBody avatarBody = 
				avatarBodyRepo.findByColorAndType(color, bodyType.getId());
		userAvatar.setAvatarBody(avatarBody);
		
		// 更新AatarHat
		if (hatName != null) {
			AvatarHat avatarHat = 
					avatarHatRepo.findByNameAndType(hatName, bodyType.getId());
			userAvatar.setAvatarHat(avatarHat);
		}
		
		// 更新AatarClothes
		if (clothesName != null) {
			AvatarClothes avatarClothes = 
					avatarClothesRepo.findByNameAndType(clothesName, bodyType.getId());
			userAvatar.setAvatarClothes(avatarClothes);
		}
		
		// 更新Aatar
		avatarRepo.save(userAvatar);
	}
	
	/**
	 * 儲存 Avatar "圖片"
	 */
	@Override
	public void saveAvatarPic(BodyType bodyType, String color, 
			String clothesName, String hatName, String saveFileName) {

		// 取基本設定檔
		File fileInput = 
				new File("src/main/resources/static/images/Avatar/AvatarXML_bassic.svg");
		
		try (
				FileInputStream svgInputStream = new FileInputStream(fileInput)
			) {

			// 建立SVG Document
			SVGDocument doc = 
					new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName())
					.createSVGDocument("", svgInputStream);
			
			//--------------------------------------------
			// 身體
			AvatarBody avatarBody = 
					avatarBodyRepo.findByColorAndType(color, bodyType.getId());
			
			// 身體 總標籤
			String[] bodyPath = avatarBody.getPathLabel().split("\n");
			String [][] avatarBodyLabel = new String[bodyPath.length][2] ;
			
			for (int i = 0; i < bodyPath.length; i++) {
				
				String st = bodyPath[i].split("%")[0];
				String d = bodyPath[i].split("%")[1];
				
				avatarBodyLabel[i][0] = st;
				avatarBodyLabel[i][1] = d;
			}
//			System.out.println(Arrays.deepToString(avatarBodyLabel));
			
			// 存身體的標籤
			Element plainAvatar = doc.getElementById("plainAvatar");
			
			// 創造標籤
			for (int i = 0; i < avatarBodyLabel.length; i++) {
				
				Element path = 
						doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "path");
				
				for (int j = 0; j < 2; j++) {
					// 存class (st)
					if (j == 0) {
						// noClass 沒有st
						if (!avatarBodyLabel[i][j].equalsIgnoreCase("noClass")) {
							path.setAttribute("class", avatarBodyLabel[i][j]);
						}
					}
					// 存 d ("M85.1,11.4c0,0-5.2-3.7-.........)
					if (j == 1) {
						path.setAttribute("d", avatarBodyLabel[i][j]);						
					}
				}
				
				// 依序加入身體標籤
				plainAvatar.appendChild(path);
				
			
			}
			
			//--------------------------------------------
			if (hatName != null) {
				// 帽子
				AvatarHat avatarHat = 
						avatarHatRepo.findByNameAndType(hatName, bodyType.getId());
				
				// 帽子 總標籤
				String[] hatPath = avatarHat.getPathLabel().split("\n");
				String [][] avatarHatLabel = new String[hatPath.length][2] ;
				
				for (int i = 0; i < hatPath.length; i++) {
					
					String st = hatPath[i].split("%")[0];
					String d = hatPath[i].split("%")[1];
					
					avatarHatLabel[i][0] = st;
					avatarHatLabel[i][1] = d;
				}
				
//			System.out.println(Arrays.deepToString(avatarHatLabel));
				
				// 存帽子的標籤
				Element hat = doc.getElementById("hat");
				
				// 創造標籤
				for (int i = 0; i < avatarHatLabel.length; i++) {
					
					Element path = 
							doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "path");
					
					for (int j = 0; j < 2; j++) {
						// 存class (st)
						if (j == 0) {
							// noClass 沒有st
							if (!avatarHatLabel[i][j].equalsIgnoreCase("noClass")) {
								path.setAttribute("class", avatarHatLabel[i][j]);
							}
						}
						// 存 d ("M85.1,11.4c0,0-5.2-3.7-.........)
						if (j == 1) {
							path.setAttribute("d", avatarHatLabel[i][j]);						
						}
					}
					
					// 依序加入帽子標籤
					hat.appendChild(path);
					
				}
			}
			
			//--------------------------------------------
			if (clothesName != null) {
				// 衣服配件
				AvatarClothes avatarClothes = 
						avatarClothesRepo.findByNameAndType(clothesName, bodyType.getId());
				
				// 衣服配件 總標籤
				String[] clothesPath = avatarClothes.getPathLabel().split("\n");
				String [][] avatarClothesLabel = new String[clothesPath.length][2] ;
				
				for (int i = 0; i < clothesPath.length; i++) {
					
					String st = clothesPath[i].split("%")[0];
					String d = clothesPath[i].split("%")[1];
					
					avatarClothesLabel[i][0] = st;
					avatarClothesLabel[i][1] = d;
				}
				
//			System.out.println(Arrays.deepToString(avatarClothesLabel));
				
				// 存衣服配件的標籤
				Element body = doc.getElementById("body");
				
				// 創造標籤
				for (int i = 0; i < avatarClothesLabel.length; i++) {
					
					Element path = 
							doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "path");
					
					for (int j = 0; j < 2; j++) {
						// 存class (st)
						if (j == 0) {
							// noClass 沒有st
							if (!avatarClothesLabel[i][j].equalsIgnoreCase("noClass")) {
								path.setAttribute("class", avatarClothesLabel[i][j]);
							}
						}
						// 存 d ("M85.1,11.4c0,0-5.2-3.7-.........)
						if (j == 1) {
							path.setAttribute("d", avatarClothesLabel[i][j]);						
						}
					}
					
					// 依序加入衣服配件標籤
					body.appendChild(path);
					
					
				}
			}
			
			// 存取路徑
			String path = "src/main/resources/static/images/Avatar/"; 
			File fileOutput = new File(path + saveFileName + ".svg");
			
			TranscoderInput input = new TranscoderInput(doc);
			outputSvg(input, fileOutput);
			
			System.out.println("建立成功");
		} catch (Exception e) {
			System.out.println("建立失敗");
			e.printStackTrace();
		}

	}

	// Output as SVG
	public void outputSvg(TranscoderInput input, File outFile)  {
		
		SVGTranscoder t = new SVGTranscoder();
		
		try (OutputStream os = new FileOutputStream(outFile)) {
			
			OutputStreamWriter writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
			TranscoderOutput output = new TranscoderOutput(writer);
			t.transcode(input, output);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}












