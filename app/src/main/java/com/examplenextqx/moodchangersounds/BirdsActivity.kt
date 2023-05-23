package com.examplenextqx.moodchangersounds

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.examplenextqx.moodchangersounds.Adapter.BirdsAdapter
import com.examplenextqx.moodsoundkotlin.R


class BirdsActivity : AppCompatActivity() {


    private var pb: ProgressBar? = null
    var context: Context? = null
    var recyclerView: RecyclerView? = null

    var list: List<ModelF>? = null
    var namearr = arrayOf("Cricket", "Cock", "Cokatail","Peacock","Piegon", "Crow", "Owl","Eagle", "Woodpacker","Robin","Cockoo", "Seagull")
    var imgarr = intArrayOf(
        R.drawable.cricket,
        R.drawable.cock,
        R.drawable.cokatail,
        R.drawable.peacock,
        R.drawable.piegon,
        R.drawable.croww,
        R.drawable.owl,
        R.drawable.eagle,
        R.drawable.woodpecker,
        R.drawable.robin,
        R.drawable.cockoobird,
        R.drawable.seagulls
    )
    var musicarr = intArrayOf(
        R.raw.cricketschirping,
        R.raw.cock,
        R.raw.cockatiel,
        R.raw.peacock,
        R.raw.pigeonsflying,
        R.raw.crow1,
        R.raw.hoot,
        R.raw.eagle,
        R.raw.woodpecker,
        R.raw.robinbird,
        R.raw.cuckoo2,
        R.raw.seagull
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
        recyclerView?.setAdapter(BirdsAdapter(list , context as BirdsActivity))


    }
}


