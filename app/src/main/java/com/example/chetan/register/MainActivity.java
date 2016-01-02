package com.example.chetan.register;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.plivo.endpoint.Endpoint;
import com.plivo.endpoint.EventListener;
import com.plivo.endpoint.Incoming;
import com.plivo.endpoint.Outgoing;

public class MainActivity extends AppCompatActivity implements EventListener {

    public final static String EXTRA_MESSAGE = "com.example.chetan.MESSAGE";
    Endpoint endpoint = new Endpoint(true, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loginEndpoint(View view) {
        // Log into plivo cloud
        EditText usernameText = (EditText) findViewById(R.id.username);
        EditText passwordText = (EditText) findViewById(R.id.password);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        endpoint.login(username, password);

        //endpoint.login("android140326225726", "kunal123");
    }

    @Override
    public void onLogin() {
        Log.v("Register", "logging in");
        Intent intent = new Intent(this, LoginActivity.class);
        String message = "Login Success";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onLogout() {

    }

    @Override
    public void onLoginFailed() {
        Log.v("Register", "login failed");
        Intent intent = new Intent(this, LoginActivity.class);
        String message = "Login Failed";

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onIncomingCall(Incoming incoming) {

    }

    @Override
    public void onIncomingCallHangup(Incoming incoming) {

    }

    @Override
    public void onIncomingCallRejected(Incoming incoming) {

    }

    @Override
    public void onOutgoingCall(Outgoing outgoing) {

    }

    @Override
    public void onOutgoingCallAnswered(Outgoing outgoing) {

    }

    @Override
    public void onOutgoingCallHangup(Outgoing outgoing) {

    }
}
