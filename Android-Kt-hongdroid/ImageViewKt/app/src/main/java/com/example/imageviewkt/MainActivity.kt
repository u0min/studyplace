package com.example.imageviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.imageviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언 , ActivityMainBinding? Import해주기
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        // 기존 setContentView 를 제거해주시고..

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

        binding.btnToast.setOnClickListener{

            binding.ivProfile.setImageResource(R.drawable.loveandroid)
            Toast.makeText(this@MainActivity, "버튼이 클릭 되었습니다.", Toast.LENGTH_SHORT).show()
        }

        //import Toast

        /* 여기서 부터 추가 */
    }
    // 액티비티가 파괴될 때..
    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }
}