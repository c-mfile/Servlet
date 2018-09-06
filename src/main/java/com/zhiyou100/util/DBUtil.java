package com.zhiyou100.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtil {
	//����һ�������ڲֿ�Ķ������������̵߳�����
		private static ThreadLocal<Connection> tl;
		private static ComboPooledDataSource dataSource = null;
		//��̬����飬������ص�ʱ��ִ�У�����ִֻ��һ��
		static{
			try{
				Properties prop = new Properties();
				InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("config.properties");
				prop.load(is);//���������ļ��е������б�
				tl=new ThreadLocal<Connection>();
				dataSource=new ComboPooledDataSource();
				//��ȡ������Ϣ
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
				//�����ӳ��л�ȡ����
				Connection conn = dataSource.getConnection();
				tl.set(conn);//�����Ӷ���ŵ��ֿ���
				return conn;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//�ͷ�����
		public static void closeConnection(){
			Connection conn = tl.get();//ֱ�ӴӲֿ�ȡ������
			tl.remove();//��ղֿ�
			//�ر�����
			if(conn!=null){
				try {
					//�ر����ӣ��������ӳ�
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
}
