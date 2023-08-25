package com.raion.putrautama.mounesiaprototype.Soal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raion.putrautama.mounesiaprototype.GagalTest.GagalTestMenengahActivity;
import com.raion.putrautama.mounesiaprototype.LulusTest.LulusTestMenengahActivity;
import com.raion.putrautama.mounesiaprototype.MainActivity;
import com.raion.putrautama.mounesiaprototype.Model.NilaiMenengah;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SoalMenengahActivity extends AppCompatActivity {
    ImageView mBack;

    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private  int QUIZ_COUNT =10;
    Users mUsers;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            //{"country"
            // ,"right answer"
            // , choice 1
            // , choice2
            // , choice3};

            {"1)\tMengkoordinasi anggota\n" +
                    "2)\tMelakukan pertolongan pertama\n" +
                    "3)\tMelihat kemampuan anggota\n" +
                    "4)\tMengadakan orientasi medan\n" +
                    "5)\tMengadakan penjatahan makanan\n" +
                    "6)\tMembuat rencana dan pembagian tugas\n" +
                    "7)\tBerusaha menyambung komunikasi dengan dunia kuar\n" +
                    "8)\tMembuat jejak dan perhatian\n" +
                    "9)\tMendapatkan pertolongan\n" +
                    "Urutkanlah langkah yang harus ditempuh bila anda/kelompok anda tersesat"
                    ,"1-2-3-4-5-6-7-8-9"
                    ,"1-4-5-6-2-3-8-7-9"
                    ,"2-3-4-5-7-8-6-1-9"
                    ,"1-3-2-4-6-9-8-7-5"},
            {"1)\tPermukaan daun atau batang yang tidak berbulu atau berduri\n" +
                    "2)\ttidak mengeluarkan getah yang sangat lekat,\n" +
                    "3)\tBerasa pahit\n" +
                    "4)\tPermukaan daun atau batang yang berbulu atau berduri\n" +
                    "5)\tMenimbulkan rasa gatal\n" +
                    "Ciri ciri tumbuhan yang dapat dimakan secara fisik yaitu"
                    ,"1 dan 2"
                    ,"2 dan 3"
                    ,"3,4 dan 5"
                    ,"1, 2, dan 3"},
            {"Bahan yang merupakan prioritas utama dalam keadaan darurat untuk bertahan hidup saat mendaki gunung adalah"
                    ,"Udara"
                    ,"Air"
                    ,"Tempat berlindung"
                    ,"Makanan"},
            {"Secara fisik kompas terdiri dari, kecuali"
                    ,"Koordinat"
                    ,"Jarum"
                    ,"Skala penunjuk"
                    ,"Badan kompas"},
            {"Beberapa unsur yang dapat dilihat dalam peta yaitu,kecuali"
                    ,"Skala Penunjuk peta"
                    ,"Kooditnat Peta"
                    ,"Nomor Peta"
                    ,"Judul peta"},
            {"apa yang dimaksud demham penampang lintasan"
                    ,"Penggambaran secara proporsional bentuk jalur lintasan jika dilihat dari samping, dengan menggunakan garis kontur sebagai acuan"
                    ,"Sumbu yang digunakan adalah garis bujur (bujur barat dan bujur timur) yang tegak lurus dengan garis khatulistiwa, dan garis lintang (lintang utara dan lintang selatan) yang sejajar dengan garis khatulistiwa."
                    ,"Perlengkapan untuk survival yang harus dibawa dalam perjalanan sebagai alat berjaga-jaga bila terjadi keadaan darurat atau juga dapat digunakan selama perjalanan"
                    ,"Alat penunjuk arah, dan karena sifat magnetnya, jarumnya akan selalu menunjuk arah utara-selatan (meskipun utara yang dimaksud disini bukan utara yang sebenarnya, tapi utara magnetis)."},
            {"Berikut ini merupakan langkah langkah orientasi peta\n" +
                    "1.\tUsahakan untuk mencari tempat yang berpemandangan terbuka agar dapat melihat tanda-tanda medan yang menyolok.\n" +
                    "2.\tUtarakan peta, dengan berpatokan pada kompas, sehingga arah peta sesuai dengan arah medan sebenarnya\n" +
                    "3.\tSiapkan kompas dan peta anda, letakkan pada bidang datar\n" +
                    "4.\tIngat tanda-tanda itu, bentuknya dan tempatnya di medan yang sebenarnya. Ingat hal-hal khas dari tanda medan.\n" +
                    "5.\tCari tanda-tanda medan yang paling menonjol disekitar anda, dan temukan tanda-tanda medan tersebut di peta. Lakukan hal ini untuk beberapa tanda medan\n" +
                    "\n" +
                    "Yang merupakan urutan langkah – langkah orientasi peta yang benar adalah"
                    ,"1-3-2-5-4"
                    ,"1-2-3-4-5"
                    ,"1-4-5-3-2"
                    ,"1-5-4-2-3"},
            {"Berikut merupakan cara membuat api dalam keadaan darurat adalah, kecuali"
                    ,"Dengan menggesekan kayu basah dengan kayu kering"
                    ,"Busur dan gurdi"
                    ,"Gesekan kayu dengan kayu"
                    ,"Dengan lensa / Kaca pembesar"},
            {"Ciri ciri binatang yang tidak dapat dimakan yaitu, kecuali"
                    ,"Binatang yang memiliki rasa yang enak"
                    ,"Binatang yang mengandung bisa"
                    ,"Binatang yang mengandung bau yang khas"
                    ,"Binatang yang mengandung racun"},
            {"Syarat atau patokan makanan yang dapat dikonsumsi pada saat kondisi hidup di alam bebas yaitu"
                    ,"Makanan yang juga dimakan kera"
                    ,"Tanaman dan buah yang berwarna mencolok"
                    ,"Makanan  yang mengeluarkan getah putih seperti sabun"
                    ,"Makanan terlalu pahit atau asam"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_menengah);
        mUsers = (Users) getIntent().getSerializableExtra("USER");

        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(SoalMenengahActivity.this,MainActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });

        countLabel = findViewById(R.id.countLabelMenengah);
        questionLabel = findViewById(R.id.questionLabelMenengah);
        answerBtn1 = findViewById(R.id.answerbtn1Menengah);
        answerBtn2 = findViewById(R.id.answerbtn2Menengah);
        answerBtn3 = findViewById(R.id.answerbtn3Menengah);
        answerBtn4 = findViewById(R.id.answerbtn4Menengah);

        for (int i = 0; i <quizData.length ; i++) {
            ArrayList<String> tempArray = new ArrayList<>();
            tempArray.add(quizData[i][0]);
            tempArray.add(quizData[i][1]);
            tempArray.add(quizData[i][2]);
            tempArray.add(quizData[i][3]);
            tempArray.add(quizData[i][4]);

            quizArray.add(tempArray);
        }

        showNextQuiz();
    }
    private void showNextQuiz() {

        countLabel.setText("Pertanyaan Ke-" + quizCount);


        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        quizArray.remove(randomNum);
    }
    public void checkAnswer(View view){
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle = "Apakah anda yakin dengan pilihan anda?";

        if (btnText.equals(rightAnswer)){
            rightAnswerCount++;
        }else {
        }

        if (quizCount ==  QUIZ_COUNT){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(alertTitle);
            builder.setPositiveButton("IYA", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    if (rightAnswerCount >= 6){
                        writeToDataBase(rightAnswerCount);
                        Intent intent = new Intent(SoalMenengahActivity.this, LulusTestMenengahActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }else {
                        writeToDataBase(rightAnswerCount);
                        Intent intent = new Intent(SoalMenengahActivity.this, GagalTestMenengahActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }
                }
            });
            builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setCancelable(false);
            builder.show();
        }else {
            quizCount++;
            showNextQuiz();
        }
    }

    void writeToDataBase(int rightAnswerCountMenengah ){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        NilaiMenengah nilaiMenengah = new NilaiMenengah(rightAnswerCountMenengah);
        databaseReference.child("Users").child(mUsers.getUniqueId()).child("nilaiMenengah").setValue(nilaiMenengah);
    }
}
