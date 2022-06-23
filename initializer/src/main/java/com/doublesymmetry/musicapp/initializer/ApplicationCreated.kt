package com.doublesymmetry.musicapp.initializer

import android.app.Application

interface ApplicationCreated {

    fun getOrderNumber(): Int = 0

    fun onAppCreated(app: Application)

}
