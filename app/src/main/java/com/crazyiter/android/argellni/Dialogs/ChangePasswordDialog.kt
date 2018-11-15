package com.crazyiter.android.argellni.Dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.crazyiter.android.argellni.R
import kotlinx.android.synthetic.main.dialog_change_password.*

class ChangePasswordDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_change_password)

        changePasswordSaveBTN.setOnClickListener {
            if (changePasswordOldPasswordET.text.length < 6) {
                Toast.makeText(context, "Incorrect Old Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (changePasswordNewPasswordET.text.length < 6) {
                Toast.makeText(context, "Password have to be 6 Characters at least", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            changePassword()
        }
    }

    private fun changePassword() {
        Toast.makeText(context, "TODO", Toast.LENGTH_SHORT).show()
    }

}