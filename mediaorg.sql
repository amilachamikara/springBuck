CREATE TABLE users(
    user_id INTEGER PRIMARY KEY,
    username VARCHAR(500),
    password VARCHAR(500),
    image_url VARCHAR(1000)
);

CREATE TABLE media_library(
    user_id INTEGER,
    library_id INTEGER PRIMARY KEY,
    name VARCHAR(500),
    FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE      
);

CREATE TABLE folder(
    folder_id INTEGER PRIMARY KEY,
    folder_path VARCHAR(1000)
);

CREATE TABLE library_folder(
    library_id INTEGER,
    folder_id INTEGER,
    FOREIGN KEY(library_id) REFERENCES media_library(library_id) ON DELETE CASCADE,
    FOREIGN KEY(folder_id) REFERENCES folder(folder_id) ON DELETE CASCADE,
    PRIMARY KEY(library_id, folder_id)
);

CREATE TABLE media_file(
    folder_id INTEGER,
    file_id INTEGER PRIMARY KEY,
    file_path VARCHAR(1000),

    title VARCHAR(1000),
    artist VARCHAR(1000),
    album VARCHAR(1000),
    genre VARCHAR(1000),
    composer VARCHAR(1000),
    mf_year VARCHAR(1000),
    ratings INTEGER,

    FOREIGN KEY(folder_id) REFERENCES folder(folder_id) ON DELETE CASCADE
);

CREATE TABLE time_slot(
    user_id INTEGER,
    timeslot_id INTEGER PRIMARY KEY,
    title VARCHAR(500),
    start_time DOUBLE,
    end_time DOUBLE,
    isWeekend BOOLEAN,
    FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE application(
    application_id INTEGER PRIMARY KEY,
    file_path VARCHAR(1000)
);

CREATE TABLE user_application(
    user_id INTEGER,
    application_id INTEGER,
    priority INTEGER,
    FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY(application_id) REFERENCES application(application_id) ON DELETE CASCADE,
    PRIMARY KEY(user_id, application_id)
);


CREATE TABLE event_log(
    event_id INTEGER PRIMARY KEY,
    timeslot_id INTEGER,
    application_id INTEGER,
    media_id INTEGER,
    frequency INTEGER,
    FOREIGN KEY(timeslot_id) REFERENCES time_slot(timeslot_id) ON DELETE CASCADE,
    FOREIGN KEY(application_id) REFERENCES application(application_id) ON DELETE CASCADE,
    FOREIGN KEY(media_id) REFERENCES media_file(file_id) ON DELETE CASCADE    
);