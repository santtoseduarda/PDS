package br.com.loja.assistec.controller;


import br.com.loja.assistec.view.PrincipalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalController {

    private PrincipalView view;
    private String usuario;
    private String perfil;

    public PrincipalController(String usuario, String perfil) {
        this.usuario = usuario;
        this.perfil = perfil;
        this.view = new PrincipalView(usuario, perfil);
        configurarListeners();
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    
    private class principalListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if ("MenuSairAction".equals(e.getActionCommand())) {
				sair();
			}else if ("MenuSobreAction".equals(e.getActionCommand())) {
				sobre();
			}else if("MenuUsuariosAction".equals(e.getActionCommand())) {
				listarUsuarios();
			}
		}
	}

    private void configurarListeners() {
		view.addPrincipalListener(new principalListener());


    }
    
    private void listarUsuarios() {
    	//new ListarUsuariosController();
    	
    }

    private void sair() {
    	int Resposta = view.SairSistema() ;
        if (Resposta == 0) {
            System.exit(0);
        }
    }

    private void sobre() {
        view.mostrarMensagem("sistema de ordem de serviço", "Informação");
    }

    /*private void listarUsuarios() {
        ListarUsuariosView listarUsuariosView = new ListarUsuariosView();
        listarUsuariosView.setLocationRelativeTo(view);
        listarUsuariosView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listarUsuariosView.setVisible(true);
    }*/
}
