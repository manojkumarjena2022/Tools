package com.mj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/**
 * @author Manoj
 *
 */
public class SelectTest {
	private static Logger logger=Logger.getLogger(SelectTest.class);
	static {
		try
		{
			//create layout
			SimpleLayout layout=new SimpleLayout();
			//create Appender object having layout object
			ConsoleAppender appender=new ConsoleAppender(layout);
			//add appender object to logger object
			logger.addAppender(appender);
			//logger level to retrive log messages
			//logger.setLevel(Level.DEBUG);//default is DEBUG
			//logger.setLevel(Level.WARN);
			//logger.setLevel(Level.OFF); //disable logging temporarily
			//logger.setLevel(Level.ALL); //same as DEBUG
			logger.info("com.mj.jdbc.SelectTest::Log4j Setup ready");
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.fatal("com.mj.jdbc.SelectTest:: Problem while setting Log4j");
		}
	}

	public static void main(String[] args) {
		logger.debug("com.mj.jdbc.SelectTest:: start of main(-) method");
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//load and register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.debug("com.mj.jdbc.SelectTest:: JDBC driver class loaded");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			logger.debug("com.mj.jdbc.SelectTest:: JDBC connection is established with DB s/w");
			//create statement object
			if(con!=null)
			{
				st=con.createStatement();
				logger.debug("com.mj.jdbc.SelectTest:: JDBC statement object is created");
			}
			//prepare sql query
			String query="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
			//send and execute sql query in DB s/w
			if (st!=null) {
				rs=st.executeQuery(query);
				logger.debug("com.mj.jdbc.SelectTest:: SQL query is send to DB s/w and ResultSet object is generated");
			}
			if (rs!=null) {
				boolean flag=false;
				while (rs.next()!=false) {
					flag=true;
					System.out.println("SNO: "+rs.getString(1)+" SNAME: "+rs.getString(2)+" SADD: "+rs.getString(3)+" AVG: "+rs.getString(4));
					
				}//while
				logger.warn("com.mj.jdbc.SelectTest:: ResultSet object is processed");
				logger.debug("com.mj.jdbc.SelectTest:: The ResultSet object are retrived using getString(-) for all cols change them accordingly");
				if(!flag)
				{
					System.out.println("No record found.");
				}
			}//if

		}//try
		catch (ClassNotFoundException ce) {//to handle known exception
			logger.error("com.mj.jdbc.SelectTest:: known DB problem::"+ce.getMessage());
			ce.printStackTrace();
		} catch (SQLException se) {//to handle known exception
			logger.error("com.mj.jdbc.SelectTest:: known DB problem::"+se.getMessage()+" SQl error code"+se.getErrorCode());
			se.printStackTrace();
		}
		catch (Exception e) {//to handle unknown exception
			logger.fatal("com.mj.jdbc.SelectTest:: Unknown DB problem::"+e.getMessage());
			e.printStackTrace();
		}
		finally {
			logger.debug("com.mj.jdbc.SelectTest:: closing JDBC objs");
			try {
				if (rs!=null) {
					rs.close();
					logger.debug("com.mj.jdbc.SelectTest:: closing ResultSet obj");
				}
			} catch (SQLException se2) {
				logger.error("com.mj.jdbc.SelectTest:: Problem in closing ResultSet obj::"+se2.getMessage());
				se2.printStackTrace();
			}
			try {
				if (st!=null) {
					st.close();
					logger.debug("com.mj.jdbc.SelectTest:: closing Statement obj");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("com.mj.jdbc.SelectTest:: Problem in closing Statement obj::"+e.getMessage());
			}
			try {
				if (con!=null) {
					con.close();
					logger.debug("com.mj.jdbc.SelectTest:: closing Connection obj");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("com.mj.jdbc.SelectTest:: Problem in closing Connection obj::"+e.getMessage());
			}

		}
		logger.debug("com.mj.jdbc.SelectTest:: end on main(-) method:");
	}

}
