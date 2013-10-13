package com.yichou.common.sdk;

import java.util.Map;

import android.content.Context;

/**
 * 
 * SDK 接口封装类
 * 
 * @author Yichou
 * 
 */
public final class SdkUtils {
	public static ISdk getImpl() {
		return gDefault.get();
	}
	
	public static String getOnlineString(Context context, String name) {
		String adsString = getImpl().getOnlineParam(context, name);

		if (adsString == null || adsString.length() == 0
				|| adsString.equals("null")) {
			return null;
		}

		return adsString;
	}

	public static int getOnlineInt(Context context, String name, int def) {
		try {
			return Integer.parseInt(getImpl().getOnlineParam(context, name));
		} catch (Exception e) {
		}

		return def;
	}

	private static final Singleton<ISdk> gDefault = new Singleton<ISdk>() {

		@Override
		protected ISdk create() {
			return new UmengSdkImpl();
		}
	};
}

class SdkProxy implements ISdk {

	@Override
	public void setUpdateWifiOnly(boolean wifiOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCheckUpdateCallback(CheckUpdateCallback cb) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateDownloadCallback(DownloadCallback cb) {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkUpdate(Context context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOnlineParams(Context context) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getOnlineParam(Context context, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendEvent(Context context, String id, String data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendEvent(Context context, Map<String, String> events) {
		// TODO Auto-generated method stub

	}

	@Override
	public void entryScene(Context context, String sceneName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitScene(Context context, String sceneName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCatchException(Context context, boolean enable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreate(Context context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPause(Context context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onResume(Context context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy(Context context) {
		// TODO Auto-generated method stub

	}

}
