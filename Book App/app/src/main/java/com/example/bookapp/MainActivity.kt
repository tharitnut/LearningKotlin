package com.example.bookapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.adapters.ParentAdapter
import com.example.bookapp.models.ChildDataClass
import com.example.bookapp.models.ParentDataClass
import java.util.Locale

class MainActivity : AppCompatActivity() {

    val parentItemsList = ArrayList<ParentDataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rvParent = findViewById<RecyclerView>(R.id.rv_parent)
        rvParent.setHasFixedSize(true)
        rvParent.layoutManager = LinearLayoutManager(this)

        val adapter = ParentAdapter(parentItemsList)

        val searchView = findViewById<SearchView>(R.id.searchView)

        setData()

        rvParent.adapter = adapter

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                val searchList = ArrayList<ParentDataClass>()

                if(newText !=null){
                    for(i in parentItemsList){
                        if(i.title.lowercase(Locale.ROOT).contains(newText)){
                            searchList.add(i)
                        }
                    }
                    if(searchList.isEmpty()){
                        Toast.makeText(this@MainActivity,"No Data", Toast.LENGTH_SHORT).show()
                    }else{
                        adapter.onApplySearch(searchList)
                    }
                }
                return true
            }
        })

    }

    private fun setData() {

        val childItemsList = ArrayList<ChildDataClass>()

        childItemsList.add(ChildDataClass(R.drawable.book1))
        childItemsList.add(ChildDataClass(R.drawable.book2))
        childItemsList.add(ChildDataClass(R.drawable.book6))
        childItemsList.add(ChildDataClass(R.drawable.book5))
        childItemsList.add(ChildDataClass(R.drawable.book7))
        childItemsList.add(ChildDataClass(R.drawable.book9))

        parentItemsList.add(ParentDataClass("Best seller:",childItemsList))

        val childItemsList2 = ArrayList<ChildDataClass>()

        childItemsList2.add(ChildDataClass(R.drawable.book2))
        childItemsList2.add(ChildDataClass(R.drawable.book3))
        childItemsList2.add(ChildDataClass(R.drawable.book9))
        childItemsList2.add(ChildDataClass(R.drawable.book8))
        childItemsList2.add(ChildDataClass(R.drawable.book4))

        parentItemsList.add(ParentDataClass("History:",childItemsList2))

        val childItemsList3 = ArrayList<ChildDataClass>()

        childItemsList3.add(ChildDataClass(R.drawable.book9))
        childItemsList3.add(ChildDataClass(R.drawable.book6))
        childItemsList3.add(ChildDataClass(R.drawable.book5))
        childItemsList3.add(ChildDataClass(R.drawable.book8))

        parentItemsList.add(ParentDataClass("Favorite:",childItemsList3))

    }
}