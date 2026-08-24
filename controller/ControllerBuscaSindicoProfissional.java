package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import condominios.SindicoProfissional;
import view.TelaBuscaSindicoProfissional;

public class ControllerBuscaSindicoProfissional implements ActionListener {

    TelaBuscaSindicoProfissional telaBuscaSindicoProfissional;

    public ControllerBuscaSindicoProfissional(TelaBuscaSindicoProfissional telaBuscaSindicoProfissional) {
        this.telaBuscaSindicoProfissional = telaBuscaSindicoProfissional;
        this.telaBuscaSindicoProfissional.getjButtonBuscar1().addActionListener(this);
        this.telaBuscaSindicoProfissional.getjButtonSair1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaSindicoProfissional.getjButtonBuscar1()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaSindicoProfissional.getjButtonSair1()) {
            this.telaBuscaSindicoProfissional.dispose();
        }
    }

    private void buscar() {
        String nomeDigitado = this.telaBuscaSindicoProfissional.getjTextFieldNome().getText().trim();

        List<SindicoProfissional> lista = ControllerCadastroSindicoProfissional.getLista();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Nome", "CRA", "Telefone 1"}
        );

        for (SindicoProfissional s : lista) {
            boolean nomeVazio = nomeDigitado.isEmpty();
            boolean nomeBate = s.getNomefantasia() != null
                    && s.getNomefantasia().toLowerCase().contains(nomeDigitado.toLowerCase());

            if (nomeVazio || nomeBate) {
                modelo.addRow(new Object[]{
                    s.getNomefantasia(),
                    s.getCra(),
                    s.getFone1()
                });
            }
        }

        this.telaBuscaSindicoProfissional.getjTable1().setModel(modelo);
    }
}