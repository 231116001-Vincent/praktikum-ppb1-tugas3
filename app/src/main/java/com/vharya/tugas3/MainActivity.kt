package com.vharya.tugas3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val items = arrayListOf(
        GraphicCard("Radeon 7900 XTX", "AMD", R.drawable.radeon7900xtx),
        GraphicCard("Radeon RX 6600", "AMD", R.drawable.radeonrx6600),
        GraphicCard("Radeon RX 6800", "AMD", R.drawable.radeonrx6800),
        GraphicCard("RTX 4060", "NVIDIA", R.drawable.rtx4060),
        GraphicCard("RTX 4070", "NVIDIA", R.drawable.rtx4070),
        GraphicCard("RTX 5070 Ti", "NVIDIA", R.drawable.rtx5070ti),
        GraphicCard("RTX 5090", "NVIDIA", R.drawable.rtx5090),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GraphicCardAdapter(this@MainActivity, items)
    }
}