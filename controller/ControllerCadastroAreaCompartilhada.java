package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import condominios.AreaCompartilhada;
import view.TelaCadastroAreaCompartilhada;

public class ControllerCadastroAreaCompartilhada implements ActionListener {

    TelaCadastroAreaCompartilhada telaCadastroAreaCompartilhada;

    private static List<AreaCompartilhada> lista = new ArrayList<>();

    public ControllerCadastroAreaCompartilhada(
            TelaCadastroAreaCompartilhada telaCadastroAreaCompartilhada) {

        this.telaCadastroAreaCompartilhada = telaCadastroAreaCompartilhada;

        this.telaCadastroAreaCompartilhada.getjButtonNovo().addActionListener(this);
        this.telaCadastroAreaCompartilhada.getjButtonCancelar().addActionListener(this);
        this.telaCadastroAreaCompartilhada.getjButtonGravar().addActionListener(this);
        this.telaCadastroAreaCompartilhada.getjButtonBuscar().addActionListener(this);
        this.telaCadastroAreaCompartilhada.getjButtonSair().addActionListener(this);

        utilities.Utilities.AtivaDesativa(
                this.telaCadastroAreaCompartilhada.getjPanelbotoes(),
                true);
    }

    public static List<AreaCompartilhada> getLista() {
        return lista;
    }

    @Override
    public void actionPerformed(ActionEvent action) {

        if (action.getSource()
                == this.telaCadastroAreaCompartilhada.getjButtonNovo()) {

            utilities.Utilities.AtivaDesativa(
                    this.telaCadastroAreaCompartilhada.getjPanelbotoes(),
                    false);

            utilities.Utilities.LimpaComponentes(
                    this.telaCadastroAreaCompartilhada.getjPanelDados(),
                    true,
                    this.telaCadastroAreaCompartilhada.getButtonGroup1());

        } else if (action.getSource()
                == this.telaCadastroAreaCompartilhada.getjButtonCancelar()) {

            utilities.Utilities.AtivaDesativa(
                    this.telaCadastroAreaCompartilhada.getjPanelbotoes(),
                    true);

            utilities.Utilities.LimpaComponentes(
                    this.telaCadastroAreaCompartilhada.getjPanelDados(),
                    false,
                    this.telaCadastroAreaCompartilhada.getButtonGroup1());

        } else if (action.getSource()
                == this.telaCadastroAreaCompartilhada.getjButtonGravar()) {

            AreaCompartilhada areaCompartilhada = new AreaCompartilhada();

            areaCompartilhada.setDescricao(
                    this.telaCadastroAreaCompartilhada
                            .getjTextFieldDescricao()
                            .getText());

            areaCompartilhada.setStatus(
                    this.telaCadastroAreaCompartilhada
                            .getjTextFieldStatus()
                            .getText());

            areaCompartilhada.setObservacao(
                    this.telaCadastroAreaCompartilhada
                            .getjTextAreaObservacao()
                            .getText());

            lista.add(areaCompartilhada);

            utilities.Utilities.AtivaDesativa(
                    this.telaCadastroAreaCompartilhada.getjPanelbotoes(),
                    true);

            utilities.Utilities.LimpaComponentes(
                    this.telaCadastroAreaCompartilhada.getjPanelDados(),
                    false,
                    this.telaCadastroAreaCompartilhada.getButtonGroup1());

        } else if (action.getSource()
                == this.telaCadastroAreaCompartilhada.getjButtonBuscar()) {

            view.TelaBuscaAreaCompartilhada telaBusca = new view.TelaBuscaAreaCompartilhada(null, true);
            new ControllerBuscaAreaCompartilhada(telaBusca);
            telaBusca.setVisible(true);

        } else if (action.getSource()
                == this.telaCadastroAreaCompartilhada.getjButtonSair()) {

            this.telaCadastroAreaCompartilhada.dispose();
        }
    }
}
