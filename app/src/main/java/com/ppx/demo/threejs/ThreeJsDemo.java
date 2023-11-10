package com.ppx.demo.threejs;

import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ppx.demo.BaseActivity;
import com.ppx.demo.R;

/**
 * @Author Shirley
 * @Date：2023/11/10
 * @Desc：
 */
public class ThreeJsDemo extends BaseActivity {

    private WebView m_Webgl3D_WV;
    private WebSettings m_WebSettings;

    @Override
    public void initView() {
        String url = "file:///android_asset/mytest/index.html";//简单的页面就能正常加载
        //        url = "http://127.0.0.1:5500/mytest/index.html";

        m_Webgl3D_WV = findViewById(R.id.webview);
        m_WebSettings = m_Webgl3D_WV.getSettings();
        m_WebSettings.setJavaScriptEnabled(true);
        m_WebSettings.setPluginState(WebSettings.PluginState.ON);
        m_WebSettings.setAllowUniversalAccessFromFileURLs(true);
        m_WebSettings.setAllowFileAccess(true);
        m_WebSettings.setLoadsImagesAutomatically(true);
        m_WebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        m_WebSettings.setDefaultTextEncodingName("utf-8");
        //允许Dom缓存数据
        m_WebSettings.setDomStorageEnabled(true); // 开启 DOM storage API 功能
        m_WebSettings.setDatabaseEnabled(true);   //开启 database storage API 功能
        m_WebSettings.setAppCacheEnabled(true);//开启 Application Caches 功能
        //设置对 viewport mate   的支持
        m_WebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        m_WebSettings.setUseWideViewPort(true);
        m_WebSettings.setLoadWithOverviewMode(true);

        m_Webgl3D_WV.setWebViewClient(new WebViewClient());
        m_Webgl3D_WV.setWebChromeClient(new WebChromeClient());
        m_Webgl3D_WV.loadUrl(url);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_threejs_demo;
    }
}

