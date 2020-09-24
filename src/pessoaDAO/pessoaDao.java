package pessoaDAO;

import java.util.ArrayList;
import java.util.List;

import Entity.Pessoa;

public class pessoaDao {
	
	public Pessoa inserirDados(Pessoa pessoa) {
		Pessoa inserirPessoa= new Pessoa();

		inserirPessoa.setNome(pessoa.Nome);
		inserirPessoa.setSobrenome(pessoa.Sobrenome);
		inserirPessoa.setIdade(pessoa.Idade);
		inserirPessoa.setCpf(pessoa.Cpf);
		inserirPessoa.setTelefone(pessoa.Telefone);
		
		return inserirPessoa;
	}

	public Pessoa findByNome(String nome, List<Pessoa> pessoas) {
		for (int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().equals(nome)) {
				return pessoas.get(i);
			}
		}
		return null;
	}
	
	public void AlterarPessoa (Pessoa pessoa, String nome, List<Pessoa> pessoas) {
		for (int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().equals(nome)) {
				pessoas.set(i, pessoa);
			}
		}
	}
	
	public void DeletarPessoa(String nome, List<Pessoa> pessoas) {
		for (int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().equals(nome)) {
				pessoas.remove(i);
			}
		}
	}
}
