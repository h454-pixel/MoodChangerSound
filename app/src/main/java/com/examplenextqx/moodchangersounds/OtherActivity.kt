package com.examplenextqx.moodchangersounds

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.examplenextqx.moodchangersounds.Adapter.OtherAdapter
import com.examplenextqx.moodsoundkotlin.R

class OtherActivity  : AppCompatActivity(){
    var context: Context? = null
    var recyclerView: RecyclerView? = null

    var list: List<ModelF>? = null
    var namearr = arrayOf( "Grasshopper", "FishnRiver","GuineaPig","WaterFootstep","Shower"," BirdsSing","Thunder")
    var imgarr = intArrayOf(
        R.drawable.grasshopper,
        R.drawable.pond,
        R.drawable.guinea,
        R.drawable.water,
        R.drawable.shower,
        R.drawable.birdsinging,
        R.drawable.thunderstorm

    )
    var musicarr = intArrayOf(
        R.raw.grasshopper,
        R.raw.fishinriver,
        R.raw.guineapig3,
        R.raw.waterfootsteps,
        R.raw.shower,
        R.raw.birdssing,
        R.raw.lightrainthunder
    )



    @SuppressLint("MissingInfatedId")
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
        recyclerView?.setAdapter(OtherAdapter(list , context as OtherActivity))


    }
}