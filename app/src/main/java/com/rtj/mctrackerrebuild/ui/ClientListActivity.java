package com.rtj.mctrackerrebuild.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rtj.mctrackerrebuild.R;
import com.rtj.mctrackerrebuild.data.Repository;
import com.rtj.mctrackerrebuild.entities.Client;
import com.rtj.mctrackerrebuild.entities.PayMethod;

import java.util.List;

public class ClientListActivity extends AppCompatActivity {

    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
            PayMethod payMethod = null;
                    Intent intent = new Intent(ClientListActivity.this, ClientDetailsActivity.class);
                    intent.putExtra("paymethod",payMethod );
                startActivity(intent);
        });

        repository = new Repository(getApplication());
        List<Client> allClients = repository.getAllClients();

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recyclerview);
        final ClientAdapter clientAdapter = new ClientAdapter(this);
        recyclerView.setAdapter(clientAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clientAdapter.setmClients(allClients);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_myclients,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        if(item.getItemId() == R.id.sample_code){
            repository = new Repository(getApplication());
            Client client = new Client(0,"John Smith","es@email.com","555-123-4567", PayMethod.CASH,PayMethod.CASH.getAmountDue(),PayMethod.CASH.getDisplayName() );
            repository.insert(client);
            client = new Client(99,"Jenny Jones","jj@email.com","255-867-5309",PayMethod.UnitedHealth,PayMethod.UnitedHealth.getAmountDue(),PayMethod.UnitedHealth.getDisplayName());
            repository.insert(client);

            Toast.makeText(ClientListActivity.this, "put in sample data", Toast.LENGTH_LONG).show();
        }
        onResume();
        return true;
    }

    @Override
    protected void onResume(){
        super.onResume();
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        repository = new Repository(getApplication());
        List<Client> allClients = repository.getAllClients();
        final ClientAdapter clientAdapter = new ClientAdapter(this);
        recyclerView.setAdapter(clientAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clientAdapter.setmClients(allClients);
    }
}
