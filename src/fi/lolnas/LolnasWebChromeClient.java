package fi.lolnas;

import android.util.Log;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class LolnasWebChromeClient extends WebChromeClient {
	//	private static final String TAG = LolnasWebChromeClient.class.getName();

	@Override
	public void onConsoleMessage(String message, int lineNumber, String sourceID) {
		Log.d(getClass().getName(), sourceID + ":" + lineNumber + " log: "
				+ message);
		super.onConsoleMessage(message, lineNumber, sourceID);
	}

	@Override
	public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
		Log.d(getClass().getName(), url + " alert: " + message);
		return super.onJsAlert(view, url, message, result);
	}

	@Override
	public void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
		callback.invoke(origin, true, false);
	}

}
