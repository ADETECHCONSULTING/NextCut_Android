package traore.adama.nextcut_android.utils.extensions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.View
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

fun View.getParentFragment(): Fragment? {
    var context = this.context
    while (context is ContextWrapper){
        if(context is Fragment){
            return context
        }

        context = context.baseContext
    }

    return null
}