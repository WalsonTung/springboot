package com.zhengzhaoxi.webdemo.core;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
	
	private static SeleniumHelper instance = new SeleniumHelper();

	public static SeleniumHelper getInstance() {
		return instance;
	}
	
	private WebDriver mDriver; 
	
	private SeleniumHelper() {}
	
	public  SeleniumHelper initChromeDriver(boolean visible) {

        //设置谷歌浏览器驱动，我放在项目的路径下，这个驱动可以帮你打开本地的谷歌浏览器
        System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\Network\\selenium\\chromedriver_win32_v74\\chromedriver.exe");

        // 设置对谷歌浏览器的初始配置           开始
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        //设置禁止图片
        //prefs.put("profile.managed_default_content_settings.images", 2);
        //设置禁止cookies
        //prefs.put("profile.default_content_settings.cookies", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--start-maximized");//页面最大化
        if(!visible) {
        	options.addArguments("--headless");//不提供可视化页面
        }
        options.addArguments("--disable-gpu");//谷歌文档提到需要加上这个属性来规避bug
        
        // 设置对谷歌浏览器的初始配置           结束

        //新建一个谷歌浏览器对象（driver）
        ChromeDriver driver = new ChromeDriver(options);
        if(!visible) {
        	driver.manage().window().setSize(new Dimension(1024,1024));
        }
        mDriver = driver;
        return this;
    }
	
	public SeleniumHelper initFirefoxDriver() {
		//设置谷歌浏览器驱动，我放在项目的路径下，这个驱动可以帮你打开本地的谷歌浏览器
        System.setProperty("webdriver.gecko.driver", "F:\\Softwares\\Network\\selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        mDriver = new FirefoxDriver(options);
        return this;
	}
	
	public SeleniumHelper get(String url) {
		mDriver.get(url);
		return this;
	}
	
	public SeleniumHelper click(By by) {
		sleep(2);
		WebDriverWait wait = new WebDriverWait(mDriver, 60);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		element.click();

		return this;
	}
	
	public SeleniumHelper doubleClick(By by) {
		sleep(2);
		WebDriverWait wait = new WebDriverWait(mDriver, 60);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		new Actions(mDriver).doubleClick(element).perform();
		return this;
	}
	
	public SeleniumHelper clear(By by) {
		WebDriverWait wait = new WebDriverWait(mDriver, 60);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		element.clear();
		return this;
	}
	
	public SeleniumHelper setTextValue(By by,String value) {
		sleep(1);
		WebDriverWait wait = new WebDriverWait(mDriver, 60);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		element.sendKeys(value);
		return this;
	}
	
	public SeleniumHelper setTextValue(By by,String value,boolean clearFirst) {
		sleep(1);
		WebDriverWait wait = new WebDriverWait(mDriver, 60);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		if(clearFirst) {
			element.clear();
		}
		element.sendKeys(value);
		return this;
	}
	
	public SeleniumHelper waitToShow(By by) {
		WebDriverWait wait = new WebDriverWait(mDriver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
		return this;
	}
	
	public SeleniumHelper switchToFrame(By by) {
		WebDriverWait wait = new WebDriverWait(mDriver, 60);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		mDriver.switchTo().frame(element);
		return this;
	}
	
	public SeleniumHelper switchToParentFrame() {
		mDriver.switchTo().parentFrame();
		return this;
	}
	
	public SeleniumHelper switchToDefaultContent() {
		mDriver.switchTo().defaultContent();
		return this;
	}
	
	public SeleniumHelper scrollTo(int polition) {
		String js=String.format("window.scrollBy(0, %d)",polition);
		((JavascriptExecutor) mDriver).executeScript(js);
		return this;
	}
	
	public SeleniumHelper scrollTo(By by) {
		sleep(1);
		WebElement el =  mDriver.findElement(by);
		((JavascriptExecutor) mDriver).executeScript("arguments[0].scrollIntoView();",el);
		return this;
	}
	
	public List<WebElement> getElements(By by) {
		sleep(1);
		return mDriver.findElements(by);
	}
	
	public String getText(By by) {
		sleep(1);
		WebDriverWait wait = new WebDriverWait(mDriver, 60);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
		return element.getText();
	}
	
	public boolean hasElements(By by) {
		List<WebElement> list = mDriver.findElements(by);
		
		return list.size() > 0;
	}
	
	public SeleniumHelper close() {
		mDriver.close();
		return this;
	}
	
	/**
	 * 关闭浏览器
	 */
	public void quit() {
		mDriver.quit();
	}
	
	private static void sleep(long seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
