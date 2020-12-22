package com.example.apitest.forms

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import com.example.apitest.common.Event

data class CardForm(var cardNumber: String = "") {
    var cardNumberError = MutableLiveData<Event<@StringRes Int>>()
}