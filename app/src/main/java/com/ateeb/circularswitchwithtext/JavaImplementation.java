package com.ateeb.circularswitchwithtext;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.ateeb.switchwithtext.CircularSwitch;

public class JavaImplementation extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    CircularSwitch circularSwitch;
    private void init() {
        circularSwitch = findViewById(R.id.circle_center);

        circularSwitch.setActiveButtonColor(ResourcesCompat.getColor(getResources(),R.color.grey,null));
        circularSwitch.setInActiveNegativeButtonColor(ResourcesCompat.getColor(getResources(),R.color.grey,null));
        circularSwitch.setInActivePositiveButtonColor(ResourcesCompat.getColor(getResources(),R.color.grey,null));
        circularSwitch.setPostiveActive(false);

        circularSwitch.setOnButton("On",openOn);
        circularSwitch.setOffButton("Off",openOn);


    }

    private View.OnClickListener openOn = new View.OnClickListener() {
        public void onClick(View v) {
            //todo add logic here
        }
    };

    private View.OnClickListener openOff = new View.OnClickListener() {
        public void onClick(View v) {
            //todo add logic here
        }
    };
}
