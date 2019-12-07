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

        val faculty = findViewById(R.id.projects) as Button
        faculty.setOnClickListener {
            val myWebLink = Intent(android.content.Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://www.osgeo.org/projects/")
            startActivity(myWebLink)
        }

        val students = findViewById(R.id.resources) as Button
        students.setOnClickListener {
            val myWebLink = Intent(android.content.Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://www.osgeo.org/resources/")
            startActivity(myWebLink)
        }

        val curriculum = findViewById(R.id.initiatives) as Button
        curriculum.setOnClickListener {
            val myWebLink = Intent(android.content.Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://www.osgeo.org/initiatives/geo-for-all/")
            startActivity(myWebLink)
        }

        val contactus = findViewById(R.id.about) as Button
        contactus.setOnClickListener {
            val myWebLink = Intent(android.content.Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://www.osgeo.org/about/")
            startActivity(myWebLink)
        }


    }
}
