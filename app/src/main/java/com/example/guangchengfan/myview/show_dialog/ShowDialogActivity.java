package com.example.guangchengfan.myview.show_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guangchengfan.myview.R;

public class ShowDialogActivity extends Activity implements View.OnClickListener{
    private Button btn_show_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dialog);
        btn_show_dialog = (Button)findViewById(R.id.btn_show_dialog);
        btn_show_dialog.setOnClickListener(this);
//        showDialog(1);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_show_dialog) {
            showDialogTest();
//            showDialog(1);
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id != 1)
            return super.onCreateDialog(id);

        Log.d("ShowDialogActivity", "ShowDialogActivity onCreateDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(ShowDialogActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("弹出警告框");
        builder.setMessage("确定删除吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(ShowDialogActivity.this, "positive: " + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(ShowDialogActivity.this, "negative: " + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(ShowDialogActivity.this, "neutral: " + which, Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }

    private void showDialogTest() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplication());
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("弹出警告框");
        builder.setMessage("确定删除吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(ShowDialogActivity.this, "positive: " + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(ShowDialogActivity.this, "negative: " + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(ShowDialogActivity.this, "neutral: " + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

}
