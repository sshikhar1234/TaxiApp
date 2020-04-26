package portfolio.shiikharshah
import android.os.Bundle;
import androidx.fragment.app.Fragment
import portfolio.shiikharshah.BaseAppCompatActivity
import portfolio.shiikharshah.utils.Helper
import portfolio.shiikharshah.utils.UiHelper


class BaseFragment : Fragment(){
    var mActivity: BaseAppCompatActivity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = getActivity() as  BaseAppCompatActivity?

    }
    fun isNetworkAvailable(): Boolean {
        return Helper.isNetworkAvailable(mActivity)
    }

    fun startProgress(isCancelable: Boolean) {
        UiHelper.startProgress(mActivity, isCancelable)
    }

    fun stopProgress() {
        UiHelper.stopProgress(mActivity)
    }
}
