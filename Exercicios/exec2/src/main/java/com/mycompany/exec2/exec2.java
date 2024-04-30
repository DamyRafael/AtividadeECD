package com.mycompany.Exec2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author Damy
 */
public class exec2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();

        System.out.println("Cadastre seus Clientes");
        while (true) {
            System.out.print("Digite o código que vai atribuir ao seu novo cliente: \n");
            System.out.print("Ou digite 0 para sair: ");
            int codCliente = scanner.nextInt();
            if (codCliente == 0) {
                break;
            }
            scanner.nextLine(); 
            System.out.print("Informe o nome do seu cliente: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a data de nascimento: ");
            String dataNascimento = scanner.nextLine();
            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();

            Cliente cliente = new Cliente(codCliente, nome, dataNascimento, cpf);
            clientes.add(cliente);
        }
 
        Collections.sort(clientes, Comparator.comparingInt
                                                    (Cliente::getCodigo));

        System.out.println("Clientes cadastrados \n:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        System.out.print("Para pesquisar o cliente digite o código dele: ");
        int codigoPesquisa = scanner.nextInt();

        Cliente clienteEncontrado = pesquisaLinear
                                    (clientes, codigoPesquisa);

        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static Cliente pesquisaLinear(ArrayList<Cliente> clientes, 
            int codCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codCliente) {
                return cliente; 
            }
        }
        return null; 
    }
}
class Cliente {
    private int codCliente;
    private String nome;
    private String dataNascimento;
    private String cpf;

    public Cliente(int codCliente, String nome, 
            String dataNascimento, String cpf) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codCliente;
    }
    
    @Override
    public String toString() {
        return "Código: " + codCliente + ", Nome: " + nome + 
                ", Data de Nascimento: " + dataNascimento + ", CPF: " + cpf;
    }
}