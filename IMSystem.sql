use ims_db;
-- ========================
-- Xóa dữ liệu cũ trước khi insert
-- ========================
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE ims_db.interviewers;
TRUNCATE TABLE ims_db.interview_results;
TRUNCATE TABLE ims_db.offers;
TRUNCATE TABLE ims_db.interviews;
TRUNCATE TABLE ims_db.job_applications;
TRUNCATE TABLE ims_db.jobs;
TRUNCATE TABLE ims_db.candidates;
TRUNCATE TABLE ims_db.users;
TRUNCATE TABLE ims_db.roles;
SET FOREIGN_KEY_CHECKS = 1;

-- ========================
-- Seed Initial Roles
-- ========================
INSERT INTO ims_db.roles (role_name)
VALUES ('Admin'),
       ('Recruiter'),
       ('Manager'),
       ('Interviewer');

-- ========================
-- Seed Users
-- ========================
INSERT INTO ims_db.users (username, password_hash, full_name, email, phone, department, role_id)
VALUES ('user0', 'password0', 'Kimberly Malone', 'user0@example.com', '0901000000', 'HR', 1),
       ('user1', 'password1', 'Jonathan Kennedy', 'user1@example.com', '0901000001', 'IT', 2),
       ('user2', 'password2', 'Max Wright', 'user2@example.com', '0901000002', 'IT', 3),
       ('user3', 'password3', 'Megan Stone', 'user3@example.com', '0901000003', 'Marketing', 4),
       ('user4', 'password4', 'Edward Carter', 'user4@example.com', '0901000004', 'HR', 2),
       ('user5', 'password5', 'Susan Nguyen', 'user5@example.com', '0901000005', 'Finance', 3),
       ('user6', 'password6', 'Brandon Murphy', 'user6@example.com', '0901000006', 'Finance', 4),
       ('user7', 'password7', 'Laura Price', 'user7@example.com', '0901000007', 'Admin', 1),
       ('user8', 'password8', 'Nicholas James', 'user8@example.com', '0901000008', 'HR', 2),
       ('user9', 'password9', 'Michelle Lee', 'user9@example.com', '0901000009', 'IT', 3);

-- ========================
-- Seed Candidates
-- ========================
INSERT INTO ims_db.candidates (username, password_hash, full_name, email, phone, dob, gender, address, current_position,
                               skills, years_experience, highest_level, cv_file_path, status, note)
VALUES ('candidate0', 'pass0', 'Amanda Fisher', 'cand0@example.com', '0902000000', '1990-01-01', 'Female', 'Address 0',
        'Developer', 'Java, SQL', 3, 'Bachelor', '/cvs/candidate0.pdf', 'Pending', 'Ready to interview'),
       ('candidate1', 'pass1', 'Brian Jackson', 'cand1@example.com', '0902000001', '1991-02-02', 'Male', 'Address 1',
        'Tester', 'Manual, Automation', 2, 'Bachelor', '/cvs/candidate1.pdf', 'Pending', 'Looking for QA role'),
       ('candidate2', 'pass2', 'Steven Duncan', 'cand2@example.com', '0902000002', '1992-03-03', 'Other', 'Address 2',
        'BA', 'Analysis, Documenting', 4, 'Master', '/cvs/candidate2.pdf', 'Active', 'Interested in BA roles'),
       ('candidate3', 'pass3', 'Emily Howard', 'cand3@example.com', '0902000003', '1993-04-04', 'Female', 'Address 3',
        'Intern', 'HTML, CSS', 1, 'College', '/cvs/candidate3.pdf', 'Pending', 'Fresher web dev'),
       ('candidate4', 'pass4', 'George Martin', 'cand4@example.com', '0902000004', '1994-05-05', 'Male', 'Address 4',
        'Support', 'Helpdesk, ITIL', 5, 'Bachelor', '/cvs/candidate4.pdf', 'Active', 'Support specialist'),
       ('candidate5', 'pass5', 'Jessica Adams', 'cand5@example.com', '0902000005', '1995-06-06', 'Female', 'Address 5',
        'PM', 'Scrum, Agile', 6, 'Master', '/cvs/candidate5.pdf', 'Pending', 'Agile Project Manager'),
       ('candidate6', 'pass6', 'Chris Walker', 'cand6@example.com', '0902000006', '1996-07-07', 'Male', 'Address 6',
        'UX Designer', 'Figma, Research', 3, 'Bachelor', '/cvs/candidate6.pdf', 'Active', 'UX focus'),
       ('candidate7', 'pass7', 'Amy Stone', 'cand7@example.com', '0902000007', '1997-08-08', 'Female', 'Address 7',
        'Data Analyst', 'SQL, Python', 4, 'Master', '/cvs/candidate7.pdf', 'Pending', 'Data enthusiast'),
       ('candidate8', 'pass8', 'Michael Brown', 'cand8@example.com', '0902000008', '1998-09-09', 'Male', 'Address 8',
        'DevOps', 'AWS, CI/CD', 5, 'Bachelor', '/cvs/candidate8.pdf', 'Pending', 'Cloud focused'),
       ('candidate9', 'pass9', 'Nancy Green', 'cand9@example.com', '0902000009', '1999-10-10', 'Female', 'Address 9',
        'Tester', 'Selenium, JMeter', 2, 'Bachelor', '/cvs/candidate9.pdf', 'Pending', 'QA Automation');

