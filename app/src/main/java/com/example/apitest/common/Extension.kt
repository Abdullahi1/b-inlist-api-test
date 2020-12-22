package com.example.apitest.common

import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.snackbar.Snackbar

fun LifecycleOwner.showSnackWithAction(
    message: String,
    view: View,
    lengthLong: Boolean = true,
    actionMessage: String,
    action: (v: View) -> Unit
) {
    val length = if (lengthLong) Snackbar.LENGTH_LONG else Snackbar.LENGTH_SHORT
    Snackbar.make(view, message, length)
        .setActionTextColor(ContextCompat.getColor(view.context, android.R.color.holo_orange_light))
        .setAction(actionMessage, action)
        .show()
}