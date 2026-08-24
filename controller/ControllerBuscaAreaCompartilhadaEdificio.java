package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import condominios.AreaCompartilhadaEdificio;
import view.TelaBuscaAreaCompartilhadaEdificio;

public class ControllerBuscaAreaCompartilhadaEdificio implements ActionListener {

    TelaBuscaAreaCompartilhadaEdificio telaBuscaAreaCompartilhadaEdificio;

    public ControllerBuscaAreaCompartilhadaEdificio(TelaBuscaAreaCompartilhadaEdificio telaBuscaAreaCompartilhadaEdificio) {
        this.telaBuscaAreaCompartilhadaEdificio = telaBuscaAreaCompartilhadaEdificio;
        this.telaBuscaAreaCompartilhadaEdificio.getjButtonBuscar1().addActionListener(this);
        this.telaBuscaAreaCompartilhadaEdificio.getjButtonSair1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaBuscaAreaCompartilhadaEdificio.getjButtonBuscar1()) {
            buscar();
        } else if (action.getSource() == this.telaBuscaAreaCompartilhadaEdificio.getjButtonSair1()) {
            this.telaBuscaAreaCompartilhadaEdificio.dispose();
        }
    }

    private void buscar() {
        List<AreaCompartilhadaEdificio> lista = ControllerCadastroAreaCompartilhadaEdificio.getLista();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Edifício", "Área Compartilhada", "Status"}
        );

        for (AreaCompartilhadaEdificio ace : lista) {
            modelo.addRow(new Object[]{
                ace.getEdificio(),
                ace.getAreaCompartilhada(),
                ace.getStatus()
            });
        }

        this.telaBuscaAreaCompartilhadaEdificio.getjTable1().setModel(modelo);
    }
}