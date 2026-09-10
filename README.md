# Sistema de Gestão de Entregas e Frota - Rota Certa Logística

DOCUMENTAÇÃO DO SISTEMA

Regras de cálculo
A aplicação calcula o valor financeiro estimado de cada viagem dependendo do modelo do veículo selecionado para a entrega. Para motocicletas, o cálculo realiza a multiplicação direta da distância em quilômetros pelo valor de custo por quilômetro do veículo. Para os carros, o cálculo multiplica a distância pelo custo por quilômetro e soma uma taxa fixa operacional de quinze reais ao resultado. Para os caminhões, a fórmula efetua a multiplicação da distância pelo custo base por quilômetro e adiciona um valor proporcional ao peso carregado, cobrando cinquenta reais para cada tonelada transportada. Distâncias informadas iguais ou menores que zero impedem o cálculo e a realização do serviço.

Regras de manutenção
Todo veículo possui um estado interno para controle de manutenção. Ao ser enviado para a manutenção, a sua disponibilidade é alterada imediatamente. Se houver qualquer tentativa de iniciar uma entrega com um veículo em manutenção, o sistema recusa a chamada, exibindo uma mensagem informativa informando a situação indisponível da unidade. A liberação do veículo restaura o seu estado de disponibilidade, permitindo o agendamento regular das entregas.

Controle da capacidade do caminhão
O caminhão dispõe de um atributo exclusivo para parametrização do limite máximo de carga medido em quilos. Antes de alocar qualquer peso à viagem, o método de carregamento valida se o valor excede a capacidade limite suportada. Tentativas de ultrapassar essa margem são rejeitadas pelo sistema, mantendo a carga anterior e protegendo a integridade operacional da frota.

Utilização do polimorfismo
A arquitetura do sistema utiliza uma classe abstrata comum chamada Veiculo, na qual o método para calcular o custo da viagem é declarado de forma abstrata. Cada subclasse implementa a sua própria regra de cálculo. Isso permite que a classe principal trate diferentes tipos de transportes de maneira uniforme através do tipo genérico Veiculo, delegando o comportamento correto para cada tipo de transporte no momento da execução.

Relatório comparativo de simulação de viagens

Veículo | Distância | Carga | Custo calculado | Situação
--- | --- | --- | --- | ---
Motocicleta | 30 km | N/A | R$ 30.0 | Disponível
Carro | 100 km | N/A | R$ 165.0 | Disponível
Caminhão | 350 km | 10000 kg | R$ 2775.0 | Disponível

Instruções para execução
Para compilar e executar o sistema, utilize o terminal no diretório raiz do projeto. Execute o comando de compilação javac -d bin src/*.java. Em seguida, execute a aplicação digitando o comando java -cp bin Main.

Resultados encontrados
A execução dos testes confirmou a validação adequada dos limites do sistema. A tentativa de inserir uma carga de vinte mil quilos em um caminhão com capacidade menor foi bloqueada com sucesso, sendo aceita apenas após o ajuste para dez mil quilos. A simulação da viagem de trezentos e cinquenta quilômetros do caminhão Volvo FH gerou o valor correto de dois mil setecentos e setenta e cinco reais. O bloqueio por manutenção funcionou adequadamente no veículo Fiorino, que teve sua entrega negada enquanto indisponível e autorizada logo após a sua liberação, comprovando a eficácia das regras de negócio implementadas.
