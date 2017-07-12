package c.reflectsample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.*;
import java.lang.reflect.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create user list
        String listType = "java.util.LinkedList";
        UserRepository userRepo = new UserRepository(listType);
        userRepo.addUser("randomuser1");
        userRepo.addUser("randomuser2");
        String users = userRepo.getUsers();

        //Screen view
        try {
            Class textViewClass = Class.forName("android.widget.TextView");
            Constructor constr = textViewClass.getConstructor(Context.class);
            Log.d("MainActivity", "before set text");
            Method setMeth = textViewClass.getMethod("setText", CharSequence.class);
            Log.d("MainActivity", setMeth.getName());
            Object textViewObj = (TextView) constr.newInstance(this);
            setMeth.invoke((TextView) textViewObj, users);
            setContentView((TextView) textViewObj);
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
