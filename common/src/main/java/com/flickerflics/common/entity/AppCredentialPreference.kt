package com.flickerflics.common.entity

import com.flickerflics.common.C
import com.flickerflics.common.interfaces.SavedPreference

/**
 * @Author rahulravindran
 */
enum class AppCredentialPreference : SavedPreference {
    ACCESS_TOKEN("accessToken", PreferenceType.APP_CRENDENTIAL),
    DEVICE_ID("deviceId", PreferenceType.APP_CRENDENTIAL);

    var prefName: String = C.EMPTY_STRING
    private var preferenceType: PreferenceType = PreferenceType.APP_STATE

    constructor(name: String, preferenceType: PreferenceType) {
        this.prefName = name
        this.preferenceType = preferenceType
    }

    override fun getPreferenceType(): PreferenceType {
        return preferenceType
    }

    override fun getName(): String {
        return prefName
    }
}