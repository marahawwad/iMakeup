package com.beyond.imakeup;

import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;
import android.content.Intent;
import android.widget.EditText;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;

public class RegisterActivity extends Activity {

    private EditText username , phone ;
    private TextInputLayout password , repassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //getActionBar().hide();

        username = findViewById(R.id.username);
        phone = findViewById(R.id.phone);
        // password = findViewById(R.id.password);
        // repassword = findViewById(R.id.repassword);

    }

    public void go_to_login(View view) {
        if (view.getId() == R.id.go_to_login)
            startActivity(new Intent(RegisterActivity.this , AuthenticationActivity.class));
    }

    public void reqister(View view) {

        /*
        username.setError(null);
        phone.setError(null);
        password.setError(null);
        repassword.setError(null);
        */

        String _username = username.getText().toString();
        String _phone = phone.getText().toString();
        String _password = "" ; // password.getEditText().toString();
        String _repassword = ""; // repassword.getEditText().toString();

        boolean cancel = false;
        // View focusView = null;

        if ( !isUsernameValid(_username)) {
            Snackbar.make(view , "إسم المستخدم غير صحيح" , Snackbar.LENGTH_LONG).show();
            // username.setError("إسم المستخدم غير صحيح");
            // focusView = username;
            cancel = true;
        }

        else if (!isPasswordValid(_password)) {
            // password.setError("الرقم السري يجب أن يتكون من 6 خانات");
            // focusView = password;
            Snackbar.make(view , "الرقم السري يجب أن يتكون من 6 خانات" , Snackbar.LENGTH_LONG).show();
            cancel = true;
        }

        else if (!isMatchPassword(_password , _repassword )) {
            // password.setError("كلمات المرور غير متشابهة");
            // repassword.setError("كلمات المرور غير متشابهة");
            // focusView = password;
            Snackbar.make(view , "كلمات المرور غير متشابهة" , Snackbar.LENGTH_LONG).show();
            cancel = true;
        }

        else if (!isPhoneValid(_phone)) {
            // phone.setError("رقم الهاتف خاطئ");
            // focusView = phone;
            Snackbar.make(view , "رقم الهاتف خاطئ" , Snackbar.LENGTH_LONG).show();
            cancel = true;
        }

        if (cancel) {
            // focusView.requestFocus();
        } else {
            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 5;
    }

    private boolean isUsernameValid(String username) {
        return username.length() > 5;
    }

    private boolean isPhoneValid(String phone) {
        return
                ( phone.startsWith("077") || phone.startsWith("078") || phone.startsWith("079") )
                        && phone.length() == 10;
    }

    private boolean isMatchPassword(String p1 , String p2) {
        return p1.equals(p2);
    }

    public void go_to_contact(View view) {
        startActivity(new Intent(RegisterActivity.this,ContactActivity.class));
    }
}
