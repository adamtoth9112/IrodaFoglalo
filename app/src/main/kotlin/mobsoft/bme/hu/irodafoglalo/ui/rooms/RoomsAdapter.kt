package mobsoft.bme.hu.irodafoglalo.ui.rooms

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mobsoft.bme.hu.irodafoglalo.R
import mobsoft.bme.hu.irodafoglalo.model.Room

/**
 * Created by Adam Toth on 2016. 05. 26..
 */
class RoomsAdapter(
        private val context: Context?,
        private val roomsList: List<Room>) : RecyclerView.Adapter<RoomsAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return roomsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.card_room, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val room = roomsList[position]

        holder?.tvTitle?.text = room.name
        holder?.tvDesc?.text = room.description
    }

    fun getItem(position: Int): Room {
        return roomsList[position]
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var tvDesc: TextView

        init {
            tvTitle = itemView.findViewById(R.id.title) as TextView
            tvDesc = itemView.findViewById(R.id.desc) as TextView
        }
    }
}