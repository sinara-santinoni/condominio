package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import condominios.CustoNivel1;
import view.TelaBuscaCustoNivel1;

public class ControllerBuscaCustoNivel1 implements ActionListener {

    TelaBuscaCustoNivel1 telaBuscaCustoNivel1;

    public ControllerBuscaCustoNivel1(TelaBuscaCustoNivel1 telaBuscaCustoNivel1) {
        this.telaBuscaCustoNivel1 = telaBuscaCustoNivel1;
        this.telaBuscaCustoNivel1.getjButtonBuscar1().addActionListener(this);
        this.telaBuscaCustoNivel1.getjButtonSair1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaCustoNivel1.getjButtonBuscar1()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaCustoNivel1.getjButtonSair1()) {
            this.telaBuscaCustoNivel1.dispose();
        }
    }

    private void buscar() {
        String descricaoDigitada = this.telaBuscaCustoNivel1.getjTextFieldDescricao().getText().trim();

        List<CustoNivel1> lista = ControllerCadastroCustoNivel1.getLista();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Descrição", "Tipo CC", "Status"}
        );

        for (CustoNivel1 c : lista) {
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

        this.telaBuscaCustoNivel1.getjTable1().setModel(modelo);
    }
}