package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import condominios.CustoNivel2;
import view.TelaBuscaCustoNivel2;

public class ControllerBuscaCustoNivel2 implements ActionListener {

    TelaBuscaCustoNivel2 telaBuscaCustoNivel2;

    public ControllerBuscaCustoNivel2(TelaBuscaCustoNivel2 telaBuscaCustoNivel2) {
        this.telaBuscaCustoNivel2 = telaBuscaCustoNivel2;
        this.telaBuscaCustoNivel2.getjButtonBuscar1().addActionListener(this);
        this.telaBuscaCustoNivel2.getjButtonSair1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaCustoNivel2.getjButtonBuscar1()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaCustoNivel2.getjButtonSair1()) {
            this.telaBuscaCustoNivel2.dispose();
        }
    }

    private void buscar() {
        String descricaoDigitada = this.telaBuscaCustoNivel2.getjTextFieldDescricao().getText().trim();

        List<CustoNivel2> lista = ControllerCadastroCustoNivel2.getLista();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Descrição", "Tipo CC", "Status"}
        );

        for (CustoNivel2 c : lista) {
            boolean descricaoVazia = descricaoDigitada.isEmpty();
            boolean descricaoBate = c.getDescricao() != null
                    && c.getDescricao().toLowerCase().contains(descricaoDigitada.toLowerCase());

            if (descricaoVazia || descricaoBate) {
                modelo.addRow(new Object[]{
                    c.getDescricao(),
                    c.getTipocc(),
                    c.getStatus()
                });
            }
        }

        this.telaBuscaCustoNivel2.getjTable1().setModel(modelo);
    }
}