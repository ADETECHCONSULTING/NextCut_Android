package traore.adama.nextcut_android.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import traore.adama.nextcut_android.R

class MainActivity : AppCompatActivity() {

    companion object {
        fun launch(context: Context){
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
