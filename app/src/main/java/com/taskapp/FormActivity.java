package com.taskapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.taskapp.ui.home.HomeFragment;

public class FormActivity extends AppCompatActivity {
    EditText edittitle, editdesk;
    public static final String KEY_BUNDLE = "key_bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        edittitle = findViewById(R.id.edit_title);
        editdesk = findViewById(R.id.edit_desc);
    }

    public void onClick(View view) {
        String title = edittitle.getText().toString().trim();
        String desk = editdesk.getText().toString().trim();
        if (title.matches("")) {
            Toast.makeText(this, "Ты не заполнил title!", Toast.LENGTH_LONG).show();
        } else if (desk.matches("")) {
            Toast.makeText(this, "Ты не заполнил desk!", Toast.LENGTH_LONG).show();
        } else {
            Task task = new Task(title, desk);
            Intent intent = new Intent();
            intent.putExtra("task", task);
            setResult(RESULT_OK, intent);
            finish();
            /*HomeFragment fragment=new HomeFragment();
            Bundle bundle=new Bundle();
            bundle.putSerializable("key",task);
            fragment.setArguments(bundle);*/

            //getIntent().putExtra(KEY_BUNDLE,task);
            FragmentManager fragmentManager = getSupportFragmentManager();
            //HomeFragment fragment=new HomeFragment();
            //fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
        }

    }
}
