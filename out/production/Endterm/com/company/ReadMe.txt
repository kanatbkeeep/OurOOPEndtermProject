Link:
https://github.com/kanatbkeeep/OurOOPEndtermProject
_________________________________________________________________________________________________________________________________
The project is connected to a supermarket, where we can manage products, employees, departments and positions.
Data: used to connect to DB;
Repositories: used to use methods;
Controllers: used to use repositories in MyApplication class;
MyApplication: used for show option and take input
Main: used for run application
_________________________________________________________________________________________________________________________________
Variable for entities classes:
Table position: position(Primary key) , salary;
Table department: department(Primary key), address, city, employee count;
Table employee: id(Primary key) serial, name, surname, date of hiring, position(Foreign key), department(Foreign key);
Table products: id(Primary key), product, price, delivery date, expiration date;
_________________________________________________________________________________________________________________________________
Postgre query to create tables:
CREATE TABLE position(
	position VARCHAR(50) PRIMARY KEY,
	salary INT
);

CREATE TABLE department(
	department VARCHAR(50) PRIMARY KEY,
	address VARCHAR(50),
	city VARCHAR(50),
	employee_quantity INT
);

CREATE TABLE employee(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	surname VARCHAR(50),
	date_of_hiring DATE,
	position VARCHAR(50),
	department VARCHAR(50),
	FOREIGN KEY(position) REFERENCES position(position),
	FOREIGN KEY(department) REFERENCES department(department)
);

CREATE TABLE products(
	id SERIAL PRIMARY KEY,
	product VARCHAR(50),
	price INT,
	delivery_date DATE,
	expiration_date DATE
);
