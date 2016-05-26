package mobsoft.bme.hu.irodafoglalo.ui.participants

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mobsoft.bme.hu.irodafoglalo.R
import mobsoft.bme.hu.irodafoglalo.model.Person

/**
 * Created by Adam Toth on 2016. 05. 27..
 */
class ParticipantsAdapter(private val context: Context?,
                          private val peopleList: List<Person>) : RecyclerView.Adapter<ParticipantsAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.card_room, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val person = peopleList[position]

        holder?.tvTitle?.text = person.firstName + " " + person.lastName
        holder?.tvDesc?.text = person.email
    }

    fun getItem(position: Int): Person {
        return peopleList[position]
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