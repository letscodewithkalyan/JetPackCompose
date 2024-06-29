package com.kp.explore

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        requestContactsPermission()
    }

    fun loadContacts() {
        var cursor = getContentResolver().query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        );
        startManagingCursor(cursor);

        // data is a array of String type which is
        // used to store Number ,Names and id.
        val data = arrayOf(
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone._ID
        );
        val to = intArrayOf( android.R.id.text1, android.R.id.text2 )

        // creation of adapter using SimpleCursorAdapter class
        val adapter =
            SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, data, to);

        val listView = findViewById<ListView>(R.id.contactsListView);
        // Calling setAdaptor() method to set created adapter
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    fun requestContactsPermission(){
        val permission = Manifest.permission.READ_CONTACTS
        when {
            ContextCompat.checkSelfPermission(
                this, permission
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Action to take when permission is already granted
                loadContacts();
            }
            shouldShowRequestPermissionRationale(permission) -> {
                // Action to take when permission was denied
                Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show()
            }
            else -> {
                // Request permission
                requestPermissionLauncher.launch(permission)
            }
        }
    }

    private var requestPermissionLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                loadContacts()
            }
        }
}