package surveyapp.com.common.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


//using only values needed for the application norms
data class SurveyEntity(@Expose val id: String,
                        @Expose val title: String,
                        @Expose val description: String,
                        @Expose @SerializedName("cover_image_url") val coverImageUrl: String,
                        @Expose val type: String) : Serializable