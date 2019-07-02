package com.example.demomvvm.features.username

import android.content.Context
import android.content.Intent
import com.example.demomvvm.features.ActivityArgs

private const val EXTRA_USER_NAME = "EXTRA_USER_NAME"

/**
 * Arguments to launch [EditUserNameActivityArgs]
 */
data class EditUserNameActivityArgs(
    val userName: String?
) : ActivityArgs {

    override fun intent(activity: Context): Intent = Intent(
        activity, EditUserNameActivity::class.java
    ).apply {
        putExtra(EXTRA_USER_NAME, userName)
    }

    companion object {
        fun deserializeFrom(intent: Intent): EditUserNameActivityArgs {
            return EditUserNameActivityArgs(
                userName = intent.getStringExtra(EXTRA_USER_NAME)
            )
        }
    }
}