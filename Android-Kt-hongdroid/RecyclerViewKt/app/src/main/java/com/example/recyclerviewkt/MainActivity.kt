package com.example.recyclerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewkt.databinding.ActivityMainBinding

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

        val profileList = arrayListOf(
            Profiles(R.drawable.manprofile, "A", 29, "안드로이드 앱 개발자"),
            Profiles(R.drawable.womanprofile, "B", 22, "아이폰 앱 개발자"),
            Profiles(R.drawable.manprofile, "C", 24, "리액트 앱 개발자"),
            Profiles(R.drawable.womanprofile, "D", 27, "플러터 앱 개발자"),
            Profiles(R.drawable.manprofile, "E", 34, "유니티 앱 개발자"),
            Profiles(R.drawable.womanprofile, "F", 31, "알고리즘 앱 개발자"),
            Profiles(R.drawable.manprofile, "G", 21, "웹 앱 개발자"),
            Profiles(R.drawable.womanprofile, "H", 25, "하이브리드 앱 개발자"),
            Profiles(R.drawable.manprofile, "I", 28, "그냥 앱 개발자"),
        )

        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)

        binding.rvProfile.adapter = ProfileAdapter(profileList)

        /* 여기서 부터 추가 */
    }
    // 액티비티가 파괴될 때..
    override fun onDestroy() { // 해당 액티비티가 종료되는 시점이 다가올 때 호출
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }
}