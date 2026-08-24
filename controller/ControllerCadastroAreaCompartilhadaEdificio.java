package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import condominios.AreaCompartilhadaEdificio;
import condominios.Edificio;
import condominios.AreaCompartilhada;
import view.TelaCadastroAreaCompartilhadaEdificio;

public class ControllerCadastroAreaCompartilhadaEdificio implements ActionListener {

    TelaCadastroAreaCompartilhadaEdificio telaCadastroAreaCompartilhadaEdificio;

    private static List<AreaCompartilhadaEdificio> lista = new ArrayList<>();

    public ControllerCadastroAreaCompartilhadaEdificio(
            TelaCadastroAreaCompartilhadaEdificio telaCadastroAreaCompartilhadaEdificio) {

        this.telaCadastroAreaCompartilhadaEdificio = telaCadastroAreaCompartilhadaEdificio;

        this.telaCadastroAreaCompartilhadaEdificio.getjButtonNovo().addActionListener(this);
        this.telaCadastroAreaCompartilhadaEdificio.getjButtonCancelar().addActionListener(this);
        this.telaCadastroAreaCompartilhadaEdificio.getjButtonGravar().addActionListener(this);
        this.telaCadastroAreaCompartilhadaEdificio.getjButtonBuscar().addActionListener(this);
        this.telaCadastroAreaCompartilhadaEdificio.getjButtonSair().addActionListener(this);

        utilities.Utilities.AtivaDesativa(
                this.telaCadastroAreaCompartilhadaEdificio.getjPanelbotoes(),
                true);

        // preenche os combos com o que já foi cadastrado nas outras telas
        for (Edificio edificio : ControllerCadastroEdificio.getLista()) {
            this.telaCadastroAreaCompartilhadaEdificio.getjComboBoxEdificio().addItem(edificio);
        }

        for (AreaCompartilhada areaCompartilhada : ControllerCadastroAreaCompartilhada.getLista()) {
            this.telaCadastroAreaCompartilhadaEdificio.getjComboBoxAreaCompartilhada().addItem(areaCompartilhada);
        }
    }

    public static List<AreaCompartilhadaEdificio> getLista() {
        return lista;
    }

    @Override
    public void actionPerformed(ActionEvent action) {

        if (action.getSource()
                == this.telaCadastroAreaCompartilhadaEdificio.getjButtonNovo()) {

            utilities.Utilities.AtivaDesativa(
                    this.telaCadastroAreaCompartilhadaEdificio.getjPanelbotoes(),
                    false);

            utilities.Utilities.LimpaComponentes(
                    this.telaCadastroAreaCompartilhadaEdificio.getjPanelDados(),
                    true,
                    this.telaCadastroAreaCompartilhadaEdificio.getButtonGroup1());

        } else if (action.getSource()
                == this.telaCadastroAreaCompartilhadaEdificio.getjButtonCancelar()) {

            utilities.Utilities.AtivaDesativa(
                    this.telaCadastroAreaCompartilhadaEdificio.getjPanelbotoes(),
                    true);

            utilities.Utilities.LimpaComponentes(
                    this.telaCadastroAreaCompartilhadaEdificio.getjPanelDados(),
                    false,
                    this.telaCadastroAreaCompartilhadaEdificio.getButtonGroup1());

        } else if (action.getSource()
                == this.telaCadastroAreaCompartilhadaEdificio.getjButtonGravar()) {

            AreaCompartilhadaEdificio areaCompartilhadaEdificio = new AreaCompartilhadaEdificio();

            areaCompartilhadaEdificio.setStatus(
                    this.telaCadastroAreaCompartilhadaEdificio
                            .getjTextFieldStatus()
                            .getText());

            areaCompartilhadaEdificio.setObservacao(
                    this.telaCadastroAreaCompartilhadaEdificio
                            .getjTextAreaObservacao()
                            .getText());

            areaCompartilhadaEdificio.setEdificio(
                    (Edificio) this.telaCadastroAreaCompartilhadaEdificio
                            .getjComboBoxEdificio()
                            .getSelectedItem());

            areaCompartilhadaEdificio.setAreaCompartilhada(
                    (AreaCompartilhada) this.telaCadastroAreaCompartilhadaEdificio
                            .getjComboBoxAreaCompartilhada()
                            .getSelectedItem());

            lista.add(areaCompartilhadaEdificio);

            utilities.Utilities.AtivaDesativa(
                    this.telaCadastroAreaCompartilhadaEdificio.getjPanelbotoes(),
                    true);

            utilities.Utilities.LimpaComponentes(
                    this.telaCadastroAreaCompartilhadaEdificio.getjPanelDados(),
                    false,
                    this.telaCadastroAreaCompartilhadaEdificio.getButtonGroup1());

        } else if (action.getSource()
                == this.telaCadastroAreaCompartilhadaEdificio.getjButtonBuscar()) {
            view.TelaBuscaAreaCompartilhadaEdificio telaBusca = new view.TelaBuscaAreaCompartilhadaEdificio(null, true);
            new ControllerBuscaAreaCompartilhadaEdificio(telaBusca);
            telaBusca.setVisible(true);

        } else if (action.getSource()
                == this.telaCadastroAreaCompartilhadaEdificio.getjButtonSair()) {

            this.telaCadastroAreaCompartilhadaEdificio.dispose();
        }
    }
}
