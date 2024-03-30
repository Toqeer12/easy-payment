package com.hexabyteds.easy_payment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil

object HelloWorld {

    fun printLog(tag: String?, message: String?) {
        Log.d(
            tag, message!!
        )
    }

    fun showDialog(context: Context) {

        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout, null)
        val phoneNumberUtil = PhoneNumberUtil.getInstance()

        // Create a BottomSheetDialog
        val bottomSheetDialog = BottomSheetDialog(context)

        // Set the content view of the dialog to the inflated layout
        bottomSheetDialog.setContentView(view)

        // Handle click event of the "Retry" button
        view.findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            // Handle retry action here if needed
            val etMobileNumber = view.findViewById<TextInputEditText>(R.id.etMobileNumber)

            val mobileNumber = etMobileNumber.text.toString()

            val etEmailAddresss = view.findViewById<TextInputEditText>(R.id.etEmailAddress)

            val emailAdress = etEmailAddresss.text.toString()
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAdress).matches()) {
                // Email address is not valid
                // Handle invalid email address
                // For example, show an error message
                etEmailAddresss.error = "Invalid email address"
                return@setOnClickListener
            }


            try {
                val isoCode = phoneNumberUtil.getRegionCodeForCountryCode("+92".toInt())
                val parsedPhoneNumber = phoneNumberUtil.parse(
                    "+92$mobileNumber", isoCode
                    )
                if (!phoneNumberUtil.isValidNumber(parsedPhoneNumber)) {
                    // Phone number is not valid
                    // Handle invalid phone number
                    // For example, show an error message
                    etMobileNumber.error = "Invalid phone number"
                    return@setOnClickListener
                }
            } catch (e: NumberParseException) {
                // Parsing error
                // Handle parsing error
                e.printStackTrace()
                return@setOnClickListener
            }

            Log.d(
                "email", mobileNumber
            )

            Log.d(
                "email", emailAdress
            )
            bottomSheetDialog.dismiss() // Dismiss the bottom sheet
        }
        view.findViewById<ImageView>(R.id.imageViewCross).setOnClickListener{

            bottomSheetDialog.dismiss()
        }



        // Show the bottom sheet
        bottomSheetDialog.show()

    }

}
