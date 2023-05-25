package com.example.asynctasklesson

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.asynctasklesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        handler = Handler(Looper.getMainLooper())
//        handler.postDelayed(runnable, 2000)
        binding.tv.setOnClickListener {
            MyTask()
                .execute()
        }

    }

    var count = 0

    @SuppressLint("StaticFieldLeak")
    inner class MyTask : AsyncTask<Void, Void, Void>() {

        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(this@MainActivity, "Start", Toast.LENGTH_SHORT).show()
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            while (count <= 10) {
                count++
                Thread.sleep(1000)
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            Toast.makeText(this@MainActivity, "End", Toast.LENGTH_SHORT).show()
            super.onPostExecute(result)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }


//    private val runnable = object : Runnable {
//        override fun run() {
//            binding.tv.text = count.toString()
//            count++
//            handler.postDelayed(this, 1000)
//        }
}