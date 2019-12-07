package com.example.osgeo_pkp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.osgeo_pkp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val project = findViewById(R.id.projects) as Button
        project.setOnClickListener {
            val myWebLink = Intent(android.content.Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://www.osgeo.org/projects/")
            startActivity(myWebLink)
        }

        val res = findViewById(R.id.resources) as Button
        res.setOnClickListener {
            val myWebLink = Intent(android.content.Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://www.osgeo.org/resources/")
            startActivity(myWebLink)
        }

        val init = findViewById(R.id.initiatives) as Button
        init.setOnClickListener {
            val myWebLink = Intent(android.content.Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://www.osgeo.org/initiatives/geo-for-all/")
            startActivity(myWebLink)
        }

        val abt = findViewById(R.id.about) as Button
        abt.setOnClickListener {
            val myWebLink = Intent(android.content.Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://www.osgeo.org/about/")
            startActivity(myWebLink)
        }

        val dev = findViewById(R.id.developer) as Button
        dev.setOnClickListener {
            val myWebLink = Intent(android.content.Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://github.com/pkp2207")
            startActivity(myWebLink)
        }


    }
}
