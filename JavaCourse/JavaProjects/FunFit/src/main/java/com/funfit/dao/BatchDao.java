package com.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.resource.DbResource;

public class BatchDao {
	
	public int addBatch(Batch batch) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into batch(typeofbatch,time) values(?,?)");
			pstmt.setString(1, batch.getTypeofbatch());
			pstmt.setString(2, batch.getTime());
			
			return pstmt.executeUpdate();
		}catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int updateBatch(Batch batch) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("update batch SET typeofbatch = ?, time = ? where bid=?");
			pstmt.setString(1, batch.getTypeofbatch());
			pstmt.setString(2, batch.getTime());
			pstmt.setInt(3, batch.getBid());
			
			System.out.println(pstmt);
			
			return pstmt.executeUpdate();
		}catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<Batch> viewAllBatches(){
		List<Batch> listOfBatch = new ArrayList<>();
		
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from batch");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Batch b = new Batch();
				b.setBid(rs.getInt(1));
				b.setTypeofbatch(rs.getString(2));
				b.setTime(rs.getString(3));
				listOfBatch.add(b);
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
		
		return listOfBatch;
	}
	
	public Batch getBatchById(String bid) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from batch where bid=?");
			pstmt.setString(1, bid);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
	            Batch b = new Batch();
	            b.setBid(rs.getInt(1));
	            b.setTypeofbatch(rs.getString(2));
	            b.setTime(rs.getString(3));
	            System.out.println(b);
	            return b;
	        } else {
	            return null;
	        }
		}
		catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	public int deleteBatch(String bid) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from batch where bid=?");
			pstmt.setString(1, bid);
			
			return pstmt.executeUpdate();
		}catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

}
