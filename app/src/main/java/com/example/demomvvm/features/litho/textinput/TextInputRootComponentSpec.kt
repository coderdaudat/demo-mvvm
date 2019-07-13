package com.example.demomvvm.features.litho.textinput

import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout

@LayoutSpec
object TextInputRootComponentSpec {
    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext): Component {
        return TimeConverter.create(c).textInputKey("text_input").build()
    }
}