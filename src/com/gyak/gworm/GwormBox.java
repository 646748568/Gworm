package com.gyak.gworm;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import com.gyak.proterty.NotInitRequestProperties;

public class GwormBox {

	private static class GwormBoxHondle {
		private final static GwormBox instance = new GwormBox();
	}
	
	public static final GwormBox getInstance() {
		return GwormBoxHondle.instance;
	}
	
	private HashMap<String, Gworm> gwormMap = new HashMap<String, Gworm>();
	
	/**
	 * ���Gworm����
	 * @param path �����ļ�·��
	 * @param name ������
	 */
	public void addGworm(String path, String name) {
		try {
			Gworm gworm = new GwormFactory(path).getInstance();
			gwormMap.put(name, gworm);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���Gworm����
	 * @param in �����ļ�������
	 * @param name ������
	 */
	public void addGworm(InputStream in, String name) {
		Gworm gworm = new GwormFactory(in).getInstance();
		gwormMap.put(name, gworm);
	}
	
	public String getJson(String name, String url, String urlId) throws NotFindGwormConfigException, NotInitRequestProperties {
		Gworm gworm = gwormMap.get(name);
		if(gworm == null) {
			throw new NotFindGwormConfigException();
		}
		else {
			return gworm.getJson(url, urlId);
		}
	}
	
	public String getJson(String name, String url, String urlId, String jsonId) throws NotFindGwormConfigException, NotInitRequestProperties {
		Gworm gworm = gwormMap.get(name);
		if(gworm == null) {
			throw new NotFindGwormConfigException();
		}
		else {
			return gworm.getJson(url, urlId, jsonId);
		}
	}
	
	
}
