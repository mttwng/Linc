package linc.linc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();

        Button confirm_login = (Button) findViewById(R.id.confirm_login);
        confirm_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = ((EditText)findViewById(R.id.password_login)).getText().toString();
                String user = ((EditText)findViewById(R.id.username_login)).getText().toString();

                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.login_layout);

                if(passwordMatch(pwd) && usersMatch(user)) {

                    //linearLayout.removeView((EditText)findViewById(R.id.password_login));
                    //linearLayout.removeView((EditText)findViewById(R.id.username_login));
                    //linearLayout.removeView((Button)findViewById(R.id.login_button));

                    linearLayout.addView(createNewTextView("Login Successful!"));

                    // start intent to Matt's MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    linearLayout.addView(createNewTextView("Try Again"));
                    ((EditText) findViewById(R.id.username_login)).setText("");
                    ((EditText) findViewById(R.id.password_login)).setText("");
                }


            }
        });


    }

    private TextView createNewTextView(String text) {
        final LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText(text);
        textView.setPadding(20, 20, 20, 20);
        return textView;
    }

    private boolean passwordMatch(String given_password) {
        if (given_password.equals("abc123") || (given_password.equals("password"))
                || (given_password.equals("123456"))) {
            return true;
        }
        return true;
    }

    private boolean usersMatch(String given_user) {
        if (given_user.equals("namrata.das") || given_user.equals("john.doe")
                || given_user.equals("sally.ride")) {
            return true;
        }
        return false;
    }
}
