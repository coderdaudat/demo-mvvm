package com.example.demomvvm.features.litho.state

import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.OnUpdateState
import com.facebook.litho.annotations.State
import com.facebook.litho.ClickEvent
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.StateValue
import com.facebook.litho.widget.Text

@LayoutSpec
object StateRootComponentSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @State counter: Int
    ): Component {
        return Column
            .create(c)
            .child(
                Text
                    .create(c)
                    .textSizeSp(20f)
                    .text("Click to increment")
                    .clickHandler(StateRootComponent.onClick(c))
                    .build()
            )
            .child(
                Text
                    .create(c)
                    .textSizeSp(20f)
                    .text(counter.toString())
                    .build()
            )
            .build()
    }

    @OnEvent(ClickEvent::class)
    fun onClick(c: ComponentContext) {
        StateRootComponent.increment(c)
    }

    @OnUpdateState
    fun increment(counter: StateValue<Int>) {
        val counterVal = counter.get()
        counter.set(counterVal!!.plus(1))
    }
}