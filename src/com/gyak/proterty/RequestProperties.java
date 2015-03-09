package com.gyak.proterty;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/** 
 * <p><B>����:</B>��ȡ���ò���
 * @author ���� E-mail:guiyanakuang@gmail.com 
 * @version ����ʱ�䣺2014��8��17�� ����9:13:21 
 *
 */

public class RequestProperties {
	
	private static class PropertiesHondle{
		private final static RequestProperties instance = new RequestProperties();
	}
	
	public final static RequestProperties getInstance(){
		return PropertiesHondle.instance;
	}
	
	private Properties properties;
	
	/**
	 * ʵ����MyProperties
	 */
	private RequestProperties(){}
	
	public void initProperties(InputStream is){
		properties = new Properties();
        try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			System.err.println("���ز����ļ�ʧ��");
		}
	}
	
	public Properties getProperties() throws NotInitRequestProperties {
		if(this.properties == null)
			throw new NotInitRequestProperties();
		return this.properties;
	}
	
	/**
	 * ��ȡ���ò���
	 * @param key ������
	 * @return ����ֵ
	 */
	public String getValue(String key){
		return properties.getProperty(key);
	}
	
	
}
