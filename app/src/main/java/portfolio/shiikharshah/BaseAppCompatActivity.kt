package portfolio.shiikharshah

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class BaseAppCompatActivity : AppCompatActivity(){
    var mActivity: BaseAppCompatActivity? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        mActivity = this
    }
    fun startProgress(isCancelable: Boolean){
        //TBI
    }
}
