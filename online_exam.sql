create database online_exam;
USE online_exam;
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100),
    role VARCHAR(20)
);
CREATE TABLE questions (
    question_id INT PRIMARY KEY AUTO_INCREMENT,
    question_text VARCHAR(255),
    option_a VARCHAR(100),
    option_b VARCHAR(100),
    option_c VARCHAR(100),
    option_d VARCHAR(100),
    correct_option CHAR(1)
);
CREATE TABLE results (
    result_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    score INT,
    exam_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
INSERT INTO users (username, password, role) VALUES
('admin', 'admin123', 'admin'),
('student1', 'student123', 'student');
INSERT INTO questions (question_text, option_a, option_b, option_c, option_d, correct_option) VALUES
('What is the capital of India?', 'Mumbai', 'Delhi', 'Kolkata', 'Chennai', 'B'),
('Java is...', 'Platform Independent', 'Slow', 'Not Secure', 'None', 'A');
