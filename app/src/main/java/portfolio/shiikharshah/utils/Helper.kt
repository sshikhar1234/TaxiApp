package portfolio.shiikharshah.utils

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WpsInfo.INVALID
import android.os.Build
import android.util.Log
import com.tech.capermint.flashmopcleanerdesign.utils.AppConstants
import portfolio.shiikharshah.App
import portfolio.shiikharshah.BaseAppCompatActivity


 object Helper:AppConstants{
    private val TAG = "Helper"
    private var sharedpreferences: SharedPreferences? = null
    private val PREFERENCE = "pref_arch_out"


    fun debugLog(tag: String?, log: String?) {
        Log.e(tag, log)
    }
    /**
     * Set string value in shared preferences
     * @param key   key to put value for
     * @param value value of the key
     */
    fun setBooleanValue(key: String?, value: Boolean) {
        sharedpreferences = App.getAppInstance()?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor? = sharedpreferences?.edit()
        editor?.putBoolean(key, value)
        editor?.apply()
    }

    fun isFirstLaunch(): Boolean? {
        sharedpreferences = App.getAppInstance()?.getSharedPreferences(PREFERENCE,Context.MODE_PRIVATE)
        //getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        return sharedpreferences?.getBoolean(AppConstants.IS_FIRST_LAUNCH, true)
    }

    /**
     * Set Integer value in shared preferences
     * @param key   key to put value for
     * @param value value of the key
     */
    fun setIntValue(key: String?, value: Int) {
        sharedpreferences = App.getAppInstance()?.getSharedPreferences(PREFERENCE,Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor? = sharedpreferences?.edit()
        editor?.putInt(key, value)
        editor?.apply()
    }

    /**
     * Set string value in shared preferences*
     * @param key   key to put value for
     * @param value value of the key
     */
    fun setStringValue(key: String?, value: String?) {
        sharedpreferences = App.getAppInstance()?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor? = sharedpreferences?.edit()
        editor?.putString(key, value)
        editor?.apply()
    }

    /**
     * Get string value from shared preferences
     * @param key key of value
     * @return value of the key
     */
    fun getStringValue(key: String?): String? {
        sharedpreferences = App.getAppInstance()?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        return sharedpreferences?.getString(key, StringUtils.EMPTY_STRING)
    }

    fun getBooleanValue(key: String?): Boolean? {
        sharedpreferences = App.getAppInstance()?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        return sharedpreferences?.getBoolean(key, true)
    }

    /**
     * Get Integer value from shared preferences
     * @param key key of value
     * @return value of the key
     */
    fun getIntValue(key: String?): Int? {
        sharedpreferences = App.getAppInstance()?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        return sharedpreferences?.getInt(key, INVALID)
    }

    /**
     * Clear all the data stored in shared preferences
     */
    fun clearPreferences() {
        Log.e(TAG, "clearPreferences: ")
        sharedpreferences = App.getAppInstance()?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        sharedpreferences?.edit()?.clear()?.apply()
    }

    /**
     * Check for network availability
     * @return true if available. false otherwise
     */
     fun isNetworkAvailable(context: BaseAppCompatActivity?): Boolean {
        var result = false
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }

                }
            }
        }
       return result
    }

}