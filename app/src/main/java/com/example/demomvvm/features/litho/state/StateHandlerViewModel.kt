package com.example.demomvvm.features.litho.state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.litho.ComponentTree
import com.facebook.litho.StateHandler

class StateHandlerViewModel : ViewModel() {
    val stateHandlerData: MutableLiveData<StateHandler> = MutableLiveData()

    fun getStateHandlerData(): StateHandler? {
        return stateHandlerData.value
    }

    fun updateStateHandler(componentTree: ComponentTree?) {
        if (componentTree != null) {
            stateHandlerData.value = componentTree.acquireStateHandler()
        }
    }
}