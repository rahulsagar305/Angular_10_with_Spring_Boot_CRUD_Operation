# Angular 10 with Spring Boot CRUD Operation Using MSSQL

# Database Details 
CREATE TABLE "employees" (
	"id" INT NOT NULL,
	"first_name" VARCHAR(50) NULL DEFAULT '''''' COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	"last_name" VARCHAR(50) NULL DEFAULT '''''' COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	"mobile_no" VARCHAR(50) NULL DEFAULT '''0''' COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	"email" VARCHAR(50) NULL DEFAULT '''0''' COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	"address" VARCHAR(50) NULL DEFAULT '''0''' COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	PRIMARY KEY ("id")
);

