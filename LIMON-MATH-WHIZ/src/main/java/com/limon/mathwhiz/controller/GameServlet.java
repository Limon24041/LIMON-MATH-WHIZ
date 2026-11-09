
package com.limon.mathwhiz.controller;

import com.limon.mathwhiz.model.GameQuestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    private final Random random = new Random();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String playerName = request.getParameter("playerName");

        if (playerName == null || playerName.trim().isEmpty()) {
            response.sendRedirect("index.jsp");
            return;
        }

        playerName = playerName.trim();

        List<GameQuestion> questions = new ArrayList<>();

        // Question 1: Prime Number
        int primeNumber = random.nextInt(49) + 2;

        questions.add(new GameQuestion(
                "Is " + primeNumber + " a prime number? (Enter 1 for Yes, 0 for No)",
                "PRIME",
                primeNumber,
                0,
                "PRIME",
                2
        ));

        // Question 2: Modulus
        int a = random.nextInt(90) + 10;
        int b = random.nextInt(9) + 2;

        questions.add(new GameQuestion(
                "Calculate the remainder of " + a + " % " + b,
                "MOD",
                a,
                b,
                "MOD",
                2
        ));

        // Question 3: Trigonometry
        int[] angles = {30, 45, 60};
        String[] operations = {"SIN", "COS", "TAN"};

        int angle1 = angles[random.nextInt(angles.length)];
        String operation1 = operations[random.nextInt(operations.length)];

        questions.add(new GameQuestion(
                "Calculate " + operation1 + "(" + angle1 + "°)",
                "TRIG",
                angle1,
                0,
                operation1,
                3
        ));

        // Question 4: Trigonometry
        int angle2 = angles[random.nextInt(angles.length)];
        String operation2 = operations[random.nextInt(operations.length)];

        questions.add(new GameQuestion(
                "Calculate " + operation2 + "(" + angle2 + "°)",
                "TRIG",
                angle2,
                0,
                operation2,
                3
        ));

        HttpSession session = request.getSession();

        session.setAttribute("playerName", playerName);
        session.setAttribute("questions", questions);

        request.setAttribute("questions", questions);

        request.getRequestDispatcher("/game.jsp")
                .forward(request, response);
    }
}
