CREATE TABLE TUSER
(
    USER_SEQ      INT AUTO_INCREMENT,
    USER_ID       VARCHAR(30)                          NOT NULL      PRIMARY KEY,
    USER_PASSWORD VARCHAR(64)                          NOT NULL,
    USER_NAME     VARCHAR(30)                          NOT NULL,
    BIRTH         VARCHAR(8)                           NOT NULL,
    GENDER        VARCHAR(1)                           NOT NULL,
    USE_YN        VARCHAR(1) DEFAULT '1'               NOT NULL,
    INSERT_DATE   TIMESTAMP  DEFAULT CURRENT_TIMESTAMP NOT NULL,
    MODIFY_DATE   TIMESTAMP  DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT TUSER_USER_SEQ_UINDEX
        UNIQUE (USER_SEQ)
);

