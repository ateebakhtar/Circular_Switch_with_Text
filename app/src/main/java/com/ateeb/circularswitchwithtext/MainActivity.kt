package com.ateeb.circularswitchwithtext

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
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

        circularSwitch.activeButtonColor = ResourcesCompat.getColor(resources, R.color.grey, null)
        circularSwitch.inActiveNegativeButtonColor = ResourcesCompat.getColor(resources, R.color.grey, null)
        circularSwitch.inActivePositiveButtonColor = ResourcesCompat.getColor(resources, R.color.grey, null)
        circularSwitch.postiveActive = false
    }
}