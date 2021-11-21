package com.example.listviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter() { // BaseAdapter 상속

    override fun getCount(): Int {
        return UserList.size // listView의 갯수
    }

    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)

        val profile = view.findViewById<ImageView>(R.id.ivProfile1)
        val name = view.findViewById<TextView>(R.id.tvName1)
        val age = view.findViewById<TextView>(R.id.tvAge1)
        val greet = view.findViewById<TextView>(R.id.tvGreet1)

        val user = UserList[position] // 0번부터 시작

        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        return view

    }
}