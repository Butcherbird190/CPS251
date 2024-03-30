package edu.wccnet.mmorgan8.carddemo

import android.content.Intent
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    interface OnClickListener {
        fun onItemClick(position: Int, itemImage: Int, itemTitle: String, itemDetail: String)
    }

    private var listener: OnClickListener? = null

    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = DataManager.titles[i]
        viewHolder.itemDetail.text = DataManager.details[i]
        viewHolder.itemImage.setImageResource(DataManager.images[i])
    }

    override fun getItemCount(): Int {
        return DataManager.titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View,   -> // we need to get the content of the specific item clicked
                val position : Int = adapterPosition


                val i = Intent(v.context, MainActivity2::class.java)
                i.putExtra("position", position)

                //val pos = DataManager.titles[position]
                v.context.startActivity(i)

            }

        }
    }

}