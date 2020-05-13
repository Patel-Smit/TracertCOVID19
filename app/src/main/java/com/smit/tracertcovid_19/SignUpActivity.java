package com.smit.tracertcovid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    EditText name, birthday, city, email, password;
    Button btnSignup;
    FirebaseAuth mFirebaseAuth;
    TextView signIn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.signup_et_name);
        birthday = findViewById(R.id.signup_et_DOB);
        city = findViewById(R.id.signup_et_city);
        email = findViewById(R.id.signup_et_email);
        password = findViewById(R.id.signup_et_password);
        btnSignup = findViewById(R.id.btn_signup);
        signIn = findViewById(R.id.signup_tv_signin);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String namee = name.getText().toString();
                String birthdayy = birthday.getText().toString();
                String cityy = city.getText().toString();
                String emailId = email.getText().toString();
                String passwd = password.getText().toString();

                UserHelperClass helperClass = new UserHelperClass(namee,birthdayy,cityy,emailId,passwd);
                reference.child(passwd).setValue(helperClass);

                if (emailId.isEmpty()) {
                    email.setError("Please enter email address");
                    email.requestFocus();
                } else if (passwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (emailId.isEmpty() && passwd.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else if (!(emailId.isEmpty() && passwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(emailId, passwd).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "User Unsuccessful, Please try again", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this, "Error !!!", Toast.LENGTH_SHORT);
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
