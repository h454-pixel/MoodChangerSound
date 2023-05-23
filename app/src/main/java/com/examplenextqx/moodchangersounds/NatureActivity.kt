package com.examplenextqx.moodchangersounds

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.examplenextqx.moodchangersounds.Adapter.NatureAdapter
import com.examplenextqx.moodsoundkotlin.R

class NatureActivity : AppCompatActivity() {
    var context: Context? = null
    var recyclerView: RecyclerView? = null

    var list: List<ModelF>? = null
    var namearr = arrayOf("Windblowing", "River", "Waterfall", "Heavyrain","Fountain","HeavyrainCar", "HurricanStrom","SeaWaves","BoatinRiver")
    var imgarr = intArrayOf(
        R.drawable.wind,
        R.drawable.river,
        R.drawable.waterfall,
        R.drawable.heavyrain,
        R.drawable.fountain,
        R.drawable.carwash,
        R.drawable.storm,
        R.drawable.wave,
        R.drawable.boat
    )
    var musicarr = intArrayOf(
        R.raw.wind,
        R.raw.riverwater,
        R.raw.waterfallwav,
        R.raw.heavyrain,
        R.raw.fountainn,
        R.raw.heavyraincarwindow,
        R.raw.hurricanestorm,
        R.raw.oceanwaves,
        R.raw.boatonriver
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
        recyclerView?.setAdapter(NatureAdapter(list , context as NatureActivity))


    }
}