package com.developer.eduica

import android.content.Intent
import android.os.Bundle
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import org.jetbrains.anko.toast

class AuthActivity : AppCompatActivity() {

    private var isSignIn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        showSignIn()

        txt_sign_in.setOnClickListener {
            isSignIn = true
            showSignIn()
        }

        txt_sign_up.setOnClickListener {
            isSignIn = false
            showSignUp()
        }

        btn_sign.setOnClickListener {
            if (isSignIn) signInValidation()
        }
    }

    private fun signInValidation() {
        val username = "siswa123"
        val password = "eduica123"

        val inputanUsername = edt_username.text.toString().trim()
        val inputanPassword = edt_password.text.toString().trim()

        if (inputanUsername == username && inputanPassword == password) {
            val intent = Intent(applicationContext, SelectAccountActivity::class.java)
            startActivity(intent)
        } else {
            toast("Username atau password tidak sesuai!")
        }
    }

    private fun showSignIn() {
        highlight_sign_up.visibility = INVISIBLE
        highlight_sign_in.visibility = VISIBLE
        input_username.visibility = VISIBLE
        input_email.visibility = GONE
        input_password.visibility = VISIBLE
        input_confirm_password.visibility = GONE
        checkbox_remember.visibility = VISIBLE
        txt_forget_password.visibility = VISIBLE
        btn_sign.text = getString(R.string.sign_in)
        txt_login_with.visibility = VISIBLE
        line_left.visibility = VISIBLE
        line_right.visibility = VISIBLE
        text_1.visibility = GONE
        text_2.visibility = GONE
        text_3.visibility = GONE
        text_4.visibility = GONE
        img_facebook.visibility = VISIBLE
        img_google.visibility = VISIBLE
    }

    private fun showSignUp() {
        highlight_sign_up.visibility = VISIBLE
        highlight_sign_in.visibility = INVISIBLE
        input_username.visibility = VISIBLE
        input_email.visibility = VISIBLE
        input_password.visibility = VISIBLE
        input_confirm_password.visibility = VISIBLE
        checkbox_remember.visibility = GONE
        txt_forget_password.visibility = GONE
        btn_sign.text = getString(R.string.sign_up)
        txt_login_with.visibility = GONE
        line_left.visibility = GONE
        line_right.visibility = GONE
        text_1.visibility = VISIBLE
        text_2.visibility = VISIBLE
        text_3.visibility = VISIBLE
        text_4.visibility = VISIBLE
        img_facebook.visibility = GONE
        img_google.visibility = GONE

    }
}
