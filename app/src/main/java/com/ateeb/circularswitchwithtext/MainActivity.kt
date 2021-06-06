package com.ateeb.circularswitchwithtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ateeb.switchwithtext.CircularSwitch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val circularSwitch = findViewById<CircularSwitch>(R.id.circle_center)
        circularSwitch.setOffButton("Post") {
            Toast.makeText(this, "Post", Toast.LENGTH_SHORT).show()
        }
        circularSwitch.setOnButton("Photos") {
            Toast.makeText(this, "Photos", Toast.LENGTH_SHORT).show()
        }
    }
}