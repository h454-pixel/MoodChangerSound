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
import com.examplenextqx.moodchangersounds.ModelF
import com.examplenextqx.moodchangersounds.PlayActivity
import com.examplenextqx.moodchangersounds.BirdsActivity
import com.examplenextqx.moodsoundkotlin.R


class BirdsAdapter(var List:ArrayList<ModelF>, var context: BirdsActivity) : RecyclerView.Adapter<BirdsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_rcy_adpater, parent, false)

        return ViewHolder(view, context, List)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val itemType = getItemViewType(position)
        val sampleuser = List[position]
        holder.name.text = sampleuser.name
        holder.imageview.setImageResource(sampleuser.img)


        holder.imageview.setOnClickListener(object : View.OnClickListener {
            var s1 = List[position].musicType
            var s2 = List[position].img
            var pos = holder.adapterPosition
            override fun onClick(view: View) {
                PlayActivity.sendPostion(pos)
                val intent:Intent = Intent(context, PlayActivity::class.java)
                intent.putExtra("namelist",List)
                intent.putExtra("pos",pos)
                context.startActivity(intent)
            }
        })


    }

    override fun getItemCount(): Int {
        return List.size
    }

    class ViewHolder(itemView: View, context: Context, gunList: List<ModelF>) :
        RecyclerView.ViewHolder(itemView) {
        var imageview: ImageView
        var name: TextView
        var context: Context
        var List: List<ModelF>

        init {
            imageview = itemView.findViewById<View>(R.id.cir) as ImageView
            name = itemView.findViewById<View>(R.id.txt) as TextView
            this.context = context
            List = gunList
        }
    }

}
