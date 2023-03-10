package com.example.pmu_lab3

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class TransitionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        val imageView: ImageView = findViewById(R.id.transition_image)
        val transitionDrawable = imageView.drawable as TransitionDrawable

        val startTransition: Button = findViewById(R.id.start_transition)
        val reverseTransition: Button = findViewById(R.id.reverse_transition)

        startTransition.setOnClickListener {
            transitionDrawable.startTransition(1000)
        }

        reverseTransition.setOnClickListener {
            transitionDrawable.reverseTransition(1000)
        }
    }
}