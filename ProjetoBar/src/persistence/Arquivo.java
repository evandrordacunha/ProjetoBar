package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import business.Cliente;

public class Arquivo {

	public Arquivo() {
	}

	public void gravarCliente(Cliente c) {
		String novaLinha = c.toString();// dados do cliente a ser armazenado
		File arquivo = new File("clientes.txt");
		// escreve no arquivo
		FileWriter fw;
		try {
			fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(novaLinha);
			bw.newLine();
			bw.close();
			fw.close();
			JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro durante a gravação do arquivo! " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void gravarClientes(CadastroClientes cad) {

		for (int i = 0; i < cad.getClientes().size(); i++) {
			JOptionPane.showMessageDialog(null, "" + cad.getClientes().get(i).toString());

		}

	}
}
