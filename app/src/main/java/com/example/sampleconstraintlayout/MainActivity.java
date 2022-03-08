package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin=findViewById(R.id.btSignIn);

        //Menghubungkan variabel edemail dengan componen button pada layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edPassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //Membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //mengeset email yang benar
                String email = "admin@mail.com";

                //mengeset password yang benar
                String pass = "123";

                //Membuat validasi Login inputan user
                if(nama.equals(email) && password.equals(pass)) {
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();

                    //Membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukkan value dari variabel nama dengan kunci "a" dan dimasukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variabel nama dengan kunci "b" dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //Membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                    Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                    //Memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                    i.putExtras(b);

                    //berpindah ke ActivityHasil
                    startActivity(i);

                    //Menghapus isi dari textview
                    edemail.getText().clear();
                    edpassword.getText().clear();
                }
                else if (nama.equals(email)){
                    Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT).show();
                }
                else if (password.equals(pass)){
                    Toast.makeText(getApplicationContext(), "Email Salah", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Email dan Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}