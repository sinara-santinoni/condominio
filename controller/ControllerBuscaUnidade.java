package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import condominios.Unidade;
import view.TelaBuscaUnidade;

public class ControllerBuscaUnidade implements ActionListener {

    TelaBuscaUnidade telaBuscaUnidade;

    public ControllerBuscaUnidade(TelaBuscaUnidade telaBuscaUnidade) {
        this.telaBuscaUnidade = telaBuscaUnidade;
        this.telaBuscaUnidade.getjButtonBuscar1().addActionListener(this);
        this.telaBuscaUnidade.getjButtonSair1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaUnidade.getjButtonBuscar1()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaUnidade.getjButtonSair1()) {
            this.telaBuscaUnidade.dispose();
        }
    }

    private void buscar() {
        String descricaoDigitada = this.telaBuscaUnidade.getjTextFieldDescricao().getText().trim();

        List<Unidade> lista = ControllerCadastroUnidade.getLista();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Descrição", "Metragem Total", "Tipo"}
        );

        for (Unidade u : lista) {
            boolean descricaoVazia = descricaoDigitada.isEmpty();
            boolean descricaoBate = u.getDescricao() != null
                    && u.getDescricao().toLowerCase().contains(descricaoDigitada.toLowerCase());

            if (descricaoVazia || descricaoBate) {
                modelo.addRow(new Object[]{
                    u.getDescricao(),
                    u.getMetragemtotal(),
                    u.getTipounidade()
                });
            }
        }

        this.telaBuscaUnidade.getjTable1().setModel(modelo);
    }
}