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
import com.raion.putrautama.mounesiaprototype.GagalTest.GagalTestProfesionalActivity;
import com.raion.putrautama.mounesiaprototype.LulusTest.LulusTestProfesionalActivity;
import com.raion.putrautama.mounesiaprototype.MainActivity;
import com.raion.putrautama.mounesiaprototype.Model.NilaiProfesional;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SoalProfesionalActivity extends AppCompatActivity {
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

            {"Berdasarkan penggunaan alat teknis yang dipakai(class) dibawah ini yang benar adalah?"
                    ,"Class 6 ; mandaki dengan tali dengan peralatan bantuan sepenuhnya berpijak diatas paku tebing, memenjat rantai sling atau mengunakan stirupss"
                    ,"Class 3 ; lintas alam tanpa bantuan tangan"
                    ,"Class 4 ; pendakian yang mudah memerlukan kaki dan tangan dalam mendaki, tali mungkin dibutuhkan oleh pemula"
                    ,"Class 5 ; mandaki dengan tali dengan peralatan bantuan sepenuhnya berpijak diatas paku tebing, memenjat rantai sling atau mengunakan stirupss"},
            {"Berdasar lama waktu akibat sukarnya pendakian dalam medan pendakian (grade) dibawah ini yang benar , kecuali"
                    ,"Grade VI, bagian yang sukar ditempuh dalam waktu 2 hari atau lebih dan dengan banyak sekali kesulitan"
                    ,"Grade III, bagian yang sukar ditempuh dalam sehari penuh"
                    ,"Grade V, bagian yang sukar ditempuh dalam waktu 1,5-2,5 hari"
                    ,"Grade I, bagian yang sukar dapat ditempuh dalam beberapa jam"},
            {"Berdasarkan tingkat kemanan pemanjat dari kemampuan alat yang digunakan(A) dibawah ini adalah"
                    ,"A2 ;aman, jikapun terjadi maslah, alat masih dapat diandalkan untuk mencegah akibat yang lebih fatal [misalnya jatuh tidak sampai kedasar]"
                    ,"A1; penggunan alat pengaman cukup aman tetapi tidak dapat diandalkan untuk menjaga resiko jatuh, kecuali dengan pemasngan yang sangat teliti dan fall-faktor yang tidak terlal;u berbeban tinggi."
                    ,"A3 ; aman sekali, peralatan yang dipasang dan digunakan dapat diandalkan untuk menjaga keselamatan pendaki"
                    ,"A4 ; aman, jikapun terjadi maslah, alat masih dapat diandalkan untuk mencegah akibat yang lebih fatal [misalnya jatuh tidak sampai kedasar]"},
            {"1.\tCari tanda medan yang mudah dikenali di lapangan dan di peta, minimal 2 buah\n" +
                    "2.\tBidik tanda-tanda medan tersebut dari posisi kita dengan menggunakan kompas bidik. Kompas orienteering dapat digunakan, namun kurang akurat.\n" +
                    "3.\tPindahkan sudut back azimuth bidikan yang didapat ke peta dan hitung sudut pelurusnya. Lakukan ini pada setiap tanda medan yang dijadikan sebagai titik acuan.\n" +
                    "4.\tLakukan orientasi peta\n" +
                    "5.\tDengan busur dan penggaris, buat salib sumbu pada tanda-tanda medan tersebut (untuk alat tulis paling ideal menggunakan pensil mekanik-B2).\n" +
                    "6.\tPerpotongan garis yang ditarik dari sudut-sudut pelurus tersebut adalah posisi kita dipeta.\n" +
                    "Berikut merupakan langka-langkah melakukan resection peta yang benar adalah"
                    ,"4-1-5-2-3-6"
                    ,"4-2-3-1-5-6"
                    ,"4-3-2-1-5-6"
                    ,"4-1-3-5-6-2"},
            {"1.\tLakukan orientasi peta\n" +
                    "2.\tBidik obyek yang kita amati\n" +
                    "3.\tPindahkan sudut yang didapat ke dalam peta\n" +
                    "4.\tLakukan resection untuk memastikan posisi kita di peta.\n" +
                    "5.\tPerpotongan garis perpanjangan dari dua sudut yang didapat adalah posisi obyek yang dimaksud.\n" +
                    "6.\tBergerak ke posisi lain dan pastikan posisi tersebut di peta. Lakukan langkah 1-3\n" +
                    "Berikut merupakan langka-langkah melakukan intersection peta yang benar adalah"
                    ,"1-4-2-3-6-5"
                    ,"1-3-4-2-6-5"
                    ,"1-2-3-4-5-6"
                    ,"1-5-6-2-4-3"},
            {"1)\tTerletak di daerah aliran air\n" +
                    "2)\tDi atas bivouck / shelter tidak ada dahan pohon mati/rapuh\n" +
                    "3)\tBerada dekat sarang nyamuk/serangga\n" +
                    "4)\tBahan kuat\n" +
                    "5)\tDapat merusak alam sekitar\n" +
                    "6)\tTerlindung langsung dari angin\n" +
                    "\n" +
                    "syarat – syarat untuk membuat bivouck adalah"
                    ,"2,4, dan 6"
                    ,"1,2, dan 3"
                    ,"3,4, dan 5"
                    ,"2,4, dan 5"},
            {"Dapat mengetahui titik-titik ketinggian dan jarak dari tanda medan tertentu\n" +
                    "Berikut adalah manfaat penampang lintasan kecuali\n"
                    ,"Dapat mengetahui titik-titik tempat pengambilan foto yang bagus"
                    ,"Sebagai bahan pertimbangan dalam menyusun perencanaan perjalanan"
                    ,"Memudahkan kita untuk menggambarkan kondisi keterjalan dan kecuraman medan"
                    ,"Untuk menyusun penampang lintasan biasanya menggunakan kertas milimeter block, guna menambah akurasi penerjemahan dari peta topografi ke penampang"},
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
            {"Syarat atau patokan makanan yang dapat dikonsumsi pada saat kondisi hidup di alam bebas yaitu"
                    ,"Makanan yang juga dimakan kera"
                    ,"Tanaman dan buah yang berwarna mencolok"
                    ,"Makanan  yang mengeluarkan getah putih seperti sabun"
                    ,"Makanan terlalu pahit atau asam"},
            {"berikuti ini merupakan langkah langkah orientasi peta\n" +
                    "1.\tUsahakan untuk mencari tempat yang berpemandangan terbuka agar dapat melihat tanda-tanda medan yang menyolok.\n" +
                    "2.\tUtarakan peta, dengan berpatokan pada kompas, sehingga arah peta sesuai dengan arah medan sebenarnya\n" +
                    "3.\tSiapkan kompas dan peta anda, letakkan pada bidang datar\n" +
                    "4.\tIngat tanda-tanda itu, bentuknya dan tempatnya di medan yang sebenarnya. Ingat hal-hal khas dari tanda medan.\n" +
                    "5.\tCari tanda-tanda medan yang paling menonjol disekitar anda, dan temukan tanda-tanda medan tersebut di peta. Lakukan hal ini untuk beberapa tanda medan"
                    ,"1-3-2-5-4"
                    ,"1-2-3-4-5"
                    ,"1-4-5-3-2"
                    ,"1-5-4-2-3"}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_profesional);

        mUsers = (Users) getIntent().getSerializableExtra("USER");
        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(SoalProfesionalActivity.this,MainActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });

        countLabel = findViewById(R.id.countLabelProfesional);
        questionLabel = findViewById(R.id.questionLabelProfesional);
        answerBtn1 = findViewById(R.id.answerbtn1Profesional);
        answerBtn2 = findViewById(R.id.answerbtn2Profesional);
        answerBtn3 = findViewById(R.id.answerbtn3Profesional);
        answerBtn4 = findViewById(R.id.answerbtn4Profesional);

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
                        Intent intent = new Intent(SoalProfesionalActivity.this, LulusTestProfesionalActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }else {
                        writeToDataBase(rightAnswerCount);
                        Intent intent = new Intent(SoalProfesionalActivity.this, GagalTestProfesionalActivity.class);
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
    void writeToDataBase(int rightAnswerCountProfesional ){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        NilaiProfesional nilaiProfesional = new NilaiProfesional(rightAnswerCountProfesional);
        databaseReference.child("Users").child(mUsers.getUniqueId()).child("nilaiProfesional").setValue(nilaiProfesional);
    }
}
