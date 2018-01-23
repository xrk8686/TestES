select * from sys.dm_tran_current_transaction

select dbo.fGetCurrentTxnId()
select current_transaction_id()

CREATE FUNCTION fGetCurrentTxnId ()
  RETURNS VARCHAR(100)
  AS
BEGIN
  DECLARE @txtId VARCHAR(100)
  SELECT @txtId=convert(VARCHAR(100),current_transaction_id())

  RETURN @txtId
END
GO

DROP TABLE AuditAction
GO

CREATE TABLE AuditAction
(
  id   BIGINT IDENTITY
CONSTRAINT PK_AuditAction_ID PRIMARY KEY,
  actionId NVARCHAR(100) NOT NULL,
  transactionId    INT  DEFAULT current_transaction_id() NOT NULL,
  modDate DATETIME not null
)
GO

SELECT *
FROM sys.sql_modules AS m
  JOIN sys.objects AS o ON m.object_id = o.object_id
                           AND type IN ('FN', 'IF', 'TF');

insert into AuditAction(actionId, modDate)
VALUES ('testaaaa',current_timestamp)