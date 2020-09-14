package com.example.firebaselab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText vId,vName,vAddress,vNumber;
    Button vSave,vShow,vUpdate,vDel;
    DatabaseReference dbref;
    Student student;

    public void clearControls(){
        vId.setText("");
        vName.setText("");
        vAddress.setText("");
        vNumber.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vId = findViewById(R.id.txtID);
        vName = findViewById(R.id.txtName);
        vAddress = findViewById(R.id.txtAddress);
        vNumber = findViewById(R.id.txtContactNo);

        vSave = findViewById(R.id.btnSave);
        vShow = findViewById(R.id.btnShow);
        vUpdate = findViewById(R.id.btnUpdate);
        vDel = findViewById(R.id.btnDelete);

        student = new Student();

        vSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dbref= FirebaseDatabase.getInstance().getReference().child("student");

                try{
                    if(TextUtils.isEmpty(vId.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter ID",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(vName.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter your name",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(vAddress.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter your Address",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(vNumber.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter your Number",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        student.setID(vId.getText().toString().trim());
                        student.setName(vName.getText().toString().trim());
                        student.setAddress(vAddress.getText().toString().trim());
                        student.setConno(Integer.parseInt(vNumber.getText().toString().trim()));

                        dbref.push().setValue(student);
                        Toast.makeText(getApplicationContext(),"Data inserted succesfully",Toast.LENGTH_SHORT).show();
                    }
                }
                catch(Exception e) {
                    System.out.println(e);
                }

            }
        });
    }


}
