package softstone.paper.hivesql.hive;

import java.sql.*;


public class FI_HiveUtils {
	/**
	 * �����ӵļ�Ⱥ�Ƿ�Ϊ��ȫ�汾
	 */
	private static PropertiesResolve pr = new PropertiesResolve();

	private static final String ZK_SERVER_PRINCIPAL = "zookeeper.server.principal";
	private static final String SECURITY_KRB5_CONF = "java.security.krb5.conf";
	private static final String ZK_SASL_CLIENT = "zookeeper.sasl.client";

	static {
		if ("true".equals(pr.readMapByKey("/hivejdbc.properties",
				"isSecureVerson"))) {
			System.setProperty(SECURITY_KRB5_CONF, pr.readMapByKey("/hivejdbc.properties", "SECURITY_KRB5_CONF"));
			System.setProperty(ZK_SERVER_PRINCIPAL, pr.readMapByKey("/hivejdbc.properties", "ZK_SERVER_PRINCIPAL"));
			System.setProperty(ZK_SASL_CLIENT, pr.readMapByKey("/hivejdbc.properties", "ZK_SASL_CLIENT"));
		}
	}
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

	public static Connection getConnection() {
		Connection conn = connectionHolder.get();
		if (conn == null) {
			try {
				JdbcInfo jdbcInfo = ConfigReader.getInstance().getJdbcInfo();
				Class.forName(jdbcInfo.getDriverName());
				conn = DriverManager.getConnection(jdbcInfo.getUrl(),
						jdbcInfo.getUsername(), jdbcInfo.getPassword());
				connectionHolder.set(conn);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static Connection getConnection(boolean isSecureVerson){

		String zkQuorum = pr.readMapByKey("/hivejdbc.properties", "zkQuorum");
		// ƴ��JDBC URL
		StringBuilder sBuilder = new StringBuilder(pr.readMapByKey(
				"/hivejdbc.properties", "jdbch")).append(zkQuorum).append("/");
		if (isSecureVerson) {
			// �����½��û���userPrincipal���˴���дΪ���������û��������紴�����û�Ϊuser����userPrincipal��Ϊuser@HADOOP.COM��
			// ���ʹ��Hive�����ϵͳ�����û�hive/hadoop.hadoop.com��������userPrincipalΪhive/hadoop.hadoop.com��
			String userPrincipal = pr.readMapByKey("/hivejdbc.properties",
					"userPrincipal");
			// ���ÿͻ��˵�keytab�ļ�·��
			String userKeyTab = pr.readMapByKey("/hivejdbc.properties",
					"userKeyTab");
			sBuilder.append(";serviceDiscoveryMode=")
					.append("zooKeeper")
					.append(";zooKeeperNamespace=")
					.append("hiveserver2;sasl.qop=auth-conf;auth=KERBEROS;principal=")
					.append(pr.readMapByKey("/hivejdbc.properties","userPrincipal"))
					.append(";user.principal=")
					.append(userPrincipal).append(";user.keytab=")
					.append(userKeyTab).append(";");
		} else {
			// �ǰ�ȫ��
			sBuilder.append(";serviceDiscoveryMode=").append("zooKeeper")
					.append(";zooKeeperNamespace=")
					.append("hiveserver2;auth=none");
		}
		String url = sBuilder.toString();

		try {
			Class.forName(pr.readMapByKey("/hivejdbc.properties", "HIVE_DRIVER"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection conn = null;
		try {
			// ��ȡJDBC����
			conn = DriverManager.getConnection(url, "", "");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// �ر�JDBC����
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return conn;
	}

	public static void closeConnection() {
		Connection conn = connectionHolder.get();
		if (conn != null) {
			try {
				conn.close();
				connectionHolder.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
