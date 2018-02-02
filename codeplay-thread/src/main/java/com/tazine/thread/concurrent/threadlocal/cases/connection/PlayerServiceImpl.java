package com.tazine.thread.concurrent.threadlocal.cases.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PlayerServiceImpl
 *
 * @author frank
 * @since 1.0.0
 */
public class PlayerServiceImpl implements PlayerService {

    private String updatePlayer = "UPDATE player SET number = ? WHERE id = ?";
    private String insertLog = "INSERT INTO op_log (log, user) VALUES (?, ?)";

    @Override
    public void updatePlayerNum(int id, int num) {
        Connection conn = null;
        try {
            conn = DBUtils2.getConnection();

            conn.setAutoCommit(false);

            updatePlayer(id, num, conn);

            insertLog(id, num, conn);

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void updatePlayer(int id, int num, Connection conn) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(updatePlayer);
        preparedStatement.setInt(1, num);
        preparedStatement.setInt(2, id);
        int rows = preparedStatement.executeUpdate();
        if (rows != 0) {
            System.out.println("更新 Player 成功！");
        }
    }

    private void insertLog(int id, int num, Connection conn) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(insertLog);
        pstm.setString(1, id + " 更新 num 为" + num);
        pstm.setString(2, "frank");
        int rows = pstm.executeUpdate();
        if (rows != 0) {
            System.out.println("插入 log 成功！");
        }
    }
}
