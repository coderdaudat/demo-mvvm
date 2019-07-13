package com.example.demomvvm.features.litho.state

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.facebook.litho.ComponentContext
import com.facebook.litho.ComponentTree
import com.facebook.litho.LithoView

class StateMainActivity : AppCompatActivity() {

    var mComponentTree: ComponentTree? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mStateHandlerViewModel = ViewModelProviders.of(this).get(StateHandlerViewModel::class.java)
        val componentContext = ComponentContext(this)

        mComponentTree = ComponentTree.create(componentContext, StateRootComponent.create(componentContext).build())
            .stateHandler(mStateHandlerViewModel.getStateHandlerData())
            .build()

        val lithoView = LithoView(componentContext)
        lithoView.componentTree = mComponentTree
        setContentView(lithoView)
    }

    override fun onDestroy() {
        super.onDestroy()
        val mStateHandlerViewModel = ViewModelProviders.of(this).get(StateHandlerViewModel::class.java)
        mStateHandlerViewModel.updateStateHandler(mComponentTree)
    }
}