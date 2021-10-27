package com.travelblog.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.travelblog.http.Blog;

import java.util.List;

@Dao
public interface BlogDAO {

    @Query("SELECT * FROM blog")
    List<Blog> getAll();

    @Insert
    void insertAll(List<Blog> blogList);

    @Query("DELETE FROM blog")
    void deleteAll();
}
