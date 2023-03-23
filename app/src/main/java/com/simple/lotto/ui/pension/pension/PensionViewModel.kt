package com.simple.lotto.ui.pension.pension

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PensionViewModel(application: Application) : AndroidViewModel(application) {

    private val _lottoNumber1 = MutableLiveData<List<String>?>()
    val lottoNumber1: LiveData<List<String>?>
        get() = _lottoNumber1
    private val _lottoNumber2 = MutableLiveData<List<String>?>()
    val lottoNumber2: LiveData<List<String>?>
        get() = _lottoNumber2
    private val _lottoNumber3 = MutableLiveData<List<String>?>()
    val lottoNumber3: LiveData<List<String>?>
        get() = _lottoNumber3
    private val _lottoNumber4 = MutableLiveData<List<String>?>()
    val lottoNumber4: LiveData<List<String>?>
        get() = _lottoNumber4
    private val _lottoNumber5 = MutableLiveData<List<String>?>()
    val lottoNumber5: LiveData<List<String>?>
        get() = _lottoNumber5


    //TextView 업데이트
    fun updateText() {
        _lottoNumber1.value = ran()
        _lottoNumber2.value = ran()
        _lottoNumber3.value = ran()
        _lottoNumber4.value = ran()
        _lottoNumber5.value = ran()
    }
    private fun ran(): List<String> {
        val lottoNumber = mutableListOf<String>()
        lottoNumber.add(randomGroup())
        while(lottoNumber.size < 7){
            lottoNumber.add((0..9).random().toString())
        }
        return lottoNumber
    }
    //난수 발생 함수
    private fun randomGroup(): String {
        return (1..5).random().toString() + "조"
    }


}



