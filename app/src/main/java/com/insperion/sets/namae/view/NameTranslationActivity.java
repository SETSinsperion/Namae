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

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.insperion.sets.namae.R;
import com.insperion.sets.namae.controller.ArrayAdapterWithIcon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NameTranslationActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> translations;
    private String firstName;
    private final int FACEBOOK = 0, TWITTER = 1, GOOGLE = 2;
    private final String [] items = new String[] {
            "Facebook", "Twitter", "Google"};
    private final String [][] packagesShare = new String[][] {
            {"https://www.facebook.com/", "com.facebook.katana"},
            {"https://twitter.com/", "com.twitter.android"},
            {"https://plus.google.com/", "com.google.android.apps.plus"}
    };
    private final Integer[] icons = new Integer[] {
            R.drawable.ic_facebook_color,
            R.drawable.ic_twitter_color,
            R.drawable.ic_googleplus_color
    };

    private FloatingActionButton speak_complete_name, greeting1, greeting2, greeting3;
    private TextView txt_greeting_1, txt_greeting_2, txt_greeting_3, ref;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_translation);

        // Getting translations
        Bundle bundle = getIntent().getExtras();
        translations = new ArrayList<>();
        translations = bundle.getStringArrayList("result_translation");
        firstName = bundle.getString("name");

        // GUI binding
        txt_greeting_1 = (TextView)findViewById(R.id.txt_greeting_1);
        txt_greeting_2 = (TextView)findViewById(R.id.txt_greeting_2);
        txt_greeting_3 = (TextView)findViewById(R.id.txt_greeting_3);
        ref = (TextView)findViewById(R.id.tv_reference);
        speak_complete_name = (FloatingActionButton)findViewById(R.id.fab_speak_complete_name);
        greeting1 = (FloatingActionButton)findViewById(R.id.fab_greeting_1);
        greeting2 = (FloatingActionButton)findViewById(R.id.fab_greeting_2);
        greeting3 = (FloatingActionButton)findViewById(R.id.fab_greeting_3);
        speak_complete_name.setOnClickListener(this);
        greeting1.setOnClickListener(this);
        greeting2.setOnClickListener(this);
        greeting3.setOnClickListener(this);

        // Putting Translation
        LinearLayout ll_complete_name =
                (LinearLayout)findViewById(R.id.ll_complete_name);
        for (int i=0; i<translations.size(); i++){
            TextView tv = new TextView(this);
            tv.setText(translations.get(i));
            if (i==0 || i%2==0) {
                tv.setTextColor(getResources().getColor(R.color.primary_text));
                tv.setTextSize(ref.getTextSize() + 5);
            }
            else {
                tv.setTextColor(getResources().getColor(R.color.secondary_text));
                tv.setTextSize(ref.getTextSize() - 5);
            }
            tv.setGravity(Gravity.CENTER);

            ll_complete_name.addView(tv);
        }

        set_InitTextGreetings();

        if (!isOnline(this)) {
            Resources r = getResources();
            set_ShowSimpleDialog(
                    r.getString(R.string.ntr_ups), r.getString(R.string.ntr_audio_not_available));
        }


    }

    private boolean isOnline(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ntr_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.ntr_share) {
            if (isOnline(this))
                set_ShareJapaneseName();
            else
                set_ShowSimpleDialog(
                    getResources().getString(R.string.ntr_ups),
                    getResources().getString(R.string.ntr_sharing_not_available));
            return true;
        }
        else if (id == R.id.ntr_want_to_know_more) {
            Intent i = new Intent(this, WantToKnowMoreActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
        else {
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }

        return super.onOptionsItemSelected(item);

    }

    private void set_ShareJapaneseName() {

        ListAdapter adapter = new ArrayAdapterWithIcon(this, items, icons);
        final Context context = this;
        String name = "Namae: Mi nombre en japonés: ";

        for (int i=0; i<translations.size(); i+=2)
            name += translations.get(i).replace(" ", "") + " ";

        final String nameToShare = name;

        new AlertDialog.Builder(this)
            .setTitle(getResources().getString(R.string.ntr_share))
            .setAdapter(adapter, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {

                    PackageManager manager = context.getPackageManager();
                    set_Clipboard(context, nameToShare);
                    Toast.makeText(
                            context, "¡Copiado al portapapeles! " + nameToShare,
                            Toast.LENGTH_LONG).show();
                    int selectionPackageShare = -1;

                    switch(item) {
                        case FACEBOOK:
                            selectionPackageShare = FACEBOOK;
                            break;
                        case TWITTER:
                            selectionPackageShare = TWITTER;
                            break;
                        case GOOGLE:
                            selectionPackageShare = GOOGLE;;
                            break;
                    }

                    Intent i = manager.getLaunchIntentForPackage(
                            packagesShare[selectionPackageShare][1]);
                    if (i == null)
                        i = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(packagesShare[selectionPackageShare][0]));

                    startActivity(i);

                }
            }).show();

    }

    private void set_Clipboard(Context context, String text) {
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard =
                    (android.text.ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
        }
        else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
        }
    }

    private void set_ShowSimpleDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(message);
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

    private void set_KillMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            catch (Exception ex){
                Log.e("MP3", ex.getMessage());
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private void set_Speak(String tts) {
        try {

            set_KillMediaPlayer();

            Uri uri = Uri.parse(
                    "http://translate.google.com/translate_tts?ie=UTF-8&total=1&idx=0" +
                            "&textlen=100&client=tw-ob&q=" + tts + "&tl=ja");

            Map<String, String> headerMap = new HashMap<>();
            headerMap.put("User-Agent", "Mozilla");

            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(this, uri, headerMap);
            mediaPlayer.prepare();
            mediaPlayer.start();

        }
        catch (Exception ex){
            Log.e("MP3", ex.getMessage());
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {

        String tts = "";

        switch(v.getId()) {
            case R.id.fab_speak_complete_name:
                for (int i=0; i<translations.size(); i+=2)
                    tts += translations.get(i).replace(" ", "") + "+";
                tts = tts.substring(0, tts.length() - 1);
                break;
            case R.id.fab_greeting_1:
                tts = "わたし+の+名前+は+" + translations.get(1).replace(" ", "") + "+です";
                break;
            case R.id.fab_greeting_2:
                tts = "こんにちは+、+" + translations.get(1).replace(" ", "") +
                        "+です+、+どうぞ+よろしく+おねがいします";
                break;
            case R.id.fab_greeting_3:
                tts = translations.get(1).replace(" ", "") + "+です+、+少し+日本語+が+話せます";
                break;
        }

        set_Speak(tts);

    }

    private void set_InitTextGreetings(){
        txt_greeting_1.setText(
                txt_greeting_1.getText().toString().replace(
                        "namae", firstName
                )
        );
        txt_greeting_2.setText(
                txt_greeting_2.getText().toString().replace(
                        "namae", firstName
                )
        );
        txt_greeting_3.setText(
                txt_greeting_3.getText().toString().replace(
                        "namae", firstName
                )
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        set_KillMediaPlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        set_KillMediaPlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        set_KillMediaPlayer();
    }
}
