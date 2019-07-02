package com.example.demomvvm.features

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

interface ActivityArgs {

    /**
     * @return returns an intent that can be used to launch this activity.
     */
    fun intent(activity: Context): Intent

    /**
     * Launches the activity given your activity context.
     *
     * The default implementation uses the intent generated from [intent]
     */
    fun launch(activity: Context) = activity.startActivity(intent(activity))

    fun launchActivityForResult(activity: Activity, requestCode: Int) =
        activity.startActivityForResult(intent(activity), requestCode)

    fun launchActivityForResult(fragment: Fragment, requestCode: Int) =
        fragment.startActivityForResult(intent(fragment.activity!!), requestCode)
}