package com.example.demomvvm.features.litho.helloworld

import androidx.annotation.LayoutRes
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.widget.Text

@LayoutSpec
object RootComponentSpec {

    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext): Component {
        return Text.create(c).textSizeSp(20f).text("Hello World").build()
    }

}