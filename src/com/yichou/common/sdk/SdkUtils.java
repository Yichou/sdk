package com.yichou.common.sdk;

import android.content.Context;

/**
 * 
 * SDK 接口封装类
 * 
 * @author Yichou
 * 
 */
public final class SdkUtils {
	public static ISdk getSdk() {
		return gDefault.get();
	}
	
	public static String getOnlineString(Context context, String name) {
		String adsString = getSdk().getOnlineParam(context, name);

		if (adsString == null || adsString.length() == 0
				|| adsString.equals("null")) {
			return null;
		}

		return adsString;
	}

	public static int getOnlineInt(Context context, String name, int def) {
		try {
			return Integer.parseInt(getSdk().getOnlineParam(context, name));
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


