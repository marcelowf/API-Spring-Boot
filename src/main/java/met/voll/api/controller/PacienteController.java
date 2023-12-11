package met.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import met.voll.api.paciente.DadosCadastroPaciente;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	@PostMapping
	public void Paciente(@RequestBody DadosCadastroPaciente dados) {
		System.out.println(dados);
	}
}