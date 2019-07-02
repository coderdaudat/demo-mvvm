package com.example.demomvvm.features.username

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demomvvm.event.Event


/**
 * ViewModel for the Edit Display Name screen.
 *
 *
 * This ViewModel only exposes [ObservableField]s, so it doesn't need to extend
 * [androidx.databinding.BaseObservable] and updates are notified automatically.
 */
class EditUserNameViewModel : ViewModel() {

    // Two-way databinding, exposing MutableLiveData
    val userName = MutableLiveData<String>()

    private val _userNameUpdated = MutableLiveData<Event<String>>()
    val userNameUpdatedEvent: LiveData<Event<String>>
        get() = _userNameUpdated

    fun start(userName: String?) {
        this.userName.value = userName
    }

    // Called when clicking on fab.
    internal fun saveUserName() {
        _userNameUpdated.value = Event(userName.value.toString())
    }

}
