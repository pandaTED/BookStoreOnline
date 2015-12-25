package cn.panda.utils;

import java.sql.Connection;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	private static DataSource ds;
	private static DataSource bak_ds;
	

	static {
		ds = new ComboPooledDataSource();
		bak_ds = new ComboPooledDataSource("bak");
	}

	public static DataSource getDataSource() {
		return ds;
	}
	
	public static DataSource getDataSource_bak(){
		return bak_ds;
	}

	public static Connection getConnection() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = ds.getConnection();
				conn.setAutoCommit(false);

			}
			tl.set(conn);
			return conn;
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static void StartTransaction() {
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public static void commitTransaction() {
		try {
			Connection conn = getConnection();
			if (conn != null) {
				conn.commit();
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static void closeConn() {
		Connection conn = null;
		try {
			conn = getConnection();
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		} finally {
			tl.remove();
		}

	}
}
