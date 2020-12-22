package com.example.apitest.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apitest.R
import com.example.apitest.common.Event
import com.example.apitest.common.LiveEvent
import com.example.apitest.common.MutableLiveEvent
import com.example.apitest.forms.CardForm
import com.example.domain.cardInfo.GetCardInfoUseCase
import com.example.domain.common.invoke
import com.example.domain.model.CardInfo
import com.example.domain.network.CheckInternetUseCase
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val checkInternetUseCase: CheckInternetUseCase,
    private val getCardInfoUseCase: GetCardInfoUseCase
) : ViewModel() {

    private val _loading = MutableLiveEvent<Boolean>()
    val loading: LiveEvent<Boolean> = _loading

    private val _internetResult = MutableLiveEvent<Unit>()
    val internetResult: LiveEvent<Unit> = _internetResult

    private val _cardInfoResult = MutableLiveEvent<CardInfo>()
    val cardInfoResult: LiveEvent<CardInfo> = _cardInfoResult

    private val _showResult = MutableLiveEvent<Boolean>()
    val showResult: LiveEvent<Boolean> = _showResult

    private val _showError = MutableLiveEvent<Boolean>()
    val showError: LiveEvent<Boolean> = _showError

    private val _errorMessage = MutableLiveEvent<String>()
    val errorMessage: LiveEvent<String> = _errorMessage

    var form = CardForm()

    init {
        hideCards()
    }

    fun onButtonClicked() {
        hideCards()
        if (isFormFilled(form)) {
            if (checkInternetUseCase()) {
                fetchCardDetails()
            } else {
                _internetResult.value = Event(Unit)
            }
        } else {
            postFormError(form)
        }

    }

    private fun postFormError(form: CardForm) {
        with(form) {
            when {
                cardNumber.isEmpty() -> cardNumberError.value = Event(R.string.card_number_empty)
                cardNumber.length < 6 -> cardNumberError.value =
                    Event(R.string.card_number_length_error)
            }
        }
    }

    private fun hideCards() {
        _showError.value = Event(false)
        _showResult.value = Event(false)
    }

    private fun fetchCardDetails() {
        viewModelScope.launch {
            hideCards()
            _loading.value = Event(true)

            val result = getCardInfoUseCase(param = form.cardNumber)

            _loading.value = Event(false)

            if (result.isSuccess()) {
                val cardInfo = result.data!!
                _showResult.value = Event(true)
                _cardInfoResult.value = Event(cardInfo)
            } else {
                _showError.value = Event(true)
                _errorMessage.value = Event(result.message)
            }
        }
    }

    private fun isFormFilled(form: CardForm): Boolean =
        form.cardNumber.isNotEmpty() && form.cardNumber.length >= 6
}