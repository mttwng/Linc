package linc.linc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final ImageButton fb_auth = (ImageButton) findViewById(R.id.fb_auth_button);
        fb_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fb_auth.setImageResource(R.drawable.checkmark);
            }
        });

        final ImageButton in_auth = (ImageButton) findViewById(R.id.in_auth_button);
        in_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in_auth.setImageResource(R.drawable.checkmark);
            }
        });


        Button signup_confirm = (Button) findViewById(R.id.signup_confirm);
        signup_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start intent to Matt's MainActivity
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
