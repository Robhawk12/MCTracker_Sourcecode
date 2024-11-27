package com.rtj.mctrackerrebuild.data;

import android.app.Application;

import com.rtj.mctrackerrebuild.dao.ClientDao;
import com.rtj.mctrackerrebuild.dao.UserDao;
import com.rtj.mctrackerrebuild.entities.Client;
import com.rtj.mctrackerrebuild.entities.User;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private ClientDao clientDao;
    private List<Client> allClients;
    private UserDao userDao;
    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        ClientDBBuilder db = ClientDBBuilder.getDatabase(application);
        clientDao = db.clientDao();
        userDao = db.userDao();
    }

    public List<Client>getAllClients(){
        databaseExecutor.execute(()->{
            allClients = clientDao.getAllClients();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allClients;
    }
    public void insert(Client client){
        databaseExecutor.execute(()->{
            clientDao.insert(client);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void update(Client client){
        databaseExecutor.execute(()->{
            clientDao.update(client);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete(Client client){
        databaseExecutor.execute(()->{
            clientDao.delete(client);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
