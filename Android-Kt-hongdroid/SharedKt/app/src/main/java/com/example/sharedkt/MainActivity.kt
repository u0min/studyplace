package com.example.sharedkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    // 함수 추가
    private fun saveData() {
        val pref = getSharedPreferences("pref", 0) // mode 옵션 default 0
        val edit = pref.edit() // 수정 모드
        edit.putString("name", binding.etHello.text.toString()) // 1번 인자 : 키 값, 2번 인자 실제 담아둘 값
        edit.apply() // 값을 저장 완료
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0) // mode 옵션 default 0
        binding.etHello.setText(pref.getString("name", "")) // 1번 인자 : 키 값, 2번 키값의 데이터가 없을 경우 대체 값
    }

    override fun onCreate(savedInstanceState: Bundle?) { // 앱이 처음 실행될 때 한번만 수행되는 곳 (초기화)
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

        loadData() // 저장된 edit text 값을 setText

        /* 여기서 부터 추가 */
    }

    // 액티비티가 파괴될 때..
    override fun onDestroy() { // 해당 액티비티가 종료되는 시점이 다가올 때 호출

        saveData() // edit text 값 저장 ! binding null 전에 저장해야 되었음

        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()

    }
}