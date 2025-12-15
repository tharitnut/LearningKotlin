package com.example.mykotlinapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val img_second = findViewById<ImageView>(R.id.img_second)
        val tv_title_second = findViewById<TextView>(R.id.tv_title_second)
        val tv_price_second = findViewById<TextView>(R.id.tv_price_second)
        val tv_ing_second = findViewById<TextView>(R.id.tv_ing_second)

        val intent = intent

        val image = intent?.getIntExtra("image", 0)
        val title = intent?.getStringExtra("name")
        val ingredients = intent?.getStringExtra("ingredients")
        val price = intent.getDoubleExtra("price", 0.0)

        if (image != null) {
            img_second.setImageResource(image)
        }
        tv_title_second.text = title
        tv_price_second.text = String.format("$%.2f", price)
        tv_ing_second.text = ingredients
        
    }
}