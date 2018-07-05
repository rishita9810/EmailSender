package com.example.hp15.emailsender;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtFrom,edtTo,edtCC,edtBCC,edtMsg,edtSub;
    String Sfrom,Sto,Scc,Sbcc,Smsg,Ssub,msg;
    Button btnSend,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFrom = (EditText) findViewById(R.id.edtFrom);
        edtTo = (EditText) findViewById(R.id.edtTo);
        edtCC = (EditText) findViewById(R.id.edtCC);
        edtBCC = (EditText) findViewById(R.id.edtBCC);
        edtMsg = (EditText) findViewById(R.id.edtMsg);
        edtSub = (EditText)findViewById(R.id.edtSub);
        btnSend = (Button)findViewById(R.id.btnSend);
        btnCancel = (Button)findViewById(R.id.btnCancel);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sfrom = edtFrom.getText().toString();
                Sto = edtTo.getText().toString();
                Scc = edtCC.getText().toString();
                Sbcc = edtBCC.getText().toString();
                Smsg = edtMsg.getText().toString();
                Ssub = edtSub.getText().toString();

                msg = "Subject : " + Ssub + "\n" + "Message : " + Smsg;
                String[] to = {Sfrom, Sto};
                String[] cc = {Sfrom, Scc};
                String[] bcc = {Sfrom, Sbcc};

                sendEmail(to, cc, bcc, Smsg);

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtFrom.setText("");
                edtTo.setText("");
                edtCC.setText("");
                edtBCC.setText("");
                edtSub.setText("");
                edtMsg.setText("");
            }
        });
    }
    private void sendEmail(String[] emailAddress, String[] carbonCopies, String[] blindCarbonCopy, String msg)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));

        String []Eto = emailAddress;
        String []Ecc = carbonCopies;
        String []Ebcc = blindCarbonCopy;

        emailIntent.putExtra(Intent.EXTRA_EMAIL,Eto);
        emailIntent.putExtra(Intent.EXTRA_CC,Ecc);
        emailIntent.putExtra(Intent.EXTRA_BCC,Ebcc);
        emailIntent.putExtra(Intent.EXTRA_TEXT,msg);
        emailIntent.setType("message/rfc822");

        startActivity(Intent.createChooser(emailIntent,"Email Test"));

    }


}

