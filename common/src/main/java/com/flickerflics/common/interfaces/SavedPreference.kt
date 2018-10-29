package com.flickerflics.common.interfaces

import com.flickerflics.common.entity.PreferenceType

/**
 * @Author rahulravindran
 */
interface SavedPreference {
    fun getPreferenceType(): PreferenceType
    fun getName(): String
}