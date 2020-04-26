package portfolio.shiikharshah

import android.app.Application

class App : Application() {

    companion object {
        public var mAppInstance: App? = null
        public fun getAppInstance(): App? {
            return mAppInstance
        }

    }

    override fun onCreate() {
        super.onCreate()
        mAppInstance = this
    }

}