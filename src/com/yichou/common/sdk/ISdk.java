package com.yichou.common.sdk;

import java.util.HashMap;

import android.content.Context;


/**
 * SDK 功能接口
 * 
 * @author Yichou
 *
 */
public interface ISdk {
	public interface CheckUpdateCallback {
		/**
		 * 检测失败
		 */
		public int ERRNO_FAILUE = 0;
		
		/**
		 * 没有更新
		 */
		public int ERRNO_NONEW = 1;
		
		/**
		 * 设置仅 wifi 更新，但是当前不是连的 wifi
		 */
		public int ERRNO_NOWIFI = 3;
		
		
		/**
		 * 检测到更新，可下载更新
		 * 
		 * @param data 更新数据
		 */
		public void onSuccess(Object updateInfo);
		
		/**
		 * 检测失败，不可更新
		 * 
		 * @param code 错误码
		 * @param msg 错误信息
		 */
		public void onFailure(int code, String msg);
	}
	
	public interface DownloadCallback {
		/**
		 * 下载成功
		 */
		public void onSuccess();
		
		/**
		 * 下载失败
		 * 
		 * @param code 错误码
		 * @param msg 错误信息
		 */
		public void onFailure(int code, String msg);
	}
	
	/**
	 * 设置仅 wifi 更新
	 * 
	 * @param wifiOnly
	 */
	public void setUpdateWifiOnly(boolean wifiOnly);
	
	public void setCheckUpdateCallback(CheckUpdateCallback cb);
	
	public void setUpdateDownloadCallback(DownloadCallback cb);
	
	/**
	 * 检查更新
	 * 
	 * @param context
	 */
	public void checkUpdate(Context context);
	
	/**
	 * 更新在线参数
	 */
	public void updateOnlineParams(Context context);
	
	/**
	 * 获取在线参数
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public String getOnlineParam(Context context, String key);
	
	/**
	 * 向服务器发送事件
	 * 
	 * @param context
	 * @param id
	 * @param data
	 */
	public void sendEvent(Context context, String id, String data);
	public void sendEvent(Context context, String id);

	/**
	 * 发送多个事件
	 * 
	 * @param context
	 * @param map 为当前事件的属性和取值（键值对）。
	 */
	public void sendEvent(Context context, String id, HashMap<String, String> map);
	
	/**
	 * 事件开始
	 * 
	 * @param context
	 * @param id
	 */
	public void beginEvnet(Context context, String id);
	public void beginEvnet(Context context, String id, String data);
	
	/**
	 * 事件结束
	 * 
	 * @param context
	 * @param id
	 */
	public void endEvnet(Context context, String id);
	public void endEvnet(Context context, String id, String data);

	/**
	 * 带参数事件开始
	 * 
	 * @param context
	 * @param id
	 * @param map 为当前事件的属性和取值（键值对）。
	 * @param flag 这个参数用于和 id 一起标示一个唯一事件，并不会被统计；
	 */
	public void beginEvnetEx(Context context, String id, String flag, HashMap<String,String> map);
	
	/**
	 * 带参数的事件结束
	 * 
	 * @param context
	 * @param id
	 * @param flag
	 */
	public void endEvnetEx(Context context, String id, String flag);
	
	
	/**
	 * 进入某场景
	 * 
	 * @param context
	 * @param sceneName 场景名
	 */
	public void entryScene(Context context, String sceneName);
	
	/**
	 * 离开某场景
	 * 
	 * @param context
	 * @param sceneName 场景名
	 */
	public void exitScene(Context context, String sceneName);
	
	/**
	 * 设置 SDK 捕获为捕获异常
	 * 
	 * @param context
	 * @param enable 是否开启
	 */
	public void setCatchException(Context context, boolean enable);
	
	///////////// 框架事件 ////////////////////////////
	public void onCreate(Context context);
	
	public void onPause(Context context);

	public void onResume(Context context);

	public void onDestroy(Context context);
}
