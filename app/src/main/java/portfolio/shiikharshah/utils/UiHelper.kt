package portfolio.shiikharshah.utils

import android.widget.ProgressBar
import com.tech.capermint.flashmopcleanerdesign.utils.AppConstants
import portfolio.shiikharshah.BaseAppCompatActivity
import java.util.*


object UiHelper:AppConstants{
     private var progress: ProgressBar? = null
     var c: Calendar? = null
    fun startProgress(
        activity: BaseAppCompatActivity?,
        isCancelable: Boolean
    ) {
//        stopProgress(activity)
//        progress = ProgressBar(activity)
//        progress?.isIndeterminate = true
//        progress.start()
    }

    fun stopProgress(activity: BaseAppCompatActivity?) {
//        if (null != activity && null != progress && progress?.isShown()!!) {
//            progress?.isShown(false)
//        }
    }

}