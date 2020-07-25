package com.developer.eduica

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        txt_add_account.setOnClickListener {
            startActivity(Intent(applicationContext, AddAccountActivity::class.java))
        }
    }
}
