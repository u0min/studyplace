package com.example.webviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.webviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        // 자동 생성된 뷰 바인딩 클래스에서의 inflate 라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시 합니다.
        setContentView(binding.root)

        // 이제부터 binding 바인딩 변수를 활용하여 마음 껏 xml 파일 내의 뷰 id 접근이 가능해집니다.
        // 뷰 id도 파스칼케이스 + 카멜케이스의 네이밍규칙 적용으로 인해서 tv_message -> tvMessage 로 자동 변환 되었습니다.
        // ex> binding.tvMessage.setText("안녕하세요 홍드로이드 입니다.")
        /* 여기서 부터 추가 */

        binding.webView.settings.javaScriptEnabled = true // 자바 스크립트 허용

        /* 웹뷰에서 새 창이 뜨지 않도록 방지 */
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()
        /* 웹뷰에서 새 창이 뜨지 않도록 방지 */

        binding.webView.loadUrl("https://www.naver.com") // 링크 주소를 Load 함

        /* 여기서 부터 추가 */
    }
    /* 뒤로가기 버튼 */
    override fun onBackPressed() {
        if(binding.webView.canGoBack()) // 웹사이트에서 뒤로 갈 페이지가 존재 한다면
        {
            binding.webView.goBack() // 웹사이트 뒤로가기
        }
        else
        {
            super.onBackPressed() // 본래의 백버튼 기능 수행 (안드로이드)
        }

    }
}