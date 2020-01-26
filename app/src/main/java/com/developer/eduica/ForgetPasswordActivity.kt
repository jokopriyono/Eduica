package com.developer.eduica

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_forget_password.*

class ForgetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        btn_send.setOnClickListener {
            showDialog()
        }
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val root = window.decorView.findViewById<ConstraintLayout>(R.id.parent_view)
        val viewDialogForget = inflater.inflate(R.layout.dialog_forget_password, root, false)
        val imgDone = viewDialogForget.findViewById<ImageView>(R.id.img_done)

        imgDone.setOnClickListener {
            finish()
        }

        dialogBuilder.setView(viewDialogForget)
        dialogBuilder.setCancelable(false)
        val dialog = dialogBuilder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
    }
}
