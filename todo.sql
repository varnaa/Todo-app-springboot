create schema todo;

create table task(id int primary key auto_increment,
					name varchar(255) ,
                    description varchar(500),
                    created_date datetime,
                    completed varchar(6));
                    
                    
insert into tasks values(1,'learn css', 'complete forms and inputs',  20/02/2020, 'no');
                    
                    
                    