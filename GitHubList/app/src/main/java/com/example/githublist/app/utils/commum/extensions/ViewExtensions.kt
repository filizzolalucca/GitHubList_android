package com.example.githublist.app.utils.commum.extensions

import android.os.SystemClock
import android.view.View
import android.view.animation.AlphaAnimation

fun View.setOnSingleClickListener(function: () -> Unit) {
    //Esta funcao faz com que tenha um tempo minimo para considerar um novo clique, evitando maiores problemas
    val MIN_CLICK_INTERVAL: Long = 1000
    var mLastClickTime: Long = 0
    val buttonClick = AlphaAnimation(1f, 0.8f)

    this.setOnClickListener {
        val currentClickTime = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        it.startAnimation(buttonClick)

        if (elapsedTime <= MIN_CLICK_INTERVAL) return@setOnClickListener
        mLastClickTime = currentClickTime

        function()
    }
}