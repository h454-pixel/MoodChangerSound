package com.examplenextqx.moodchangersounds

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.examplenextqx.moodchangersounds.Adapter.AnimalAdapter
import com.examplenextqx.moodsoundkotlin.R

class AnimalActivity : AppCompatActivity() {
    var context: Context? = null
    var recyclerView: RecyclerView? = null

    var list: List<ModelF>? = null
    var namearr = arrayOf("Frogs", "LaughingFox", "Lamb", "Rhino","Sheep","Cat", "Dog", "Duck","Duck2", "SmallDog","Pig","horse","FunnyGoat","Cow")
    var imgarr = intArrayOf(
        R.drawable.frog,
        R.drawable.fox,
        R.drawable.sheepp,
        R.drawable.rhinoceros,
        R.drawable.sheep,
        R.drawable.cat,
        R.drawable.dog,
        R.drawable.duck,
        R.drawable.duck2,
        R.drawable.dog2,
        R.drawable.pig,
        R.drawable.horse,
        R.drawable.goat,
        R.drawable.cow

        )
    var musicarr = intArrayOf(
        R.raw.frogs,
        R.raw.foxlaughing,
        R.raw.lamb,
        R.raw.rhinoceros,
        R.raw.sheepp,
        R.raw.cat,
        R.raw.dogbarking,
        R.raw.duck,
        R.raw.duck2,
        R.raw.smalldog,
        R.raw.pig,
        R.raw.singlehorsegalopp,
        R.raw.funnygoatsound,
        R.raw.cow1
    )



    @SuppressLint("MissingInflatedId")
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
        recyclerView?.setAdapter(AnimalAdapter(list , context as AnimalActivity))


    }
}