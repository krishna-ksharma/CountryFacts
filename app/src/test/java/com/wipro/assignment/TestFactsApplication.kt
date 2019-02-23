package com.wipro.assignment

import com.wipro.assignment.di.DaggerTestAppComponent

/**
 * Created by krishnas on 2/23/2019.
 */
class TestFactsApplication : FactsApplication() {
    override fun initDagger() {
        DaggerTestAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }
}