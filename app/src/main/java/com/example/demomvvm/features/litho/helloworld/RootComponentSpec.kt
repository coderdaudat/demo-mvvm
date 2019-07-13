package com.example.demomvvm.features.litho.helloworld

import android.graphics.Color
import androidx.annotation.LayoutRes
import com.example.demomvvm.R
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
import kotlinx.android.synthetic.main.activity_main.view.*

@LayoutSpec
object RootComponentSpec {

    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext,
                       @Prop
                       content: String): Component {
        return Text
            .create(c)
            .textColor(Color.RED)
            .textSizeSp(c.applicationContext.resources.getDimension(R.dimen.text_size))
            .text(content)
            .build()
    }

}