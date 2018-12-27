package com.linkstar.app.guide.ui.fragment

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.view.Window
import com.linkstar.app.guide.R
import com.linkstar.app.guide.util.Constants
import kotlinx.android.synthetic.main.fragment_call_phone.*

class CallPhoneFragment : DialogFragment() {

    private var listener : OnClickListener ?= null
    private var type = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return inflater.inflate(R.layout.fragment_call_phone , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        arguments?.let {

            type = it.getInt("type")

            if (type == Constants.OPEN_FRAGMENT_CLEAN_CACHE){
                tv_title.text = "确定要清除缓存数据？"
                tv_phone.visibility = GONE
            }else if (type == Constants.OPEN_FRAGMENT_SERVICE_PHONE){
                tv_phone.text = it.getString("phone")
            }
        }

        tv_cancel.setOnClickListener {
            dismiss()
        }

        tv_confirm.setOnClickListener {
            listener?.onClick(type)
            dismiss()
        }

    }

    interface OnClickListener{
        fun onClick(type : Int)
    }

    fun setClickListener(listener : OnClickListener){
        this.listener = listener
    }
}
