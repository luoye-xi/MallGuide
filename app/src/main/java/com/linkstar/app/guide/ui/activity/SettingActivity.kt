package com.linkstar.app.guide.ui.activity

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.telecom.Call
import android.widget.Toast
import com.linkstar.app.guide.R
import com.linkstar.app.guide.base.BaseActivity
import com.linkstar.app.guide.ui.fragment.CallPhoneFragment
import com.linkstar.app.guide.util.StartActivityUtil
import kotlinx.android.synthetic.main.activity_setting.*

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

        //客服电话点击
        rl_service_phone.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("phone" , phone)
            phoneFragment.arguments = bundle
            phoneFragment.setClickListener(this)
            manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            phoneFragment.show(transaction , "")

        }

    }

    override fun onClick() {
        //客服电话点击回调
        Toast.makeText(this , "show" , Toast.LENGTH_SHORT).show()
    }

}
