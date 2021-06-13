package com.example.flames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private static final String FIRST_NAME="FIRST NAME:";
    private static final String SECOND_NAME="SECOND NAME:";

    EditText editText1;
    EditText editText2;
    TextView textView;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
   // CollectionReference noteBook = db.collection("NoteBook");
    DocumentReference documentReference = db.collection("NoteBook").document("Note1");


    public  void Check(View view)
    {
        String a = editText1.getText().toString();
        String b = editText2.getText().toString();

        char y[]=a.toCharArray();
        char z[]=b.toCharArray();

        int i,j,sp=0,t,n;
        n=a.length()+b.length();
        for(i=0;i<a.length();i++)
        {
            for(j=0;j<b.length();j++)
            {
                if(y[i]==z[j]&&z[j]!='#')
                {
                    z[j]='#';
                    System.out.println(" "+i+" "+j);
                    sp=sp+2;
                    break;
                }
            }
        }

        t = n-sp;

        String flam="flames";
        StringBuilder sb3 = new StringBuilder(flam);

        char flameResult = '0';

        while(sb3.length()!=1)
        {
            int p = t%sb3.length();
            String temp;

            if(p!=0)
            {
                temp = sb3.substring(p)+sb3.substring(0, p-1);

            }
            else
            {
                temp = sb3.substring(0, sb3.length()-1);

            }
            sb3 = new StringBuilder(temp);
            flameResult = sb3.charAt(0);

        }

        switch (flameResult)
        {
            case 'f':
                textView.setText(a+" and "+b+" are FRIENDS");
                break;
            case 'l':
                textView.setText(a+" and "+b+" are LOVERS");
                break;
            case 'a':
                textView.setText(a+" and "+b+" are AFFECTIONATE about each other");
                break;
            case 'm':
                textView.setText(a+" and "+b+" are going to get MARRIED");
                break;
            case 'e':
                textView.setText(a+" and "+b+" are ENEMIES");
                break;
            case 's':
                textView.setText(a+" and "+b+" are BRO and SIS");
                break;
        }

        String first = editText1.getText().toString();
        String second = editText2.getText().toString();

        Note note = new Note(first,second);
        db.collection("notebook").add(note);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        textView=findViewById(R.id.textView);
    }
}