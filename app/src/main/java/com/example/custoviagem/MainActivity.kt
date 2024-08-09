package com.example.custoviagem

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.custoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonCalculate.setOnClickListener(this)

        setobserver()
    }

    // Eventos de click
    override fun onClick(v: View) {
        if (v.id == R.id.button_calculate) {
            val distance = binding.editDistance.text.toString().toFloat()
            val preco = binding.editPrice.text.toString().toFloat()
            val autonomia = binding.editAutonomy.text.toString().toFloat()

            viewModel.calculate(distance, preco, autonomia)
        }
    }

    private fun setobserver() {
        viewModel.textCoin().observe(this, Observer {value ->
            binding.textCoin.text = String.format("R$ %.2f", value)
        })
    }
}