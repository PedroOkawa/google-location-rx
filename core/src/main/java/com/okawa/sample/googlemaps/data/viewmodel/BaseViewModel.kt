package com.okawa.sample.googlemaps.data.viewmodel

import androidx.lifecycle.ViewModel
import com.okawa.sample.googlemaps.data.schedulers.BaseSchedulerProvider
import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel constructor(
    private val schedulerProvider: BaseSchedulerProvider
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun Disposable.addToDisposable() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun <T> Observable<T>.baseSubscribe(
        observeOn: Scheduler? = schedulerProvider.ui(),
        subscribeOn: Scheduler = schedulerProvider.io(),
        onError: ((Throwable) -> Unit)? = null,
        onSuccess: (T) -> Unit
    ) {
        this.subscribeOn(subscribeOn)
            .run {
                if (observeOn != null) {
                    observeOn(observeOn)
                } else {
                    this
                }
            }
            .subscribe(
                { onSuccess.invoke(it) },
                { onError?.invoke(it) }
            ).addToDisposable()
    }

    fun <T> Single<T>.baseSubscribe(
        observeOn: Scheduler? = schedulerProvider.ui(),
        subscribeOn: Scheduler = schedulerProvider.io(),
        onError: ((Throwable) -> Unit)? = null,
        onSuccess: (T) -> Unit
    ) {
        this.subscribeOn(subscribeOn)
            .run {
                if (observeOn != null) {
                    observeOn(observeOn)
                } else {
                    this
                }
            }
            .subscribe(
                { onSuccess.invoke(it) },
                { onError?.invoke(it) }
            ).addToDisposable()
    }

    fun <T> Flowable<T>.baseSubscribe(
        observeOn: Scheduler? = schedulerProvider.ui(),
        subscribeOn: Scheduler = schedulerProvider.io(),
        onError: ((Throwable) -> Unit)? = null,
        onSuccess: (T) -> Unit
    ) {
        this.subscribeOn(subscribeOn)
            .run {
                if (observeOn != null) {
                    observeOn(observeOn)
                } else {
                    this
                }
            }
            .subscribe(
                { onSuccess.invoke(it) },
                { onError?.invoke(it) }
            ).addToDisposable()
    }

    fun Completable.baseSubscribe(
        observeOn: Scheduler? = schedulerProvider.ui(),
        subscribeOn: Scheduler = schedulerProvider.io(),
        onError: ((Throwable) -> Unit)? = null,
        onComplete: () -> Unit
    ) {
        this.subscribeOn(subscribeOn)
            .run {
                if (observeOn != null) {
                    observeOn(observeOn)
                } else {
                    this
                }
            }
            .subscribe(
                { onComplete.invoke() },
                { onError?.invoke(it) }
            ).addToDisposable()
    }

}