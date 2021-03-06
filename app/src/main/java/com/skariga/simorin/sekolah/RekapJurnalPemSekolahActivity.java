package com.skariga.simorin.sekolah;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.skariga.simorin.R;
import com.skyhope.showmoretextview.ShowMoreTextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RekapJurnalPemSekolahActivity extends AppCompatActivity {

    ImageView kembali;
    RelativeLayout perusahaan, siswa, ttd_jurnal, jurnal;
    LinearLayout lp1, lp2, lp3, lp4, lp5, lp6, lp7, lp8, ls1, ls2, ls3, ls4, ls5, ls6, ls7, ls8, ls9;
    Button semua, dipilih;
    ShowMoreTextView kegiatan, prosedur, spek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarGradiant(RekapJurnalPemSekolahActivity.this);
        setContentView(R.layout.activity_rekap_jurnal_pem_sekolah);

        kembali = findViewById(R.id.back);
        perusahaan = findViewById(R.id.rl_perusahaan);
        siswa = findViewById(R.id.rl_siswa);
        ttd_jurnal = findViewById(R.id.rl_ttd_jurnal);
        jurnal = findViewById(R.id.rl_jurnal);
        semua = findViewById(R.id.btn_semua);
        dipilih = findViewById(R.id.btn_dipilih);
        lp1 = findViewById(R.id.perusahaan2);
        lp2 = findViewById(R.id.perusahaan3);
        lp3 = findViewById(R.id.perusahaan4);
        lp4 = findViewById(R.id.perusahaan5);
        lp5 = findViewById(R.id.perusahaan6);
        lp6 = findViewById(R.id.perusahaan7);
        lp7 = findViewById(R.id.perusahaan8);
        lp8 = findViewById(R.id.perusahaan9);
        ls1 = findViewById(R.id.siswa1);
        ls2 = findViewById(R.id.siswa2);
        ls3 = findViewById(R.id.siswa3);
        ls4 = findViewById(R.id.siswa4);
        ls5 = findViewById(R.id.siswa5);
        ls6 = findViewById(R.id.siswa6);
        ls7 = findViewById(R.id.siswa7);
        ls8 = findViewById(R.id.siswa8);
        ls9 = findViewById(R.id.siswa9);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RekapJurnalPemSekolahActivity.this, DashboardPemSekolahActivity.class);
                startActivity(i);
                finish();
            }
        });

        semua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(RekapJurnalPemSekolahActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Maaf...")
                        .setContentText("Fitur ini masih dalam pengembangan :)")
                        .show();
            }
        });

        dipilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(RekapJurnalPemSekolahActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Maaf...")
                        .setContentText("Fitur ini masih dalam pengembangan :)")
                        .show();
            }
        });

        lp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perusahaan.setVisibility(View.GONE);
                siswa.setVisibility(View.VISIBLE);
            }
        });

        lp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perusahaan.setVisibility(View.GONE);
                siswa.setVisibility(View.VISIBLE);
            }
        });

        lp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perusahaan.setVisibility(View.GONE);
                siswa.setVisibility(View.VISIBLE);
            }
        });

        lp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perusahaan.setVisibility(View.GONE);
                siswa.setVisibility(View.VISIBLE);
            }
        });

        lp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perusahaan.setVisibility(View.GONE);
                siswa.setVisibility(View.VISIBLE);
            }
        });

        lp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perusahaan.setVisibility(View.GONE);
                siswa.setVisibility(View.VISIBLE);
            }
        });

        lp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perusahaan.setVisibility(View.GONE);
                siswa.setVisibility(View.VISIBLE);
            }
        });

        lp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perusahaan.setVisibility(View.GONE);
                siswa.setVisibility(View.VISIBLE);
            }
        });

        ls1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siswa.setVisibility(View.GONE);
                ttd_jurnal.setVisibility(View.VISIBLE);
                jurnal.setVisibility(View.VISIBLE);
            }
        });

        ls2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siswa.setVisibility(View.GONE);
                ttd_jurnal.setVisibility(View.VISIBLE);
                jurnal.setVisibility(View.VISIBLE);
            }
        });

        ls3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siswa.setVisibility(View.GONE);
                ttd_jurnal.setVisibility(View.VISIBLE);
                jurnal.setVisibility(View.VISIBLE);
            }
        });

        ls4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siswa.setVisibility(View.GONE);
                ttd_jurnal.setVisibility(View.VISIBLE);
                jurnal.setVisibility(View.VISIBLE);
            }
        });

        ls5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siswa.setVisibility(View.GONE);
                ttd_jurnal.setVisibility(View.VISIBLE);
                jurnal.setVisibility(View.VISIBLE);
            }
        });

        ls6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siswa.setVisibility(View.GONE);
                ttd_jurnal.setVisibility(View.VISIBLE);
                jurnal.setVisibility(View.VISIBLE);
            }
        });

        ls7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siswa.setVisibility(View.GONE);
                ttd_jurnal.setVisibility(View.VISIBLE);
                jurnal.setVisibility(View.VISIBLE);
            }
        });

        ls8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siswa.setVisibility(View.GONE);
                ttd_jurnal.setVisibility(View.VISIBLE);
                jurnal.setVisibility(View.VISIBLE);
            }
        });

        ls9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siswa.setVisibility(View.GONE);
                ttd_jurnal.setVisibility(View.VISIBLE);
                jurnal.setVisibility(View.VISIBLE);
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