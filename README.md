# LIMON - MATH WHIZ

## 1. Project Title and Description

**LIMON - MATH WHIZ** is a web-based mathematical quiz game developed using Java Servlet, JSP, JDBC, and MySQL.

Players can answer mathematical questions, calculate their scores, save their results in a database, and view the leaderboard.

## 2. Objectives

- To develop an interactive mathematical quiz game.
- To implement mathematical operations using Java.
- To understand Java Servlet and JSP.
- To connect a web application with MySQL using JDBC.
- To store player scores in a database.
- To display the top 10 players on the leaderboard.

## 3. Technologies Used

- Java
- Java Servlet
- JSP
- JDBC
- MySQL
- HTML
- CSS
- Apache Tomcat 10.1
- Maven
- IntelliJ IDEA

## 4. Software Requirements

- JDK 26
- IntelliJ IDEA
- Apache Tomcat 10.1
- MySQL 8.0
- Maven
- Web Browser

## 5. Database Configuration

- **Database Name:** `math_whiz_db`
- **Table Name:** `game_scores`

The application uses MySQL to store player scores.

The database connection is configured in `DBConnection.java`.

Update the database username and password according to your local MySQL configuration.

**Note:** Never upload your actual database password to GitHub.

## 6. Database SQL

The SQL script is available in:

`database/math_whiz_db.sql`

Execute the SQL file in MySQL to create the database and table.

The `game_scores` table contains:

- `id`
- `player_name`
- `score`
- `difficulty`
- `played_at`

## 7. Installation and Run Instructions

1. Install JDK, IntelliJ IDEA, MySQL, and Apache Tomcat.
2. Open the project in IntelliJ IDEA.
3. Configure MySQL credentials in `DBConnection.java`.
4. Execute the SQL script to create the database and table.
5. Build the project using Maven.
6. Generate the `MathWhiz.war` file.
7. Deploy the WAR file to the Tomcat `webapps` directory.
8. Start the Apache Tomcat server.
9. Open the following URL in a web browser:

   `http://localhost:8080/MathWhiz/`

## 8. Game Rules and Scoring System

The game contains four mathematical questions.

| Question | Topic | Marks |
|----------|-------|-------|
| Question 1 | Prime Number | 2 |
| Question 2 | Modulus Operation | 2 |
| Question 3 | Trigonometric Calculation | 3 |
| Question 4 | Trigonometric Calculation | 3 |
| **Total** | | **10** |

**Difficulty Level:** NORMAL

Players receive marks for correct answers. Their final scores are stored in the MySQL database.

The leaderboard displays the top 10 scores in descending order.

## 9. Screenshots

The application screenshots are available in the `screenshots` directory.

- Leaderboard Page
- <img width="848" height="446" alt="Screenshot 2026-11-10 010358" src="https://github.com/user-attachments/assets/30df1058-100f-4312-ae53-8de8811512ee" />


