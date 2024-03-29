package traore.adama.nextcut_android.ui

import android.os.Handler
import android.os.HandlerThread

class DatabaseWorkerThread(threadName: String) : HandlerThread(threadName){
    private lateinit var mWorkerHandler: Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        mWorkerHandler = Handler(looper)
    }

    fun postTask(task: Runnable){
        mWorkerHandler.post(task)
    }
}