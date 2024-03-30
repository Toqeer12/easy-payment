package com.hexabyteds.easy_payment

import com.google.android.material.bottomsheet.BottomSheetDialogFragment


interface BottomSheetListener {
    fun onAction1()
    fun onAction2()
}


class CustomBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private var listener: BottomSheetListener? = null

    fun setListener(listener: BottomSheetListener) {
        this.listener = listener
    }

}