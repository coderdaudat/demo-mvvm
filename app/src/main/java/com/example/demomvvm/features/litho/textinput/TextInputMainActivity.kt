package com.example.demomvvm.features.litho.textinput

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demomvvm.features.litho.helloworld.RootComponent
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView

class TextInputMainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val componentContext = ComponentContext(this)
        setContentView(
            LithoView.create(
                this,
                TextInputRootComponent.create(componentContext).build()
            )
        )
    }
}