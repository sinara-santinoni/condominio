package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import condominios.UnidadeCondomino;
import view.TelaBuscaUnidadeCondomino;

public class ControllerBuscaUnidadeCondomino implements ActionListener {

    TelaBuscaUnidadeCondomino telaBuscaUnidadeCondomino;

    public ControllerBuscaUnidadeCondomino(TelaBuscaUnidadeCondomino telaBuscaUnidadeCondomino) {
        this.telaBuscaUnidadeCondomino = telaBuscaUnidadeCondomino;
        this.telaBuscaUnidadeCondomino.getjButtonBuscar1().addActionListener(this);
        this.telaBuscaUnidadeCondomino.getjButtonSair1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaUnidadeCondomino.getjButtonBuscar1()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaUnidadeCondomino.getjButtonSair1()) {
            this.telaBuscaUnidadeCondomino.dispose();
        }
    }

    private void buscar() {
        List<UnidadeCondomino> lista = ControllerCadastroUnidadeCondomino.getLista();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Data Aquisição", "Data Venda", "Status"}
        );

        for (UnidadeCondomino uc : lista) {
            String dataAquisicao = uc.getDataaquisicao() != null ? formato.format(uc.getDataaquisicao()) : "";
            String dataVenda = uc.getDatavenda() != null ? formato.format(uc.getDatavenda()) : "";

            modelo.addRow(new Object[]{
                dataAquisicao,
                dataVenda,
                uc.getStatus()
            });
        }

        this.telaBuscaUnidadeCondomino.getjTable1().setModel(modelo);
    }
}