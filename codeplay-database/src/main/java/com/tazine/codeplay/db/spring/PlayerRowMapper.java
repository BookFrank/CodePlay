package com.tazine.codeplay.db.spring;

import com.tazine.codeplay.db.NbaPlayer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PlayerRowMapper
 *
 * @author frank
 * @date 2017/03/14
 */
public class PlayerRowMapper implements RowMapper<NbaPlayer>{

    @Override
    public NbaPlayer mapRow(ResultSet resultSet, int i) throws SQLException {
        NbaPlayer player = new NbaPlayer();
        player.setName(resultSet.getString("name"));
        player.setNum(resultSet.getInt("num"));
        player.setTeam(resultSet.getString("team"));
        player.setCreatTime(resultSet.getDate("creat_time"));
        return player;
    }
}
