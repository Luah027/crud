-- Criar a tabela de Hóspedes
CREATE TABLE Hospedes (
    hospede_id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(50),
    telefone VARCHAR(15),
    data_nascimento DATE
);

-- Criar a tabela de Reservas
CREATE TABLE Reservas (
    reserva_id INT PRIMARY KEY,
    hospede_id INT,
    data_checkin DATE NOT NULL,
    data_checkout DATE NOT NULL,
    status VARCHAR(20) NOT NULL, -- Ex.: "Reservado", "Check-in", "Check-out"
    FOREIGN KEY (hospede_id) REFERENCES Hospedes(hospede_id),
    FOREIGN KEY (quarto_id) REFERENCES Quartos(quarto_id)
);

-- Inserir dados na tabela de Hóspedes
INSERT INTO Hospedes (hospede_id, nome, cpf, email, telefone, data_nascimento) VALUES
(1, 'Ana Costa', '12345678901', 'ana@gmail.com', '11987654321', '1990-05-15'),
(2, 'Pedro Silva', '98765432109', 'pedro@gmail.com', '11976543210', '1985-11-23');