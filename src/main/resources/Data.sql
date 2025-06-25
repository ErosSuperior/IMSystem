-- =====================================================================================
-- Data.sql: Seeding sample data for the Interview Management System (MySQL, snake_case)
-- This script is re-runnable. It first clears all existing data
-- and then inserts a fresh set of sample records.
-- =====================================================================================

USE ims_db;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE offers;
TRUNCATE TABLE interviewers;
TRUNCATE TABLE interview_results;
TRUNCATE TABLE interviews;
TRUNCATE TABLE job_applications;
TRUNCATE TABLE jobs;
TRUNCATE TABLE candidates;
TRUNCATE TABLE users;
TRUNCATE TABLE roles;
SET FOREIGN_KEY_CHECKS = 1;

-- ========================
-- Seed Roles
-- ========================
INSERT INTO roles (role_id, role_name) VALUES
(1, 'Admin'),
(2, 'Recruiter'),
(3, 'Manager'),
(4, 'Interviewer');

-- ========================
-- Seed Users
-- ========================
INSERT INTO users (user_id, username, password_hash, full_name, email, phone, department, role_id, status) VALUES
(1, 'admin_user', 'pass_admin', 'Alice Admin', 'alice.admin@example.com', '111222333', 'Management', 1, TRUE),
(2, 'recruiter_user', 'pass_recruiter', 'Bob Recruiter', 'bob.recruiter@example.com', '222333444', 'HR', 2, TRUE),
(3, 'manager_user', 'pass_manager', 'Charlie Manager', 'charlie.manager@example.com', '333444555', 'IT', 3, TRUE),
(4, 'interviewer_one', 'pass_interviewer1', 'Diana Interviewer', 'diana.interviewer@example.com', '444555666', 'IT', 4, TRUE),
(5, 'interviewer_two', 'pass_interviewer2', 'Evan Interviewer', 'evan.interviewer@example.com', '555666777', 'Marketing', 4, TRUE);

-- ========================
-- Seed Candidates
-- ========================
INSERT INTO candidates (
    candidate_id, self_registered, years_experience, dob, phone, status, username, current_position, email, full_name, highest_level, address, cv_file_path, note, password_hash, skills, gender
) VALUES
(1, TRUE, 5, '1995-08-15', '987654321', 'Active', 'john_doe', 'Senior Java Developer', 'john.doe@example.com', 'John Doe', 'B.Sc. Computer Science', '123 Tech Lane, Silicon Valley', '/cv/john_doe.pdf', 'Looking for new opportunities.', 'pass_candidate1', 'Java, Spring Boot, Microservices, SQL', 'Male'),
(2, TRUE, 3, '1998-02-20', '987654322', 'In-Process', 'jane_smith', 'Frontend Developer', 'jane.smith@example.com', 'Jane Smith', 'In-Process', '456 Code Avenue, New York', NULL, 'Actively interviewing.', 'pass_candidate2', 'React, TypeScript, Redux, HTML, CSS', 'Female'),
(3, FALSE, 2, '2000-11-30', '987654323', 'New', 'sam_brown', 'UX/UI Designer', 'sam.brown@example.com', 'Sam Brown', 'B.A. Graphic Design', '789 Design Drive, Austin', '/cv/sam_brown.pdf', 'Open to freelance and full-time.', 'pass_candidate3', 'Figma, Sketch, User Research', 'Other');

-- ========================
-- Seed Jobs
-- ========================
INSERT INTO jobs (job_id, title, skills, start_date, end_date, salary_from, salary_to, address, benefits, levels, description, status, created_by, created_at) VALUES
(1, 'Senior Backend Engineer (Java)', 'Java, Spring Boot, AWS, Kubernetes', '2024-08-01', '2024-09-30', 80000, 120000, 'Remote or San Francisco Office', 'Health Insurance, 401k, Unlimited PTO', 'Senior', 'We are looking for an experienced backend engineer to join our core services team.', 'Open', 2, NOW()),
(2, 'Frontend Engineer (React)', 'React, TypeScript, Next.js, GraphQL', '2024-08-01', NULL, 70000, 100000, 'New York Office', 'Health Insurance, Gym Membership, Free Lunch', 'Mid-level', 'Join our web platform team to build beautiful and performant user interfaces.', 'Open', 2, NOW()),
(3, 'UX/UI Product Designer', 'Figma, Prototyping, User Testing', '2024-07-20', '2024-09-15', 65000, 95000, 'Austin Office (Hybrid)', 'Health Insurance, Stock Options', 'Mid-level', 'Design the future of our product suite, from concept to launch.', 'Draft', 2, NOW());

-- ========================
-- Seed JobApplications
-- ========================
INSERT INTO job_applications (application_id, candidate_id, job_id, apply_date, status, cv_path, note) VALUES
(1, 1, 1, NOW(), 'Under Review', '/cv/john_doe.pdf', 'Strong candidate, background matches perfectly.'),
(2, 2, 2, NOW(), 'Applied', '/cv/jane_smith.pdf', 'Submitted application via company website.'),
(3, 3, 3, NOW(), 'Applied', '/cv/sam_brown.pdf', 'Referred by an internal employee.'),
(4, 2, 1, NOW(), 'Rejected', '/cv/jane_smith.pdf', 'Candidate is more focused on frontend roles.');

-- ========================
-- Seed Interviews
-- ========================
INSERT INTO interviews (interview_id, candidate_id, job_id, schedule_time, end_time, status, note) VALUES
(1, 1, 1, '2024-08-10 10:00:00', '2024-08-10 11:00:00', 'Scheduled', 'First round: Technical screen with a team member.'),
(2, 2, 2, '2024-08-12 14:00:00', '2024-08-12 15:00:00', 'Scheduled', 'First round: Portfolio review with the hiring manager.'),
(3, 1, 1, '2024-07-30 09:00:00', '2024-07-30 10:30:00', 'Completed', 'Previous final round interview for a similar role. Re-engaging candidate.');

-- ========================
-- Seed Interviewers
-- ========================
INSERT INTO interviewers (interview_id, user_id) VALUES
(1, 4),
(2, 5),
(3, 3),
(3, 4);

-- ========================
-- Seed InterviewResults
-- ========================
INSERT INTO interview_results (result_id, interview_id, score, feedback, result) VALUES
(1, 3, 92, 'Excellent technical skills, great problem-solving approach. Strong hire recommendation.', 'Passed');

-- ========================

-- Seed Offers
-- ========================
INSERT INTO offers (offer_id, interview_id, created_by, approved_by, created_at, approved_at, status, response_date, note) VALUES
(1, 3, 2, 3, '2024-07-31 10:00:00', '2024-07-31 14:00:00', 'Waiting for response', NULL, 'Offer sent to John Doe after successful final round.'); 

DESC candidates; 