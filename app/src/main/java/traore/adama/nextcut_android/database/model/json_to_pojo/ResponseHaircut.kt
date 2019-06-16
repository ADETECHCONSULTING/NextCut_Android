package traore.adama.nextcut_android.database.model.json_to_pojo

import com.squareup.moshi.Json
import traore.adama.nextcut_android.database.model.Haircut

data class ResponseHaircut(

	@Json(name="list")
	val list: List<Haircut?>? = null
)