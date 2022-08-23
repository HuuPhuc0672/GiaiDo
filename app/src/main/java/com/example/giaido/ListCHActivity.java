package com.example.giaido;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giaido.Mode.CauTraLoi;
import com.example.giaido.Mode.ListCauH;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListCHActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtCauhoi;
    private TextView txtCautra1;
    private TextView txtCautra2;
    private TextView txtCautra3;
    private TextView txtCautra4;
    private TextView txtSocau;



    private List<ListCauH> hList;
    private  ListCauH mCauH;
    private int soCau=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chactivity);
        txtSocau = (TextView) findViewById(R.id.txt_socau);
        txtCauhoi = (TextView) findViewById(R.id.txt_cauhoi);
        txtCautra1 = (TextView) findViewById(R.id.txt_cautra1);
        txtCautra2 = (TextView) findViewById(R.id.txt_cautra2);
        txtCautra3 = (TextView) findViewById(R.id.txt_cautra3);
        txtCautra4 = (TextView) findViewById(R.id.txt_cautra4);



        hList=getCauHoi();
        setDataCauHoi(hList.get(soCau));
        thoiGian();


    }
    private void thoiGian(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                manHinh("Game Over");
            }
        },60000);

    }


    private void setDataCauHoi(ListCauH listCauH) {
        mCauH=listCauH;



        txtCautra1.setOnClickListener(this);
        txtCautra2.setOnClickListener(this);
        txtCautra3.setOnClickListener(this);
        txtCautra4.setOnClickListener(this);

        txtCautra1.setBackgroundResource(R.color.white);
        txtCautra2.setBackgroundResource(R.color.white);
        txtCautra3.setBackgroundResource(R.color.white);
        txtCautra4.setBackgroundResource(R.color.white);

        String CauMay= "Câu :"+listCauH.getCauSo();
        txtSocau.setText(CauMay);
        txtCauhoi.setText(listCauH.getCauHoi());
        txtCautra1.setText(listCauH.getCauTraLois().get(0).getDapAn());
        txtCautra2.setText(listCauH.getCauTraLois().get(1).getDapAn());
        txtCautra3.setText(listCauH.getCauTraLois().get(2).getDapAn());
        txtCautra4.setText(listCauH.getCauTraLois().get(3).getDapAn());
        thoiGian();

       /* for (int i=0 ; i<hList.size();i++){
            Random random=new Random();
            ListCauH cauH=new ListCauH();
            int so=random.nextInt(hList.get(i).getCauSo());
            if (cauH.getCauSo() == so){

            }
        }*/


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_cautra1:
                txtCautra1.setBackgroundResource(R.color.purple_200);
                checDapAn(txtCautra1, mCauH,mCauH.getCauTraLois().get(0));
                break;
            case R.id.txt_cautra2:
                txtCautra2.setBackgroundResource(R.color.purple_200);
                checDapAn(txtCautra2, mCauH,mCauH.getCauTraLois().get(1));
                break;
            case R.id.txt_cautra3:
                txtCautra3.setBackgroundResource(R.color.purple_200);
                checDapAn(txtCautra3, mCauH,mCauH.getCauTraLois().get(2));
                break;

            case R.id.txt_cautra4:
                txtCautra4.setBackgroundResource(R.color.purple_200);
                checDapAn(txtCautra4, mCauH,mCauH.getCauTraLois().get(3));
                break;
        }

    }
    private  void checDapAn(TextView textView,ListCauH listCauH,CauTraLoi cauTraLoi){
        if (cauTraLoi.isDungSai()){
            textView.setBackgroundResource(R.color.yellow);
            Toast.makeText(this, "Đá áp bạn chọn đúng.", Toast.LENGTH_SHORT).show();
            nextCau();
        }else {
            textView.setBackgroundResource(R.drawable.ic_sai);
            Toast.makeText(this, "Đá áp bạn chọn sai.", Toast.LENGTH_SHORT).show();
           /* thuaGame();*/
        }

    }
    private void thuaGame(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                manHinh("Câu trả lời của bạn sai.");
            }
        },100);

    }


    private void nextCau() {
        if (soCau==hList.size() -1){
            Intent intent =new Intent(ListCHActivity.this,WinActivity.class);
            startActivity(intent);
        }else {
            soCau++;
            setDataCauHoi(hList.get(soCau));
        }
    }

    private List<ListCauH> getCauHoi(){
        List<ListCauH> list=new ArrayList<>();
        List<CauTraLoi> cauTraLoi1=new ArrayList<>();

        cauTraLoi1.add(new CauTraLoi("Con sắn",false));
        cauTraLoi1.add(new CauTraLoi("Con Vịt",false));
        cauTraLoi1.add(new CauTraLoi("Kiến đen",true));
        cauTraLoi1.add(new CauTraLoi("Không Tốt",false));
        list.add(new ListCauH(1,"...... tha trứng lên cao,\n" +
                "Thế nào cũng có mưa rào rất to.",cauTraLoi1));

        List<CauTraLoi> cauTraLoi2=new ArrayList<>();
        cauTraLoi2.add(new CauTraLoi("Chó",false));
        cauTraLoi2.add(new CauTraLoi("Gà",true));
        cauTraLoi2.add(new CauTraLoi("Lợn",false));
        cauTraLoi2.add(new CauTraLoi("Mèo",false));
        list.add(new ListCauH(2,"Chớp đông nhay nháy, ... gáy thì mưa.",cauTraLoi2));

        List<CauTraLoi> cauTraLoi3=new ArrayList<>();
        cauTraLoi3.add(new CauTraLoi("Ếch",true));
        cauTraLoi3.add(new CauTraLoi("Gà",false));
        cauTraLoi3.add(new CauTraLoi("Chó",false));
        cauTraLoi3.add(new CauTraLoi("Mèo",false));
        list.add(new ListCauH(3,"... kêu uôm uôm, ao chuôm đầy nước.",cauTraLoi3));

        List<CauTraLoi> cauTraLoi4=new ArrayList<>();
        cauTraLoi4.add(new CauTraLoi("Cào Cào",false));
        cauTraLoi4.add(new CauTraLoi("Con Én",true));
        cauTraLoi4.add(new CauTraLoi("Con Cò",false));
        cauTraLoi4.add(new CauTraLoi("Con Chim",false));
        list.add(new ListCauH(4,"Tháng bảy heo may, ...... bay thì bão.",cauTraLoi4));

        List<CauTraLoi> cauTraLoi5=new ArrayList<>();
        cauTraLoi5.add(new CauTraLoi("Chó / Mèo",false));
        cauTraLoi5.add(new CauTraLoi("Gà / Chó",false));
        cauTraLoi5.add(new CauTraLoi("Én / Én",true));
        cauTraLoi5.add(new CauTraLoi("Mèo / Mèo",false));
        list.add(new ListCauH(5,"... bay thấp, mưa ngập bờ ao\n" + "... bay cao, mưa rào lại tạnh",cauTraLoi5));

        List<CauTraLoi> cauTraLoi6=new ArrayList<>();
        cauTraLoi6.add(new CauTraLoi("Trâu Bò",true));
        cauTraLoi6.add(new CauTraLoi("Lợn Gà",false));
        cauTraLoi6.add(new CauTraLoi("Bò Trâu",false));
        cauTraLoi6.add(new CauTraLoi("Chó Mèo",false));
        list.add(new ListCauH(6,".... hút nhau, ruồi muỗi chết.",cauTraLoi6));

        List<CauTraLoi> cauTraLoi7=new ArrayList<>();
        cauTraLoi7.add(new CauTraLoi("Con Chó",false));
        cauTraLoi7.add(new CauTraLoi("Con Lợn",false));
        cauTraLoi7.add(new CauTraLoi("Con Mèo",false));
        cauTraLoi7.add(new CauTraLoi("Con Ngựa",true));
        list.add(new ListCauH(7,"Một ..... đau cả tàu bỏ cỏ.",cauTraLoi7));

        List<CauTraLoi> cauTraLoi8=new ArrayList<>();
        cauTraLoi8.add(new CauTraLoi("Vở",false));
        cauTraLoi8.add(new CauTraLoi("Mèo",false));
        cauTraLoi8.add(new CauTraLoi("Bút",true));
        cauTraLoi8.add(new CauTraLoi("Chó",false));
        list.add(new ListCauH(8,"... sa gà chết.",cauTraLoi8));

        List<CauTraLoi> cauTraLoi9=new ArrayList<>();

        cauTraLoi9.add(new CauTraLoi("Con Nghé",false));
        cauTraLoi9.add(new CauTraLoi("Con Trâu",true));
        cauTraLoi9.add(new CauTraLoi("Con Voi",false));
        cauTraLoi9.add(new CauTraLoi("Con Mèo",false));
        list.add(new ListCauH(9,".... là đầu cơ nghiệp",cauTraLoi9));

        List<CauTraLoi> cauTraLoi10=new ArrayList<>();
        cauTraLoi10.add(new CauTraLoi("Mèo / Mèo",false));
        cauTraLoi10.add(new CauTraLoi("Lợn / Gà",false));
        cauTraLoi10.add(new CauTraLoi("Mèo / Chó ",false));
        cauTraLoi10.add(new CauTraLoi("Chó / Mèo",true));
        list.add(new ListCauH(10,"... tha đi, ... tha lại",cauTraLoi10));

        return list;
    }

    private void manHinh(String mes){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage(mes);
        builder.setCancelable(false);

        builder.setPositiveButton("Chơi Lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialop, int i) {
                soCau=0;
                setDataCauHoi(hList.get(soCau));
                dialop.dismiss();
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();


    }





}