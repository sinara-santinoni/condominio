package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaCadastroUnidade;
import java.util.ArrayList;
import java.util.List;
import condominios.Unidade;

public class ControllerCadastroUnidade implements ActionListener {

    TelaCadastroUnidade telaCadastroUnidade;
    private static List<Unidade> lista = new ArrayList<>();

    public static List<Unidade> getLista() {
        return lista;
    }

    public ControllerCadastroUnidade(TelaCadastroUnidade telaCadastroUnidade) {
        this.telaCadastroUnidade = telaCadastroUnidade;

        this.telaCadastroUnidade.getjButtonNovo().addActionListener(this);
        this.telaCadastroUnidade.getjButtonCancelar().addActionListener(this);
        this.telaCadastroUnidade.getjButtonGravar().addActionListener(this);
        this.telaCadastroUnidade.getjButtonBuscar().addActionListener(this);
        this.telaCadastroUnidade.getjButtonSair().addActionListener(this);

        utilities.Utilities.AtivaDesativa(this.telaCadastroUnidade.getjPanelbotoes(), true);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaCadastroUnidade.getjButtonNovo()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroUnidade.getjPanelbotoes(), false);
            utilities.Utilities.LimpaComponentes(this.telaCadastroUnidade.getjPanelDados(), true, this.telaCadastroUnidade.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroUnidade.getjButtonCancelar()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroUnidade.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroUnidade.getjPanelDados(), false, this.telaCadastroUnidade.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroUnidade.getjButtonGravar()) {
            Unidade unidade = new Unidade();
            unidade.setDescricao(this.telaCadastroUnidade.getjTextFieldDescricao().getText());
            unidade.setObservacao(this.telaCadastroUnidade.getjTextArea1().getText());

            try {
                unidade.setMetragemtotal(Float.parseFloat(this.telaCadastroUnidade.getjTextFieldMetragemTotal().getText()));
            } catch (NumberFormatException e) {
                unidade.setMetragemtotal(0f);
            }

            try {
                unidade.setMetragemindividual(Float.parseFloat(this.telaCadastroUnidade.getjTextFieldMetragemIndividual().getText()));
            } catch (NumberFormatException e) {
                unidade.setMetragemindividual(0f);
            }

            try {
                unidade.setTipounidade(Integer.parseInt(this.telaCadastroUnidade.getjTextFieldTipoUnidade().getText()));
            } catch (NumberFormatException e) {
                unidade.setTipounidade(0);
            }

            lista.add(unidade);

            utilities.Utilities.AtivaDesativa(this.telaCadastroUnidade.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroUnidade.getjPanelDados(), false, this.telaCadastroUnidade.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroUnidade.getjButtonBuscar()) {
            view.TelaBuscaUnidade telaBusca = new view.TelaBuscaUnidade(null, true);
            new ControllerBuscaUnidade(telaBusca);
            telaBusca.setVisible(true);

        } else if (action.getSource() == this.telaCadastroUnidade.getjButtonSair()) {
            this.telaCadastroUnidade.dispose();
        }
    }
}
