SELECT p.NOME , c.* FROM PESSOA p RIGHT OUTER JOIN CONTATO c on p.ID_PESSOA  = c.ID_PESSOA;

SELECT * FROM PESSOA_X_PESSOA_ENDERECO a RIGHT OUTER JOIN ENDERECO b on a.ID_ENDERECO  = b.ID_ENDERECO RIGHT OUTER join PESSOA  c on a.ID_PESSOA  = c.ID_PESSOA;

SELECT * FROM PESSOA_X_PESSOA_ENDERECO a RIGHT OUTER JOIN ENDERECO b ON a.ID_ENDERECO = b.ID_ENDERECO RIGHT OUTER JOIN PESSOA c ON a.ID_PESSOA = c.ID_PESSOA RIGHT OUTER JOIN ENDERECO_PESSOA d ON b.ID_ENDERECO = d.ID_ENDERECO;


SELECT p.NOME , c.* FROM PESSOA p FULL OUTER JOIN CONTATO c on p.ID_PESSOA  = c.ID_PESSOA;

SELECT * FROM PESSOA_X_PESSOA_ENDERECO a FULL OUTER JOIN ENDERECO b on a.ID_ENDERECO  = b.ID_ENDERECO FULL OUTER join PESSOA  c on a.ID_PESSOA  = c.ID_PESSOA;

SELECT * FROM PESSOA_X_PESSOA_ENDERECO a FULL OUTER JOIN ENDERECO b ON a.ID_ENDERECO = b.ID_ENDERECO FULL OUTER JOIN PESSOA c ON a.ID_PESSOA = c.ID_PESSOA FULL OUTER JOIN ENDERECO_PESSOA d ON b.ID_ENDERECO = d.ID_ENDERECO;

SELECT p.NOME FROM PESSOA p WHERE EXISTS (SELECT * FROM ENDERECO e WHERE e.ID_ENDERECO = p.ID_PESSOA);

--SELECT c.ID_PESSOA, c.NOME, b.ID_ENDERECO, b.LOGRADOURO FROM PESSOA_X_PESSOA_ENDERECO a INNER JOIN ENDERECO_PESSOA b on a.ID_ENDERECO  = b.ID_ENDERECO INNER join PESSOA  c ON a.ID_PESSOA  = c.ID_PESSOA;

SELECT * FROM ENDERECO_PESSOA ep, PESSOA p WHERE EXISTS (SELECT * FROM PESSOA_X_PESSOA_ENDERECO pxpe WHERE p.ID_PESSOA = pxpe.ID_PESSOA AND ep.ID_ENDERECO = pxpe.ID_ENDERECO);