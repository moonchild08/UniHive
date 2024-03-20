package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.*;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;

import java.util.HashMap;
import java.util.Map;

public class register_page extends AppCompatActivity {

    private EditText etEnroll, etEmail, etPhone, etPassword, etReenterPassword;
    private MaterialButton btnRegister;
    private String enroll, email, phone, password, reenterPassword;

    private String URL = "http:/192.168.1.5/register.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        TextView log_here = (TextView) findViewById(R.id.textView4);
        log_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), login_page.class));
            }
        });

        etEnroll = (EditText) findViewById(R.id.r1);
        etEmail = (EditText) findViewById(R.id.r2);
        etPhone = (EditText) findViewById(R.id.r3);
        etPassword = (EditText) findViewById(R.id.r4);
        etReenterPassword = (EditText) findViewById(R.id.r5);
        btnRegister = (MaterialButton) findViewById(R.id.signup);

        enroll = email = phone = password = reenterPassword = "";

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enroll = etEnroll.getText().toString().trim();
                email = etEmail.getText().toString().trim();
                phone = etPhone.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                reenterPassword = etReenterPassword.getText().toString().trim();

                if (!password.equals(reenterPassword)) {
                    Toast.makeText(register_page.this, "Password Mismatch", Toast.LENGTH_SHORT).show();

                } else if (!enroll.equals("") && !email.equals("") && !phone.equals("") && !password.equals("")) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("successsuccess")) {
                                Toast.makeText(register_page.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Success.class));
                            } else if (response.equals("failurefailure")) {
                                Toast.makeText(register_page.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                            }
                            else if (response.equals("successfailure")) {
                                Toast.makeText(register_page.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                            }
                            else if (response.equals("failuresuccess")) {
                                Toast.makeText(register_page.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("enroll", enroll);
                            data.put("email", email);
                            data.put("phone", phone);
                            data.put("password", password);
                            return data;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }
            }
        });

    }

}
