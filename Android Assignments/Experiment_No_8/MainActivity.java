package com.example.menus;


import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvContext, tvCAB;
    Button btnPopup;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tvContext = findViewById(R.id.tvContext);
        tvCAB = findViewById(R.id.tvCAB);
        btnPopup = findViewById(R.id.btnPopup);

        setSupportActionBar(toolbar);

        // Context Menu
        registerForContextMenu(tvContext);

        // Popup Menu
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, btnPopup);
                popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        handleClick(item);
                        return true;
                    }
                });

                popup.show();
            }
        });

        // Contextual Action Mode (CAB)
        tvCAB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (actionMode != null) return false;

                actionMode = startSupportActionMode(new ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        mode.setTitle("Select Action");
                        getMenuInflater().inflate(R.menu.menu_main, menu);
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        handleClick(item);
                        mode.finish();
                        return true;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {
                        actionMode = null;
                    }
                });

                return true;
            }
        });
    }

    // Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return handleClick(item);
    }

    // Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Context Menu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return handleClick(item);
    }

    // Handle Menu Clicks
    private boolean handleClick(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) show("Home");
        else if (id == R.id.settings) show("Settings");
        else if (id == R.id.help) show("Help");
        else if (id == R.id.about) show("About");
        else if (id == R.id.logout) show("Logout");

        return true;
    }

    private void show(String msg) {
        Toast.makeText(this, msg + " Clicked", Toast.LENGTH_SHORT).show();
    }
}