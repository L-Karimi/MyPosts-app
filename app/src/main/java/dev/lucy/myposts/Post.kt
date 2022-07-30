package dev.lucy.myposts

import android.provider.ContactsContract

data class Post(
    var userId:Int,
    var Id:Int,
    var title:String,
    var body:String
)
data class Comment(
    var postId:Int,
    var id:Int,
    var name:String,
    var email: String,
    var body:String
)

//Generic function