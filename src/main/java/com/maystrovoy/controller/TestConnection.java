//package com.maystrovoy.controller;
//
//import oracle.jdbc.driver.OracleDriver;
//
//import java.sql.*;
//
//public class TestConnection {
//
//    public static void main(String[] args) throws SQLException {
//
//        DriverManager.registerDriver(new OracleDriver());
//        Connection conn = DriverManager.getConnection("jdbc:Oracle:thin:@10.1.32.39:1521:MAXIMO2T","MXSAP","INTEGRATION");
//
//        Statement stmt = null;
//
////        PreparedStatement insert = conn.prepareStatement("INSERT INTO MXSAP.QUEUE (QUEUEID,OBJECTID,OBJECTTYPE,STATUS,STARTDATE,FINISHDATE,USERNAME,MESSAGE) VALUES (9999888, 'test', 9, 'DONE', sysdate, null, 'test', null)");
////        PreparedStatement insert = conn.prepareStatement("INSERT INTO MXSAP.QUEUE VALUES(MXSAP.QUEUE_SEQ.NEXTVAL,'test','10','ACTIVE',sysdate,NULL,'MAXIMO',NULL)");
//        PreparedStatement insert = conn.prepareStatement("INSERT INTO queue (objectid, objecttype, username, queueid, status, startdate, message) VALUES (?,10,'sapuser',queue_seq.nextval,'ACTIVE',sysdate,'')");
//        insert.setString(1, "test");
//        insert.executeUpdate();
//
//        try {
//            stmt = conn.createStatement();
//
//            ResultSet rs = stmt.executeQuery("SELECT * FROM QUEUE where queueid=9999888");
////            ResultSet rs = stmt.executeQuery("SELECT * FROM MXSAP.QUEUE");
//
//            if (rs.next()) {
//                System.out.println("test: " + rs.getString(1));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            if (stmt != null) try { stmt.close(); } catch (Exception e) {}
//            if (conn != null) try { conn.close(); } catch (Exception e) {}
//        }
//    }
//}
