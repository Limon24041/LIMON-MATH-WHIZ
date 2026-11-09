
package com.limon.mathwhiz.controller;

import com.limon.mathwhiz.dao.ScoreDAO;
import com.limon.mathwhiz.model.GameQuestion;
import com.limon.mathwhiz.model.GameScore;
import com.limon.mathwhiz.service.MathService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/submit")
public class AnswerServlet extends HttpServlet {

    private final ScoreDAO scoreDAO = new ScoreDAO();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
                session.getAttribute("playerName") == null ||
                session.getAttribute("questions") == null) {

            response.sendRedirect("index.jsp");
            return;
        }

        String playerName =
                (String) session.getAttribute("playerName");

        List<GameQuestion> questions =
                (List<GameQuestion>) session.getAttribute("questions");

        if (questions.size() != 4) {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid game session."
            );
            return;
        }

        int totalScore = 0;
        String[] results = new String[4];

        try {

            for (int i = 0; i < questions.size(); i++) {

                GameQuestion q = questions.get(i);

                String answerText =
                        request.getParameter("answer" + (i + 1));

                if (answerText == null || answerText.trim().isEmpty()) {
                    throw new IllegalArgumentException(
                            "All answers are required."
                    );
                }

                double answer = Double.parseDouble(answerText.trim());

                if (!Double.isFinite(answer)) {
                    throw new IllegalArgumentException(
                            "Invalid answer."
                    );
                }

                double correctAnswer;

                switch (q.getOperation()) {

                    case "PRIME":

                        if (answer != Math.rint(answer) ||
                                (answer != 0 && answer != 1)) {

                            throw new IllegalArgumentException(
                                    "Prime answer must be 0 or 1."
                            );
                        }

                        correctAnswer =
                                MathService.isPrime((int) q.getValue1());

                        break;

                    case "MOD":

                        if (answer != Math.rint(answer) ||
                                answer < Integer.MIN_VALUE ||
                                answer > Integer.MAX_VALUE) {

                            throw new IllegalArgumentException(
                                    "Modulus answer must be a valid integer."
                            );
                        }

                        correctAnswer = MathService.calculateMod(
                                (int) q.getValue1(),
                                (int) q.getValue2()
                        );

                        break;

                    case "SIN":

                        correctAnswer =
                                MathService.calculateSin(q.getValue1());

                        break;

                    case "COS":

                        correctAnswer =
                                MathService.calculateCos(q.getValue1());

                        break;

                    case "TAN":

                        correctAnswer =
                                MathService.calculateTan(q.getValue1());

                        break;

                    default:

                        throw new IllegalArgumentException(
                                "Unknown question type."
                        );
                }

                boolean isCorrect;

                if (q.getType().equals("TRIG")) {

                    isCorrect =
                            Math.abs(answer - correctAnswer) <= 0.0001;

                } else {

                    isCorrect = answer == correctAnswer;
                }

                if (isCorrect) {

                    totalScore += q.getMarks();
                    results[i] = "Correct";

                } else {

                    results[i] = "Incorrect";
                }
            }

            GameScore gameScore =
                    new GameScore(playerName, totalScore, "NORMAL");

            boolean saved = scoreDAO.saveScore(gameScore);

            request.setAttribute("playerName", playerName);
            request.setAttribute("totalScore", totalScore);
            request.setAttribute("results", results);
            request.setAttribute("saved", saved);

            request.getRequestDispatcher("/result.jsp")
                    .forward(request, response);

        } catch (IllegalArgumentException e) {

            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid answer: " + e.getMessage()
            );
        }
    }
}
