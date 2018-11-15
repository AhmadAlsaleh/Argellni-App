package com.crazyiter.android.argellni

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.crazyiter.android.argellni.Dialogs.ChangePasswordDialog
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.profileNameIV -> setEdit(profileNameIV, profileNameET, profileNameOldTV, profileNameTV)
            R.id.profilePhoneIV -> setEdit(profilePhoneIV, profilePhoneET, profilePhoneOldTV, profilePhoneTV)
            R.id.profileEmailIV -> setEdit(profileEmailIV, profileEmailET, profileEmailOldTV, profileEmailTV)
            R.id.profileSaveBTN -> saveNewInfo()
            R.id.profileCancelBTN -> clearNewData()
            R.id.profileChangePasswordLL -> ChangePasswordDialog(this).show()
        }
    }

    private fun clearNewData() {
        profileChangePasswordLL.visibility = View.GONE
        setEdit(profileNameIV, profileNameET, profileNameOldTV, profileNameTV, true)
        setEdit(profilePhoneIV, profilePhoneET, profilePhoneOldTV, profilePhoneTV, true)
        setEdit(profileEmailIV, profileEmailET, profileEmailOldTV, profileEmailTV, true)
    }

    private fun setEdit(imageView: ImageView?, editText: EditText?, oldTV: TextView?, textView: TextView?, isCancel: Boolean = false) {
        if (editText?.visibility == View.GONE && !isCancel) {
            editText.visibility = View.VISIBLE
            editText.setText("")
            imageView?.setImageResource(R.drawable.ic_close)
            textView?.visibility = View.GONE
            oldTV?.text = textView?.text.toString()
            profileChangePasswordLL.visibility = View.VISIBLE
        } else {
            editText?.visibility = View.GONE
            editText?.setText("")
            imageView?.setImageResource(R.drawable.ic_edit)
            textView?.visibility = View.VISIBLE
            oldTV?.text = ""
            checkBTNsLL()
        }
    }

    private fun checkBTNsLL() {
        if (!(profileNameET.visibility == View.VISIBLE ||
                profilePhoneET.visibility == View.VISIBLE ||
                profileEmailET.visibility == View.VISIBLE)) {
            profileChangePasswordLL.visibility = View.GONE
        }
    }

    private fun saveNewInfo() {
        var newName = profileNameTV.text.toString()
        var newPhone = profilePhoneTV.text.toString()
        var newEmail = profileEmailTV.text.toString()
        when (View.VISIBLE) {
            profileNameET.visibility -> if (profileNameET.text.isNotEmpty()) {
                newName = profileNameET.text.toString()
            } else {
                Toast.makeText(this, "Enter Name Please",Toast.LENGTH_SHORT).show()
                return
            }
            profilePhoneET.visibility -> if (PrimaryMethods.isPhone(profilePhoneET.text.toString())) {
                newPhone = profilePhoneET.text.toString()
            } else {
                Toast.makeText(this, "Incorrect Phone Number",Toast.LENGTH_SHORT).show()
                return
            }
            profileEmailET.visibility -> if (PrimaryMethods.isEmail(profileEmailET.text.toString())) {
                newEmail = profileEmailET.text.toString()
            } else {
                Toast.makeText(this, "Incorrect Email Address",Toast.LENGTH_SHORT).show()
                return
            }
        }

        // TODO SEND DATA
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        onClickListeners()

    }

    private fun onClickListeners() {
        profileNameIV.setOnClickListener(this)
        profilePhoneIV.setOnClickListener(this)
        profileEmailIV.setOnClickListener(this)
        profileSaveBTN.setOnClickListener(this)
        profileCancelBTN.setOnClickListener(this)
        profileChangePasswordLL.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}
