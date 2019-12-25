package com.webmeng.simulator.client.util;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpClientUtil {
	public static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

	public static String post(String url, Map<String, String> paramMap, int timeout) {
		HttpClientBuilder.create();
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
		post.setConfig(config);

		try {
			if (paramMap != null) {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				for (Entry<String, String> entity : paramMap.entrySet()) {
					NameValuePair nameValuePair = new BasicNameValuePair(entity.getKey(), entity.getValue());
					params.add(nameValuePair);
				}

				UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(params, "UTF-8");
				post.setEntity(postEntity);
			}

			HttpResponse response = client.execute(post);
			return IOUtils.toString(response.getEntity().getContent(), "utf-8");
		} catch (Exception e) {
             System.out.println(e.getMessage());
		} finally {
			try {
				client.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	public static String get(String url, Map<String, String> paramMap, int timeout) {
		HttpClientBuilder.create();
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);

		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
		get.setConfig(config);

		try {
			HttpResponse response = client.execute(get);
			return IOUtils.toString(response.getEntity().getContent(), "gbk");
		} catch (Exception e) {

		} finally {
			try {
				client.close();
			} catch (IOException e) {
			}
		}
		return null;
	}
	
	public static void getImage(String url,File file) {
		HttpClientBuilder.create();
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);

		RequestConfig config = RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(60000).build();
		get.setConfig(config);

		try {
			HttpResponse response = client.execute(get);
			FileOutputStream out=new FileOutputStream(file);
			InputStream in=response.getEntity().getContent();
			byte[] buff=new byte[1024];
			int len=0;
			while((len=in.read(buff))!=-1){
				out.write(buff, 0, len);
			}
			out.flush();
			out.close();
			
		} catch (Exception e) {

		} finally {
			try {
				client.close();
			} catch (IOException e) {
			}
		}
	}
	

	public static String postByGzip(String url, String result, int timeout) throws Exception {
		HttpClientBuilder.create();
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		HttpHost proxy = new HttpHost("10.10.20.4", 8888);
		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
		post.setConfig(config);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(result.getBytes("UTF-8"));
		gzip.close();

		try {
			ByteArrayEntity entity = new ByteArrayEntity(out.toByteArray(), ContentType.APPLICATION_JSON);
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			return IOUtils.toString(response.getEntity().getContent(), "utf-8");
		} catch (Exception e) {

		} finally {
			try {
				client.close();
			} catch (IOException e) {
			}
		}
		return null;
	}
	
	public static void main(String args[]) throws Exception{
        String url="http://localhost:8800/qy/acceptSdkFileReq";
        int timeout=3000;
 		CloseableHttpClient client = HttpClientBuilder.create().build();
 		HttpPost post = new HttpPost(url);

 		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
 		post.setConfig(config);
 		
 		
 		File file=new File("E:\\test\\build.prop");
 		FileInputStream in=new FileInputStream(file);
 		byte[] fileData=new byte[in.available()];
 		in.read(fileData);
 		in.close();
 		String fileContent=Base64.encodeBase64String(fileData);
 		
 		System.out.println(fileContent);
 		
 		MultipartEntityBuilder reqEntity = MultipartEntityBuilder.create();
 		reqEntity.addTextBody("md5", "11111111");
 		reqEntity.addTextBody("uuid", "1111111111111");
 		reqEntity.addTextBody("file",fileContent );
 		reqEntity.addTextBody("filename",file.getName());
 		
 		GzipDecompressingEntity entity=new GzipDecompressingEntity(reqEntity.build());
 		
 		post.setEntity(entity);
 		try {
 			HttpResponse response = client.execute(post);
 			System.out.println(IOUtils.toString(response.getEntity().getContent(), "utf-8"));
 		} catch (Exception e) {

 		} finally {
 			try {
 				client.close();
 			} catch (IOException e) {
 			}
 		}
	}

}
