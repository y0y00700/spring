package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCtest {
	static {
		try {
			Class.forName("oracle:jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try(
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","user_prac","oracle")
				){
			log.info(con);
			log.info("연결되었습니다.");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
