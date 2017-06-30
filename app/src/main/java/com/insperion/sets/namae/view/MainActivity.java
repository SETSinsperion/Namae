/*

    This file is part of Namae.

    Namae is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Namae is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Namae.  If not, see <http://www.gnu.org/licenses/>.

*/

/*
	Developed by: Insperion
	Team: EDS Insperion
	Developer(s): Sergio Ernesto Tostado Sánchez (sets@insperion.com.mx)
	Contact: contacto@insperion.com.mx
*/

package com.insperion.sets.namae.view;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.insperion.sets.namae.R;
import com.insperion.sets.namae.controller.SpanishToKatakana;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txt_CompleteName;
    private Button btn_translaste;

    private SpanishToKatakana stk;
    private final int m_INTERNET = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Testing internet permission
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {
            }
            else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        m_INTERNET);
            }
        }

        stk = new SpanishToKatakana();

        txt_CompleteName = (EditText)findViewById(R.id.txt_complete_name);
        btn_translaste = (Button)findViewById(R.id.btn_translate);
        btn_translaste.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.mi_wii) {
            set_WhatIsNamae();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void set_WhatIsNamae(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Resources r = getResources();

        builder.setTitle(r.getString(R.string.main_wii));
        builder.setMessage(R.string.main_wii_content);
        builder.setCancelable(true);
        builder.setPositiveButton(
                "OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {
            case m_INTERNET: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                }
                else {
                }
                return;
            }
        }

    }

    @Override
    public void onClick(View v) {
        String name = txt_CompleteName.getText().toString().trim();
        if (!name.isEmpty()) {
            TranslatingProcessThread tpt =
                    new TranslatingProcessThread(MainActivity.this);
            tpt.execute(txt_CompleteName.getText().toString().trim());
        }
        else {
            Resources r2 = getResources();
            Toast.makeText(
                    this, r2.getString(R.string.main_no_name),
                    Toast.LENGTH_LONG).show();
            r2 = null;
        }
    }

    private class TranslatingProcessThread
            extends AsyncTask<String, Void, String[][]>{

        private ProgressDialog pDialog;
        private Context context;

        public TranslatingProcessThread(Context c){
            context = c;
        }

        @Override
        protected void onPreExecute() {

            if (pDialog != null) {
                pDialog.dismiss();
                pDialog = null;
            }

            Resources r1 = getResources();
            pDialog = new ProgressDialog(context);
            pDialog.setMessage(r1.getString(R.string.pd_translating));
            pDialog.setCancelable(false);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();

        }

        @Override
        protected String[][] doInBackground(String... params) {
            return stk.get_Translation(params[0]);
        }

        @Override
        protected void onPostExecute(String[][] result) {

            pDialog.dismiss();
            boolean isNullTranslation = false;
            for (int i=0; i<result.length; i++) {
                if (result[i][1].contains("null"))
                    isNullTranslation = true;
            }

            if (isNullTranslation) {
                Toast.makeText(context, "Lo sentimos", Toast.LENGTH_SHORT).show();
                txt_CompleteName.setText("");
            }
            else {

                ArrayList<String> merosName = new ArrayList<>();
                Intent intent = new Intent(MainActivity.this, NameTranslationActivity.class);

                for (int i=0; i<result.length; i++){
                    for (int j=0;j<result[i].length; j++){
                        merosName.add(result[i][j]);
                    }
                }

                String firstName = txt_CompleteName.getText().toString().split(" ")[0];

                intent.putExtra("result_translation", merosName);
                intent.putExtra("name", firstName);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

            }

        }

    }

}
