package com.linkstar.app.guide.ui.activity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.util.StartActivityUtil;
import com.linkstar.app.guide.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SMSInviteActivity extends BaseActivity {

    @BindView(R.id.et_phone)
    EditText etPhone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_smsinvite;
    }

    @Override
    public void initView() {

        setToolBarTitle("短信邀请");
        getSubTitle().setText("邀请记录");

    }

    @OnClick({R.id.rl_read_contacts, R.id.btn_send , R.id.toolbar_subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_read_contacts:
                //读取联系人
                //**版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取**
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                            != PackageManager.PERMISSION_GRANTED) {
                        // 若不为GRANTED(即为DENIED)则要申请权限了
                        // 申请权限 第一个为context 第二个可以指定多个请求的权限 第三个参数为请求码
                        ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.READ_CONTACTS},
                                100);
                    } else {
                        //权限已经被授予，在这里直接写要执行的相应方法即可
                        intentToContact();
                    }
                } else {
                    // 低于6.0的手机直接访问
                    intentToContact();
                }
                break;
            case R.id.btn_send:
                //发送短信

                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                    ToastUtil.showShortToast(context , "手机号码不能为空");
                    return;
                }

                //**版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取**
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                            != PackageManager.PERMISSION_GRANTED) {
                        // 若不为GRANTED(即为DENIED)则要申请权限了
                        // 申请权限 第一个为context 第二个可以指定多个请求的权限 第三个参数为请求码
                        ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.SEND_SMS},
                                101);
                    } else {
                        //权限已经被授予，在这里直接写要执行的相应方法即可
                        doSendSMSTo(etPhone.getText().toString() , "111");
                    }
                } else {
                    // 低于6.0的手机直接访问
                    doSendSMSTo(etPhone.getText().toString() , "111");
                }
                break;
            case R.id.toolbar_subtitle:
                //邀请记录
                StartActivityUtil.start(this , InviteHistoryActivity.class);
                break;
        }
    }

    /**
     * 调起系统发短信功能
     *
     * @param phoneNumber
     * @param message
     */
    public void doSendSMSTo(String phoneNumber, String message) {
        if (PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumber));
            intent.putExtra("sms_body", message);
            startActivity(intent);
        }
    }

    private void intentToContact() {
        // 跳转到联系人界面
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("vnd.android.cursor.dir/phone_v2");
        startActivityForResult(intent, 0x30);
    }

    // 用户权限 申请 的回调方法
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                intentToContact();
            } else {
                ToastUtil.showShortToast(context, "授权被禁止");
            }
        }
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                doSendSMSTo(etPhone.getText().toString() , "111");
            } else {
                ToastUtil.showShortToast(context, "授权被禁止");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions,
                grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x30) {
            if (data != null) {
                Uri uri = data.getData();
                String phoneNum = null;
                String contactName = null;
                // 创建内容解析者
                ContentResolver contentResolver = getContentResolver();
                Cursor cursor = null;
                if (uri != null) {
                    cursor = contentResolver.query(uri,
                            new String[]{"display_name", "data1"}, null, null, null);
                }
                while (cursor.moveToNext()) {
                    contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    phoneNum = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
                cursor.close();
                //  把电话号码中的  -  符号 替换成空格
                if (phoneNum != null) {
                    phoneNum = phoneNum.replaceAll("-", " ");
                    // 空格去掉  为什么不直接-替换成"" 因为测试的时候发现还是会有空格 只能这么处理
                    phoneNum = phoneNum.replaceAll(" ", "");
                }

                etPhone.setText(phoneNum);

            }
        }
    }

}
