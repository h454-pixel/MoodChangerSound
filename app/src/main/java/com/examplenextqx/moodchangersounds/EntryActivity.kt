package com.examplenextqx.moodchangersounds
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.examplenextqx.moodchangersounds.Adapter.EntryAdapter
import com.examplenextqx.moodsoundkotlin.R


class EntryActivity : AppCompatActivity() {
    var context: Context? = null
    lateinit var recyclerView: RecyclerView
    var leaves: LottieAnimationView? = null
    var image:ImageView?=null
    var boolean:Boolean = false
    var toolbar:androidx.appcompat.widget.Toolbar?=null
    var namearr = arrayOf(
        "animals",
        "Intruments",
        "birds",
        "nature",
        "mix",
        )
    var imgarr = intArrayOf(
        R.drawable.deer,
        R.drawable.guitar,
        R.drawable.bird,
        R.drawable.nature,
        R.drawable.fish,
        )
    //  int[] musicarr ={R.raw.mix1,R.raw.mix1,R.raw.mix1,R.raw.mix1,R.raw.mix1,R.raw.mix1,R.raw.mix1,R.raw.mix1,R.raw.mix1};


    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        leaves = findViewById(R.id.animationleaves)
        recyclerView = findViewById(R.id.recy)
        context = this

      boolean=   Utis.isNetworkAvailable(context)
        val list: MutableList<ModelF> = ArrayList<ModelF>()
        for (i in namearr.indices) {
            val mf = ModelF()
            mf.name = namearr[i]
            mf.img = imgarr[i]
            //   mf.musicType =musicarr[i];
            list.add(mf)
        }

        recyclerView.setHasFixedSize(true)
        recyclerView.setAdapter(EntryAdapter(list, context as EntryActivity))





    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.examplenextqx.moodsoundkotlin.R.menu.bottom_nav_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == com.examplenextqx.moodsoundkotlin.R.id.lic) {
            val `in` = Intent(context, AssetsActivity::class.java)
            context?.startActivity(`in`)
        }
        return super.onOptionsItemSelected(item)
    }



}