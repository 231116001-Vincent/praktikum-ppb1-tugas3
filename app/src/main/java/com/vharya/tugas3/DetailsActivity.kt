package com.vharya.tugas3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(v.paddingLeft, systemBars.top + v.paddingTop, v.paddingRight, v.paddingBottom)
            insets
        }

        val selectedItem = this.intent.getSerializableExtra("gpu") as GraphicCard

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val imageView: ImageView = findViewById(R.id.detail_image)
        val textViewName: TextView = findViewById(R.id.detail_name)
        val textViewBrand: TextView = findViewById(R.id.detail_brand)

        toolbar.setNavigationIcon(R.drawable.arrow_left)
        toolbar.setNavigationOnClickListener { finish() }

        imageView.setImageResource(selectedItem.image)
        textViewName.text = selectedItem.name
        textViewBrand.text = selectedItem.brand
    }
}