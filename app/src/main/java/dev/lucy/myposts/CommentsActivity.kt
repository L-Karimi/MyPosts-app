package dev.lucy.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.lucy.myposts.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId = 0
    lateinit var binding: ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostsId()
    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID") ?: 0
    }

    fun fetchPostsId() {
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    binding.tvPostTittle.text = post?.title
                    binding.tvPostBody.text = post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}