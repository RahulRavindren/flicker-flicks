package surveyapp.com.network.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @Author rahulravindran
 */
data class AccessTokenEntity(
        @Expose @SerializedName("access_token")
        val accessToken: String,

        @Expose @SerializedName("token_type")
        val tokenType: String,

        @Expose @SerializedName("expires_in")
        val expiresIn: Int,

        @Expose @SerializedName("created_at")
        val createdAt: Long
)