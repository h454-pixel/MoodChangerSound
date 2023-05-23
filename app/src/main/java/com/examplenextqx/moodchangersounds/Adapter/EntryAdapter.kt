package com.examplenextqx.moodchangersounds.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.examplenextqx.moodchangersounds.*
import com.examplenextqx.moodsoundkotlin.R


class EntryAdapter(var List: MutableList<ModelF>, var context: EntryActivity) : RecyclerView.Adapter<EntryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.menuentry_adapter, parent, false)
        return ViewHolder(view, context, List)
    }


    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val itemType = getItemViewType(position)
        val sampleuser = List[position]
        holder.name.text = sampleuser.name
        holder.imageview.setImageResource(sampleuser.img)
        holder.imageview.setOnClickListener(object : View.OnClickListener {
            var s1 = List[position].name
            var s2 = List[position].img
            override fun onClick(view: View) {
                if(position==0) {
                  val `in` = Intent(context, AnimalActivity::class.java)
                  context.startActivity(`in`)
              }else if(position==1){
                  val `in` = Intent(context, IntrumentActivity::class.java)
                  context.startActivity(`in`)
              }else if(position==2 ){
                  val `in` = Intent(context, BirdsActivity::class.java)
                  context.startActivity(`in`)
              }else if(position==3){
                    val `in` = Intent(context, NatureActivity::class.java)
                  context.startActivity(`in`)
              }else if(position==4){
                    val `in` = Intent(context, OtherActivity::class.java)
                    context.startActivity(`in`)

                }
            }
        })
    }

    override fun getItemCount(): Int {
        return List.size
    }


    class ViewHolder(itemView: View, context: Context?, gunList: List<ModelF>?) :
        RecyclerView.ViewHolder(itemView) {
        var imageview: ImageView
        var name: TextView
        var context: Context?
        var List: List<ModelF>?

        init {
            imageview = itemView.findViewById<View>(R.id.cir) as ImageView
            name = itemView.findViewById<View>(R.id.txt) as TextView
            this.context = context
            List = gunList
        }
    }
}