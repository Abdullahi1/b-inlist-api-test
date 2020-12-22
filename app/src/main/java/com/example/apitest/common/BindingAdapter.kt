package com.example.apitest.common

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("visibleGone")
    fun setVisibility(view: View, value: Boolean?) {
        value?.let {
            if (value)
                view.visibility = View.VISIBLE
            else
                view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("visibleGone")
    fun setVisibility(view: View, value: Event<Boolean>?) {
        value?.let {
            if (value.peekContent())
                view.visibility = View.VISIBLE
            else
                view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("visibleInvisible")
    fun setVisible(view: View, value: Boolean?) {
        value?.let {
            if (value)
                view.visibility = View.VISIBLE
            else
                view.visibility = View.INVISIBLE
        }
    }


    @JvmStatic
    @BindingAdapter("error")
    fun setError(view: View, errorMessage: Event<Int>?) {
        if (errorMessage != null && !errorMessage.hasBeenHandled) {
            val error = view.context.getString(errorMessage.peekContent())

            when (view) {
                is TextInputLayout -> view.error = error
                is TextInputEditText -> view.error = error
                else -> Snackbar.make(view, error, Snackbar.LENGTH_LONG).show()
            }
        } else {
            when (view) {
                // TextInputLayout error doesn't clear automatically unlike TextInputEditText
                is TextInputLayout -> view.error = null
            }
        }
    }

}