package com.example.careshare;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Home extends AppCompatActivity {
    //Initialize Variable
    DrawerLayout drawerLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void clickMenu(View view){
        //Open Drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void clickLogo(View view){
        //close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void clickHome(View view){
        //recreate activity
        recreate();
    }

    public void clickDashboard(View view){
        //Redirect activity to dashboard
        redirectActivity(this , DashBoard.class);
    }

    public void clickAboutus(View view){
        //Redirect activity to dashboard
        redirectActivity(this , AboutUs.class);
    }

    public void clickLogout(View view){
        //Close App
        logout(this);
    }

    public static void logout(Activity activity) {
        //Initialize alert Dialouge Box
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("LogOut");
        //Set Message
        builder.setMessage("Are you sure you want to log out?");
        //Positive yes button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Finish Activity
                activity.finishAffinity();
                //Exit app
                System.exit(0);
            }
        });
        //Negative No button
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Dismiss dialouge
                dialogInterface.dismiss();
            }
        });
        //show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity , Class aclass) {
        //Initialize Intent
        Intent intent = new Intent(activity , aclass);
        //Setting Flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}