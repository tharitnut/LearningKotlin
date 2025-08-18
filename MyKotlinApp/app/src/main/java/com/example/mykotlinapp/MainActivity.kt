package com.example.mykotlinapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mykotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)



        binding.btnAdd.setOnClickListener(this)
        binding.btnMinus.setOnClickListener(this)
        binding.btnMultiply.setOnClickListener(this)
        binding.btnDivide.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        var a = binding.etA.text.toString().toDouble()
        var b = binding.etB.text.toString().toDouble()
        if (a == null || b == null) {
            binding.resultTv.text = "Please enter valid numbers"
            return
        }
        var result = 0.0
        when(v?.id){
            R.id.btn_add -> {
                result = a+b
            }
            R.id.btn_minus -> {
                result = a-b
            }
            R.id.btn_multiply -> {
                result = a*b
            }
            R.id.btn_divide -> {
                result = a/b
            }
        }
        binding.resultTv.text = "Result: $result"
    }
}