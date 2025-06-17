
-- Interview Management System (MySQL)

-- ========================
-- Drop & Create Database
-- ========================
DROP DATABASE IF EXISTS ims_db;
CREATE DATABASE ims_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ims_db;

-- ========================
-- Roles
-- ========================
CREATE TABLE Roles (
                       role_id INT AUTO_INCREMENT PRIMARY KEY,
                       role_name VARCHAR(50) NOT NULL UNIQUE
);

-- ========================
-- Users (Admins, Recruiters, Interviewers, Managers)
-- ========================
CREATE TABLE Users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password_hash VARCHAR(255) NOT NULL,
                       full_name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       phone VARCHAR(20),
                       department VARCHAR(100),
                       role_id INT,
                       status BOOLEAN DEFAULT TRUE,
                       FOREIGN KEY (role_id) REFERENCES Roles(role_id)
);

-- ========================
-- Candidates (self-managed)
-- ========================
CREATE TABLE Candidates (
                            candidate_id INT AUTO_INCREMENT PRIMARY KEY,
                            username VARCHAR(50) NOT NULL UNIQUE,
                            password_hash VARCHAR(255) NOT NULL,
                            full_name VARCHAR(100) NOT NULL,
                            email VARCHAR(100) NOT NULL,
                            phone VARCHAR(20),
                            dob DATE,
                            gender ENUM('Male', 'Female', 'Other'),
                            address VARCHAR(255),
                            current_position VARCHAR(100),
                            skills TEXT,
                            years_experience INT,
                            highest_level VARCHAR(100),
                            cv_file_path VARCHAR(255),
                            status VARCHAR(50),
                            note TEXT,
                            self_registered BOOLEAN DEFAULT FALSE
);

-- ========================
-- Jobs
-- ========================
CREATE TABLE Jobs (
                      job_id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(100) NOT NULL,
                      skills TEXT,
                      start_date DATE,
                      end_date DATE,
                      salary_from INT,
                      salary_to INT,
                      address VARCHAR(255),
                      benefits TEXT,
                      levels VARCHAR(100),
                      description TEXT,
                      status ENUM('Draft', 'Open', 'Closed') DEFAULT 'Draft',
                      created_by INT,
                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                      FOREIGN KEY (created_by) REFERENCES Users(user_id)
);


-- ========================
-- JobApplications (candidate self-apply)
-- ========================
CREATE TABLE JobApplications (
                                 application_id INT AUTO_INCREMENT PRIMARY KEY,
                                 candidate_id INT NOT NULL,
                                 job_id INT NOT NULL,
                                 apply_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                                 status ENUM('Applied', 'Under Review', 'Rejected', 'Accepted') DEFAULT 'Applied',
                                 cv_path VARCHAR(255),
                                 note TEXT,
                                 FOREIGN KEY (candidate_id) REFERENCES Candidates(candidate_id),
                                 FOREIGN KEY (job_id) REFERENCES Jobs(job_id)
);

-- ========================
-- Interviews
-- ========================
CREATE TABLE Interviews (
                            interview_id INT AUTO_INCREMENT PRIMARY KEY,
                            candidate_id INT,
                            job_id INT,
                            schedule_time DATETIME,
                            end_time DATETIME,
                            status ENUM('Scheduled', 'Cancelled', 'Completed') DEFAULT 'Scheduled',
                            note TEXT,
                            FOREIGN KEY (candidate_id) REFERENCES Candidates(candidate_id),
                            FOREIGN KEY (job_id) REFERENCES Jobs(job_id)
);

-- ========================
-- InterviewResults
-- ========================
CREATE TABLE InterviewResults (
                                  result_id INT AUTO_INCREMENT PRIMARY KEY,
                                  interview_id INT,
                                  score INT CHECK (score BETWEEN 0 AND 100),
                                  feedback TEXT,
                                  result ENUM('Passed', 'Failed', 'N/A') DEFAULT 'N/A',
                                  FOREIGN KEY (interview_id) REFERENCES Interviews(interview_id)
);

-- ========================
-- Interviewers (multi-evaluator)
-- ========================
CREATE TABLE Interviewers (
                              interview_id INT NOT NULL,
                              user_id INT NOT NULL,
                              PRIMARY KEY (interview_id, user_id),
                              FOREIGN KEY (interview_id) REFERENCES Interviews(interview_id),
                              FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- ========================
-- Offers
-- ========================
CREATE TABLE Offers (
                        offer_id INT AUTO_INCREMENT PRIMARY KEY,
                        interview_id INT,
                        created_by INT,
                        approved_by INT,
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                        approved_at DATETIME NULL,
                        status ENUM(
        'Waiting for approval',
        'Approved',
        'Rejected',
        'Waiting for response',
        'Accepted',
        'Declined',
        'Cancelled'
    ) DEFAULT 'Waiting for approval',
                        response_date DATE,
                        note TEXT,
                        FOREIGN KEY (interview_id) REFERENCES Interviews(interview_id),
                        FOREIGN KEY (created_by) REFERENCES Users(user_id),
                        FOREIGN KEY (approved_by) REFERENCES Users(user_id)
);

-- ========================
-- Seed Initial Roles
-- ========================
INSERT INTO Roles (role_name)
VALUES ('Admin'), ('Recruiter'), ('Manager'), ('Interviewer'), ('Candidate');
