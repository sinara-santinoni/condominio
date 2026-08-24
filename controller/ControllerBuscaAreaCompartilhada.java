package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import condominios.AreaCompartilhada;
import view.TelaBuscaAreaCompartilhada;

public class ControllerBuscaAreaCompartilhada implements ActionListener {

    TelaBuscaAreaCompartilhada telaBuscaAreaCompartilhada;

    public ControllerBuscaAreaCompartilhada(TelaBuscaAreaCompartilhada telaBuscaAreaCompartilhada) {
        this.telaBuscaAreaCompartilhada = telaBuscaAreaCompartilhada;
        this.telaBuscaAreaCompartilhada.getjButtonBuscar1().addActionListener(this);
        this.telaBuscaAreaCompartilhada.getjButtonSair1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaAreaCompartilhada.getjButtonBuscar1()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaAreaCompartilhada.getjButtonSair1()) {
            this.telaBuscaAreaCompartilhada.dispose();
        }
    }

    private void buscar() {
        String descricaoDigitada = this.telaBuscaAreaCompartilhada.getjTextFieldNome().getText().trim();

        List<AreaCompartilhada> lista = ControllerCadastroAreaCompartilhada.getLista();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Descrição", "Status"}
        );

        for (AreaCompartilhada a : lista) {
            boolean descricaoVazia = descricaoDigitada.isEmpty();
            boolean descricaoBate = a.getDescricao() != null
                    && a.getDescricao().toLowerCase().contains(descricaoDigitada.toLowerCase());

            if (descricaoVazia || descricaoBate) {
                modelo.addRow(new Object[]{
                    a.getDescricao(),
                    a.getStatus()
                });
            }
        }

        this.telaBuscaAreaCompartilhada.getjTable1().setModel(modelo);
    }
}