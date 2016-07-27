package com.example.myapplication;

import android.content.ContentProvider;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }



        public void onClickAddName(View view) {
            // Add a new student record
            ContentValues values = new ContentValues();

            values.put(StudentsProvider.NAME,
                    ((EditText) findViewById(R.id.editText2)).getText().toString());

            values.put(StudentsProvider.GRADE,
                    ((EditText) findViewById(R.id.editText3)).getText().toString());

            Uri uri = getContentResolver().insert(
                    StudentsProvider.CONTENT_URI, values);

            Toast.makeText(getBaseContext(),
                    uri.toString(), Toast.LENGTH_LONG).show();
        }

        public void onClickRetrieveStudents(View view) {
            String URL = "content://com.example.provider.College/students";

            Uri students = Uri.parse(URL);
            Cursor c = managedQuery(students, null, null, null, "name");

            if (c.moveToFirst()) {
                do {
                    Toast.makeText(this , c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                    ", " + c.getString(c.getColumnIndex(StudentsProvider.NAME)) +
                                    ", " + c.getString(c.getColumnIndex(StudentsProvider.GRADE)),
                            Toast.LENGTH_SHORT).show();
                } while (c.moveToNext());
            }
        }


        public boolean onCreate() {
            return false;
        }

        @Nullable
        public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
            return null;
        }

        @Nullable
        public String getType(Uri uri) {
            return null;
        }

        @Nullable
        public Uri insert(Uri uri, ContentValues values) {
            return null;
        }

        public int delete(Uri uri, String selection, String[] selectionArgs) {
            return 0;
        }

        public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
            return 0;
        }
    }
