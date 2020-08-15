package com.developer.eduica

import android.content.Intent
import android.os.Bundle
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.developer.eduica.models.bodies.LoginBody
import com.developer.eduica.models.responses.LoginResponse
import kotlinx.android.synthetic.main.activity_auth.*
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthActivity : AppCompatActivity() {

    private var isSignIn = true
    private val client = ApiClient().getRetrofit().create(ApiService::class.java)

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
        txt_forget_password.setOnClickListener {
            startActivity(Intent(this, ForgetPasswordActivity::class.java))
        }
    }

    private fun signInValidation() {
        val inputanUsername = edt_username.text.toString().trim()
        val inputanPassword = edt_password.text.toString().trim()

        if (inputanUsername.isNotEmpty() && inputanPassword.isNotEmpty()) {
            val body = LoginBody(email = inputanUsername, password = inputanPassword)
            val callLogin = client.login(body)
            callLogin.enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // gagal disini
                    toast(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    // sukses disini
                    if (response.isSuccessful) {
                        val res = response.body()?.dataLogin
                        defaultSharedPreferences.edit {
                            putBoolean("isLogged", true)
                            putString("token", res?.token?.accessToken)
                            putString("idUser", res?.idUser.toString())
                            putString("email", res?.email)
                            putString("fullName", res?.fullName)
                            putString("userName", res?.username)
                            apply()
                        }
                        val intent = Intent(applicationContext, AccountActivity::class.java)
                        startActivity(intent)
                    } else {
                        response.body()?.let {
                            longToast("Gagal login: ${it.code}")
                        }
                        if (response.body() == null) {
                            longToast("Response body null")
                        }
                    }
                }

            })

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
