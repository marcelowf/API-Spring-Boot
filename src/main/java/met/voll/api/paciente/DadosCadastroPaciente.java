package met.voll.api.paciente;

import met.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String cpf, String email, String telefone, DadosEndereco endereco) {

}