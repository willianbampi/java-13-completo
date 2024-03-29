package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarTabelaPessoas2 {

	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um nome");
        String nomePesquisa = entrada.nextLine();

        Connection conexao = FabricaConexao.getConexao();
        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%" + nomePesquisa + "%");
        ResultSet resultado = stmt.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();
        while(resultado.next()){
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }
        
        if(pessoas.size() > 0) {
        	for(Pessoa p : pessoas){
        		System.out.println(p.getCodigo() + " ==> " + p.getNome());
        	}
        } else {
        	System.out.println("Nenhuma pessoa retornada.");
        }
       
        stmt.close();
        conexao.close();
        entrada.close();
	}

}
