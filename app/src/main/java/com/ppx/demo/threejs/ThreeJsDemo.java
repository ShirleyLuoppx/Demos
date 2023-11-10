package com.ppx.demo.threejs;

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
        m_Webgl3D_WV = findViewById(R.id.webview);
        m_WebSettings = m_Webgl3D_WV.getSettings();
        m_WebSettings.setJavaScriptEnabled(true);
        m_WebSettings.setAllowUniversalAccessFromFileURLs(true);
        m_WebSettings.setAllowFileAccess(true);
        //允许Dom缓存数据
        m_WebSettings.setDomStorageEnabled(true);
        String url = "file:///android_asset/mytest/index.html";//简单的页面就能正常加载
//        url = "http://127.0.0.1:5500/mytest/index.html";
        m_Webgl3D_WV.setWebViewClient(new WebViewClient());
        m_Webgl3D_WV.loadUrl(url);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_threejs_demo;
    }
}

