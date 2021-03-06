package com.skariga.simorin.perusahaan;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.skariga.simorin.R;
import com.skariga.simorin.auth.LoginActivity;
import com.skariga.simorin.auth.SessionManager;
import com.skariga.simorin.sekolah.DashboardPemSekolahActivity;
import com.skariga.simorin.siswa.DashboardSiswaActivity;

import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class DashboardPemPerusahaanActivity extends AppCompatActivity {

    RelativeLayout absen, jurnal;
    TextView nama, perusahaan;
    ImageView logout;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarGradiant(DashboardPemPerusahaanActivity.this);
        setContentView(R.layout.activity_dashboard_pem_perusahaan);

        absen = findViewById(R.id.acc_absen);
        jurnal = findViewById(R.id.acc_jurnal);
        logout = findViewById(R.id.iv_logout);
        nama = findViewById(R.id.tv_nama);
        perusahaan = findViewById(R.id.tv_perusahaan);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin("Pembimbing Perusahaan");

        HashMap<String, String> user =  sessionManager.getUserDetail();
        String mPer = user.get(sessionManager.PSB);
        String mNama = user.get(sessionManager.NAMA);

        perusahaan.setText(mPer);
        nama.setText(mNama);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(DashboardPemPerusahaanActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Yeay...")
                        .setContentText("Anda berhasil Logout!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sessionManager.logout("Pembimbing Perusahaan");
                            }
                        })
                        .show();
            }
        });

        absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardPemPerusahaanActivity.this, AccAbsenPemPerusahaanActivity.class);
                startActivity(i);
                finish();
            }
        });

        jurnal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardPemPerusahaanActivity.this, AccJurnalPemPerusahaanActivity.class);
                startActivity(i);
                finish();
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