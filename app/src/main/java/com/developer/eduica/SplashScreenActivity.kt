package com.developer.eduica

import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.startActivity

class SplashScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val isLogged = defaultSharedPreferences.getBoolean("isLogged", false)

        Handler().postDelayed({
            if (isLogged) {
                startActivity<AccountActivity>()
            } else {
                startActivity<WelcomeActivity>()
            }
            finish()

        }, 2000)

    }
}
