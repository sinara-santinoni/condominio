package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import condominios.Proprietario;
import view.TelaBuscaProprietario;

public class ControllerBuscaProprietario implements ActionListener {

    TelaBuscaProprietario telaBuscaProprietario;

    public ControllerBuscaProprietario(TelaBuscaProprietario telaBuscaProprietario) {
        this.telaBuscaProprietario = telaBuscaProprietario;
        this.telaBuscaProprietario.getjButtonBuscar1().addActionListener(this);
        this.telaBuscaProprietario.getjButtonSair1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaProprietario.getjButtonBuscar1()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaProprietario.getjButtonSair1()) {
            this.telaBuscaProprietario.dispose();
        }
    }

    private void buscar() {
        String nomeDigitado = this.telaBuscaProprietario.getjTextFieldNome().getText().trim();

        List<Proprietario> lista = ControllerCadastroProprietario.getLista();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Nome Fantasia", "CPF", "Telefone 1", "Cidade"}
        );

        for (Proprietario p : lista) {
            boolean nomeVazio = nomeDigitado.isEmpty();
            boolean nomeBate = p.getNomefantasia() != null
                    && p.getNomefantasia().toLowerCase().contains(nomeDigitado.toLowerCase());

            if (nomeVazio || nomeBate) {
                modelo.addRow(new Object[]{
                    p.getNomefantasia(),
                    p.getCpf(),
                    p.getFone1(),
                    p.getCidade()
                });
            }
        }

        this.telaBuscaProprietario.getjTable1().setModel(modelo);
    }
}