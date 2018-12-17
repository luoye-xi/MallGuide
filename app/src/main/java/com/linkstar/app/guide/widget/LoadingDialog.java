package com.linkstar.app.guide.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkstar.app.guide.R;
import com.wang.avi.AVLoadingIndicatorView;

public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context);
    }

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {
        private Context context;
        private String message;
        private boolean isShowMessage = true;
        private boolean isCancelable = false;
        private boolean isCancelOutside = false;

        public Builder(Context context) {
            this.context = context;
        }

        public LoadingDialog.Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public LoadingDialog.Builder setShowMessage(boolean isShowMessage) {
            this.isShowMessage = isShowMessage;
            return this;
        }

        public LoadingDialog.Builder setCancelable(boolean isCancelable) {
            this.isCancelable = isCancelable;
            return this;
        }

        public LoadingDialog.Builder setCancelOutside(boolean isCancelOutside) {
            this.isCancelOutside = isCancelOutside;
            return this;
        }

        public LoadingDialog create() {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            View view = inflater.inflate(R.layout.dialog_loading, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.context, R.style.MyDialogStyle);
            AVLoadingIndicatorView avView = view.findViewById(R.id.av_view);
            avView.show();

            loadingDialog.setContentView(view);
            loadingDialog.setCancelable(this.isCancelable);
            loadingDialog.setCanceledOnTouchOutside(this.isCancelOutside);
            return loadingDialog;
        }
    }
}
