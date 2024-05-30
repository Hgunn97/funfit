package com.funfit.service;

import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.dao.BatchDao;

public class BatchService {
	
	BatchDao db = new BatchDao();
	
	public boolean addBatch(Batch batch) {
		if(db.addBatch(batch) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Batch> viewAllBatches(){
		return db.viewAllBatches();
	}
	
	public Batch getBatchById(String bid) {
		return db.getBatchById(bid);
	}
	
	public boolean deleteBatch(String bid) {
		if(db.deleteBatch(bid) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean updateBatch(Batch batch) {
		if(db.updateBatch(batch) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
