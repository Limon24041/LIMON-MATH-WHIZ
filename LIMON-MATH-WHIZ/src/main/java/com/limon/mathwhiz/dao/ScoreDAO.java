
package com.limon.mathwhiz.dao;

import com.limon.mathwhiz.model.GameScore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {

    // Save player score
    public boolean saveScore(GameScore gameScore) {

        String sql = "INSERT INTO game_scores " +
                "(player_name, score, difficulty) " +
                "VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, gameScore.getPlayerName());
            statement.setInt(2, gameScore.getScore());
            statement.setString(3, gameScore.getDifficulty());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve top 10 scores
    public List<GameScore> getTop10Scores() {

        List<GameScore> scores = new ArrayList<>();

        String sql = "SELECT * FROM game_scores " +
                "ORDER BY score DESC, played_at ASC LIMIT 10";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                GameScore gameScore = new GameScore();

                gameScore.setId(resultSet.getInt("id"));
                gameScore.setPlayerName(
                        resultSet.getString("player_name"));
                gameScore.setScore(resultSet.getInt("score"));
                gameScore.setDifficulty(
                        resultSet.getString("difficulty"));
                gameScore.setPlayedAt(
                        resultSet.getTimestamp("played_at"));

                scores.add(gameScore);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scores;
    }
}
