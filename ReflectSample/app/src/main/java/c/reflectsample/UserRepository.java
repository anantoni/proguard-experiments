package c.reflectsample;

import android.text.TextUtils;

import java.util.Collection;
import java.lang.*;
import java.lang.reflect.*;

public class UserRepository {

    private Collection<String> userHolder;
    private String listT;

    public UserRepository(String listType) {
        try {
            listT = listType;
            Constructor listConstructor = Class.forName(listT).getConstructor();
            userHolder = (Collection) listConstructor.newInstance();
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

    public String getListType() {
        return listT;
    }

    public void addUser(String name) {
        userHolder.add(name);
    }

    public String getUsers() {
        return TextUtils.join(", ", userHolder);
    }

}
