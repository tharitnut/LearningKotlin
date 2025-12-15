package com.example.mykotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var imageId: Array<Int>
    private lateinit var name: Array<String>
    private lateinit var ingredients: Array<String>
    private lateinit var price: DoubleArray

    private lateinit var recView: RecyclerView
    private lateinit var itemArrayList: ArrayList<Pizza>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.pizza1,
            R.drawable.pizza2,
            R.drawable.pizza3,
            R.drawable.pizza4,
            R.drawable.pizza5,
            R.drawable.pizza6,
            R.drawable.pizza1,
            R.drawable.pizza2,
            R.drawable.pizza3,
            R.drawable.pizza4,
            R.drawable.pizza5,
            R.drawable.pizza6,
            R.drawable.pizza1,
            R.drawable.pizza2,
            R.drawable.pizza3,
            R.drawable.pizza4,
            R.drawable.pizza5,
            R.drawable.pizza6,
            R.drawable.pizza1,
            R.drawable.pizza2
        )

        name = arrayOf(
            "Mushroom & Garlic",
            "Classic Veggie Supreme",
            "Spicy BBQ Chicken",
            "Avocado Chicken Delight",
            "Authentic Margherita",
            "The Works Supreme",
            "Mushroom & Garlic",
            "Classic Veggie Supreme",
            "Spicy BBQ Chicken",
            "Avocado Chicken Delight",
            "Authentic Margherita",
            "The Works Supreme",
            "Mushroom & Garlic",
            "Classic Veggie Supreme",
            "Spicy BBQ Chicken",
            "Avocado Chicken Delight",
            "Authentic Margherita",
            "The Works Supreme",
            "Mushroom & Garlic",
            "Classic Veggie Supreme"
        )

        ingredients = arrayOf(
            "Ingredients: Mushrooms, Fresh Basil, Garlic oil, Mozzarella.",
            "Ingredients: Bell Peppers, Onions, Black Olives, Mozzarella, Tomato Sauce.",
            "Ingredients: Chicken chunks, BBQ sauce, Red Peppers, Jalapeños.",
            "Ingredients: BBQ Chicken, Red Onion, Avocado/Pesto, Drizzle.",
            "Ingredients: Fresh Basil, Large Buffalo Mozzarella Rounds, Tomato Sauce.",
            "Ingredients: Pepperoni, Sausage, Olives, Peppers, Red Onion.",
            "Ingredients: Mushrooms, Fresh Basil, Garlic oil, Mozzarella.",
            "Ingredients: Bell Peppers, Onions, Black Olives, Mozzarella, Tomato Sauce.",
            "Ingredients: Chicken chunks, BBQ sauce, Red Peppers, Jalapeños.",
            "Ingredients: BBQ Chicken, Red Onion, Avocado/Pesto, Drizzle.",
            "Ingredients: Fresh Basil, Large Buffalo Mozzarella Rounds, Tomato Sauce.",
            "Ingredients: Pepperoni, Sausage, Olives, Peppers, Red Onion.",
            "Ingredients: Mushrooms, Fresh Basil, Garlic oil, Mozzarella.",
            "Ingredients: Bell Peppers, Onions, Black Olives, Mozzarella, Tomato Sauce.",
            "Ingredients: Chicken chunks, BBQ sauce, Red Peppers, Jalapeños.",
            "Ingredients: BBQ Chicken, Red Onion, Avocado/Pesto, Drizzle.",
            "Ingredients: Fresh Basil, Large Buffalo Mozzarella Rounds, Tomato Sauce.",
            "Ingredients: Pepperoni, Sausage, Olives, Peppers, Red Onion.",
            "Ingredients: Mushrooms, Fresh Basil, Garlic oil, Mozzarella.",
            "Ingredients: Bell Peppers, Onions, Black Olives, Mozzarella, Tomato Sauce."
        )

        price = doubleArrayOf(
            13.00, 14.50, 15.99, 17.50, 12.00, 16.75,
            13.00, 14.50, 15.99, 17.50, 12.00, 16.75,
            13.00, 14.50, 15.99, 17.50, 12.00, 16.75,
            13.00, 14.50
        )

        recView = findViewById(R.id.recView)
        recView.layoutManager = GridLayoutManager(
            this, 2
        )
        recView.setHasFixedSize(true)

        itemArrayList = arrayListOf<Pizza>()

        getData()

        recView.adapter = RecAdapter(itemArrayList)
    }

    private fun getData() {
        for (i in imageId.indices) {
            val pizza = Pizza(imageId[i], name[i], ingredients[i], price[i])
            itemArrayList.add(pizza)
        }
    }

}