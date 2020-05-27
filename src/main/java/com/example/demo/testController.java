package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class testController {
    @RequestMapping("/get")
    public String getEmployee() throws ClassNotFoundException, SQLException {
        Class.forName("dm.jdbc.driver.DmDriver");
        String url = "jdbc:dm://127.0.0.1:5236";
        // 加载驱动程序
        // 主库 IP = 223.254.254.19
        String userID = "QSK";
        String passwd = "123456789";
        Connection con = DriverManager.getConnection(url, userID, passwd);
        PreparedStatement ps = con.prepareStatement("select * from SYSDBA.aidijing_order;");
        ResultSet rs = ps.executeQuery();
        String userId1 = "";
        String id1 = "";
        String orderId1 = "";
        String orderName1 = "";

        while (rs.next())
        {
            id1 = rs.getString("id");
            userId1 = rs.getString("user_id");
            orderId1 = rs.getString("order_id");
            orderName1 = rs.getString("order_name");
        }

        return id1+"  "+userID +"  " + orderId1+"   " +orderName1;
    }
}
