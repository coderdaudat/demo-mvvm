package com.example.demomvvm.features.username

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.demomvvm.R
import com.example.demomvvm.utils.obtainViewModel
import com.example.demomvvm.utils.replaceFragmentInActivity
import com.example.demomvvm.utils.setupActionBar



/**
 * Displays edit full name screen.
 */

class EditUserNameActivity : AppCompatActivity(), EditUserNameNavigator {

    private val args by lazy {
        EditUserNameActivityArgs.deserializeFrom(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onUserNameSaved(userName: String) {
        val intent = Intent()
        intent.putExtra(EditUserNameFragment.ARGUMENT_DISPLAY_NAME, userName)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user_name)

        setupActionBar(R.id.toolbar) {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        replaceFragmentInActivity(obtainViewFragment(), R.id.contentFrame)

        subscribeToNavigationChanges()

    }

    private fun subscribeToNavigationChanges() {
        // The activity observes the navigation events in the ViewModel
        obtainViewModel().userNameUpdatedEvent.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
                this@EditUserNameActivity.onUserNameSaved(it)
            }
        })
    }

    private fun obtainViewFragment() =
        supportFragmentManager.findFragmentById(R.id.contentFrame) ?: EditUserNameFragment.newInstance().apply {
            arguments = Bundle().apply {
                putString(
                    EditUserNameFragment.ARGUMENT_DISPLAY_NAME,
                    args.userName
                )
            }
        }

    fun obtainViewModel(): EditUserNameViewModel = obtainViewModel(EditUserNameViewModel::class.java)

}