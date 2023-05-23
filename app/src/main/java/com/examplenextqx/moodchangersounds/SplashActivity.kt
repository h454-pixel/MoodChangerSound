package com.examplenextqx.moodchangersounds

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.examplenextqx.moodsoundkotlin.R


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {


    var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        handler = Handler()
        handler!!.postDelayed({
            val intent = Intent(this@SplashActivity, EntryActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}