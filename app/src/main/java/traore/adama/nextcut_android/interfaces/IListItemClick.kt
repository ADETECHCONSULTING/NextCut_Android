package traore.adama.nextcut_android.interfaces

import android.view.View

interface IListItemClick<T> {
    fun itemClicked(item: T, view: View)
}