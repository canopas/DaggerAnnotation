package com.canopas.dagger2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canopas.dagger2.databinding.ItemUserBinding
import com.canopas.dagger2.model.User

class UserAdapter : RecyclerView.Adapter<UserVH>() {
    var users = emptyList<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserVH(binding)
    }
    override fun getItemCount(): Int {
        return users.size
    }
    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = users[position]
        holder.bind(user)
    }
}
class UserVH(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User) {
        binding.userName.text = user.name
        binding.userEmail.text = user.email
        binding.userInitial.text = user.name.substring(0, 1)
    }
}