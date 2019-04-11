package me.zhaohuajun.hnuplus.Bmob

import cn.bmob.v3.BmobObject

class Comment : BmobObject() {
    var content: String? = null
    var user: MyUser? = null
    var post: Post? = null
}
