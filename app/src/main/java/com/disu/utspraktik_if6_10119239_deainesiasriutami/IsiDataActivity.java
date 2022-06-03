package com.disu.utspraktik_if6_10119239_deainesiasriutami;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IsiDataActivity extends AppCompatActivity {

    @BindView(R.id.tgl_konfir)
    EditText tglKonfir;
    private String tgl_konfir = "";

    @BindView(R.id.nik)
    EditText nik;
    private String input_nik = "";

    @BindView(R.id.nama)
    EditText nama;
    private String input_nama = "";

    @BindView(R.id.tgl_lhr)
    EditText tglLhr;
    private String input_tgllhr = "";

    @BindView(R.id.radio_jenis)
    RadioGroup jenisTes;
    private String input_jenisTes = "";

    @BindView(R.id.radio_jk)
    RadioGroup jenisKel;
    private String input_jenisKel = "";

    @BindView(R.id.radio_hub)
    RadioGroup jenisHub;
    private String input_jenisHub = "";

    public static final String EXTRA_JENIS_TES = "";
    public static final String EXTRA_TGL_KONFIR = "";
    public static final String EXTRA_NIK = "";
    public static final String EXTRA_NAMA = "";
    public static final String EXTRA_TGL_LHR = "";
    public static final String EXTRA_JK = "";
    public static final String EXTRA_HUB = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_next)
    public void next(View view) {
        tgl_konfir = tglKonfir.getText().toString();
        input_nik = nik.getText().toString();
        input_nama = nama.getText().toString();
        input_tgllhr = tglLhr.getText().toString();

        if(inputKosong(tgl_konfir)) {
            WarningToast("Tanggal Konfirmasi");
        } else if (inputKosong(input_nama)) {
            WarningToast("Nama");
        } else if (inputKosong(input_tgllhr)) {
            WarningToast("Tanggal Lahir");
        } else if (inputKosong(input_jenisTes)) {
            WarningToast("Jenis Tes");
        } else if (inputKosong(input_jenisKel)) {
            WarningToast("Jenis Kelamin");
        } else if (inputKosong(input_jenisHub)) {
            WarningToast("Hubungan dengan Anda");
        } else {
            Intent intent = new Intent(this, CekData.class);

            intent.putExtra(EXTRA_JENIS_TES, input_jenisTes);
            intent.putExtra(EXTRA_TGL_KONFIR, tgl_konfir);
            intent.putExtra(EXTRA_NIK, input_nik);
            startActivity(intent);
        }
    }

    public static boolean inputKosong(String text) {
        return "".equals(text);
    }

    public String inputJenisTes() {
        jenisTes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rapid:
                        input_jenisTes = "Rapid Antigen";
                        break;
                    case R.id.pcr:
                        input_jenisTes = "PCR";
                        break;
                }
            }
        });
        return input_jenisTes;
    }

    public String inputJenisKel() {
        jenisKel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.lk:
                        input_jenisKel = "Laki - laki";
                        break;
                    case R.id.pr:
                        input_jenisKel = "Perempuan";
                        break;
                }
            }
        });
        return input_jenisKel;
    }

    public String inputJenisHub() {
        jenisHub.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.ortu:
                        input_jenisKel = "Orangtua";
                        break;
                    case R.id.su_is:
                        input_jenisKel = "Suami / Istri";
                        break;
                    case R.id.anak:
                        input_jenisKel = "Anak";
                        break;
                    case R.id.kerabat:
                        input_jenisKel = "Kerabat";
                        break;
                }
            }
        });
        return input_jenisHub;
    }

    public void WarningToast(String title) {
        Toast.makeText(this, title+ " belum diisi", Toast.LENGTH_LONG).show();
    }



}