package com.skariga.simorin.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.skariga.simorin.ortu.DashboardOrangTuaActivity;
import com.skariga.simorin.perusahaan.DashboardPemPerusahaanActivity;
import com.skariga.simorin.sekolah.DashboardPemSekolahActivity;
import com.skariga.simorin.siswa.DashboardSiswaActivity;
import com.skariga.simorin.R;
import com.skyhope.showmoretextview.ShowMoreTextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText et_user, et_pass;
    String username, password;
    SessionManager sessionManager;
    public static String URL_LOGIN = "https://simorin.malangcreativeteam.biz.id/api/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarGradiant(LoginActivity.this);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        et_user = findViewById(R.id.et_username);
        et_pass = findViewById(R.id.et_password);

        sessionManager = new SessionManager(getApplicationContext());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_user.getText().toString().trim();
                password = et_pass.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Maaf...")
                            .setContentText("Username dan Password tidak boleh kosong!")
                            .show();
                } else {
                    Login(username, password);
                }
            }

            private void Login(final String user, final String pass) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String success = jsonObject.getString("RESULT");
                                    JSONObject object = jsonObject.getJSONObject("USER");

                                    if (success.equals("OK")) {
                                        String id = object.getString("ID").trim();
                                        String nama = object.getString("NAMA").trim();
                                        String psb = object.getString("NAMA_PERUSAHAAN").trim();
                                        String role = object.getString("ROLE").trim();

                                        sessionManager.createSession(id, nama, psb, role);

                                        if (role.equals("Siswa")) {
                                            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                                    .setTitleText("Yaey...")
                                                    .setContentText("Anda Berhasil Login!")
                                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                        @Override
                                                        public void onClick(SweetAlertDialog sweetAlertDialog) {

                                                            Intent i = new Intent(LoginActivity.this, DashboardSiswaActivity.class);
                                                            startActivity(i);
                                                            finish();
                                                        }
                                                    })
                                                    .show();
                                        } else if (role.equals("Pembimbing Sekolah")) {
                                            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                                    .setTitleText("Yaey...")
                                                    .setContentText("Anda Berhasil Login!")
                                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                        @Override
                                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                            Intent i = new Intent(LoginActivity.this, DashboardPemSekolahActivity.class);
                                                            startActivity(i);
                                                            finish();
                                                        }
                                                    })
                                                    .show();
                                        } else if (role.equals("Pembimbing Perusahaan")) {
                                            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                                    .setTitleText("Yaey...")
                                                    .setContentText("Anda Berhasil Login!")
                                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                        @Override
                                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                            Intent i = new Intent(LoginActivity.this, DashboardPemPerusahaanActivity.class);
                                                            startActivity(i);
                                                            finish();
                                                        }
                                                    })
                                                    .show();
                                        } else if (role.equals("Orang Tau")) {
                                            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                                    .setTitleText("Yaey...")
                                                    .setContentText("Anda Berhasil Login!")
                                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                        @Override
                                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                            Intent i = new Intent(LoginActivity.this, DashboardOrangTuaActivity.class);
                                                            startActivity(i);
                                                            finish();
                                                        }
                                                    })
                                                    .show();
                                        } else {
                                            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.WARNING_TYPE)
                                                    .setTitleText("Maaf...")
                                                    .setContentText("Akses ditolak!")
                                                    .show();
                                        }

                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("Error...")
                                            .setContentText(e.toString())
                                            .show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Error...")
                                        .setContentText(error.toString())
                                        .show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("username", user);
                        params.put("password", pass);
                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                requestQueue.add(stringRequest);

            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarGradiant(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            Drawable background = activity.getResources().getDrawable(R.drawable.gradient);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }
    }
}