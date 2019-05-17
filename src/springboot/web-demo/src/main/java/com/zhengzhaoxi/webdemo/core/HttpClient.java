package com.zhengzhaoxi.webdemo.core;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

public final class HttpClient {
	
	private String mEncoding="utf-8";
	private HttpURLConnection httpUrlConn;
	
	private HttpClient() {
		CookieManager manager = new CookieManager();
	    CookieHandler.setDefault(manager);
	}
	
	public static HttpClient newInstance() {
		return new HttpClient();
	}
	
	public static void setWebProxy(boolean hasProxy) {
		setWebProxy(hasProxy, "10.74.46.23", "8080");
	}
	
	public static void setWebProxy(boolean hasProxy,String host,String port){
		if(hasProxy){
			System.getProperties().put("proxySet", "true");
			System.getProperties().put("proxyHost", host);
			System.getProperties().put("proxyPort", port);
		}else{
			System.getProperties().put("proxySet", "false");
			System.getProperties().put("proxyHost", "");
			System.getProperties().put("proxyPort", "");
		}
	}
	
	public HttpClient setEncoding(String encoding) {
		mEncoding = encoding;
		return this;
	}
	
	public HttpClient createRequest(String requestUrl) throws IOException, GeneralSecurityException {
		URL url = new URL(requestUrl);
		httpUrlConn = (HttpURLConnection) url.openConnection();
		if(requestUrl.startsWith("https://")) {
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			HttpsURLConnection httpsConn = (HttpsURLConnection)httpUrlConn;
			httpsConn.setSSLSocketFactory(ssf);
		}
		httpUrlConn.setDoOutput(true);
		httpUrlConn.setDoInput(true);
		httpUrlConn.setUseCaches(false); 
		
		httpUrlConn.setRequestProperty("Connection", "Keep-Alive");
		httpUrlConn.setRequestProperty("Charset", "UTF-8");
		httpUrlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");
		httpUrlConn.setConnectTimeout(30000);
		httpUrlConn.setReadTimeout(30000);
		
		return this;
	}
	
	public HttpClient setHeader(String key,String value) throws Exception {
		if(httpUrlConn == null) {
			throw new Exception("请先创建Request.");
		}
		
		httpUrlConn.addRequestProperty(key, value);
		
		return this;
	}
	
	public HttpClient setUseRandomIp(boolean useRandomIp) throws Exception {
		if(httpUrlConn == null) {
			throw new Exception("请先创建Request.");
		}
		
		httpUrlConn.setRequestProperty("x-forwarded-for", getRandomIp());
		
		return this;
	}
	
	public String get() throws IOException, Exception {
		if(httpUrlConn == null) {
			throw new Exception("请先创建Request.");
		}
		
		httpUrlConn.setRequestMethod("GET");
		
		return requestData(null);
	}
	
	public String post(HashMap<String,String> formData) throws Exception, IOException {
		if(httpUrlConn == null) {
			throw new Exception("请先创建Request.");
		}
        httpUrlConn.setRequestMethod("POST");
        httpUrlConn.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
		String requestData = getQueryString(formData);
		
		return requestData(requestData);
	}
	
	public String postJson(Object data) throws Exception, IOException {
		if(httpUrlConn == null) {
			throw new Exception("请先创建Request.");
		}
        httpUrlConn.setRequestMethod("POST");
        httpUrlConn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        String args = null;
		if(data instanceof String) {
			args = (String)data;
		}else {
			args = JsonUtils.toJson(data);
		}
		
		return requestData(args);
	}	
	
	public String postXml(String xmlData) throws Exception {
		if(httpUrlConn == null) {
			throw new Exception("请先创建Request.");
		}
        httpUrlConn.setRequestMethod("POST");
        httpUrlConn.setRequestProperty("Content-Type","text/xml; charset=UTF-8");
        String args = xmlData;
		
		return requestData(args);
	}
	
