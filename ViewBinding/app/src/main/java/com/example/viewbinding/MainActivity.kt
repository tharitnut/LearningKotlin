package com.example.viewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: Adapter
    private lateinit var list: ArrayList<Info>
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)

        list = ArrayList()
        list.add(Info(R.drawable.book1, "Book 1"))
        list.add(Info(R.drawable.book2, "Book 2"))
        list.add(Info(R.drawable.book3, "Book 3"))
        list.add(Info(R.drawable.book4, "Book 4"))
        list.add(Info(R.drawable.book5, "Book 5"))
        list.add(Info(R.drawable.book6, "Book 6"))
        list.add(Info(R.drawable.book7, "Book 7"))
        list.add(Info(R.drawable.book8, "Book 8"))
        list.add(Info(R.drawable.book9, "Book 9"))

        adapter = Adapter(list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}