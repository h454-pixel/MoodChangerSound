package com.examplenextqx.moodchangersounds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.examplenextqx.moodsoundkotlin.R
import java.io.IOException
import java.io.InputStream

class AssetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assets)

        // Declaring and initializing the TextView from the layout
        val myTextView = findViewById<TextView>(R.id.textView)

        // A string variable to store the text from the text file
        val myOutput: String

        // Declaring an input stream to read data
        val myInputStream: InputStream

        // Try to open the text file, reads
        // the data and stores it in the string
        try {
            myInputStream = assets.open("liacense.txt")
            val size: Int = myInputStream.available()
            val buffer = ByteArray(size)
            myInputStream.read(buffer)
            myOutput = String(buffer)

            // Sets the TextView with the string
            myTextView.text = myOutput

        } catch (e: IOException) {
            // Exception
            e.printStackTrace()
        }


    }
}