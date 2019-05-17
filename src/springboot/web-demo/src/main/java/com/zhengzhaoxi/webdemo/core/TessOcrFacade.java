package com.zhengzhaoxi.webdemo.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

public class TessOcrFacade {
	private ITesseract mTesseract = new Tesseract();
	
	public TessOcrFacade() {
		//String tessdata = FileUtils.getLocalResourcePath("tessdata");
		String tessdata = "D:\\nongTest\\tessdata";
		mTesseract.setDatapath(tessdata);
	}
	
	public TessOcrFacade useEngish() {
		mTesseract.setLanguage("eng");
		return this;
	}
	
	public TessOcrFacade useChinese() {
		mTesseract.setLanguage("ch-sim");
		return this;
	}
	
	public String doOcr(InputStream in) throws IOException, TesseractException {
		BufferedImage image = ImageIO.read(in);
		return mTesseract.doOCR(image);
	}
	
	public String doOcr(URL url) throws IOException, TesseractException {
		BufferedImage image = ImageIO.read(url);
		image = ImageHelper.convertImageToGrayscale(image);
		return mTesseract.doOCR(image);
	}
	
	public String doOcr(File imageFile) throws TesseractException, IOException {
		String result = "";
		if(imageFile.exists()) {
			BufferedImage image = ImageIO.read(imageFile);
			image = ImageHelper.convertImageToGrayscale(image);
			result = mTesseract.doOCR(image);
		}
        
		return result;
	}
}
