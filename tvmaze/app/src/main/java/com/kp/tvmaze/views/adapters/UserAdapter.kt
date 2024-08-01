package com.kp.tvmaze.views.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kp.tvmaze.R
import com.kp.tvmaze.data.db.User
import com.kp.tvmaze.data.dto.Schedule

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var usersList: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false);
        return UserViewHolder(view);
    }

    override fun getItemCount(): Int {
       return usersList.count()
    }

    fun updateList(users: List<User>){
        usersList = users
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.view.setBackgroundColor(if(position % 2 == 0) Color.BLUE else Color.GREEN)
        holder.firstName.text = usersList[position].firstName
        holder.lastName.text = usersList[position].lastName
    }

    class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        var firstName: TextView
        var lastName: TextView
        init {
            firstName = view.findViewById(R.id.firstName)
            lastName = view.findViewById(R.id.lastName)
        }
    }
}