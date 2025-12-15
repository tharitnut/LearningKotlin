package com.example.mykotlinapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale;

class RecAdapter(private val pizzaList: ArrayList<Pizza>) :
    RecyclerView.Adapter<RecAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageTitle = itemView.findViewById<ImageView>(R.id.imgTitle)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvIng = itemView.findViewById<TextView>(R.id.tvIng)
        val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)
        val constraintRow: ConstraintLayout = itemView.findViewById(R.id.constraint_row)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val currentItem = pizzaList[position]
        holder.imageTitle.setImageResource(currentItem.imageTitle)
        holder.tvName.text = currentItem.name
        holder.tvIng.text = currentItem.ingredients
        val formattedPrice = String.format(Locale.US, "$%.2f", currentItem.price)
        holder.tvPrice.text = formattedPrice

        val cont = holder.constraintRow.context
        holder.constraintRow.setOnClickListener {
            val intent = Intent(it.context, SecondActivity::class.java)

            intent.putExtra("image", currentItem.imageTitle)
            intent.putExtra("name", currentItem.name)
            intent.putExtra("ingredients", currentItem.ingredients)
            intent.putExtra("price", currentItem.price)

            it.context.startActivity(intent)

            Toast.makeText(cont, "The item ${currentItem.name} is clicked", Toast.LENGTH_SHORT)
                .show()
        }

        holder.constraintRow.setOnLongClickListener(View.OnLongClickListener {
            Toast.makeText(cont, "The item ${currentItem.name} is long clicked", Toast.LENGTH_SHORT)
                .show()
            return@OnLongClickListener true
        })

        holder.cardView.startAnimation(
            AnimationUtils.loadAnimation(
                holder.cardView.context,
                R.anim.scale_up
            )
        )
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }
}