package com.example.filedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.filedemo.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String>{

}
