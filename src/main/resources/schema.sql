CREATE TABLE task (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description VARCHAR(255),
                      status VARCHAR(20),
                      priority VARCHAR(20),
                      created_at DATE NOT NULL,
                      due_date DATE
);
