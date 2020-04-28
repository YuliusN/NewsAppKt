package com.test.mandiri.newsappkt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.test.mandiri.newsappkt.ui.CategoryActivity
import com.test.mandiri.newsappkt.ui.SourceActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        category_option.setOnClickListener(View.OnClickListener {
            Log.i("ONCLICK", "CLICKING")
            val i = Intent(this@MainActivity, CategoryActivity::class.java)
            startActivity(i)
        })

        sources_option.setOnClickListener(View.OnClickListener {
            Log.i("ONCLICK", "CLICKING333")
            val i = Intent(this@MainActivity, SourceActivity::class.java)
            startActivity(i)
        })
    }
}
