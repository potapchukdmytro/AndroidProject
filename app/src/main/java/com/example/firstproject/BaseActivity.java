package com.example.firstproject;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstproject.account.LoginActivity;
import com.example.firstproject.account.RegisterActivity;
import com.example.firstproject.application.HomeApplication;
import com.example.firstproject.category.CategoryCreateActivity;
import com.example.firstproject.utils.CommonUtils;

public class BaseActivity extends AppCompatActivity {

    public BaseActivity() {
        CommonUtils.setContext(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        menu.setGroupVisible(R.id.group_anonymous, !HomeApplication.getInstance().isAuth());
        menu.setGroupVisible(R.id.group_auth, HomeApplication.getInstance().isAuth());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.m_home:
                try {
                    intent = new Intent(BaseActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception ex) {
                    System.out.println("Error. " + ex.getMessage());
                }
                return true;
            case R.id.m_create:
                try {
                    intent = new Intent(BaseActivity.this, CategoryCreateActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception ex) {
                    System.out.println("Error. " + ex.getMessage());
                }
                return true;
            case R.id.m_register:
                try {
                    intent = new Intent(BaseActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception ex) {
                    System.out.println("Error. " + ex.getMessage());
                }
                return true;
            case R.id.m_login:
                try {
                    intent = new Intent(BaseActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception ex) {
                    System.out.println("Error. " + ex.getMessage());
                }
                return true;
            case R.id.m_logout:
                try {
                    HomeApplication.getInstance().deleteToken();
                    intent = new Intent(BaseActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch(Exception ex) {
                    System.out.println("Problem "+ ex.getMessage());
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
