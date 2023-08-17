drop table if exists account_transactions;
drop table if exists accounts;
drop table if exists authorities;
drop table if exists cards;
drop table if exists contact_messages;
drop table if exists customer;
drop table if exists hibernate_sequence;
drop table if exists loans;
drop table if exists notice_details;

create table account_transactions (
                                      transaction_id varchar(255) not null,
                                      account_number bigint,
                                      closing_balance integer,
                                      create_dt varchar(255),
                                      customer_id integer,
                                      transaction_amt integer,
                                      transaction_dt datetime(6),
                                      transaction_summary varchar(255),
                                      transaction_type varchar(255),
                                      primary key (transaction_id)
);
create table accounts (
                          account_number bigint not null,
                          account_type varchar(255),
                          branch_address varchar(255),
                          create_dt varchar(255),
                          customer_id integer,
                          primary key (account_number)
);


create table authorities (
                             id bigint not null,
                             name varchar(255),
                             customer_id integer,
                             primary key (id)
);


create table cards (
                       card_id integer not null,
                       amount_used integer,
                       available_amount integer,
                       card_number varchar(255),
                       card_type varchar(255),
                       create_dt datetime(6),
                       customer_id integer,
                       total_limit integer,
                       primary key (card_id)
);


create table contact_messages (
                                  contact_id varchar(255) not null,
                                  contact_email varchar(255),
                                  contact_name varchar(255),
                                  create_dt date,
                                  message varchar(255),
                                  subject varchar(255),
                                  primary key (contact_id)
);


create table customer (
                          customer_id integer not null,
                          create_dt varchar(255),
                          email varchar(255),
                          mobile_number varchar(255),
                          name varchar(255),
                          pwd varchar(255),
                          role varchar(255),
                          primary key (customer_id)
);


create table hibernate_sequence (
    next_val bigint
);


insert into hibernate_sequence values ( 1 );


create table loans (
                       loan_number integer not null,
                       amount_paid integer,
                       create_dt varchar(255),
                       customer_id integer,
                       loan_type varchar(255),
                       outstanding_amount integer,
                       start_dt date,
                       total_loan integer,
                       primary key (loan_number)
);


create table notice_details (
                                notice_id integer not null,
                                create_dt date,
                                notic_beg_dt date,
                                notic_end_dt date,
                                notice_details varchar(255),
                                notice_summary varchar(255),
                                update_dt date,
                                primary key (notice_id)
);


alter table authorities
    add constraint FKmxfrbnq69sqqdpiwlopu58f3u
        foreign key (customer_id)
            references customer (customer_id);


INSERT INTO `customer` (`customer_id`,`name`,`email`,`mobile_number`, `pwd`, `role`,`create_dt`)
VALUES (1,'Happy','happy@example.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',CURDATE());

INSERT INTO `authorities` (`id`, `name`, `customer_id`) VALUES (1, 'ROLE_USER', 1);
INSERT INTO `authorities` (`id`, `name`, `customer_id`) VALUES (2, 'ROLE_ADMIN', 1);

INSERT INTO `accounts` (`customer_id`, `account_number`, `account_type`, `branch_address`, `create_dt`)
VALUES (1, 186576453434, 'Savings', '123 Main Street, New York', CURDATE());

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                    `closing_balance`, `create_dt`)  VALUES (UUID(), 186576453434, 1, CURDATE()-7, 'Coffee Shop', 'Withdrawal', 30,34500,CURDATE()-7);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                    `closing_balance`, `create_dt`)  VALUES (UUID(), 186576453434, 1, CURDATE()-6, 'Uber', 'Withdrawal', 100,34400,CURDATE()-6);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                    `closing_balance`, `create_dt`)  VALUES (UUID(), 186576453434, 1, CURDATE()-5, 'Self Deposit', 'Deposit', 500,34900,CURDATE()-5);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                    `closing_balance`, `create_dt`)  VALUES (UUID(), 186576453434, 1, CURDATE()-4, 'Ebay', 'Withdrawal', 600,34300,CURDATE()-4);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                    `closing_balance`, `create_dt`)  VALUES (UUID(), 186576453434, 1, CURDATE()-2, 'OnlineTransfer', 'Deposit', 700,35000,CURDATE()-2);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                    `closing_balance`, `create_dt`)  VALUES (UUID(), 186576453434, 1, CURDATE()-1, 'Amazon.com', 'Withdrawal', 100,34900,CURDATE()-1);


INSERT INTO `loans` ( `loan_number`,`customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES ( 1,1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13');

INSERT INTO `loans` (`loan_number`, `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES ( 2,1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06');

INSERT INTO `loans` (`loan_number`, `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES ( 3,1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14');

INSERT INTO `loans` (`loan_number`, `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES (4, 1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');

INSERT INTO `cards` (`card_id`,`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `create_dt`)
VALUES (1,'4565XXXX4656', 1, 'Credit', 10000, 500, 9500, CURDATE());

INSERT INTO `cards` (`card_id`,`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `create_dt`)
VALUES (2,'3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURDATE());

INSERT INTO `cards` (`card_id`,`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `create_dt`)
VALUES (3,'2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURDATE());


INSERT INTO `notice_details` ( `notice_id`,`notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES (1,'Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` (`notice_id`, `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES (2,'Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` (`notice_id`, `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES (3,'Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` (`notice_id`, `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES (4,'E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` (`notice_id`, `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES (5,'Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` (`notice_id`, `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES (6,'COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);
