package com.example.cleankoin.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleankoin.R
import com.example.cleankoin.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter:
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var mList = mutableListOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun addAll(userList: List<User>) {
        mList.clear()
        mList.addAll(userList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(mList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(user: User) {
            itemView.tvFirstName.text = user.nombre
            itemView.tvLastName.text = user.apellido
        }
    }
}