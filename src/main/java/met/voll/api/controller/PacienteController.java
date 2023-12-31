package met.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import met.voll.api.paciente.DadosAtualizacaoPaciente;
import met.voll.api.paciente.DadosCadastroPaciente;
import met.voll.api.paciente.DadosListagemPaciente;
import met.voll.api.paciente.PacienteRepository;
import met.voll.api.paciente.Paciente;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
		repository.save(new Paciente(dados));
	}

	@GetMapping
	public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var paciente = repository.getReferenceById(id);
		paciente.excluir();
	}
}