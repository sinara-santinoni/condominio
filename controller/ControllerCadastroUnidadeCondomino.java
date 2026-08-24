package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaCadastroUnidadeCondomino;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import condominios.UnidadeCondomino;

public class ControllerCadastroUnidadeCondomino implements ActionListener {

    TelaCadastroUnidadeCondomino telaCadastroUnidadeCondomino;
    private static List<UnidadeCondomino> lista = new ArrayList<>();

    public static List<UnidadeCondomino> getLista() {
        return lista;
    }

    public ControllerCadastroUnidadeCondomino(TelaCadastroUnidadeCondomino telaCadastroUnidadeCondomino) {
        this.telaCadastroUnidadeCondomino = telaCadastroUnidadeCondomino;

        this.telaCadastroUnidadeCondomino.getjButtonNovo().addActionListener(this);
        this.telaCadastroUnidadeCondomino.getjButtonCancelar().addActionListener(this);
        this.telaCadastroUnidadeCondomino.getjButtonGravar().addActionListener(this);
        this.telaCadastroUnidadeCondomino.getjButtonBuscar().addActionListener(this);
        this.telaCadastroUnidadeCondomino.getjButtonSair().addActionListener(this);

        utilities.Utilities.AtivaDesativa(this.telaCadastroUnidadeCondomino.getjPanelbotoes(), true);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaCadastroUnidadeCondomino.getjButtonNovo()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroUnidadeCondomino.getjPanelbotoes(), false);
            utilities.Utilities.LimpaComponentes(this.telaCadastroUnidadeCondomino.getjPanelDados(), true, this.telaCadastroUnidadeCondomino.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroUnidadeCondomino.getjButtonCancelar()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroUnidadeCondomino.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroUnidadeCondomino.getjPanelDados(), false, this.telaCadastroUnidadeCondomino.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroUnidadeCondomino.getjButtonGravar()) {
            UnidadeCondomino unidadeCondomino = new UnidadeCondomino();
            unidadeCondomino.setObservacao(this.telaCadastroUnidadeCondomino.getjTextAreaObservacao().getText());

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);

            try {
                unidadeCondomino.setDataaquisicao(formato.parse(this.telaCadastroUnidadeCondomino.getjTextFieldDataAquisicao().getText()));
            } catch (java.text.ParseException e) {
                unidadeCondomino.setDataaquisicao(null);
            }

            try {
                unidadeCondomino.setDatavenda(formato.parse(this.telaCadastroUnidadeCondomino.getjTextFieldDataVenda().getText()));
            } catch (java.text.ParseException e) {
                unidadeCondomino.setDatavenda(null);
            }

            lista.add(unidadeCondomino);

            utilities.Utilities.AtivaDesativa(this.telaCadastroUnidadeCondomino.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroUnidadeCondomino.getjPanelDados(), false, this.telaCadastroUnidadeCondomino.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroUnidadeCondomino.getjButtonBuscar()) {
            view.TelaBuscaUnidadeCondomino telaBusca = new view.TelaBuscaUnidadeCondomino(null, true);
            new ControllerBuscaUnidadeCondomino(telaBusca);
            telaBusca.setVisible(true);

        } else if (action.getSource() == this.telaCadastroUnidadeCondomino.getjButtonSair()) {
            this.telaCadastroUnidadeCondomino.dispose();
        }
    }
}
