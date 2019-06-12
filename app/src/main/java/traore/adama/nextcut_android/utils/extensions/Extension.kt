package traore.adama.nextcut_android.utils.extensions

import android.app.Activity
import androidx.fragment.app.Fragment
import android.util.Log
import android.widget.Toast

fun Activity.logd(message: String){
    Log.d(this::class.java.simpleName, message)
}

fun Activity.shortToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.shortToast(message: String){
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}