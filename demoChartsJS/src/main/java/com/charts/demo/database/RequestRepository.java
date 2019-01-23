package com.charts.demo.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.charts.demo.beans.Request;

@Repository
public interface RequestRepository extends MongoRepository<Request, String> {

	public interface TopRepository extends MongoRepository<Request, String>, RequestRepository {
	    @Query("{'Name':?0}")
	    Request findByName(String name);  
	}
	 
}