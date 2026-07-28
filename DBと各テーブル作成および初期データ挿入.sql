CREATE DATABASE taskdb; 

USE taskdb; 

CREATE TABLE m_user( 
    user_id VARCHAR (24) PRIMARY KEY NOT NULL
    , password VARCHAR (32) NOT NULL
    , user_name VARCHAR (20) UNIQUE NOT NULL
    , update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
); 

CREATE TABLE m_category( 
    category_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT
    , category_name VARCHAR (20) UNIQUE NOT NULL
    , update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE m_status(
    status_code CHAR(2) PRIMARY KEY NOT NULL
    , status_name VARCHAR(20) UNIQUE NOT NULL
    , update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE t_task(
    task_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT
    , task_name VARCHAR(50) NOT NULL
    , category_id INT NOT NULL
    , limit_date DATE
    , user_id VARCHAR(24) NOT NULL
    , status_code CHAR(2) NOT NULL
    , memo VARCHAR(100)
    , create_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    , update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
    , FOREIGN KEY (category_id) REFERENCES m_category(category_id)
    , FOREIGN KEY (user_id) REFERENCES m_user(user_id)
    , FOREIGN KEY (status_code) REFERENCES m_status(status_code)
);

INSERT INTO m_user (user_id, password, user_name) VALUES ('yamada', 'taro', '山田');
INSERT INTO m_user (user_id, password, user_name) VALUES ('tanaka', 'hanako', '田中');

INSERT INTO m_category (category_name) VALUES ('新商品A：開発プロジェクト');
INSERT INTO m_category (category_name) VALUES ('既存商品B：改良プロジェクト');

INSERT INTO m_status (status_code, status_name) VALUES ('00', '未着手');
INSERT INTO m_status (status_code, status_name) VALUES ('50', '着手');
INSERT INTO m_status (status_code, status_name) VALUES ('99', '完了');

INSERT INTO t_task (task_name, category_id, limit_date, user_id, status_code, memo) 
    VALUES ('画面改良', 2, '2026-07-31', 'yamada', 50, 'ヘッダーは改良済み');
