package mobsoft.bme.hu.irodafoglalo.ui.times

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mobsoft.bme.hu.irodafoglalo.R
import mobsoft.bme.hu.irodafoglalo.model.Time

/**
 * Created by Adam Toth on 2016. 05. 26..
 */
class TimesAdapter(private val context: Context?,
                   private val timesList: List<Time>) : RecyclerView.Adapter<TimesAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return timesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.card_room, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val time = timesList[position]

        holder?.tvTitle?.text = time.time
        holder?.tvDesc?.text = time.date
    }

    fun getItem(position: Int): Time {
        return timesList[position]
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