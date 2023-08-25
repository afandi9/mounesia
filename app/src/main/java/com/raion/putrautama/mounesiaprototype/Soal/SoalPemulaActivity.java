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
import com.raion.putrautama.mounesiaprototype.GagalTest.GagalTestPemulaActivity;
import com.raion.putrautama.mounesiaprototype.LulusTest.LulusTestPemulaActivity;
import com.raion.putrautama.mounesiaprototype.MainActivity;
import com.raion.putrautama.mounesiaprototype.Model.NilaiPemula;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SoalPemulaActivity extends AppCompatActivity {
    ImageView mBack;
//    Button mBtnSumbit;
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

            {"Persiapan umum yang harus dimiliki seorang pendaki sebelum naik gunung adalah,kecuali ?"
                    ,"Membawa alat alat yang berlebihan"
                    ,"Membawa alat navigasi berupa peta lokasi pendakian, peta, altimeter"
                    ,"Pastikan perut anda sudah terisi dari rumah"
                    ,"Mendaki dalam kondisi yang tidak sehat dan kuat"},
            {"Berikut dibawah ini yang merupakan perlengkapan dasar perjalanan yang harus dibawa, kecuali"
                    ,"Perlengkapan  pembantu :  jam tangan, penggaris, busur drajat"
                    ,"Perlengkapan masak dan makan: kompor, sendok, makanan, korek dll."
                    ,"Perlengkapan tidur : sleeping bag, tenda, matras dll."
                    ,"Perlengkapan jalan : sepatu, kaos kaki, celana, ikat pinggang, baju, topi, jas hujan, dll"},
            {"Berikut dibawah ini yang merupakan perlengkapan pembantu dalam melakukan pendakian gunung ,kecuali"
                    ,"Laptop"
                    ,"Kompas"
                    ,"Senter"
                    ,"Peta"},
            {"Persiapan apa yang diperlukan sebelum mendaki gunung, kecuali"
                    ,"Kesiapan paket data internet"
                    ,"Kesiapan fisik"
                    ,"Kesiapan mental"
                    ,"Kesiapan pengetahuan dan ketreampilan"},
            {"Hal – hal yang perlu diketahui saat melakukan pendakian, kecuali"
                    ,"Keadaan perut lapar"
                    ,"Keadaan alam (cuaca dan medan)"
                    ,"Keadaan mahluk hidup disekitar kita (binatang dan tumbuhan)"
                    ,"Keadaan diri sendiri (mental, fisik, dan kesehatan)"},
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
            {"Bahaya apa saja yang bisa saja dihadapi saat mendaki gunung yaitu, kecuali"
                    ,"Tidak menemukan spot untuk berfoto"
                    ,"Terpisah dari rombongan atau kelompok"
                    ,"Ketegangan dan panik"
                    ,"Sengatan panas matahari"},
            {"Berikut ini yang merupakan pengertian dari kompas adalah"
                    ,"Alat penunjuk arah, dan karena sifat magnetnya, jarumnya akan selalu menunjuk arah utara-selatan (meskipun utara yang dimaksud disini bukan utara yang sebenarnya, tapi utara magnetis)."
                    ,"Penggambaran dua dimensi (pada bidang datar) dari sebagian atau keseluruhan permukaan bumi yang dilihat dari atas, kemudian diperbesar atau diperkecil dengan perbandingan tertentu."
                    ,"Sumbu yang digunakan adalah garis bujur (bujur barat dan bujur timur) yang tegak lurus dengan garis khatulistiwa, dan garis lintang (lintang utara dan lintang selatan) yang sejajar dengan garis khatulistiwa."
                    ,"Perlengkapan untuk survival yang harus dibawa dalam perjalanan sebagai alat berjaga-jaga bila terjadi keadaan darurat atau juga dapat digunakan selama perjalanan"},
            {"Berikut ini yang merupakan pengertian dari peta adalah"
                    ,"Penggambaran dua dimensi (pada bidang datar) dari sebagian atau keseluruhan permukaan bumi yang dilihat dari atas, kemudian diperbesar atau diperkecil dengan perbandingan tertentu."
                    ,"Alat penunjuk arah, dan karena sifat magnetnya, jarumnya akan selalu menunjuk arah utara-selatan (meskipun utara yang dimaksud disini bukan utara yang sebenarnya, tapi utara magnetis)."
                    ,"Sumbu yang digunakan adalah garis bujur (bujur barat dan bujur timur) yang tegak lurus dengan garis khatulistiwa, dan garis lintang (lintang utara dan lintang selatan) yang sejajar dengan garis khatulistiwa."
                    ,"Perlengkapan untuk survival yang harus dibawa dalam perjalanan sebagai alat berjaga-jaga bila terjadi keadaan darurat atau juga dapat digunakan selama perjalanan"},
            {"1)\tPermukaan daun atau batang yang tidak berbulu atau berduri\n" +
                    "2)\ttidak mengeluarkan getah yang sangat lekat,\n" +
                    "3)\tBerasa pahit\n" +
                    "4)\tPermukaan daun atau batang yang berbulu atau berduri\n" +
                    "5)\tMenimbulkan rasa gatal\n" +
                    "Ciri ciri tumbuhan yang dapat dimakan secara fisik yaitu"
                    ,"1 dan 2"
                    ,"2 dan 3"
                    ,"3,4 dan 5"
                    ,"1, 2, dan 3"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_pemula);
        mBack = findViewById(R.id.back);

        mUsers = (Users) getIntent().getSerializableExtra("USER");

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(SoalPemulaActivity.this,MainActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });


        countLabel = findViewById(R.id.countLabelPemula);
        questionLabel = findViewById(R.id.questionLabelPemula);
        answerBtn1 = findViewById(R.id.answerbtn1Pemula);
        answerBtn2 = findViewById(R.id.answerbtn2Pemula);
        answerBtn3 = findViewById(R.id.answerbtn3Pemula);
        answerBtn4 = findViewById(R.id.answerbtn4Pemula);

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
                        Intent intent = new Intent(SoalPemulaActivity.this, LulusTestPemulaActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }else {
                        writeToDataBase(rightAnswerCount);
                        Intent intent = new Intent(SoalPemulaActivity.this, GagalTestPemulaActivity.class);
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

    void writeToDataBase(int rightAnswerCountPemula ){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        NilaiPemula nilaiPemula = new NilaiPemula(rightAnswerCountPemula);
        databaseReference.child("Users").child(mUsers.getUniqueId()).child("nilaiPemula").setValue(nilaiPemula);
    }
}
