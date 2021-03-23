package com.mvvmwithhilt.module.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mvvmwithhilt.R
import com.mvvmwithhilt.module.homeScreen.HomeScreenActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        /**splash_img size is more than 3MB. So if we set this image directly in xml, some time rendering exception will occur in low level device that's
        why we used glide for set the image here**/
        Glide.with(this).load(R.drawable.splash_img).into(findViewById(R.id.image_view))

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(
                Intent(
                    this@SplashScreenActivity,
                    HomeScreenActivity::class.java
                )
            )
        }, 3000)
    }

}