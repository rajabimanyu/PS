package com.example.ps

import android.content.Context
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

@RequiresApi(Build.VERSION_CODES.P)
fun Context.toast(){
    val a = this.applicationContext.applicationInfo.appComponentFactory

}

fun AppCompatActivity.listing(id: Int){

}

fun View.viewExtension(){
    this.alpha = 0.0F
}
class Utils {


}