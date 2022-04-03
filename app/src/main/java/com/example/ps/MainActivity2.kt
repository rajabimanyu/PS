package com.example.ps

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    var view: View = findViewById(R.id.accelerate)
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        toast()
        listing(3)

        view.viewExtension()


        var i: Int = 0
        repeat(10) {
            GlobalScope.launch {
                println("${++i}: ${Thread.currentThread().name}")
            }
        }
    }
}