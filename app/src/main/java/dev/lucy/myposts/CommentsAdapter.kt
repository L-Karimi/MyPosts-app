package dev.lucy.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.lucy.myposts.databinding.CommentListItemBinding

class CommentsAdapter(var comments:List<Comment>): RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding= CommentListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment=comments.get(position)
        holder.binding.tvTitle.text=currentComment.name
        holder.binding.tvBody.text=currentComment.body
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}
class CommentViewHolder(var binding:CommentListItemBinding):RecyclerView.ViewHolder(binding.root)