package com.simple.lotto.ui.lotto.lottery

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.simple.lotto.R
import com.simple.lotto.ui.lotto.DialogExcept
import com.simple.lotto.ui.lotto.DialogFix

class LotteryViewModel(application: Application) : AndroidViewModel(application) {
    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext

    private val _lottoNumber1 = MutableLiveData<List<Int>?>()
    val lottoNumber1: LiveData<List<Int>?>
        get() = _lottoNumber1
    private val _lottoNumber2 = MutableLiveData<List<Int>?>()
    val lottoNumber2: LiveData<List<Int>?>
        get() = _lottoNumber2
    private val _lottoNumber3 = MutableLiveData<List<Int>?>()
    val lottoNumber3: LiveData<List<Int>?>
        get() = _lottoNumber3
    private val _lottoNumber4 = MutableLiveData<List<Int>?>()
    val lottoNumber4: LiveData<List<Int>?>
        get() = _lottoNumber4
    private val _lottoNumber5 = MutableLiveData<List<Int>?>()
    val lottoNumber5: LiveData<List<Int>?>
        get() = _lottoNumber5
    //고정수
    private val _fixNumber = MutableLiveData<List<Int>?>()
    val fixNumber: LiveData<List<Int>?>
        get() = _fixNumber
    //제외수
    private val _exceptNumber = MutableLiveData<List<Int>?>()
    val exceptNumber: LiveData<List<Int>?>
        get() = _exceptNumber

    //고정수
    var excep : MutableList<Int> = mutableListOf()
    //제외수
    var fix : MutableList<Int> = mutableListOf()

    //TextView 업데이트
    fun updateText(){
        _lottoNumber1.value = ran()
        _lottoNumber2.value = ran()
        _lottoNumber3.value = ran()
        _lottoNumber4.value = ran()
        _lottoNumber5.value = ran()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun setNumberBackGround(number: Int, textView: TextView){
        textView.text = number.toString()
        when(number){ // 숫자별로 색깔 꾸미기
            in 1..10 -> textView.background = ContextCompat.getDrawable(context, R.drawable.circle_yello)
            in 11..20 -> textView.background = ContextCompat.getDrawable(context, R.drawable.circle_blue)
            in 21..30 -> textView.background = ContextCompat.getDrawable(context, R.drawable.circle_red)
            in 31..40 -> textView.background = ContextCompat.getDrawable(context, R.drawable.circle_gray)
            in 41..50 -> textView.background = ContextCompat.getDrawable(context, R.drawable.circle_green)
        }
        textView.isVisible = true
    }

    //제외수 백그라운드 설정
    fun setExcepNumberBackGround(number: Int, textView: TextView){
            textView.text = number.toString()
            textView.background = ContextCompat.getDrawable(context, R.drawable.circle_deepred)
            textView.isVisible = true
    }
    //고정수 백그라운드 설정
    fun setFixNumberBackGround(number: Int, textView: TextView){
        textView.text = number.toString()
        textView.background = ContextCompat.getDrawable(context, R.drawable.circle_deepblue)
        textView.isVisible = true
    }

    fun dialogShowExcept(context: Context){
        val dialog = DialogExcept(context)
        dialog.showDia()
        dialog.setOnClickListener(object : DialogExcept.ButtonClickListener{
            override fun onClicked(text: MutableList<Int>) {
                _exceptNumber.value = text.sorted()
                excep = text
            }
        })
    }
    fun dialogShowFix(context: Context){
        val dialog = DialogFix(context)
        dialog.showDia()
        dialog.setOnClickListener(object : DialogFix.ButtonClickListener{
            override fun onClicked(text: MutableList<Int>) {
                _fixNumber.value = text.sorted()
                fix = text
            }
        })
    }
    private fun ran(): List<Int> {
        val set = mutableSetOf<Int>()
        for (i in fix){
            set.add(i)
        }
        while(set.size < 6){
            val i = (1..45).random()
            if (i !in excep){
                set.add(i)
            }
        }
        return set.sorted()
    }


}



