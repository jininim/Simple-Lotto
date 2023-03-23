package com.simple.lotto.ui.lotto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.simple.lotto.R
import com.simple.lotto.databinding.ActivityLottoBinding


class LottoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLottoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLottoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        //바텀 네비게이션 아이템 색상 없애기
        navView.itemIconTintList = null

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)
    }
}
