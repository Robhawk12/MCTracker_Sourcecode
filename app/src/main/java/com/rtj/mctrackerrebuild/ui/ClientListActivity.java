package com.rtj.mctrackerrebuild.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.SearchView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rtj.mctrackerrebuild.R;
import com.rtj.mctrackerrebuild.dao.ClientDao;
import com.rtj.mctrackerrebuild.data.Repository;
import com.rtj.mctrackerrebuild.entities.Client;
import com.rtj.mctrackerrebuild.entities.PayMethod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientListActivity extends AppCompatActivity {
    ClientAdapter adapter;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
            PayMethod payMethod = null;
            Intent intent = new Intent(ClientListActivity.this, ClientDetailsActivity.class);
            intent.putExtra("paymethod", payMethod);
            startActivity(intent);
        });

        repository = new Repository(getApplication());
        List<Client> allClients = repository.getAllClients();

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new ClientAdapter(this, allClients);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       adapter.setmClients(allClients);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_myclients, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return false;
            }
        });
        return true;
    }
    private void filter(String text){
        List<Client> filteredlist = new ArrayList<>();
        for (Client item : repository.getAllClients()){
            if (item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredlist.add(item);
            }
        }
        if(filteredlist.isEmpty()){
            Toast.makeText(this,"Not Found", Toast.LENGTH_SHORT).show();
        }else {
            adapter.filterList(filteredlist);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.report) {
            startReport();
        }
        if (item.getItemId() == R.id.sample_code) {
            Date date = new Date();
            String timestamp = date.toString();
            repository = new Repository(getApplication());
            Client client = new Client(0, "John Smith", "es@email.com", "555-123-4567", PayMethod.CASH, PayMethod.CASH.getAmountDue(), PayMethod.CASH.getDisplayName(), timestamp);
            repository.insert(client);
            client = new Client(99, "Jenny Jones", "jj@email.com", "255-867-5309", PayMethod.UnitedHealth, PayMethod.UnitedHealth.getAmountDue(), PayMethod.UnitedHealth.getDisplayName(), timestamp);
            repository.insert(client);

            Toast.makeText(ClientListActivity.this, "put in sample data", Toast.LENGTH_LONG).show();
        }
        onResume();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        repository = new Repository(getApplication());
        List<Client> allClients = repository.getAllClients();
        adapter.setmClients(allClients);
    }
    String makeCsvReport(List<Client> clients) {
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("Name,Email,PhoneNumber,Timestamp\n");
        for (Client client : clients) {
            csvBuilder.append(client.getName()).append(",")
                    .append(client.getEmail()).append(",")
                    .append(client.getPhoneNumber()).append(",")
                    .append(client.getTimestamp()).append("\n");
        }
        return csvBuilder.toString();
    }

    public void saveCsvFile(String csv, String filename) throws IOException {
        FileOutputStream fileOutputStream = this.openFileOutput(filename, Context.MODE_PRIVATE);
        fileOutputStream.write(csv.getBytes());
        fileOutputStream.close();
    }

    public void shareReport(String filename) {
        File file = new File(this.getFilesDir(), filename);
        Uri fileUri = FileProvider.getUriForFile(this, "com.rtj.mctrackerrebuild", file);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/csv");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Client Report");
        shareIntent.putExtra(Intent.EXTRA_STREAM, fileUri);
        this.startActivity(Intent.createChooser(shareIntent, "Send Report"));
    }
    private void startReport(){
        List<Client> clients = repository.getAllClients();
        String csvReport = this.makeCsvReport(clients);
        String fileName = "client_report.csv";

        try {
            this.saveCsvFile(csvReport, fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        shareReport(fileName);
    }
}
