package met.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
	private String logradouro;
	private String bairro;
	private String cep;
	private String complemento;
	private String numero;
	private String uf;
	private String cidade;

	public Endereco(DadosEndereco dados) {
		this.logradouro = dados.logradouro();
		this.bairro = dados.bairro();
		this.cep = dados.cep();
		this.complemento = dados.complemento();
		this.numero = dados.numero();
		this.uf = dados.uf();
		this.cidade = dados.cidade();
	}
}