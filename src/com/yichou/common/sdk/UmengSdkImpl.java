package com.yichou.common.sdk;

import java.util.HashMap;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;
import com.umeng.update.UmengDownloadListener;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;

/**
 * 
 * @author YYichou 2013-10-10
 * 
 */
public class UmengSdkImpl implements ISdk, UmengUpdateListener,
		UmengDownloadListener {
	CheckUpdateCallback mCheckUpdateCallback;
	DownloadCallback mDownloadCallback;
	

	public UmengSdkImpl() {
		UmengUpdateAgent.setUpdateAutoPopup(true);
		UmengUpdateAgent.setUpdateListener(this);
		UmengUpdateAgent.setDownloadListener(this);
	}
	
	@Override
	public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
		switch (updateStatus) {

		case 0: {// has update
			if (mCheckUpdateCallback != null)
				mCheckUpdateCallback.onSuccess(updateInfo);
			
			break;
		}
		
		case 1: {// has no update
			if (mCheckUpdateCallback != null)
				mCheckUpdateCallback.onFailure(CheckUpdateCallback.ERRNO_NONEW, "no new");
			break;
		}
		
		case 2: {// none wifi
			if (mCheckUpdateCallback != null)
				mCheckUpdateCallback.onFailure(CheckUpdateCallback.ERRNO_NOWIFI, "no wifi");
			break;
		}
		
		case 3: // time out
			if (mCheckUpdateCallback != null)
				mCheckUpdateCallback.onFailure(CheckUpdateCallback.ERRNO_FAILUE, "time out");
			break;
		}
	}
	
	@Override
	public void OnDownloadStart() {
	}

	@Override
	public void OnDownloadUpdate(int arg0) {
	}
	
	@Override
	public void OnDownloadEnd(int result, String file) {
		if(mDownloadCallback != null){
			if(result == 1)
				mDownloadCallback.onSuccess();
			else
				mDownloadCallback.onFailure(result, file);
		}
	}

	@Override
	public void setUpdateWifiOnly(boolean wifiOnly) {
		UmengUpdateAgent.setUpdateOnlyWifi(true);
	}

	@Override
	public void setCheckUpdateCallback(CheckUpdateCallback cb) {
		mCheckUpdateCallback = cb;
	}

	@Override
	public void setUpdateDownloadCallback(DownloadCallback cb) {
		mDownloadCallback = cb;
	}

	@Override
	public void checkUpdate(Context context) {
		UmengUpdateAgent.update(context);
	}

	@Override
	public void updateOnlineParams(Context context) {
		MobclickAgent.updateOnlineConfig(context);
	}

	@Override
	public String getOnlineParam(Context context, String key) {
		return MobclickAgent.getConfigParams(context, key);
	}

	@Override
	public void sendEvent(Context context, String id, String data) {
		MobclickAgent.onEvent(context, id, data);
	}

	@Override
	public void sendEvent(Context context, String id, HashMap<String, String> map) {
		MobclickAgent.onEvent(context, id, map);
	}

	@Override
	public void entryScene(Context context, String sceneName) {
		MobclickAgent.onPageStart(sceneName);
	}

	@Override
	public void exitScene(Context context, String sceneName) {
		MobclickAgent.onPageEnd(sceneName);
	}

	@Override
	public void setCatchException(Context context, boolean enable) {
		if(enable)
			MobclickAgent.onError(context);
	}

	@Override
	public void onCreate(Context context) {
	}

	@Override
	public void onPause(Context context) {
		MobclickAgent.onPause(context);
	}

	@Override
	public void onResume(Context context) {
		MobclickAgent.onResume(context);
	}

	@Override
	public void onDestroy(Context context) {
	}

	@Override
	public void sendEvent(Context context, String id) {
		MobclickAgent.onEvent(context, id);
	}

	@Override
	public void beginEvnet(Context context, String id) {
		MobclickAgent.onEventBegin(context, id);
	}

	@Override
	public void endEvnet(Context context, String id) {
		MobclickAgent.onEventEnd(context, id);
	}

	@Override
	public void beginEvnetEx(Context context, String id, String flag, HashMap<String,String> map) {
		MobclickAgent.onKVEventBegin(context, id, map, flag);
	}

	@Override
	public void endEvnetEx(Context context, String id, String flag) {
		MobclickAgent.onKVEventEnd(context, id, flag);
	}

	@Override
	public void beginEvnet(Context context, String id, String data) {
		MobclickAgent.onEventBegin(context, id, data);
	}
	
	@Override
	public void endEvnet(Context context, String id, String data) {
		MobclickAgent.onEventEnd(context, id, data);
	}
	
	public static void startFeedbackActivity(Context context) {
		new FeedbackAgent(context).startFeedbackActivity();
	}
}
