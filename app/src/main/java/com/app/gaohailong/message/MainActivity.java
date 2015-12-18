package com.app.gaohailong.message;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout mInputLayout;
    private EditText mEditText;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Snackbar的使用
        findViewById(R.id.id_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbar(v);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, TabActivity.class));
                    }
                }, 3000);
            }
        });

        //TextInputLayout的使用
        mInputLayout = (TextInputLayout) findViewById(R.id.id_text_input_layout1);
        mInputLayout.setHint("请输入邮箱");
        mEditText = (EditText) findViewById(R.id.id_edit_text);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 4){
                    mInputLayout.setErrorEnabled(true);
                    mInputLayout.setError("用户名不能超过4个字符");
                }else {
                    mInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //FloatingActionButton的使用
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.id_floating_action_button);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "FloatingActionButton", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showSnackbar(View v) {
        Snackbar.make(v, "Snackbar come out", Snackbar.LENGTH_LONG).setAction("点我", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG).show();
            }
        }).setActionTextColor(Color.GREEN).show();
    }
}
