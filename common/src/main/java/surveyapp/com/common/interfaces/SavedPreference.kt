package surveyapp.com.common.interfaces

import surveyapp.com.common.entity.PreferenceType

/**
 * @Author rahulravindran
 */
interface SavedPreference {
    fun getPreferenceType(): PreferenceType
    fun getName(): String
}