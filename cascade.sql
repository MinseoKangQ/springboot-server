// quiz 테이블 FK 설정
ALTER TABLE quiz DROP FOREIGN KEY FK1tofsm1qynhakggx7ttqh8ihu;
ALTER TABLE quiz
    ADD FOREIGN KEY (user_id)
        REFERENCES user (email)
        ON DELETE CASCADE;

ALTER TABLE quiz DROP FOREIGN KEY FK7vx1486i0wfvwydjen3untoy6;
ALTER TABLE quiz
    ADD FOREIGN KEY (sum_id)
        REFERENCES summary (sum_id)
        ON DELETE CASCADE;

// summary 테이블 FK 설정
ALTER TABLE summary DROP FOREIGN KEY FK4aq2hcb2llq9e2adpump1e6gy;
ALTER TABLE summary
    ADD FOREIGN KEY (user_id)
        REFERENCES user (email)
        ON DELETE CASCADE;