package com.example.demomvvm.features.litho.state2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demomvvm.features.litho.helloworld.RootComponent
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView

class State2MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val componentContext = ComponentContext(this)
        setContentView(
            LithoView.create(
                this,
                State2RootComponent.create(componentContext).startCount(5).build()
            )
        )
    }

}