package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.Domain.Baseballteam;

/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author risa.nazato
 *
 */
@Repository
public class BaseballRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * Baseballteamオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<Baseballteam> BASEBALL_ROW_MAPPER = (rs, i) -> {
		Baseballteam baseballteam = new Baseballteam();
		baseballteam.setId(rs.getInt("id"));
		baseballteam.setLeague(rs.getString("league_name"));
		baseballteam.setTeamName(rs.getString("team_name"));
		baseballteam.setHeadquarters(rs.getString("headquarters"));
		baseballteam.setInauguration(rs.getString("inauguration"));
		baseballteam.setHistory(rs.getString("history"));
		return baseballteam;
	};

	/**
	 * 球団一覧情報を取得.
	 * 
	 * @return 全球団一覧
	 */
	public List<Baseballteam> showList() {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY inauguration;";

		List<Baseballteam> teamList = template.query(sql, BASEBALL_ROW_MAPPER);

		return teamList;
	}

	/**
	 * 
	 * 主キーから球団情報を取得.
	 * 
	 * @param id ID
	 * @return 球団情報
	 */
	public Baseballteam showDetail(Integer id) {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Baseballteam baseballteam = template.queryForObject(sql, param, BASEBALL_ROW_MAPPER);
		return baseballteam;
	}
}
