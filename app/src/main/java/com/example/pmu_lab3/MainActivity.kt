package com.example.pmu_lab3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pmu_lab3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    open fun onButton_1(){

    }

    open fun onButton_2(){
        val intent = Intent(this@MainActivity, second_view::class.java)
        startActivity(intent)
    }
}