## Motivation 💭
A economia da minha cidade se baseia em empresas de transporte, com muitas delas de pequeno porte. Já tive experiencia de trabalhar em uma dessas empresas e os documentos de cargas, motoristas e veiculos eram organizados em papel. Esse sistema propoe uma solucao fácil de usar, extensivel e de baixo custo para auxiliar esses empreendedores.

## Transport System 🚛
Breve descricao do sistema com seu diagrama de classes aparente, quais sao seus objetivos e tecnologias utilizadas.

## License
Feel free to use or modify the system as you wish!!!

## **Engenharia de Requisitos 📝**

• ***Requisitos Nao Funcionais***:

→ Sistema Java baseado em terminal;

→ Persistencia de dados com JDBC;

→ Ferramenta de build com Maven;

→ Padroes de projeto Factory e DAO.

• ***Requisitos Funcionais***: 

![image.png](attachment:e81bc2bb-456f-48be-a408-b5b840520065:image.png)

1) Carga: - valor (double), + localOrigem (String), + localDestino(String), - Pagamento(boolean), + Pesokg(double), + TipoCarga(String)

Operacoes: mudar o status de pagamento da carga, acessar as cargas pendentes (ordem temporal), acessar as cargas pagas (ordem temporal), adicionar uma nova carga, excluir uma carga existente, alterar algum atributo de uma carga, listar todas as cargas.

2) Motorista: - cpf(String), + nome(String), + dataNascimento (Date), + categoriaHabilitacao (String), + telefone (String)

Operacoes: listar todos os funcionarios, alterar o atributo de um funcionario, adicionar um funcionario e excluir um funcionario.

3) Veiculo: + pesoMax(double), +numeroEixos (int), + placa (String), + numeroRegistro (int).

Operacoes: adicionar um veiculo, alterar um veiculo, excluir um veiculo, listar todos os veiculos.