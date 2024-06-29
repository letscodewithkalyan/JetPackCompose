package com.kp.tvmaze.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kp.tvmaze.R
import com.kp.tvmaze.data.dto.Schedule

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
    }
    fun updateList(list: List<Schedule>){
        scheduleList = list
        notifyDataSetChanged()
    }

    inner class ScheduleListViewHolder(val view: View): RecyclerView.ViewHolder(view){

    }
}