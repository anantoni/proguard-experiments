package c.reflectsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.*;
import java.lang.reflect.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Class textViewClass = Class.forName("android.widget.TextView");
            Constructor constr = textViewClass.getConstructor(this.getClass());
            Method setMeth = textViewClass.getMethod("setText", String.class);
            Object textViewObj = (TextView) constr.newInstance(this);
            setMeth.invoke((TextView) textViewObj, textViewClass.getName());
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
