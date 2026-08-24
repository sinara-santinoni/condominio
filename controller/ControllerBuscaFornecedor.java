package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import condominios.Fornecedor;
import view.TelaBuscaFornecedor;

public class ControllerBuscaFornecedor implements ActionListener {

    TelaBuscaFornecedor telaBuscaFornecedor;

    public ControllerBuscaFornecedor(TelaBuscaFornecedor telaBuscaFornecedor) {
        this.telaBuscaFornecedor = telaBuscaFornecedor;
        this.telaBuscaFornecedor.getjButtonBuscar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaFornecedor.getjButtonBuscar()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaFornecedor.getjButtonSair()) {
            this.telaBuscaFornecedor.dispose();
        }
    }

    private void buscar() {
        String nomeDigitado = this.telaBuscaFornecedor.getjTextFieldNomeFantasia().getText().trim();

        List<Fornecedor> lista = ControllerCadastroFornecedor.getLista();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Nome Fantasia", "CPF", "Telefone 1"}
        );

        for (Fornecedor f : lista) {
            boolean nomeVazio = nomeDigitado.isEmpty();
            boolean nomeBate = f.getNomefantasia() != null
                    && f.getNomefantasia().toLowerCase().contains(nomeDigitado.toLowerCase());

            if (nomeVazio || nomeBate) {
                modelo.addRow(new Object[]{
                    f.getNomefantasia(),
                    f.getCpf(),
                    f.getFone1()
                });
            }
        }

        this.telaBuscaFornecedor.getjTable1().setModel(modelo);
    }
}