	public void loadData(final String data,final OutputStream out) throws IOException {
		httpUrlConn.connect();
		if (null != data) {
			OutputStream outputStream = null;
			try {
				outputStream = httpUrlConn.getOutputStream();
				outputStream.write(data.getBytes(mEncoding));
			}catch (Exception e) {
				httpUrlConn.disconnect();
				httpUrlConn = null;
				throw e;
			}
			finally {
				if(null != outputStream) {
					outputStream.close();
					outputStream = null;
				}
			}
		}
		InputStream inputStream = null;
		try {
			inputStream = httpUrlConn.getInputStream();
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=inputStream.read(buffer)) != -1){
				out.write(buffer, 0, length);
			}
		} finally {
			if(null != inputStream) {
				inputStream.close();
				inputStream = null;
			}
			httpUrlConn.disconnect();
			httpUrlConn = null;
		}
	}
	
	private String requestData(String data) throws IOException {
		ByteArrayOutputStream byteOutput= new ByteArrayOutputStream();
		loadData(data,byteOutput);
		return byteOutput.toString(mEncoding);
	}
	
	private String getQueryString(HashMap<String,String>formData){
    	if(formData==null||formData.size()==0){
    		return "";
    	}
    	int i=0;
    	Entry<String, String> next=null;
    	StringBuilder sb=new StringBuilder();
    	Iterator<Entry<String, String>> iter = formData.entrySet().iterator();  
    	while(iter.hasNext()){
    		i++;
    		next=iter.next();
    		sb.append(MessageFormat.format("{0}={1}", next.getKey(),next.getValue()));
    		if(i<formData.size()){
    			sb.append("&");
    		}
    	}
    	return sb.toString();
    }
	
	
	private  String getRandomIp(){
        int[][] range = {{607649792,608174079},//36.56.0.0-36.63.255.255
                         {1038614528,1039007743},//61.232.0.0-61.237.255.255
                         {1783627776,1784676351},//106.80.0.0-106.95.255.255
                         {2035023872,2035154943},//121.76.0.0-121.77.255.255
                         {2078801920,2079064063},//123.232.0.0-123.235.255.255
                         {-1950089216,-1948778497},//139.196.0.0-139.215.255.255
                         {-1425539072,-1425014785},//171.8.0.0-171.15.255.255
                         {-1236271104,-1235419137},//182.80.0.0-182.92.255.255
                         {-770113536,-768606209},//210.25.0.0-210.47.255.255
                         {-569376768,-564133889}, //222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0]+new Random().nextInt(range[index][1]-range[index][0]));
        return ip;
    }
	
	private String num2ip(int ip) {
        int [] b=new int[4] ;
        String x = "";

        b[0] = (int)((ip >> 24) & 0xff);
        b[1] = (int)((ip >> 16) & 0xff);
        b[2] = (int)((ip >> 8) & 0xff);
        b[3] = (int)(ip & 0xff);
        x=Integer.toString(b[0])+"."+Integer.toString(b[1])+"."+Integer.toString(b[2])+"."+Integer.toString(b[3]); 

        return x; 
     }
	
	public  String formUpload(Map<String, String> textMap, Map<String, String> fileMap) throws Exception {

		String result = "";
		String BOUNDARY = "----------" + System.currentTimeMillis(); //boundary就是request头和上传文件内容的分隔符  
		httpUrlConn.setRequestMethod("POST");
		httpUrlConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
		
		
		StringBuffer textBuffer = new StringBuffer();
		if (textMap != null) {
			for(Map.Entry<String, String> item : textMap.entrySet()) {
				textBuffer.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
				textBuffer.append("Content-Disposition: form-data; name=\"" + item.getKey() + "\"\r\n\r\n");
				textBuffer.append(item.getValue());
			}
		}
		OutputStream out = null;
		try {
			out = new DataOutputStream(httpUrlConn.getOutputStream());
			// 文本参数
			if (textBuffer.length() > 0) {
				out.write(textBuffer.toString().getBytes(mEncoding));
			}
 
			// 文件参数
			if (fileMap != null) {
				for(Map.Entry<String, String> item : fileMap.entrySet()) {
					if(item.getValue() == null) {
						continue;
					}
					File file = new File(item.getValue());
					String filename = file.getName();
					MagicMatch match = Magic.getMagicMatch(file, false, true);
					String contentType = match.getMimeType();
 
					StringBuffer fileBuffer = new StringBuffer();
					fileBuffer.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
					fileBuffer.append("Content-Disposition: form-data; name=\"" + item.getKey() + "\"; filename=\"" + filename + "\"\r\n");
					fileBuffer.append("Content-Type:" + contentType + "\r\n\r\n");
					out.write(fileBuffer.toString().getBytes(mEncoding));
 
					DataInputStream in = new DataInputStream(new FileInputStream(file));
					int bytes = 0;
					byte[] bufferOut = new byte[1024];
					while ((bytes = in.read(bufferOut)) != -1) {
						out.write(bufferOut, 0, bytes);
					}
					in.close();
				}
			}
 
			byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes(mEncoding);
			out.write(endData);
			out.flush();
 
			// 读取返回数据  
			StringBuffer resultBuffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				resultBuffer.append(line).append("\n");
			}
			result = resultBuffer.toString();
			reader.close();
			reader = null;
		} finally {
			if(null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (httpUrlConn != null) {
				httpUrlConn.disconnect();
				httpUrlConn = null;
			}
		}
		return result;
	}
	

}

