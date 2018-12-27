package com.linkstar.app.guide.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkstar.app.guide.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.linkstar.app.guide.util.Constants.CLICK_BY_ADD_BANK;

public class BankFragment extends BottomSheetDialogFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Unbinder unbind;

    private OnClickListener listener;

    public BankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bank, container);
        unbind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }


    @OnClick(R.id.tv_add)
    public void onViewClicked() {
        listener.onClick(-1 , CLICK_BY_ADD_BANK);
        dismiss();
    }

    public interface OnClickListener{
        void onClick(int position , int clickType);
    }

    public void setClickListener(OnClickListener listener){
        this.listener = listener;
    }

}
