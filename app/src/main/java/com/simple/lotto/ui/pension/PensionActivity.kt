package com.simple.lotto.ui.pension

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.simple.lotto.R
import com.simple.lotto.databinding.ActivityPensionBinding

class PensionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPensionBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰 바인딩
        binding = ActivityPensionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView1

        //바텀 네비게이션 아이템 색상 없애기
        navView.itemIconTintList = null


        val navController = findNavController(R.id.fragmentContainerView)

        navView.setupWithNavController(navController)


    }

}