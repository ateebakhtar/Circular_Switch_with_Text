package com.ateeb.switchwithtext

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class CircularSwitch : ConstraintLayout {

    var onButton: Button? = null
    var offButton: Button? = null

    var inActiveNegativeButtonColor: Int = R.color.grey
        set(value) {
            field = value
            onButton?.setTextColor(value)
        }
    var inActivePositiveButtonColor: Int = R.color.grey
        set(value) {
            field = value
            offButton?.setTextColor(value)
        }
    var activeButtonColor: Int = R.color.green
        set(value) {
            field = value
            setInitLayout()
        }
    var postiveActive: Boolean = true
        set(value) {
            field = value
            setInitLayout()
        }

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
        if(postiveActive) {
            onButton?.let {
                it.setTextColor(activeButtonColor)
                it.background = ContextCompat.getDrawable(context,R.drawable.background_card)
            }
            offButton?.let {
                it.setTextColor(inActiveNegativeButtonColor)
                it.background = ContextCompat.getDrawable(context,R.drawable.background_button_not_selected)
            }
        } else {
            onButton?.let {
                it.setTextColor(inActivePositiveButtonColor)
                it.background = ContextCompat.getDrawable(context,R.drawable.background_button_not_selected)
            }
            offButton?.let {
                it.setTextColor(activeButtonColor)
                it.background = ContextCompat.getDrawable(context,R.drawable.background_card)
            }
        }

    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        attrs?.let {
            try {
                val attributes = context.obtainStyledAttributes(it,R.styleable.CircularSwitch)
                inActiveNegativeButtonColor = attributes.getColor(R.styleable.CircularSwitch_negativeButtonTextColorForInactive,ResourcesCompat.getColor(resources,R.color.grey,null))
                inActivePositiveButtonColor = attributes.getColor(R.styleable.CircularSwitch_positiveButtonTextColorForInactive,ResourcesCompat.getColor(resources,R.color.grey,null))
                activeButtonColor = attributes.getColor(R.styleable.CircularSwitch_activeButtonTextColor,ResourcesCompat.getColor(resources,R.color.green,null))
                postiveActive = attributes.getBoolean(R.styleable.CircularSwitch_setPositiveAsActive,true)
                attributes.recycle()

            } catch (ex : Exception) {
                ex.printStackTrace()
            }
        }
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        attrs?.let {
            try {
                val attributes = context.obtainStyledAttributes(it,R.styleable.CircularSwitch,0,0)
                inActiveNegativeButtonColor = attributes.getColor(R.styleable.CircularSwitch_negativeButtonTextColorForInactive,ResourcesCompat.getColor(resources,R.color.grey,null))
                inActivePositiveButtonColor = attributes.getColor(R.styleable.CircularSwitch_positiveButtonTextColorForInactive,ResourcesCompat.getColor(resources,R.color.grey,null))
                activeButtonColor = attributes.getColor(R.styleable.CircularSwitch_activeButtonTextColor,ResourcesCompat.getColor(resources,R.color.green,null))
                attributes.recycle()
            } catch (ex : Exception) {
                ex.printStackTrace()
            }
        }
        initLayout(context)
    }

    fun setOnButton(text: String, onClickListener:  View.OnClickListener) {
        if(onButton != null && offButton != null) {
            onButton!!.setText(text)
            onButton!!.setOnClickListener {
                onClickListener.onClick(it)
                onButton!!.setTextColor(activeButtonColor)
                offButton!!.setTextColor(inActiveNegativeButtonColor)
                onButton!!.background = ResourcesCompat.getDrawable(resources,R.drawable.background_card,null)
                offButton!!.background = ResourcesCompat.getDrawable(resources,R.drawable.background_button_not_selected,null)
            }
        }
    }

    fun setOffButton(text: String,onClickListener:  View.OnClickListener) {
        if(onButton != null && offButton != null) {
            offButton!!.setText(text)
            offButton!!.setOnClickListener {
                onClickListener.onClick(it)
                offButton!!.setTextColor(activeButtonColor)
                onButton!!.setTextColor(inActivePositiveButtonColor)
                offButton!!.background = ResourcesCompat.getDrawable(resources,R.drawable.background_card,null)
                onButton!!.background = ResourcesCompat.getDrawable(resources,R.drawable.background_button_not_selected,null)
            }
        }
    }
}