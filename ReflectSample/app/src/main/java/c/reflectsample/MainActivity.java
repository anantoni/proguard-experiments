package c.reflectsample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.*;
import java.lang.reflect.*;


public class MainActivity extends AppCompatActivity {

    EditText edt1;
    Button buttonEqual;
    UserRepository userRepository;
    Object tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEqual = (Button) findViewById(R.id.buttoneql);
        edt1 = (EditText) findViewById(R.id.edt1);
//        final TextView tv = (TextView) findViewById(R.id.text);
        try {
            tv = (TextView) Class.forName("android.widget.TextView").getConstructor(Context.class).newInstance(this);
            final Method setTextMeth = Class.forName("android.widget.TextView").getMethod("setText", CharSequence.class);
            final Method setVisMeth = Class.forName("android.widget.TextView").getMethod("setVisibility", int.class);
//            tv.setVisibility(View.GONE);
            try {
                setVisMeth.invoke((TextView) tv, View.GONE);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            buttonEqual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (userRepository == null) {
                        String listType = edt1.getText().toString();
                        userRepository = new UserRepository(listType);
                        userRepository.addUser("randomuser1");
                        userRepository.addUser("randomuser24");

                        edt1.setVisibility(View.GONE);
//                        tv.setVisibility(View.VISIBLE);
                        try {
                            Log.d("ReflectSample", "before invokation");
                            setVisMeth.invoke((TextView) tv, View.VISIBLE);
                            Log.d("ReflectSample", "after setting textview");
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        try {
                            Log.d("ReflectSample", "before invokation of set text");
                            setTextMeth.invoke((TextView) tv, userRepository.getUsers());
                            Log.d("ReflectSample", "after setting text");
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
//                        tv.setText(userRepository.getUsers());
                    } else {
//                        tv.setVisibility(View.VISIBLE);
                        try {
                            setVisMeth.invoke((TextView) tv, View.VISIBLE);
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        try {
                            setTextMeth.invoke((TextView) tv, userRepository.getListType());
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
//                        tv.setText(userRepository.getListType());
                    }
                    setContentView((TextView) tv);
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
