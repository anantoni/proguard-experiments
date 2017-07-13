package c.reflectsample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.*;
import java.lang.reflect.*;


public class MainActivity extends AppCompatActivity {

    EditText edt1;
    Button buttonEqual;
    UserRepository userRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEqual = (Button) findViewById(R.id.buttoneql);
        edt1 = (EditText) findViewById(R.id.edt1);
        final TextView tv = (TextView) findViewById(R.id.text);
        tv.setVisibility(View.GONE);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (userRepository == null) {
                        String listType = edt1.getText().toString();
                        userRepository = new UserRepository(listType);
                        userRepository.addUser("randomuser1");
                        userRepository.addUser("randomuser24");

                        edt1.setVisibility(View.GONE);
                        tv.setVisibility(View.VISIBLE);
                        tv.setText(userRepository.getUsers());
                    } else {
//                        textView.setText(userRepository.getListType())
                        tv.setVisibility(View.VISIBLE);
                        tv.setText(userRepository.getUsers());
                    }
                }
            });

    }
}
