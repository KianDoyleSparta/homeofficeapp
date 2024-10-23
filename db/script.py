from sqlalchemy import create_engine, text
from sqlalchemy.exc import SQLAlchemyError

# Database configuration
DB_USER = 'user'
DB_PASSWORD = 'password'
DB_HOST = 'localhost'  
DB_PORT = '3306'       
DB_NAME = 'home_office_db'

# Create the database engine
engine = create_engine(f'mysql+pymysql://{DB_USER}:{DB_PASSWORD}@{DB_HOST}:{DB_PORT}/mysql')

# SQL commands to execute
sql_commands = """
-- Drop the schema if it already exists  
DROP DATABASE IF EXISTS home_office_db;

-- Create the database schema  
CREATE DATABASE home_office_db;

-- Use the newly created schema  
USE home_office_db;

-- Create the 'tickets' table  
CREATE TABLE IF NOT EXISTS tickets (  
    id INT AUTO_INCREMENT PRIMARY KEY,  
    category VARCHAR(50),  
    priority ENUM('Low', 'Medium', 'High', 'Critical') NOT NULL,  
    state ENUM('Open', 'In Progress', 'Resolved', 'Closed') NOT NULL,  
    assigned VARCHAR(50),  
    short_desc VARCHAR(100) NOT NULL,  
    `desc` TEXT,  
    type ENUM('Bug', 'Feature', 'Task', 'Incident') NOT NULL  
);
"""

# Execute the SQL commands
try:
    with engine.connect() as connection:
        # Execute each command individually
        for command in sql_commands.split(';'):
            if command.strip():  # Skip empty commands
                connection.execute(text(command))
    print("Database and table created successfully.")

except SQLAlchemyError as e:

    print(f"An error occurred: {e}")

finally:
    engine.dispose() 