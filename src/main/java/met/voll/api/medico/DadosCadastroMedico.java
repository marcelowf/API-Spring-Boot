package met.voll.api.medico;

import met.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,
		DadosEndereco endereco) {

}