package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.databinding.ItemUserBinding

class UserAdapter(
    private val onItemClick: (User) -> Unit,
    private val onEditClick: (User) -> Unit,
    private val onDeleteClick: (User) -> Unit
) : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class UserViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.apply {
                userNameText.text = user.name
                userEmailText.text = user.email
                userPhoneText.text = user.phone ?: "Telefon yok"
                
                // Role badge
                when (user.role) {
                    com.balancetech.sitemanagement.data.model.UserRole.ADMIN -> {
                        roleBadge.text = "Yönetici"
                    }
                    com.balancetech.sitemanagement.data.model.UserRole.RESIDENT -> {
                        roleBadge.text = "Daire Sakini"
                    }
                    com.balancetech.sitemanagement.data.model.UserRole.AUDITOR -> {
                        roleBadge.text = "Denetçi"
                    }
                }

                root.setOnClickListener {
                    onItemClick(user)
                }

                editButton.setOnClickListener {
                    onEditClick(user)
                }

                deleteButton.setOnClickListener {
                    onDeleteClick(user)
                }
            }
        }
    }

    class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}

