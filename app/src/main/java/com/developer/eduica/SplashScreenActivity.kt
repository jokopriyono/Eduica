package com.developer.eduica

import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class SplashScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//        Fonty.setFonts(this)

        Handler().postDelayed({
            //            val intent = Intent(this, WelcomeActivity::class.java)
//            startActivity(intent)
            startActivity<WelcomeActivity>()
            finish()

        }, 2000)

    }
}
