package com.zhengzhaoxi.webdemo;

import java.io.IOException;

import org.junit.Assert;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitTest {

	private void login() {
		WebClient client = new WebClient(BrowserVersion.CHROME);
		try {
			HtmlPage page = client.getPage("http://10.190.48.150:7001/systemUse.do?branchCode=5020100&employeeCode=3116&mac=");
			System.out.print(page.asText());
			client.close();
			Assert.assertTrue(true);
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
