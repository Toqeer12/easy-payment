package com.hexabyteds.easy_payment

import android.util.Log

object HelloWorld {
    @JvmStatic
    fun main(args: Array<String>) {
    }

    fun printLog(tag: String?, message: String?) {
        Log.d(
            tag, message!!
        )
    }
}
