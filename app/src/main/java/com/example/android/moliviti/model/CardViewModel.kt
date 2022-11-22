package com.example.android.moliviti.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class CardViewModel : ViewModel() {

    private val _chargeValue = MutableLiveData<Int>()
    val chargeValue: LiveData<String> = Transformations.map(_chargeValue) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _id = MutableLiveData<Long>()
    val id: LiveData<Long> = _id

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _privacyCheck = MutableLiveData<Boolean>()
    val privacyCheck: LiveData<Boolean> = _privacyCheck

    init {
        _chargeValue.value = 0
        _privacyCheck.value = false
    }

    fun setChargeValue(chargeValue: Int) {
        _chargeValue.value = chargeValue
    }

    fun setNameValue(name: String) {
        _name.value = name
    }

    fun setIdValue(id: Long) {
        _id.value = id
    }

    fun setEmailValue(email: String) {
        _email.value = email
    }

    fun checkFields(): Boolean {
        return _chargeValue.value != null && _chargeValue.value != 0 && !name.value.isNullOrEmpty() && id.value != null && id.value != 0L && !email.value.isNullOrEmpty()
    }

    fun checkPrivacyPolicy(checkStatus: Boolean) {
        _privacyCheck.value = checkStatus
    }


}