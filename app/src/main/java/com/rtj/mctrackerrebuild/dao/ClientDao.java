package com.rtj.mctrackerrebuild.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.rtj.mctrackerrebuild.entities.Client;

import java.util.List;

@Dao
public interface ClientDao {
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   void insert(Client client);
   @Update
    void update(Client client);
   @Delete
    void delete(Client client);
   @Query("SELECT * FROM table_client ORDER BY clientid ASC")
    List<Client> getAllClients();
}
