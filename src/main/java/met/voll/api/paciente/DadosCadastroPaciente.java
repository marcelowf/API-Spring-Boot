package met.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import met.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(
		
		@NotBlank
		String nome, 
		
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String cpf, 
		
		@NotBlank
		@Email
		String email, 
		
		@NotBlank
		@Pattern(regexp = "\\d{11,15}")
		String telefone, 
		
		@NotNull
		@Valid
		DadosEndereco endereco) {

}