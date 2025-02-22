/*
 * Copyright 2016 Michael Boyde Wallace (http://wallaceit.com.au)
 * This file is part of Reddinator.
 *
 * Reddinator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Reddinator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Reddinator (COPYING). If not, see <http://www.gnu.org/licenses/>.
 */
package au.com.wallaceit.reddinator.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.IconButton;

import au.com.wallaceit.reddinator.R;
import au.com.wallaceit.reddinator.Reddinator;
import au.com.wallaceit.reddinator.core.ThemeManager;
import au.com.wallaceit.reddinator.core.Utilities;

public class ViewImageDialogActivity extends Activity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Reddinator global = (Reddinator) getApplicationContext();
        setContentView(R.layout.activity_view_image_dialog);
        // get content url (which will be an image)
        String imageUrl = getIntent().getStringExtra(Reddinator.ITEM_URL);
        // fix imgur links so it's not redirected to full webpage
        if (Utilities.isImgurUrl(imageUrl)) {
            imageUrl = imageUrl.replaceFirst("//*.imgur.com/", "//i.imgur.com/");
            if (!Utilities.hasImageExtension(imageUrl))
                imageUrl += ".jpg"; // any extension will work
        }
        // setup image view
        WebView webView = (WebView) findViewById(R.id.imagewebview);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setWebViewClient(new ImageWebViewClient());
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        boolean multi = getPackageManager().hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH);
        webView.getSettings().setDisplayZoomControls(!multi);
        // Make sure we specify a proper user agent. Many sites block generic ones.
        webView.getSettings().setUserAgentString("Android/Reddinator v3.20.2");
        webView.loadUrl(imageUrl);
        registerForContextMenu(webView);
        // setup open comments button
        IconButton button = (IconButton) findViewById(R.id.commentsbutton);
        ThemeManager.Theme theme = global.mThemeManager.getActiveTheme("appthemepref");
        int headerBg = Color.parseColor(theme.getValue("header_color"));
        int headerText = Color.parseColor(theme.getValue("header_text"));
        button.setBackgroundColor(headerBg);
        button.setTextColor(headerText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                extras.putBoolean("view_comments", true);
                Intent commentsIntent = new Intent(ViewImageDialogActivity.this, ViewRedditActivity.class);
                commentsIntent .putExtras(extras);
                startActivity(commentsIntent );
                finish();
            }
        });
        setFinishOnTouchOutside(true);
    }

    private class ImageWebViewClient extends WebViewClient {
        public void onPageFinished(WebView webView, String url) {
            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }
    }
}