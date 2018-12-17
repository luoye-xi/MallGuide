package com.linkstar.app.guide.ui.fragment

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.linkstar.app.guide.R
import kotlinx.android.synthetic.main.fragment_call_phone.*

class CallPhoneFragment : DialogFragment() {

    private var phone : String = "400-2123-1123"
    private var listener : OnClickListener ?= null


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
            phone = it.getString("phone")
        }

        tv_phone.text = phone

        tv_cancel.setOnClickListener {
            dismiss()
        }

        tv_confirm.setOnClickListener {
            listener?.onClick()
            dismiss()
        }

    }

    interface OnClickListener{
        fun onClick()
    }

    fun setClickListener(listener : OnClickListener){
        this.listener = listener
    }
}
