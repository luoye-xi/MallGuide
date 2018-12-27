package com.linkstar.app.guide.ui.activity

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.telecom.Call
import android.view.View
import android.widget.Toast
import com.linkstar.app.guide.R
import com.linkstar.app.guide.base.BaseActivity
import com.linkstar.app.guide.ui.fragment.CallPhoneFragment
import com.linkstar.app.guide.util.Constants
import com.linkstar.app.guide.util.StartActivityUtil
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.fragment_call_phone.*

class SettingActivity : BaseActivity() , CallPhoneFragment.OnClickListener{

    private lateinit var manager: FragmentManager
    private var phone : String ? = "400-2123-1123"
    private val phoneFragment = CallPhoneFragment()

    override fun getLayoutId(): Int = R.layout.activity_setting

    override fun initView() {
        toolbarTitle.text = "设置"

        //关于我们点击
        rl_about_us.setOnClickListener {
            StartActivityUtil.start(this , AboutUsActivity::class.java)
        }

        //清除缓存点击
        rl_clean_cache.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("type" , Constants.OPEN_FRAGMENT_CLEAN_CACHE)
            phoneFragment.arguments = bundle
            phoneFragment.setClickListener(this)
            manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            phoneFragment.show(transaction , "")
        }

        //客服电话点击
        rl_service_phone.setOnClickListener {

            val bundle = Bundle()
            bundle.putInt("type" , Constants.OPEN_FRAGMENT_SERVICE_PHONE)
            bundle.putString("phone" , phone)
            phoneFragment.arguments = bundle
            phoneFragment.setClickListener(this)
            manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            phoneFragment.show(transaction , "")

        }

        //消息提醒点击
        rl_notice.setOnClickListener {
            StartActivityUtil.start(this , MessageSetActivity :: class.java)
        }

        //黑名单点击
        rl_blacklist.setOnClickListener {
            StartActivityUtil.start(this , BlackListActivity :: class.java)
        }

        //修改密码
        rl_change_pwd.setOnClickListener {
            StartActivityUtil.start(this , ChangePwdActivity :: class.java)
        }

    }

    override fun onClick(type : Int) {
        //fragment点击回调
        if (type == Constants.OPEN_FRAGMENT_CLEAN_CACHE){
            //清除缓存
            Toast.makeText(this , "清除缓存" , Toast.LENGTH_SHORT).show()
        }else if (type == Constants.OPEN_FRAGMENT_SERVICE_PHONE){
            //客服电话
            Toast.makeText(this , "客服电话" , Toast.LENGTH_SHORT).show()
        }
    }

}
