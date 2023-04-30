package com.simple.lotto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simple.lotto.databinding.ActivityIntroBinding
import com.simple.lotto.ui.WebViewActivity
import com.simple.lotto.ui.lotto.LottoActivity
import com.simple.lotto.ui.pension.PensionActivity


class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)




//        konfetti 애니메이션 실행
        binding.konfettiView.start(Presets.parade())

        binding.buttonLotto.setOnClickListener {
            showLottoActivity()

        }
        binding.buttonPension.setOnClickListener {
            showPensionActivity()
        }
        binding.webViewButton.setOnClickListener {
            showWebView()
        }



    }
    //로또 버튼 클릭시 LottoActivity로 이동
    private fun showLottoActivity(){
        val intent = Intent(this, LottoActivity::class.java)
        startActivity(intent)
    }
    //연금 복권 버튼 클릭시 pensionActivity로 이동
    private fun showPensionActivity(){
        val intent = Intent(this, PensionActivity::class.java)
        startActivity(intent)
    }
    //로또 판매점 버튼클릭
    private fun showWebView(){
        val intent = Intent(this, WebViewActivity::class.java)
        startActivity(intent)
    }
}

