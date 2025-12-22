package com.example.mvvm.ui.quotes

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.data.Quote // Assuming your data class is here
import com.example.mvvm.utilities.InjectorUtils
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quotes)
        initializeUI()
    }

    private fun initializeUI() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        // Find views
        val tvQuote = findViewById<TextView>(R.id.textView_quote)
        val btnAddQuote = findViewById<MaterialButton>(R.id.button_add_quote)
        val etQuote = findViewById<TextInputEditText>(R.id.editText_quote)
        val etAuthor = findViewById<TextInputEditText>(R.id.editText_author)

        // Observe LiveData
        viewModel.getQuotes().observe(this) { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            tvQuote.text = stringBuilder.toString()
        }

        // Handle Add Button Click
        btnAddQuote.setOnClickListener {
            val quoteText = etQuote.text.toString()
            val authorText = etAuthor.text.toString()

            if (quoteText.isNotEmpty() || authorText.isNotEmpty()) {
                val quote = Quote(quoteText, authorText)
                viewModel.addQuote(quote)

                // Clear inputs
                etQuote.setText("")
                etAuthor.setText("")
            }
        }
    }
}