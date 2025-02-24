package com.safwa.mealsusecase

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {

        instance = this
        context =applicationContext
   //     Logger.init(BuildConfig.DEBUG)
  //      listenToNetworkConnectivity()
        super.onCreate()

    }
/*
    private fun listenToNetworkConnectivity() {

        ReactiveNetwork.observeInternetConnectivity()
            .subscribeOn(Schedulers.io())
            // anything else what you can do with RxJava
            .observeOn(Schedulers.io())
            .subscribe { isConnected: Boolean ->

                //using logger file depend on timber lib
                Logger.e(isConnected.toString())

                //using timber lib
                //Timber.tag(TAG).e("Connection to internet is $isConnected")


                //FirebaseCrashlytics.getInstance().setCustomKey("connect_to_internet", isConnected)

            }

    }
*/
    companion object{
        lateinit var instance: MyApp
        lateinit var context: Context


    }

}