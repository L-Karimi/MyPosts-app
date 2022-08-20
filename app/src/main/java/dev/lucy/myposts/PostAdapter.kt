package dev.lucy.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.lucy.myposts.databinding.PostListItemBinding

class PostAdapter( var postlist: List<Post>) :RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding =
            PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost = postlist.get(position)
        with(holder.binding) {
            holder.binding.tvUserid.text = currentPost.userId.toString()
            holder.binding.tvId.text = currentPost.Id.toString()
            holder.binding.tvTitle.text = currentPost.title.toString()
            holder.binding.tvbody.text = currentPost.body.toString()
            holder.binding.cvpost.setOnClickListener {
                var context=holder.itemView.context
                val intent = Intent(context, CommentsActivity::class.java)
                intent.putExtra("POST_ID",currentPost.Id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return postlist.size
    }
}


class PostViewHolder(var binding: PostListItemBinding) :
    RecyclerView.ViewHolder(binding.root)