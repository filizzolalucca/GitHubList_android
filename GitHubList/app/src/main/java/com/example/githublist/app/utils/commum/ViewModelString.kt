package com.example.githublist.app.utils.commum

import android.content.Context
import androidx.annotation.StringRes

class ViewModelString {

    private var string: String? = null
    private var resource: Int? = null
    private var arguments: Array<out Any>? = null
    private var exception: Exception? = null

    constructor(@StringRes value: Int) {
        resource = value
    }

    constructor(@StringRes value: Int, e: Exception) {
        resource = value
        exception = e
    }

    constructor(value: String) {
        string = value
    }

    fun setValue(@StringRes value: Int) {
        string = null
        resource = value
    }

    fun setValue(value: String, vararg args: Any) {
        resource = null
        string = value
        arguments = args
    }

    fun getValue(context: Context): String {
        return if (string != null) {
            string!!
        } else {
            if (arguments != null && arguments?.isNotEmpty() == true) {
                context.getString(resource!!, arguments)
            } else {
                context.getString(resource!!)
            }
        }
    }

    fun getException(): Exception? {
        return if (exception != null) {
            exception!!
        } else {
            null
        }
    }
}