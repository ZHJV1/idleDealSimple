package me.zhaohuajun.hnuplus

import android.content.Intent
import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import kotlinx.android.synthetic.main.activity_order.*
import me.zhaohuajun.hnuplus.Bmob.Order
import org.jetbrains.anko.toast

class OrderActivity : AppCompatActivity() {

    companion object {
        private val TAG = "OrderActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        title = "确认订单(测试版)"

        val intent = intent
        val goodId = intent.getStringExtra("goodId")
        val buyerId = intent.getStringExtra("buyerId")
        val sellerId = intent.getStringExtra("sellerId")
        val address = intent.getStringExtra("address")
        val goodName = intent.getStringExtra("goodName")
        val price = intent.getStringExtra("price")
        val imageUrl = intent.getStringExtra("imageUrl")

        tv_address.text = "地址：" + address
        tv_price.text = "价格：" + price
        tv_good.text = "商品名字：" + goodName

        btn_order.setOnClickListener {
            val order = Order()
            order.address = address
            order.goodId = goodId
            order.sellerId = sellerId
            order.buyerId = buyerId
            order.price = price
            order.goodName = goodName
            order.imageUrl = imageUrl

            order.save(object : SaveListener<String>() {
                override fun done(s: String, e: BmobException?) {
                    if (e == null) {
//                        Toast.makeText(this@OrderActivity, "下单成功", Toast.LENGTH_SHORT).show()
                        toast("下单成功！")
                        val intent = Intent()
                        //获取intent对象
                        intent.setClass(this@OrderActivity, MainActivity::class.java)
                        // 获取class是使用::反射
                        startActivity(intent)
//                        finish()
                    } else {
                        Toast.makeText(this@OrderActivity, "下单失败", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

    }
}
