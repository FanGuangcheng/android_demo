package com.example.guangchengfan.myview.viewpager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.guangchengfan.myview.R

class PageTwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var contentView = inflater.inflate(R.layout.page_two, container, false)
        //        val scrollView = findViewById<ScrollView>(R.id.sc_container)
//        val llContainer = findViewById<LinearLayout>(R.id.ll_container)
        val webView = contentView.findViewById<WebView>(R.id.webview)

        // 启用JavaScript
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // 在应用内打开链接而不是使用外部浏览器
        webView.webViewClient = WebViewClient()

//        window.decorView.post(Runnable {
//            var param = llContainer.layoutParams
//            param.height = scrollView.height
//            llContainer.layoutParams = param
//
//
//            var webParam = webView.layoutParams
//            webParam.height = scrollView.height
//            webView.layoutParams = webParam
//        })

        // 加载网页
//        webView.loadUrl("https://ih5.cztv.com/batrix-h5/h5/songyun/#/")
        webView.loadUrl("https://www.163.com/")
//        webView.loadUrl("https://www.baidu.com/")
        return contentView
    }
}