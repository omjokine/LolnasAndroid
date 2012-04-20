package fi.lolnas;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LolnasWebViewClient extends WebViewClient {
	private static final String TAG = LolnasWebViewClient.class.getName();
	private final LolnasActivity activity;

	public LolnasWebViewClient(LolnasActivity activity) {
		this.activity = activity;
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		Log.d(TAG, "Opening url: " + url);
		if(url.startsWith("mailto:")) {
			Intent i = new Intent(Intent.ACTION_SEND);
			i.setType("message/rfc822");
			i.putExtra(Intent.EXTRA_EMAIL, new String[]{url});
			this.activity.startActivity(i);
		} else {
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			this.activity.startActivity(browserIntent);
		}
		return true;
	}

	@Override
	public void onPageFinished(WebView view, String url) {
		super.onPageFinished(view, url);
		Log.d(TAG, "onPageFinished: " + view.getUrl());
		//hide loading image
		this.activity.findViewById(R.id.imageLoading1).setVisibility(View.GONE);
		//show webview
		this.activity.findViewById(R.id.webView1).setVisibility(View.VISIBLE);
	}

}
