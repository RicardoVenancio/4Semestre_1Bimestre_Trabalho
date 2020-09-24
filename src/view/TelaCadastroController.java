package view;


import java.io.IOException;
import java.util.*;

import javax.print.DocFlavor.URL;

import Entity.Pessoa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pessoaDAO.pessoaDao;
import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TelaCadastroController extends Application implements Initializable{


    @FXML
    private Button BTNSalvar;

    @FXML
    private TextField TXNome;

    @FXML
    private TextField TXSobrenome;

    @FXML
    private TextField TXIdade;

    @FXML
    private TextField TXCpf;

    @FXML
    private TextField TXTelefone;

    @FXML
    private Button BTNEditar;

    @FXML
    private Button BTNExcluir;

    @FXML
    private TextArea textAreaLista;

    @FXML
    private Button listDados;

    @FXML
    private Button pesquisarCPF;

    @FXML
    private TextField TXCpfPesquisar;

    @FXML
    private Label labelLabelID;

    @FXML
    private Label labelNOME;

    @FXML
    private Button BTNSair;

    
    //////////	AÇÕES DOS BOTÕES //////////
    
//////////////////////////////////////////////////////////////////CRIANDO A LISTA
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    
    pessoaDao daoPessoas = new pessoaDao();
	

    @FXML
    void SalvarDados(ActionEvent event) {///////////
   
    	
    	Pessoa pessoaInserir = new Pessoa();
    	pessoaInserir.setNome(TXNome.getText());
    	pessoaInserir.setSobrenome(TXSobrenome.getText());
    	pessoaInserir.setIdade(Integer.parseInt(TXIdade.getText()));
    	pessoaInserir.setCpf(TXCpf.getText());
    	pessoaInserir.setTelefone(TXTelefone.getText());
    	
    	pessoas.add(pessoaInserir);
    	limpaCampo();
        System.out.println(pessoas);
	}
	
    
    @FXML
    void EditarDados(ActionEvent event) { 	
       	Pessoa pessoa = obtemDados();
       	
       	
    	String nomeString= TXCpfPesquisar.getText();
    	TXNome.setText(pessoa.getNome());
    	TXSobrenome.setText(pessoa.getSobrenome());
    	TXIdade.setText(Integer.toString(pessoa.getIdade()));
    	TXCpf.setText(pessoa.getCpf());
    	TXTelefone.setText(pessoa.getTelefone());
		daoPessoas.AlterarPessoa(pessoa,nomeString, pessoas );
		ListarPessoa();
		limpaCampo();
    }
    
    @FXML
    void ExcluirDados(ActionEvent event) {
//    	Pessoa pessoaExcluir = new Pessoa();
//    	
//     	String cpfLista = pessoaExcluir.Cpf;
//    	String cpfPesquisa = TXCpfPesquisar.getText();
//    	
//    	for(int i = 0; i <= pessoas.size(); i++) {
//    		if(cpfPesquisa.equals(cpfLista)) {
//    			pessoas.remove(i);d
//    			System.out.println("pessoa exluida");
//    		}
//    		else {
//    			System.out.println("Pessoa não existe!");
//    		}
//    		
//    	}
    	
    	String nomeString = TXCpfPesquisar.getText();
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("EXCLUIR PESSOA");
    	alert.setHeaderText("VOCÊ CLICOU NA OPÇÃO EXCLUIR PESSOA");
    	alert.setContentText("TEM CERTEZA QUE DESEJA EXCLUIR ESTÁ PESSOA?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		daoPessoas.DeletarPessoa(nomeString, pessoas);
            limpaCampo();
            ListarPessoa();
        }
    }
    

    @FXML
    void ListarDadosSalvos(ActionEvent event) {
    	ListarPessoa();
    }
    

    @FXML
    void pesquisarDados(ActionEvent event) {
//    	Pessoa pessoaPesquisar = new Pessoa();
//    	
//    	String cpfLista = pessoaPesquisar.Cpf;
//    	String cpfPesquisa = TXCpfPesquisar.getText();
//    	
//    	for(int i = 0; i <= pessoas.size(); i++) {
//    		if(cpfLista.equals(cpfPesquisa)) {
//        		System.out.println(i);
//        		limpaCampo();
//        		
//    		}
//    	}
    	
    	String nomeString= TXCpfPesquisar.getText();
    	Pessoa pessoa = null;
    	if (!nomeString.equals("")) {
			try {
				pessoa = new pessoaDao().findByNome(nomeString, pessoas);
			} catch (Exception e) {
			}
			if (pessoa != null) { 
				labelLabelID.setVisible(true);
				labelNOME.setVisible(true);
				labelNOME.setText(pessoa.getNome());
		    	TXNome.setText(pessoa.getNome());
		    	TXSobrenome.setText(pessoa.getSobrenome());
		    	TXIdade.setText(Integer.toString((pessoa.getIdade())));
		    	TXCpf.setText(pessoa.getCpf());
		    	TXTelefone.setText(pessoa.getTelefone());
			}
		}
    	
    }
    

    @FXML
    void SairSistema(ActionEvent event) {
    	
    	String nomeString = TXCpfPesquisar.getText();
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("SAIR SISTEMA");
    	alert.setHeaderText("VOCÊ CLICOU NA OPÇÃO SAIR");
    	alert.setContentText("TEM CERTEZA QUE DESEJA SAIR DO SISTEMA?");
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if (result.get() == ButtonType.OK){
    		 System.exit(0);
        }
    	
 
    }
    
    
	public ArrayList<Pessoa> ListarTodos() {
			
		
    	Pessoa pessoaInserir = new Pessoa();
    	
    	pessoaInserir.setNome(TXNome.getText());
    	pessoaInserir.setSobrenome(TXSobrenome.getText());
    	pessoaInserir.setIdade(Integer.parseInt(TXIdade.getText()));
    	pessoaInserir.setCpf(TXCpf.getText());
    	pessoaInserir.setTelefone(TXTelefone.getText());
    	
    	pessoas.add(pessoaInserir);
    	
		return pessoas;
	}
	
	
	
	
  	private void ListarPessoa() {
  		
  		textAreaLista.clear();
  		for (Pessoa pessoa : pessoas) {
  			textAreaLista.appendText(pessoa.toString() +"\n");
		}
}
  	
  	
  	
  	 private void limpaCampo() {
     	TXNome.clear();
     	TXSobrenome.clear();
     	TXIdade.clear();
     	TXCpf.clear();
     	TXTelefone.clear();
     			
     	TXNome.requestFocus();
     }
  	 
  	 
  	 
//  	public void ExcluirPessoa() {
//  		Pessoa pessoa = obtemDadosCPF();
//  		int qtde = deletar(pessoa.getCpf());
//  		limpaCampo();
//  		ListarPessoa();
//  	}
//  	
//  	
//  	
//  	public int deletar(String CpfPessoa) {
//  		int quantidade = 0;
//  		return quantidade;
//  	}
  	
  	
  	
    private Pessoa obtemDados() {
    	return new Pessoa(TXNome.getText(), TXSobrenome.getText(), Integer.parseInt(TXIdade.getText()), TXCpf.getText(), TXTelefone.getText());
    }
    
    
  	
    private Pessoa obtemDadosCPF() {
    	return new Pessoa(TXNome.getText(), TXSobrenome.getText(), Integer.parseInt(TXIdade.getText()), TXCpf.getText(), TXTelefone.getText());
    }
	

    
  	public void execute() {
  		launch();
  	}
   


	public void start(Stage stage) {

        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
            Scene sc = new Scene(pane);
            stage.setScene(sc);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }

	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
     ListarPessoa();
		
	}	 

}

