package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import condominios.Edificio;
import view.TelaBuscaEdificio;

public class ControllerBuscaEdificio implements ActionListener {

    TelaBuscaEdificio telaBuscaEdificio;

    public ControllerBuscaEdificio(TelaBuscaEdificio telaBuscaEdificio) {
        this.telaBuscaEdificio = telaBuscaEdificio;
        this.telaBuscaEdificio.getjButtonBuscar1().addActionListener(this);
        this.telaBuscaEdificio.getjButtonSair1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaEdificio.getjButtonBuscar1()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaEdificio.getjButtonSair1()) {
            this.telaBuscaEdificio.dispose();
        }
    }

    private void buscar() {
        String nomeDigitado = this.telaBuscaEdificio.getjTextFieldNome().getText().trim();

        List<Edificio> lista = ControllerCadastroEdificio.getLista();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Nome", "CNPJ", "Cidade"}
        );

        for (Edificio e : lista) {
            boolean nomeVazio = nomeDigitado.isEmpty();
            boolean nomeBate = e.getNome() != null
                    && e.getNome().toLowerCase().contains(nomeDigitado.toLowerCase());

            if (nomeVazio || nomeBate) {
                modelo.addRow(new Object[]{
                    e.getNome(),
                    e.getCnpj(),
                    e.getCidade()
                });
            }
        }

        this.telaBuscaEdificio.getjTable1().setModel(modelo);
    }
}