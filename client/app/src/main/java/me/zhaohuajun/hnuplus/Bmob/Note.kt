package me.zhaohuajun.hnuplus.Bmob

import cn.bmob.v3.BmobObject



class Note : BmobObject() {
    var content: String? = null
    var author: MyUser? = null
}
