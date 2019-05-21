package com.zhengzhaoxi.webdemo;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.zhengzhaoxi.webdemo.core.HttpClient;
import com.zhengzhaoxi.webdemo.core.TessOcrFacade;

import net.sourceforge.tess4j.TesseractException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NongCoreSystemCrawlingTest {
	
	private final String dataUrl = "http://10.190.48.150:7001/dorado/view-service";

	
	public void testLogin()   {
		HttpClient client = HttpClient.newInstance();
		try {
			client.createRequest("http://10.190.48.150:7001/systemUse.do?branchCode=5020100&employeeCode=3116&mac=")
			.get();
			String xmlData = "<batch>\r\n" + 
					"<request type=\"json\"><![CDATA[{\"action\":\"load-data\",\"dataProvider\":\"claimFolderQueryController#findClaimFolderQuery\",\"supportsEntity\":true,\"parameter\":{\"accidentTimeFromStart\":\"2019-04-15T00:00:00Z\",\"accidentTimeFromEnd\":\"2019-05-15T00:00:00Z\",\"reportNo\":\"DSHZ94594619050058\",\"$dataType\":\"v:notification.view.ClaimFolderQuery$ClaimFolderQueryCondition\"},\"resultDataType\":\"v:notification.view.ClaimFolderQuery$[ClaimFolderQueryResult]\",\"pageSize\":15,\"pageNo\":1,\"context\":{},\"loadedDataTypes\":[\"ClaimFolderQueryCondition\",\"ClaimFolderQueryResult\"]}]]></request>\r\n" + 
					"</batch>";
			String result =  client.createRequest(dataUrl).postXml(xmlData);
			System.out.print(result);
			Assert.assertTrue(true);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	public void testOrc() throws TesseractException, IOException {
		TessOcrFacade tessOcr = new TessOcrFacade().useEngish();
		Pattern pattern = Pattern.compile("[A-Za-z0-9]+");
		File dir = new File("D:\\nongTest\\checkCode");
		if(dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			String result = null;
			for(File file : files) {
				result =  tessOcr.doOcr(file);
				System.out.println(String.format("%s文件内容%s", file.getName(), result));
			}
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void testHtmlUnit() {

		
	}
}
