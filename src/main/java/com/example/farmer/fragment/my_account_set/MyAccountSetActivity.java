package com.example.farmer.fragment.my_account_set;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.farmer.R;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class MyAccountSetActivity extends AppCompatActivity {
    private static final String IMAGE_UNSPECIFIED = "image/*";
    public static final int NONE = 0;
    private static final int PHOTOHRAPH = 1;//拍照
    private static final int PHOTOZOOM = 2;//缩放
    private static final int PHOTORESULT = 3;//缩放
    ImageView user_photo;
    ImageView my_set_back;//账号设置返回键
    LinearLayout my_set_account;//退出当前账号
    LinearLayout my_set_photo;//设置头像
   Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_set);
        initViews();//绑定控件
        Listeners();//事件监听
    }

    private void Listeners() {
        //返回键监听
        my_set_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用系统的finish方法，返回到
                //finish();
                onBackPressed();
            }
        });
        //头像设置
        my_set_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doUploadPhoto();

            }


        });

    }

    private void doUploadPhoto() {
        View view = getLayoutInflater().inflate(R.layout.my_upload_photo, null);//绑定布局
        Dialog dialog = new Dialog(this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //获取对话框的window实例
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        //设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.onWindowAttributesChanged(wl);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        mDialog=dialog;

    }

    private void initViews() {
        my_set_back = (ImageView) findViewById(R.id.my_set_back);
        my_set_account = (LinearLayout) findViewById(R.id.my_set_account);
        my_set_photo = (LinearLayout) findViewById(R.id.my_set_photo);
        user_photo= (ImageView) findViewById(R.id.user_photo);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //本地上传图片
    public void local_upload(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        startActivityForResult(intent, PHOTOZOOM);
    }

    //拍照上传图片
    public void camera_upload(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "a.jpg")));
        startActivityForResult(intent, PHOTOHRAPH);
    }



        //取消上传
        public void cancel_upload (View view){
                mDialog.dismiss();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NONE) {
            return;
        }
        //拍照
        if (requestCode == PHOTOHRAPH) {
            //设置文件保存路径(暂时放在根目录下)
            File pic = new File(Environment.getExternalStorageDirectory() + "/a.jpg");
            startPhotoZoom(Uri.fromFile(pic));
        }
        if (data == null) {
            return;
        }
        //读取相册缩放图片
        if (requestCode == PHOTOZOOM) {
            startPhotoZoom(data.getData());
        }
        //处理结果
        if (requestCode == PHOTORESULT) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                Bitmap bitmap = bundle.getParcelable("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                user_photo.setImageBitmap(bitmap);
                //获得imageView中设置的图片
                BitmapDrawable drawable= (BitmapDrawable) user_photo.getDrawable();
                Bitmap bmp = drawable.getBitmap();
                //获得图片的宽，并创建结果bitmap
                int width = bmp.getWidth();
                Bitmap resultBmp = Bitmap.createBitmap(width, width,
                        Bitmap.Config.ARGB_8888);//该函数创建一个带有特定宽度、高度和颜色格式的位图。
                Paint paint = new Paint();//创建新画笔
                Canvas canvas = new Canvas(resultBmp);//为该位图创建一个画布
                //画圆
                canvas.drawCircle(width / 2, width / 2, width / 2, paint);//圆心坐标  半径 和画笔
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));// 选择交集去上层图片
                canvas.drawBitmap(bmp, 0, 0, paint);//将位图画到指定坐标
                user_photo.setImageBitmap(resultBmp);


            }
        }

    }

    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
        intent.putExtra("crop", "true");
        //设置传递的宽和高比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTORESULT);
    }
}



