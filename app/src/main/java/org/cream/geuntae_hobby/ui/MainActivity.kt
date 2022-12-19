package org.cream.geuntae_hobby.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.cream.geuntae_hobby.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)

        // 아이콘 색상의 틴트를 널로 해서 나타나게 하는 것
        bottomNavigationView.itemIconTintList = null

        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            // 바텀 내비게이션 뷰와 프래그먼트 컨테이너 뷰의 내부 호스트 프래그먼트를 연결
            // 바텀 내비게이션의 화면을 클릭함으로서 화면 이동을 하게 해주는 메소드
            bottomNavigationView.setupWithNavController(it) }

    }
}