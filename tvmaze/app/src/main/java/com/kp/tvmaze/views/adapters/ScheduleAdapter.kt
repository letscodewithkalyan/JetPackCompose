package com.kp.tvmaze.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kp.tvmaze.R
import com.kp.tvmaze.data.dto.Schedule
import com.squareup.picasso.Picasso

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleListViewHolder>() {

    private var scheduleList: List<Schedule> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule,null,false);
        return ScheduleListViewHolder(view)
    }

    override fun getItemCount(): Int {
       return scheduleList.count()
    }

    override fun onBindViewHolder(holder: ScheduleListViewHolder, position: Int) {
        var schedule = scheduleList[position]
        holder.titleText.text = schedule.show.name
        holder.descritptionText.text = schedule.show.summary
        Picasso.get()
            .load(schedule.show.image.medium)
            .into(holder.imageView);
    }
    fun updateList(list: List<Schedule>){
        scheduleList = list
        notifyDataSetChanged()
    }

    inner class ScheduleListViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val imageView:ImageView
        val titleText:TextView
        val descritptionText:TextView
       init {
           imageView = view.findViewById(R.id.showImageView)
           titleText = view.findViewById(R.id.titleText)
           descritptionText = view.findViewById(R.id.descriptionText)
       }
    }
}