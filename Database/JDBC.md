# JDBC

### 1. 시작

- DBMS는 Oracle을 이용
- C:\app\student\product\11.2.0\dbhome_1\jdbc\lib 에서 `ojdbc6`를 사용
- JDBC는 Java application과 DBMS사이에서의 다리역할을 함.

![](JDBC_assets/JDBC_brige.jpg)



- 티어(tier) vs 레이어(layer)

  - 티어?

    HOST - HOST - HOST = 3tier 물리적으로 서로 떨어져 있으면 티어라고 함.

  - 레이어?

    HOST(내부에 기능별로 계층으로 나눠져 있는)  = layer

  - 3tier? 클라이언트 / 미들웨어(타입3) / 데이터베이스 서버.

    - 2tier에 비해, 유지보수 비용을 절약할 수 있음. 왜? 데이터베이스를 뭔가 변경하면, 한단계 거쳐 진행되므로 조금 느릴 수 있음.

- 붙어넣기
  - `C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext` 에 `ojdbc6`붙여넣기
  - 안되면? 직접추가해라.

### 2. 연결

```JAVA
package lab.java.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null; //db연결된 세션 정보가 저장될 것이고
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("driver loading성공");
			con = DriverManager.getConnection(url,"scott","oracle");
			System.out.println("db connect 성공");
		}catch (ClassNotFoundException e) {
			System.out.println("driver 없음.");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			//db 연결 실패

		}
	}
}
//driver loading성공
//db connect 성공
```

### 3. 가져오기

```java
package lab.java.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement stat =null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String sql = "select * from dept"; //sql문장 준비
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,"scott","oracle");

			stat = con.createStatement(); //stat 객체생성			
			rs = stat.executeQuery(sql); //메서드 실행해서 받음
			while(rs.next()) {
				System.out.print(rs.getInt("deptno"));
				//System.out.print(rs.getInt(1); 첫번째 컬럼을 꺼내오려면?
				System.out.print(rs.getString(2)); //두번째 컬럼 꺼내오기
				//System.out.print(rs.getString("dname"));
				System.out.println(rs.getString(3));
				//System.out.println(rs.getString("loc"));
			}
		}catch (ClassNotFoundException e) {
			System.out.println("driver 없음.");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			//db 연결 실패
		}finally {
			try {
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(con!=null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}//finally end
	}
}

```



### 4. 데이터 insert

```java
package lab.java.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class InsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null; //db연결된 세션 정보가 저장될 것이고
		PreparedStatement stat =null; //왜? sql에 ???3개를 통해 쓸꺼니까
		String sql = "insert into dept values(?,?,?)";
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:/workplace_rubin/Java13/src/lab/java/core/dbinfo.properties"));
			Class.forName(prop.getProperty("driver"));
			System.out.println("driver loading성공");
			con = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pwd")
					);
			System.out.println("db connect 성공");
			stat = con.prepareStatement(sql); //stat 객체생성, sql쿼리문을 보냄		
			stat.setInt(1, 70);
			stat.setString(2, "Bigdata");
			stat.setString(3, "Seoul");
			
			int row = stat.executeUpdate(); //변경된 row수가 리턴됨.
			
			if(row>0) {
				System.out.println("insert 성공");
			}	
			
		}catch (ClassNotFoundException e) {
			System.out.println("driver 없음.");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			//db 연결 실패
		}catch (IOException e) {
			System.out.println(e.getMessage());//properties파일 오류
		}

		finally {
			try {
			if(stat!=null) stat.close();
			if(con!=null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}//finally end

	}
}

```

