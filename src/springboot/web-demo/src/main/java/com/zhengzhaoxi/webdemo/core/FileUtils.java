package com.zhengzhaoxi.webdemo.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class FileUtils {

	public static String getLocalResourcePath(String filePath){
		String url = FileUtils.class.getClassLoader().getResource("").getPath();
		File file = new File(url);
		String rootPath = file.getParentFile().getParent();
		return FileUtils.combinePath(rootPath, "resources",filePath);
	}
	
	public static String combinePath(String root,String ...filePath ){
		
		String result = root.replace('\\', '/');	
		for (String item : filePath) {
			item = item.replace('\\', '/');
			result = result.endsWith("/")?result:result+"/";
			result+= (item.startsWith("/")?item.substring(1):item);
		}
		return result;
	}
	
	public static boolean downloadImage(URL url,final File localPath) throws IOException {
		BufferedImage image = ImageIO.read(url);
		return ImageIO.write(image, "JPEG", localPath);
	}
}
