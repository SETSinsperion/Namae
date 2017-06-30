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

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.insperion.sets.namae.R;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton website, license;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        website = (FloatingActionButton)findViewById(R.id.fab_about_website);
        license = (FloatingActionButton)findViewById(R.id.fab_about_license);
        website.setOnClickListener(this);
        license.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String web = "";
        switch(v.getId()) {
            case R.id.fab_about_website:
                web = "http://www.insperion.com.mx";
                break;
            case R.id.fab_about_license:
                web = "https://www.gnu.org/licenses/gpl-3.0.en.html";
                break;
        }

        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(web));
        startActivity(browserIntent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

}
