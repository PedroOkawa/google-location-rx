package com.okawa.sample.googlemaps.common

import android.view.View
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

private const val SKIP_DURATION = 400L

fun View.throttleClick(executeBlock: () -> Unit): Disposable {
    return clicks()
        .throttleFirst(SKIP_DURATION, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
        .subscribe {
            executeBlock.invoke()
        }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}