-- =====================================================================================
-- Data.sql: Seeding sample data for the Interview Management System
-- This script is re-runnable. It first clears all existing data
-- and then inserts a fresh set of sample records.
-- =====================================================================================

-- Select the database to use
USE ims_db;

-- Temporarily disable foreign key checks to allow truncation
SET FOREIGN_KEY_CHECKS = 0;

-- Truncate tables in reverse order of dependency to avoid foreign key errors
TRUNCATE TABLE offers;
TRUNCATE TABLE interviewers;
TRUNCATE TABLE interview_results;
TRUNCATE TABLE interviews;
TRUNCATE TABLE job_applications;
TRUNCATE TABLE jobs;
TRUNCATE TABLE candidates;
TRUNCATE TABLE users;
TRUNCATE TABLE roles;

-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;


-- ========================
-- Seed Roles
-- ========================
INSERT INTO Roles (role_id, role_name) VALUES
(1, 'Admin'),
(2, 'Recruiter'),
(3, 'Manager'),
(4, 'Interviewer');


-- ========================
-- Seed Users
-- ========================
INSERT INTO Users (user_id, username, password_hash, full_name, email, phone, department, role_id, status) VALUES
(1, 'admin_user', 'pass_admin', 'Alice Admin', 'alice.admin@example.com', '111222333', 'Management', 1, TRUE),
(2, 'recruiter_user', 'pass_recruiter', 'Bob Recruiter', 'bob.recruiter@example.com', '222333444', 'HR', 2, TRUE),
(3, 'manager_user', 'pass_manager', 'Charlie Manager', 'charlie.manager@example.com', '333444555', 'IT', 3, TRUE),
(4, 'interviewer_one', 'pass_interviewer1', 'Diana Interviewer', 'diana.interviewer@example.com', '444555666', 'IT', 4, TRUE),
(5, 'interviewer_two', 'pass_interviewer2', 'Evan Interviewer', 'evan.interviewer@example.com', '555666777', 'Marketing', 4, TRUE);


-- ========================
-- Seed Candidates
-- ========================
INSERT INTO Candidates (candidate_id, username, password_hash, full_name, email, phone, dob, gender, address, current_position, skills, years_experience, highest_level, cv_file_path, status, note, self_registered) VALUES
(1, 'john_doe', 'pass_candidate1', 'John Doe', 'john.doe@example.com', '987654321', '1995-08-15', 'Male', '123 Tech Lane, Silicon Valley', 'Senior Java Developer', 'Java, Spring Boot, Microservices, SQL', 5, 'B.Sc. Computer Science', '/cv/john_doe.pdf', 'Active', 'Looking for new opportunities.', TRUE),
(2, 'jane_smith', 'pass_candidate2', 'Jane Smith', 'jane.smith@example.com', '987654322', '1998-02-20', 'Female', '456 Code Avenue, New York', 'Frontend Developer', 'React, TypeScript, Redux, HTML, CSS', 3, 'In-Process', 'Actively interviewing.', TRUE),
(3, 'sam_brown', 'pass_candidate3', 'Sam Brown', 'sam.brown@example.com', '987654323', '2000-11-30', 'Other', '789 Design Drive, Austin', 'UX/UI Designer', 'Figma, Sketch, User Research', 2, 'B.A. Graphic Design', '/cv/sam_brown.pdf', 'New', 'Open to freelance and full-time.', FALSE);


-- ========================
-- Seed Jobs
-- ========================
INSERT INTO Jobs (job_id, title, skills, start_date, end_date, salary_from, salary_to, address, benefits, levels, description, status, created_by, created_at) VALUES
(1, 'Senior Backend Engineer (Java)', 'Java, Spring Boot, AWS, Kubernetes', '2024-08-01', '2024-09-30', 80000, 120000, 'Remote or San Francisco Office', 'Health Insurance, 401k, Unlimited PTO', 'Senior', 'We are looking for an experienced backend engineer to join our core services team.', 'Open', 2, NOW()),
(2, 'Frontend Engineer (React)', 'React, TypeScript, Next.js, GraphQL', '2024-08-01', NULL, 70000, 100000, 'New York Office', 'Health Insurance, Gym Membership, Free Lunch', 'Mid-level', 'Join our web platform team to build beautiful and performant user interfaces.', 'Open', 2, NOW()),
(3, 'UX/UI Product Designer', 'Figma, Prototyping, User Testing', '2024-07-20', '2024-09-15', 65000, 95000, 'Austin Office (Hybrid)', 'Health Insurance, Stock Options', 'Mid-level', 'Design the future of our product suite, from concept to launch.', 'Draft', 2, NOW());


-- ========================
-- Seed JobApplications
-- ========================
INSERT INTO JobApplications (application_id, candidate_id, job_id, apply_date, status, cv_path, note) VALUES
(1, 1, 1, NOW(), 'Under Review', '/cv/john_doe.pdf', 'Strong candidate, background matches perfectly.'),
(2, 2, 2, NOW(), 'Applied', '/cv/jane_smith.pdf', 'Submitted application via company website.'),
(3, 3, 3, NOW(), 'Applied', '/cv/sam_brown.pdf', 'Referred by an internal employee.'),
(4, 2, 1, NOW(), 'Rejected', '/cv/jane_smith.pdf', 'Candidate is more focused on frontend roles.');


-- ========================
-- Seed Interviews
-- ========================
INSERT INTO Interviews (interview_id, candidate_id, job_id, schedule_time, end_time, status, note) VALUES
(1, 1, 1, '2024-08-10 10:00:00', '2024-08-10 11:00:00', 'Scheduled', 'First round: Technical screen with a team member.'),
(2, 2, 2, '2024-08-12 14:00:00', '2024-08-12 15:00:00', 'Scheduled', 'First round: Portfolio review with the hiring manager.'),
(3, 1, 1, '2024-07-30 09:00:00', '2024-07-30 10:30:00', 'Completed', 'Previous final round interview for a similar role. Re-engaging candidate.');


-- ========================
-- Seed Interviewers (The join table for multi-evaluator)
-- ========================
INSERT INTO Interviewers (interview_id, user_id) VALUES
(1, 4), -- Diana (Interviewer) for John's technical screen
(2, 5), -- Evan (Interviewer) for Jane's portfolio review
(3, 3), -- Charlie (Manager) for John's previous final round
(3, 4); -- Diana (Interviewer) also on John's previous final round


-- ========================
-- Seed InterviewResults
-- ========================
INSERT INTO InterviewResults (result_id, interview_id, score, feedback, result) VALUES
(1, 3, 92, 'Excellent technical skills, great problem-solving approach. Strong hire recommendation.', 'Passed');


-- ========================
-- Seed Offers
-- ========================
INSERT INTO Offers (offer_id, interview_id, created_by, approved_by, created_at, approved_at, status, response_date, note) VALUES
(1, 3, 2, 3, '2024-07-31 10:00:00', '2024-07-31 14:00:00', 'Waiting for response', NULL, 'Offer sent to John Doe after successful final round.'); 