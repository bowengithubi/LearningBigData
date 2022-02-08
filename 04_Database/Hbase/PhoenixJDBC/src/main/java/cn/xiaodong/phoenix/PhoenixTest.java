package cn.xiaodong.phoenix;

import org.apache.phoenix.queryserver.client.ThinClientUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: xiaodong
 * @create: 2021-08-31 05:19
 **/
public class PhoenixTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        //1.定义参数
//        String driver = "org.apache.phoenix.jdbc.PhoenixDriver";
//        String url = "jdbc:phoenix:hadoop102,hadoop103,hadoop104:2181";
//
//        //2.加载驱动
//        Class.forName(driver);

        // 1.获取JDBC URL(以瘦终端的方式)
        String url = ThinClientUtil.getConnectionUrl("hadoop102", 8765);
        System.out.println(url);

        //3.创建连接
        Connection connection = DriverManager.getConnection(url);

        //4.预编译SQL
        PreparedStatement preparedStatement = connection.prepareStatement("select * from XIAODONG.STUDENT");

        //5.查询获取返回值
        ResultSet resultSet = preparedStatement.executeQuery();

        //6.打印结果
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "    " + resultSet.getString(2));
        }

        //7.关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

}
