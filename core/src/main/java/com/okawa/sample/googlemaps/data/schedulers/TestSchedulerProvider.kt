package com.okawa.sample.googlemaps.data.schedulers

import com.okawa.sample.googlemaps.data.schedulers.BaseSchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider :
    BaseSchedulerProvider {
    private val testScheduler = TestScheduler()
    override fun io(): Scheduler = testScheduler
    override fun computation(): Scheduler = testScheduler
    override fun ui(): Scheduler = testScheduler
}