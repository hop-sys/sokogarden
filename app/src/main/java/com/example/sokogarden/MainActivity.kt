package com.example.sokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        find the button by its id
        val signupBtn = findViewById<Button>(R.id.signupBtn)
        val signinBtn = findViewById<Button>(R.id.signinBtn)

//        create the intent
        signupBtn.setOnClickListener {
            val intent = Intent(applicationContext, Signup::class.java)
            startActivity(intent)
        }
//        ====================================

        signinBtn.setOnClickListener {
            val intent = Intent(applicationContext, Signin::class.java)
            startActivity(intent)
        }

//        find the recyclerView and the progressbar by use of their ids
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

//        specify the API url endpoint of fetching the products from always data
        val url = "https://hope.alwaysdata.net/api/get_products"

//        import the helper class
        val helper = ApiHelper(applicationContext)

//        call the loadProducts function inside the helper class
        helper.loadProducts(url, recyclerView, progressBar)

//        find the about button by use of its id and have the intent
        val aboutButton = findViewById<Button>(R.id.aboutBtn)

//        below is the intent to the about activity/page
        aboutButton.setOnClickListener {
            val intent = Intent(applicationContext, About::class.java)
            startActivity(intent)
        }
    }
}