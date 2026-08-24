package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import condominios.Edificio;
import view.TelaCadastroEdificio_1;

public class ControllerCadastroEdificio implements ActionListener {

    TelaCadastroEdificio_1 telaCadastroEdificio;

    private static List<Edificio> lista = new ArrayList<>();

    public ControllerCadastroEdificio(TelaCadastroEdificio_1 telaCadastroEdificio) {

        this.telaCadastroEdificio = telaCadastroEdificio;

        this.telaCadastroEdificio.getjButtonNovo().addActionListener(this);
        this.telaCadastroEdificio.getjButtonCancelar().addActionListener(this);
        this.telaCadastroEdificio.getjButtonGravar().addActionListener(this);
        this.telaCadastroEdificio.getjButtonBuscar().addActionListener(this);
        this.telaCadastroEdificio.getjButtonSair().addActionListener(this);

        utilities.Utilities.AtivaDesativa(
                this.telaCadastroEdificio.getjPanelbotoes(), true);
    }

    public static List<Edificio> getLista() {
        return lista;
    }

    @Override
    public void actionPerformed(ActionEvent action) {

        if (action.getSource() == this.telaCadastroEdificio.getjButtonNovo()) {

            utilities.Utilities.AtivaDesativa(
                    this.telaCadastroEdificio.getjPanelbotoes(), false);

            utilities.Utilities.LimpaComponentes(
                    this.telaCadastroEdificio.getjPanelDados(),
                    true,
                    this.telaCadastroEdificio.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroEdificio.getjButtonCancelar()) {

            utilities.Utilities.AtivaDesativa(
                    this.telaCadastroEdificio.getjPanelbotoes(), true);

            utilities.Utilities.LimpaComponentes(
                    this.telaCadastroEdificio.getjPanelDados(),
                    false,
                    this.telaCadastroEdificio.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroEdificio.getjButtonGravar()) {

            try {

                Edificio edificio = new Edificio();

                edificio.setNome(
                        this.telaCadastroEdificio.getjTextFieldNome().getText());

                edificio.setAnolancamento(
                        Integer.parseInt(
                                this.telaCadastroEdificio.getjTextFieldAnoLancamento().getText()));

                edificio.setAreatotal(
                        Float.parseFloat(
                                this.telaCadastroEdificio.getjTextFieldAreaTotal().getText()));

                edificio.setQuantidadeandares(
                        Integer.parseInt(
                                this.telaCadastroEdificio.getjTextFieldNumeroAndares().getText()));

                edificio.setQuantidadeunidades(
                        Integer.parseInt(
                                this.telaCadastroEdificio.getjTextFieldNumeroUnidades().getText()));

                edificio.setCnpj(
                        this.telaCadastroEdificio.getjFormattedTextFieldCnpj().getText());

                edificio.setNumerounidadegas(
                        this.telaCadastroEdificio.getjTextFieldUnidadeGas().getText());

                edificio.setNumerounidadeagua(
                        this.telaCadastroEdificio.getjTextFieldUnidadeAgua().getText());

                if (this.telaCadastroEdificio.getjRadioButtonRateioPorUnidade().isSelected()) {
                    edificio.setFormulacalculo("Por Unidade");
                } else if (this.telaCadastroEdificio.getjRadioButtonRateioPorM2().isSelected()) {
                    edificio.setFormulacalculo("Por m²");
                }

                edificio.setCep(
                        this.telaCadastroEdificio.getjFormattedTextFieldCep().getText());

                edificio.setCidade(
                        this.telaCadastroEdificio.getjTextFieldCidade().getText());

                edificio.setBairro(
                        this.telaCadastroEdificio.getjTextFieldBairro().getText());

                edificio.setLogradouro(
                        this.telaCadastroEdificio.getjTextFieldLogradouro().getText());

                edificio.setComplemento(
                        this.telaCadastroEdificio.getjTextFieldComplemento().getText());

                edificio.setObservacao(
                        this.telaCadastroEdificio.getjTextArea1().getText());

                lista.add(edificio);

                utilities.Utilities.AtivaDesativa(
                        this.telaCadastroEdificio.getjPanelbotoes(), true);

                utilities.Utilities.LimpaComponentes(
                        this.telaCadastroEdificio.getjPanelDados(),
                        false,
                        this.telaCadastroEdificio.getButtonGroup1());

            } catch (NumberFormatException erro) {
                javax.swing.JOptionPane.showMessageDialog(
                        this.telaCadastroEdificio,
                        "Preencha corretamente todos os campos obrigatórios antes de gravar.",
                        "Dados incompletos",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
            }

        } else if (action.getSource() == this.telaCadastroEdificio.getjButtonBuscar()) {

            view.TelaBuscaEdificio telaBuscaEdificio = new view.TelaBuscaEdificio(null, true);
            ControllerBuscaEdificio controllerBuscaEdificio = new ControllerBuscaEdificio(telaBuscaEdificio);
            telaBuscaEdificio.setVisible(true);

        } else if (action.getSource() == this.telaCadastroEdificio.getjButtonSair()) {

            this.telaCadastroEdificio.dispose();
        }
    }
}