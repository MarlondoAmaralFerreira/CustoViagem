package com.example.custoviagem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var textCoin = MutableLiveData<Float>()
    private var personrepository = Personrepository()

    fun textCoin():LiveData<Float>{
        return textCoin
    }

    fun calculate(distance:Float, preco:Float, autonomia:Float){
        textCoin.value = personrepository.validationCalculate(distance, preco, autonomia)
    }
}