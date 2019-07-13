package com.example.demomvvm.features.litho.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demomvvm.R
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView

class LithoMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            LithoView.create(
                this,
                RootComponentSpec.onCreateLayout(ComponentContext(this), getString(R.string.app_name))))
    }
}