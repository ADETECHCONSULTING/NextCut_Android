package traore.adama.nextcut_android.extensions

import android.app.Activity
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.Toast
import traore.adama.nextcut_android.BuildConfig

fun Activity.logd(message: String){
    Log.d(this::class.java.simpleName, message)
}

fun Activity.shortToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.shortToast(message: String){
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}