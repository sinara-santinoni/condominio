package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaCadastroCustoNivel1;
import java.util.ArrayList;
import java.util.List;
import condominios.CustoNivel1;

public class ControllerCadastroCustoNivel1 implements ActionListener {

    TelaCadastroCustoNivel1 telaCadastroCustoNivel1;
    private static List<CustoNivel1> lista = new ArrayList<>();

    public static List<CustoNivel1> getLista() {
        return lista;
    }

    public ControllerCadastroCustoNivel1(TelaCadastroCustoNivel1 telaCadastroCustoNivel1) {
        this.telaCadastroCustoNivel1 = telaCadastroCustoNivel1;

        this.telaCadastroCustoNivel1.getjButtonNovo().addActionListener(this);
        this.telaCadastroCustoNivel1.getjButtonCancelar().addActionListener(this);
        this.telaCadastroCustoNivel1.getjButtonGravar().addActionListener(this);
        this.telaCadastroCustoNivel1.getjButtonBuscar().addActionListener(this);
        this.telaCadastroCustoNivel1.getjButtonSair().addActionListener(this);

        utilities.Utilities.AtivaDesativa(this.telaCadastroCustoNivel1.getjPanelbotoes(), true);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaCadastroCustoNivel1.getjButtonNovo()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroCustoNivel1.getjPanelbotoes(), false);
            utilities.Utilities.LimpaComponentes(this.telaCadastroCustoNivel1.getjPanelDados(), true, this.telaCadastroCustoNivel1.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroCustoNivel1.getjButtonCancelar()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroCustoNivel1.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroCustoNivel1.getjPanelDados(), false, this.telaCadastroCustoNivel1.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroCustoNivel1.getjButtonGravar()) {

            CustoNivel1 custoNivel1 = new CustoNivel1();
            custoNivel1.setDescricao(this.telaCadastroCustoNivel1.getjTextFieldDescricao().getText());
            custoNivel1.setTipocc(this.telaCadastroCustoNivel1.getjTextFieldTipoCentroCusto().getText());
            custoNivel1.setObservacao(this.telaCadastroCustoNivel1.getjTextArea1().getText());

            lista.add(custoNivel1);

            utilities.Utilities.AtivaDesativa(this.telaCadastroCustoNivel1.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroCustoNivel1.getjPanelDados(), false, this.telaCadastroCustoNivel1.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroCustoNivel1.getjButtonBuscar()) {
            view.TelaBuscaCustoNivel1 telaBuscaCustoNivel1 = new view.TelaBuscaCustoNivel1(null, true);
            ControllerBuscaCustoNivel1 controllerBuscaCustoNivel1 = new ControllerBuscaCustoNivel1(telaBuscaCustoNivel1);
            telaBuscaCustoNivel1.setVisible(true);

        } else if (action.getSource() == this.telaCadastroCustoNivel1.getjButtonSair()) {
            this.telaCadastroCustoNivel1.dispose();
        }
    }
}
