package com.examplenextqx.moodchangersounds

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.examplenextqx.moodchangersounds.Adapter.InstrumentAdapter
import com.examplenextqx.moodsoundkotlin.R

class IntrumentActivity : AppCompatActivity() {
    var context: Context? = null
    var recyclerView: RecyclerView? = null
    var list: List<ModelF>? = null
     var namearr = arrayOf("Flute","Flute2", "Guitar","Guitar2" ,"Harmonica", "Harmonica2","Trumpet","Trumpet2","Xylophone","Xylophone2","Piano","Piano2" ,"Harp","Violin")
    var imgarr = intArrayOf(
        R.drawable.flute,
        R.drawable.flute,
        R.drawable.guitar,
        R.drawable.guitar,
        R.drawable.harmonica,
        R.drawable.harmonica,
        R.drawable.trumpet,
        R.drawable.trumpet,
        R.drawable.xylophone,
        R.drawable.xylophone,
        R.drawable.piano,
        R.drawable.piano,
        R.drawable.harp,
        R.drawable.violin
    )
    var musicarr = intArrayOf(
        R.raw.flute,
        R.raw.flute1,
        R.raw.guitar,
        R.raw.heavenguitar,
        R.raw.harmonicawav,
        R.raw.harmonica,
        R.raw.trumpet,
        R.raw.trumpet2,
        R.raw.xylo,
        R.raw.xylo2,
        R.raw.pianonext,
        R.raw.piano2,
        R.raw.harp,
        R.raw.violin

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mix)
        recyclerView = findViewById(R.id.recy)

        context = this

        val list: ArrayList<ModelF> = ArrayList<ModelF>()
        for (i in namearr.indices) {
            val mf = ModelF()
            mf.name = namearr[i]
            mf.img = imgarr[i]
            mf.musicType = musicarr[i]
            list.add(mf)
        }

        recyclerView?.setHasFixedSize(true)
        recyclerView?.setAdapter(InstrumentAdapter(list , context as IntrumentActivity))
    }

}