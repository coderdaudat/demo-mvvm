package com.example.demomvvm.features.litho.textinput

import android.content.Context
import androidx.annotation.UiThread
import com.facebook.litho.ComponentContext
import com.facebook.litho.ComponentLayout
import com.facebook.litho.Size
import com.facebook.litho.annotations.*

@MountSpec(isPureRender = true)
object ClockSpec {

    @OnMeasure
    fun onMeasure(
        context: ComponentContext,
        layout: ComponentLayout,
        widthSpec: Int,
        heightSpec: Int,
        size: Size,
        @Prop radius: Int
    ) {
        size.width = radius * 2
        size.height = radius * 2
    }

    @UiThread
    @OnCreateMountContent
    fun onCreateMountContent(c: Context): ClockDrawable {
        return ClockDrawable()
    }

    @UiThread
    @OnMount
    fun onMount(
        context: ComponentContext,
        mounterdDrawable: ClockDrawable,
        @Prop radius: Int,
        @Prop timeMillis: Long
    ) {
        mounterdDrawable.radius = radius
        mounterdDrawable.setTime(timeMillis)
    }
}