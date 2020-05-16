package com.okawa.sample.googlemaps.data.schedulers

import com.okawa.sample.googlemaps.data.schedulers.BaseSchedulerProvider
import io.reactivex.schedulers.Schedulers

class TrampolineSchedulerProvider :
    BaseSchedulerProvider {
    override fun computation() = Schedulers.trampoline()
    override fun ui() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
}