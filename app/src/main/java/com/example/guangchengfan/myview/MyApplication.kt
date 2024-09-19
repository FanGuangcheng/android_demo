package com.example.guangchengfan.myview


import android.app.Application

class MyApplication : Application() {

    companion object {
        lateinit var instance: MyApplication
            private set
    }


    fun getScreenWidth(): Int {
        return resources.displayMetrics.widthPixels
    }

    fun getScreenHeight(): Int {
        return resources.displayMetrics.heightPixels
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        // 在应用启动时执行初始化操作
        initializeGlobalVariables()
    }

    private fun initializeGlobalVariables() {
        // 进行全局初始化，比如初始化日志系统、数据库、第三方库等
    }
}
