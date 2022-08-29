package org.cream.udemshoppingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        // 아이콘 색상의 틴트를 널로 해서 나타나게 하는 것
        bottomNavigationView.itemIconTintList = null

    }
}