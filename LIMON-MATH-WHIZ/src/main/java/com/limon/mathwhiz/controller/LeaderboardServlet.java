
package com.limon.mathwhiz.controller;

import com.limon.mathwhiz.dao.ScoreDAO;
import com.limon.mathwhiz.model.GameScore;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/leaderboard")
public class LeaderboardServlet extends HttpServlet {

    private final ScoreDAO scoreDAO = new ScoreDAO();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<GameScore> scores = scoreDAO.getTop10Scores();

        request.setAttribute("scores", scores);

        request.getRequestDispatcher("/leaderboard.jsp")
                .forward(request, response);
    }
}
