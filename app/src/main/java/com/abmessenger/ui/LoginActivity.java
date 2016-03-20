package com.abmessenger.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.abmessenger.R;
import com.abmessenger.adapters.BaseApplication;
import com.abmessenger.utils.UiUtil;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    //public static final String url = "jdbc:mysql://192.168.1.32:3306/users";
    //public static final String user = "user12345";
    //public static final String pass = "12345";
    private static final String WEB_API = "74.208.227.178:3306/user.php";
    private static final String TAG = "LoginActivity";
    public EditText etEmail, etPwd;
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        // This is to undo auto-capitalization of words in Buttons by Android
        UiUtil.removeButtonTransformationMethod((ViewGroup) findViewById(R.id.rl_root_login));

        // Take reference of sign_in button
        Button btnSignIn = (Button) findViewById(R.id.btn_sign_in);
        // set onClickListener so that you can handle on click event on this button
        btnSignIn.setOnClickListener(
                // This is a anonymous class created by implementing View.OnClickListener interface
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                  //      String username = etEmail.getText().toString();
                    //    String password = etPwd.getText().toString();
//                        BaseApplication.getInstance().addToRequestQueue(getLoginRequest(username, password, null));
                      //  BaseApplication.getInstance().addToRequestQueue(getLoginRequest("serena@gmail.com", "12345", null));
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                });


        Button btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    JsonObjectRequest getLoginRequest(final String username, final String password, final String email) {
        // Creating volley request obj
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, WEB_API, null, new
                Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, response.toString());
                        int isSuccess = 0;
                        if (response.has("success"))
                            try {
                                isSuccess = response.getInt("success");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, username);
                params.put(KEY_PASSWORD, password);
                params.put(KEY_EMAIL, email);
                return params;
            }
        };

        return request;
    }

/*
    class MyTask extends AsyncTask<Void, Void, ResultSet> {


        protected ResultSet doInBackground(Void... arg0) throws SQLException {


            ResultSet resultSet = null;
            String result = "";
//the year data to send
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("email", "serena@gmail.com"));
            nameValuePairs.add(new BasicNameVlauePair("pasword", "123456"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

//http post
            try {

                httpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("connection.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
//convert response to string
            try {

                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();

                result = sb.toString();
            } catch (Exception e) {
                Log.e("log_tag", "Error converting result " + e.toString());
            }


//parse json data
            try

            {
                JSONArray jArray = new JSONArray(result);
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json_data = jArray.getJSONObject(i);
                    Log.i("log_tag", "id: " + json_data.getInt("id") +
                                    ", name: " + json_data.getString("name") +
                                    ", email: " + json_data.getInt("email") +
                                    ", password: " + json_data.getInt("password")
                    );
                }

            } catch (JSONException e) {
                Log.e("log_tag", "Error parsing data " + e.toString());

            }

        protected void onPostExecute(ResultSet result) {
            super.onPostExecute(result);


            if (result != null) {
                try {
                    // check if any username/password matches what you have entered in login screen
                    while (result.next()) {
                        String userName = result.getString(0);
                        String userPassword = result.getString(1);

                        if (userName.equals(etEmail.getText().toString()) && userPassword.equals(etPwd.getText().toString())) {
                            goToHomeScreen();
                            return;
                        }
                    }
                    Toast.makeText(LoginActivity.this, "Username or password is invalid", Toast.LENGTH_SHORT).show();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "Username or password is invalid", Toast.LENGTH_SHORT).show();
                }
             }
            }
        }
        */


    private void goToHomeScreen() {
        // Intent to start a new activity, in this case, HomeActivity for example
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
