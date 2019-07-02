package com.example.demomvvm.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.demomvvm.R
import com.example.demomvvm.features.username.EditUserNameActivityArgs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<AppCompatButton>(R.id.button_next_activity).setOnClickListener {
            EditUserNameActivityArgs(getString(R.string.main_user_name_default)).launch(this)
        }
    }
}
