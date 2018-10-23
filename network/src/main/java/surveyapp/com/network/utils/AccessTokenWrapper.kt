package surveyapp.com.network.utils

import surveyapp.com.common.C
import surveyapp.com.common.entity.AppCredentialPreference
import surveyapp.com.common.utils.JsonUtils
import surveyapp.com.common.utils.PreferenceManager
import surveyapp.com.network.entity.AccessTokenEntity


/**
 * @Author rahulravindran
 */
interface AccessTokenWrapperType {
    fun getAccessToken(): AccessTokenEntity?
    fun saveAccessToken(tokenEntity: AccessTokenEntity)
}

class AccessTokenWrapper : AccessTokenWrapperType {

    override fun getAccessToken(): AccessTokenEntity? {
        val tokenJson = PreferenceManager.getPreference(AppCredentialPreference.ACCESS_TOKEN, C.EMPTY_STRING)
        if (tokenJson == C.EMPTY_STRING) {
            return null
        } else {
            return JsonUtils.fromJson<AccessTokenEntity>(tokenJson, AccessTokenEntity::class.java)!!
        }
    }

    override fun saveAccessToken(tokenEntity: AccessTokenEntity) {
        if (tokenEntity == null) {
            throw NullPointerException("token entity response null")
        }
        PreferenceManager.savePreference(AppCredentialPreference.ACCESS_TOKEN,
                JsonUtils.toJson(tokenEntity))
    }


}