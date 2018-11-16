package com.example.dns.placesapp.domain.global.manager

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject



open class SchedulersProvider @Inject constructor() {

    open fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    open fun computation(): Scheduler {
        return Schedulers.computation()
    }

    open fun io(): Scheduler {
        return Schedulers.io()
    }

    open fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

    open fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }

}