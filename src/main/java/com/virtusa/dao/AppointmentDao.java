package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.virtusa.entity.Appointment;

public class AppointmentDao {

	private Connection conn;
	
	public AppointmentDao(Connection conn) {
		this.conn=conn;
	}
	
	public boolean saveAppointmentToDB(Appointment ap) {
		Boolean f=false;
		
		try {
			String sql="INSERT INTO appointment (userId, doctorId, username, age, disease, appointmentDate, slot, specialistName, doctorName, isApproved, comment, status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, ap.getUserId());
			ps.setInt(2, ap.getDoctorId());
			ps.setString(3, ap.getUsername());
			ps.setInt(4, ap.getAge());
			ps.setString(5, ap.getDisease());
			ps.setDate(6,ap.getAppointmentDate());
			ps.setString(7, ap.getSlot());
			ps.setString(8, ap.getSpecialistName());
			ps.setString(9, ap.getDoctorName());
			ps.setBoolean(10, ap.getIsApproved());
			ps.setString(11, ap.getComment());
			ps.setString(12, ap.getStatus());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		return f;
	}
}
