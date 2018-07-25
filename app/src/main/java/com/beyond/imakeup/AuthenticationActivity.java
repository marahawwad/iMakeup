package com.beyond.imakeup;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.view.KeyEvent;
import android.widget.Button;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.support.v7.app.AppCompatActivity;

public class AuthenticationActivity extends AppCompatActivity {

    private EditText mPhoneView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        mPhoneView = findViewById(R.id.phonenumber);
        mPasswordView = findViewById(R.id.password);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button SignInButton = findViewById(R.id.sign_in_button);
        SignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();

                Intent in =new Intent(AuthenticationActivity.this,HomeActivity.class);
                startActivity(in);
            }
        });
    }

    private void attemptLogin() {

        mPhoneView.setError(null);
        mPasswordView.setError(null);

        String phone = mPhoneView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if ( !isPasswordValid(password)) {
            mPasswordView.setError("الرقم السري يجب أن يتكون من 6 خانات");
            focusView = mPasswordView;
            cancel = true;
        }

        if (TextUtils.isEmpty(phone)) {
            mPhoneView.setError("هذا الحقل مطلوب");
            focusView = mPhoneView;
            cancel = true;
        } else if (!isPhoneValid(phone)) {
            mPhoneView.setError("رقم الهاتف خاطئ");
            focusView = mPhoneView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isPhoneValid(String email) {
        return
                ( email.startsWith("077") || email.startsWith("078") || email.startsWith("079") )
                && email.length() == 10;
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 5;
    }

    public void go_to_register(View view) {
        if (view.getId() == R.id.go_to_register)
            startActivity(new Intent(AuthenticationActivity.this,RegisterActivity.class));
    }

    public void go_to_contact(View view) {
        if (view.getId() == R.id.go_to_contact)
            startActivity(new Intent(AuthenticationActivity.this,ContactActivity.class));
    }
}

