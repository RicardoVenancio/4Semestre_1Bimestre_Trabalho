package Entity;

public class Pessoa {
	public String Nome;
	public String Sobrenome;
	public int Idade;
	public String Cpf;
	public String Telefone;
	
	
	//////////////////CONSTRUCTOR VAZIO//////////////////////
	public Pessoa() {
		super();
	}

	//////////////////CONSTRUCTOR//////////////////////
	public Pessoa(String nome, String sobrenome, int idade, String cpf, String telefone) {
		super();
		Nome = nome;
		Sobrenome = sobrenome;
		Idade = idade;
		Cpf = cpf;
		Telefone = telefone;
	}

	//////////////////GET E SET//////////////////////
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}
	public int getIdade() {
		return Idade;
	}
	public void setIdade(int idade) {
		Idade = idade;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
	//////////////////TO STRING//////////////////////
	@Override
	public String toString() {
		return "[Nome: " + Nome + ", Sobrenome: " + Sobrenome + ", Idade: " + Idade + ", Cpf: " + Cpf + ", Telefone: "
				+ Telefone + "]";
	}
}
