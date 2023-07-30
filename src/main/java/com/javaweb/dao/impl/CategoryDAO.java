package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.ICategoryDAO;
import com.javaweb.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO{
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mySQL://localhost:3306/jspservletjdbc";
			String name = "root";
			String password = "Ktam123456";
			return DriverManager.getConnection(url, name, password);
		} catch (SQLException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			return null;
		}	
	}

	@Override
	public List<CategoryModel> findAll() {
		
		List<CategoryModel> result = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM category";
		
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection !=null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					CategoryModel category = new CategoryModel();
					category.setId(resultSet.getLong("id"));
					category.setCode(resultSet.getString("code"));
					category.setName(resultSet.getString("name"));
					result.add(category);		
				}
			
				
				return result;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(connection!=null)
					{
						connection.close();
					}
					if(statement!=null) {
						statement.close();
					}
					if(resultSet!=null) {
						resultSet.close();
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
			
		// TODO Auto-generated method stub
		
		return null;
	}

}