-- ========================
-- Seed Jobs
-- ========================
INSERT INTO ims_db.jobs (title, skills, start_date, end_date, salary_from, salary_to, address, benefits, levels,
                         description, status, created_by)
VALUES ('Java Developer', 'Java, Spring Boot', '2025-06-01', '2025-08-01', 1000, 2000, '123 Main St', 'Bonus, OT',
        'Junior', 'Develop backend using Spring Boot', 'Open', 1),
       ('QA Engineer', 'Selenium, Manual Testing', '2025-06-01', '2025-09-01', 800, 1500, '456 QA St',
        'Health insurance', 'Fresher', 'Test web and mobile apps', 'Open', 2),
       ('Project Manager', 'Agile, Scrum', '2025-05-15', '2025-07-30', 2000, 3000, '789 Manager St', 'Car, Lunch',
        'Senior', 'Manage team and delivery', 'Draft', 3),
       ('UX Designer', 'Figma, UI/UX', '2025-07-01', '2025-10-01', 900, 1600, '321 Design Blvd', 'Remote OK',
        'Mid-level', 'Design user interfaces', 'Open', 4),
       ('DevOps Engineer', 'AWS, Docker, CI/CD', '2025-06-15', '2025-08-15', 1200, 2500, '654 Infra Lane',
        'Training, Laptop', 'Mid-level', 'Manage deployment pipeline', 'Open', 5);

-- ========================
-- Seed JobApplications
-- ========================
INSERT INTO ims_db.job_applications (candidate_id, job_id, apply_date, status, cv_path, note)
VALUES (1, 1, NOW(), 'Applied', '/cvs/candidate1.pdf', 'Interested in Java role'),
       (2, 2, NOW(), 'Applied', '/cvs/candidate2.pdf', 'QA background'),
       (3, 3, NOW(), 'UnderReview', '/cvs/candidate3.pdf', 'Has PM experience'),
       (4, 1, NOW(), 'Rejected', '/cvs/candidate4.pdf', 'Not suitable'),
       (5, 4, NOW(), 'Accepted', '/cvs/candidate5.pdf', 'Great portfolio');

-- ========================
-- Seed Interviews
-- ========================
INSERT INTO ims_db.interviews (candidate_id, job_id, schedule_time, end_time, status, note)
VALUES (1, 1, '2025-06-20 09:00:00', '2025-06-20 10:00:00', 'Scheduled', 'Initial tech round'),
       (2, 2, '2025-06-21 14:00:00', '2025-06-21 15:00:00', 'Scheduled', 'QA round'),
       (3, 3, '2025-06-22 10:00:00', '2025-06-22 11:30:00', 'Completed', 'PM discussion'),
       (4, 4, '2025-06-23 13:00:00', '2025-06-23 14:00:00', 'Cancelled', 'Reschedule needed'),
       (5, 5, '2025-06-24 15:00:00', '2025-06-24 16:00:00', 'Scheduled', 'DevOps round');

-- ========================
-- Seed InterviewResults
-- ========================
INSERT INTO ims_db.interview_results (interview_id, score, feedback, result)
VALUES (1, 85, 'Strong in Java, needs DB work', 'Passed'),
       (2, 78, 'Good testing skills', 'Passed'),
       (3, 65, 'Average communication', 'Failed'),
       (4, 0, 'Interview cancelled', 'NA'),
       (5, 90, 'Excellent DevOps understanding', 'Passed');

-- ========================
-- Seed Interviewers
-- ========================
INSERT INTO ims_db.interviewers (interview_id, user_id)
VALUES (1, 4),
       (1, 5),
       (2, 6),
       (3, 7),
       (5, 8);

-- ========================
-- Seed Offers
-- ========================
INSERT INTO ims_db.offers (interview_id, created_by, approved_by, status, response_date, note)
VALUES (1, 1, 3, 'Approved', '2025-06-25', 'Offer approved and sent'),
       (2, 2, 4, 'Rejected', NULL, 'Candidate not selected'),
       (3, 3, 1, 'Waiting_for_response', NULL, 'Awaiting response'),
       (5, 5, 2, 'Accepted', '2025-06-26', 'Candidate accepted offer'),
       (4, 4, 2, 'Cancelled', NULL, 'Interview cancelled, no offer');
