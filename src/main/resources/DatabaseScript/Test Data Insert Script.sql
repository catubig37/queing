--TEST DATA--
INSERT INTO rtp."Payment_Transaction" 
(
	transaction_number, 
	account_number, 
	amount, 
	payment_status,
	payment_date,
	payment_method, 
	payment_channel,
	payment_branch_channel,
	bc_presentment_date
)
VALUES (
	'TRP100204', '32132132', 201.37, 'SUCCESS',NOW(), 'CASH', '80001','PASIG', NOW()
	   ) returning id, transaction_number as transactionNumber,
	   account_number as accountNumber,
	   amount,
	   payment_channel as paymentChannel,
	   payment_branch_channel as paymentChannelBranch,
	   payment_date as paymentDate,
	   payment_method as paymentMethod,
	   bc_presentment_date as presentmentDate,
	   created_at as createdAt;