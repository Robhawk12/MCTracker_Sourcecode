package com.rtj.mctrackerrebuild.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rtj.mctrackerrebuild.R;
import com.rtj.mctrackerrebuild.entities.Client;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {
    private List<Client> mClients;
    private  Context context;
    private final LayoutInflater mInflater;

    public class ClientViewHolder extends RecyclerView.ViewHolder {
        private final TextView clientItemView;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            clientItemView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Client current = mClients.get(position);
                    Intent intent = new Intent(context, ClientDetailsActivity.class);
                    intent.putExtra("id", current.getClientid());
                    intent.putExtra("name", current.getName());
                    intent.putExtra("email", current.getEmail());
                    intent.putExtra("phone", current.getPhoneNumber());
                    //intent.putExtra("paymentamount", current.getAmountDue());
                    context.startActivity(intent);

                }
            });
        }
    }

    @NonNull
    @Override
    public ClientAdapter.ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_client_view, parent, false);
        return new ClientViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientAdapter.ClientViewHolder holder, int position) {
        if (mClients != null) {
            Client current = mClients.get(position);
            String name = current.getName();
            holder.clientItemView.setText(name);
        } else {
            holder.clientItemView.setText("Not Found");
        }
    }

    public void setmClients(List<Client> clients) {
        mClients = clients;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if(mClients != null){
            return mClients.size();
        }else return 0;
    }

    public ClientAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

}
