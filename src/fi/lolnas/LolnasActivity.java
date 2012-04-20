package fi.lolnas;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class LolnasActivity extends Activity {
	private static final String TAG = LolnasActivity.class.getName();
	private WebView webView;

	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);

		String url = "http://www.lolnas.fi?" + LocationService.getLocation(this);

		Log.d(TAG, "Loading URL: " + url);

		this.onCreateHelper(url);
	}

	private void onCreateHelper(String url) {
		setContentView(R.layout.main);

		this.webView = (WebView)findViewById(R.id.webView1);

		this.webView.setWebViewClient(new LolnasWebViewClient(this));
		this.webView.setWebChromeClient(new LolnasWebChromeClient());
		this.webView.getSettings().setJavaScriptEnabled(true);

		this.webView.setScrollbarFadingEnabled(true);
		this.webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
		this.webView.setVerticalScrollBarEnabled(false);
		this.webView.setHorizontalScrollBarEnabled(false);

		this.webView.getSettings().setDefaultTextEncodingName("utf-8");
		this.webView.loadUrl(url);
		this.webView.getSettings().setDomStorageEnabled(true); // localStorage
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.push_in_left, R.anim.push_out_right);
	}

}