package com.developer.eduica

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*
import org.jetbrains.anko.startActivity

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        img_button.setOnClickListener {
            startActivity<OnboardingActivity>()
            finish()
        }

    }
}
