package com.zhiyou100.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtil {
	//声明一个类似于仓库的东西用来隔离线程的数据
		private static ThreadLocal<Connection> tl;
		private static ComboPooledDataSource dataSource = null;
		//静态代码块，在类加载的时候执行，而且只执行一次
		static{
			try{
				Properties prop = new Properties();
				InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("config.properties");
				prop.load(is);//加载配置文件中的属性列表
				tl=new ThreadLocal<Connection>();
				dataSource=new ComboPooledDataSource();
				//获取属性信息
				String jdbcUrl=prop.getProperty("c3p0.jdbcUrl");
				String driverClass = prop.getProperty("c3p0.driverClass");
				String user=prop.getProperty("c3p0.user");
				String password = prop.getProperty("c3p0.password");
				Integer maxPoolSize = Integer.parseInt(prop.getProperty("c3p0.maxPoolSize")) ;
				Integer minPoolSize = Integer.parseInt(prop.getProperty("c3p0.minPoolSize"));
				Integer initialPoolSize = Integer.parseInt(prop.getProperty("c3p0.initialPoolSize"));
				dataSource.setDriverClass(driverClass);
				dataSource.setJdbcUrl(jdbcUrl);
				dataSource.setUser(user);
				dataSource.setPassword(password);
				dataSource.setMaxPoolSize(maxPoolSize);
				dataSource.setMinPoolSize(minPoolSize);
				dataSource.setInitialPoolSize(initialPoolSize);
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection(){
			try {
				//从连接池中获取连接
				Connection conn = dataSource.getConnection();
				tl.set(conn);//将连接对象放到仓库中
				return conn;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//释放连接
		public static void closeConnection(){
			Connection conn = tl.get();//直接从仓库取出连接
			tl.remove();//清空仓库
			//关闭连接
			if(conn!=null){
				try {
					//关闭连接，返回连接池
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
}
