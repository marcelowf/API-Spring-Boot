package met.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import met.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(

		@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}