package com.example.custoviagem

class Personrepository {

    fun validationCalculate(distance: Float, preco: Float, autonomia: Float):Float {
        return (distance * preco) / autonomia
    }
}