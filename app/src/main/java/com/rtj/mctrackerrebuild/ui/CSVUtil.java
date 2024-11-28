package com.rtj.mctrackerrebuild.ui;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.opencsv.CSVWriter;
import com.rtj.mctrackerrebuild.entities.Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVUtil {
    public static void exportCSV(Context context, List<Client> clientList){
        File exportDir = new File(Environment.getExternalStorageDirectory(), "ClientReports");
        if(!exportDir.exists()){
            exportDir.mkdirs();
        }
        File file = new File(exportDir,"ClientReport.csv");
        try {
            file.createNewFile();
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            String[] header = {"Client Name","Email","Phone Number","Updated"};
            csvWriter.writeNext(header);
            for(Client client :clientList){
                String[] data = {client.getName(),client.getEmail(),client.getPhoneNumber(),client.getTimestamp().toString()};
                csvWriter.writeNext(data);
            }
            csvWriter.close();
            Toast.makeText(context,"CSV File created",Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(context,"Error creating CSV File.",Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        }
    }
}
