package com.periyar.commerce;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    public WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_search, container, false);
        mWebView=(WebView) v.findViewById(R.id.webview);
        mWebView.loadUrl("https://micoder-dev.github.io/commerce-department");

        //Enable js
        WebSettings webSettings=mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //Force links & redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        //webview can go back
        mWebView.canGoBack();
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode==KeyEvent.KEYCODE_BACK
                && event.getAction()== MotionEvent.ACTION_UP
                && mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
                return false;
            }
        });
        return v;
    }
}
