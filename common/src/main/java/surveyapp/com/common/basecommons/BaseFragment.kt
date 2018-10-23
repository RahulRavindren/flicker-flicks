package surveyapp.com.common.basecommons

import android.os.Bundle
import android.support.v4.app.Fragment
import surveyapp.com.common.C
import surveyapp.com.common.utils.Logger

/**
 * @Author rahulravindran
 */
open class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Logger.debug(C.LIFE_CYCLE, "fragment start");
        super.onStart()
    }

    override fun onResume() {
        Logger.debug(C.LIFE_CYCLE, "fragment resume");
        super.onResume()
    }

    override fun onPause() {
        Logger.debug(C.LIFE_CYCLE, "fragment pause");
        super.onPause()
    }

    override fun onDestroy() {
        Logger.debug(C.LIFE_CYCLE, "fragment destroy");
        super.onDestroy()
    }

}