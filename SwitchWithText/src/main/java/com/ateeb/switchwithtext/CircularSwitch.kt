package com.ateeb.switchwithtext

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout

class CircularSwitch : ConstraintLayout {

    lateinit var onButton: Button
    lateinit var offButton: Button

    constructor(context: Context) : super(context) {
        initLayout(context)
    }

    fun initLayout(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_switch_layout, this)
        onButton = findViewById(R.id.on)
        offButton = findViewById(R.id.off)
        setInitLayout()
    }

    private fun setInitLayout() {
        onButton.setTextColor(resources.getColor(R.color.green))
        offButton.setTextColor(resources.getColor(R.color.grey))
        onButton.background = resources.getDrawable(R.drawable.background_card)
        offButton.background = resources.getDrawable(R.drawable.background_button_not_selected)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initLayout(context)
    }

    fun setOnButton(text: String, onClickListener:  View.OnClickListener) {
        onButton.setText(text)
        onButton.setOnClickListener {
            onClickListener.onClick(it)
            onButton.setTextColor(resources.getColor(R.color.green))
            offButton.setTextColor(resources.getColor(R.color.grey))
            onButton.background = resources.getDrawable(R.drawable.background_card)
            offButton.background = resources.getDrawable(R.drawable.background_button_not_selected)
        }
    }

    fun setOffButton(text: String,onClickListener: (view: View) -> Unit) {
        offButton.setText(text)
        offButton.setOnClickListener {
            onClickListener.invoke(it)
            offButton.setTextColor(resources.getColor(R.color.green))
            onButton.setTextColor(resources.getColor(R.color.grey))
            offButton.background = resources.getDrawable(R.drawable.background_card)
            onButton.background = resources.getDrawable(R.drawable.background_button_not_selected)
        }
    }
}