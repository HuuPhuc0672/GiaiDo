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

        String CauMay= "C??u :"+listCauH.getCauSo();
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
            Toast.makeText(this, "???? ??p b???n ch???n ????ng.", Toast.LENGTH_SHORT).show();
            nextCau();
        }else {
            textView.setBackgroundResource(R.drawable.ic_sai);
            Toast.makeText(this, "???? ??p b???n ch???n sai.", Toast.LENGTH_SHORT).show();
           /* thuaGame();*/
        }

    }
    private void thuaGame(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                manHinh("C??u tr??? l???i c???a b???n sai.");
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

        cauTraLoi1.add(new CauTraLoi("Con s???n",false));
        cauTraLoi1.add(new CauTraLoi("Con V???t",false));
        cauTraLoi1.add(new CauTraLoi("Ki???n ??en",true));
        cauTraLoi1.add(new CauTraLoi("Kh??ng T???t",false));
        list.add(new ListCauH(1,"...... tha tr????ng l??n cao,\n" +
                "Th???? na??o cu??ng co?? m??a ra??o r????t to.",cauTraLoi1));

        List<CauTraLoi> cauTraLoi2=new ArrayList<>();
        cauTraLoi2.add(new CauTraLoi("Ch??",false));
        cauTraLoi2.add(new CauTraLoi("G??",true));
        cauTraLoi2.add(new CauTraLoi("L???n",false));
        cauTraLoi2.add(new CauTraLoi("M??o",false));
        list.add(new ListCauH(2,"Ch????p ????ng nhay nha??y, ... ga??y thi?? m??a.",cauTraLoi2));

        List<CauTraLoi> cauTraLoi3=new ArrayList<>();
        cauTraLoi3.add(new CauTraLoi("???ch",true));
        cauTraLoi3.add(new CauTraLoi("G??",false));
        cauTraLoi3.add(new CauTraLoi("Ch??",false));
        cauTraLoi3.add(new CauTraLoi("M??o",false));
        list.add(new ListCauH(3,"... k??u u??m u??m, ao chu??m ??????y n??????c.",cauTraLoi3));

        List<CauTraLoi> cauTraLoi4=new ArrayList<>();
        cauTraLoi4.add(new CauTraLoi("C??o C??o",false));
        cauTraLoi4.add(new CauTraLoi("Con ??n",true));
        cauTraLoi4.add(new CauTraLoi("Con C??",false));
        cauTraLoi4.add(new CauTraLoi("Con Chim",false));
        list.add(new ListCauH(4,"Tha??ng ba??y heo may, ...... bay thi?? ba??o.",cauTraLoi4));

        List<CauTraLoi> cauTraLoi5=new ArrayList<>();
        cauTraLoi5.add(new CauTraLoi("Ch?? / M??o",false));
        cauTraLoi5.add(new CauTraLoi("G?? / Ch??",false));
        cauTraLoi5.add(new CauTraLoi("??n / ??n",true));
        cauTraLoi5.add(new CauTraLoi("M??o / M??o",false));
        list.add(new ListCauH(5,"... bay th????p, m??a ng????p b???? ao\n" + "... bay cao, m??a ra??o la??i ta??nh",cauTraLoi5));

        List<CauTraLoi> cauTraLoi6=new ArrayList<>();
        cauTraLoi6.add(new CauTraLoi("Tr??u B??",true));
        cauTraLoi6.add(new CauTraLoi("L???n G??",false));
        cauTraLoi6.add(new CauTraLoi("B?? Tr??u",false));
        cauTraLoi6.add(new CauTraLoi("Ch?? M??o",false));
        list.add(new ListCauH(6,".... hu??t nhau, ru????i mu????i ch????t.",cauTraLoi6));

        List<CauTraLoi> cauTraLoi7=new ArrayList<>();
        cauTraLoi7.add(new CauTraLoi("Con Ch??",false));
        cauTraLoi7.add(new CauTraLoi("Con L???n",false));
        cauTraLoi7.add(new CauTraLoi("Con M??o",false));
        cauTraLoi7.add(new CauTraLoi("Con Ng???a",true));
        list.add(new ListCauH(7,"M????t ..... ??au ca?? ta??u bo?? co??.",cauTraLoi7));

        List<CauTraLoi> cauTraLoi8=new ArrayList<>();
        cauTraLoi8.add(new CauTraLoi("V???",false));
        cauTraLoi8.add(new CauTraLoi("M??o",false));
        cauTraLoi8.add(new CauTraLoi("B??t",true));
        cauTraLoi8.add(new CauTraLoi("Ch??",false));
        list.add(new ListCauH(8,"... sa ga?? ch????t.",cauTraLoi8));

        List<CauTraLoi> cauTraLoi9=new ArrayList<>();

        cauTraLoi9.add(new CauTraLoi("Con Ngh??",false));
        cauTraLoi9.add(new CauTraLoi("Con Tr??u",true));
        cauTraLoi9.add(new CauTraLoi("Con Voi",false));
        cauTraLoi9.add(new CauTraLoi("Con M??o",false));
        list.add(new ListCauH(9,".... la?? ??????u c?? nghi????p",cauTraLoi9));

        List<CauTraLoi> cauTraLoi10=new ArrayList<>();
        cauTraLoi10.add(new CauTraLoi("M??o / M??o",false));
        cauTraLoi10.add(new CauTraLoi("L???n / G??",false));
        cauTraLoi10.add(new CauTraLoi("M??o / Ch?? ",false));
        cauTraLoi10.add(new CauTraLoi("Ch?? / M??o",true));
        list.add(new ListCauH(10,"... tha ??i, ... tha la??i",cauTraLoi10));

        return list;
    }

    private void manHinh(String mes){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage(mes);
        builder.setCancelable(false);

        builder.setPositiveButton("Ch??i L???i", new DialogInterface.OnClickListener() {
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