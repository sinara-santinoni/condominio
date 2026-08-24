package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaCadastroSindicoProfissional;
import java.util.ArrayList;
import java.util.List;
import condominios.SindicoProfissional;

public class ControllerCadastroSindicoProfissional implements ActionListener {

    TelaCadastroSindicoProfissional telaCadastroSindicoProfissional;
    private static List<SindicoProfissional> lista = new ArrayList<>();

    public static List<SindicoProfissional> getLista() {
        return lista;
    }

    public ControllerCadastroSindicoProfissional(TelaCadastroSindicoProfissional telaCadastroSindicoProfissional) {
        this.telaCadastroSindicoProfissional = telaCadastroSindicoProfissional;

        this.telaCadastroSindicoProfissional.getjButtonNovo().addActionListener(this);
        this.telaCadastroSindicoProfissional.getjButtonCancelar().addActionListener(this);
        this.telaCadastroSindicoProfissional.getjButtonGravar().addActionListener(this);
        this.telaCadastroSindicoProfissional.getjButtonBuscar().addActionListener(this);
        this.telaCadastroSindicoProfissional.getjButtonSair().addActionListener(this);

        utilities.Utilities.AtivaDesativa(this.telaCadastroSindicoProfissional.getjPanelbotoes(), true);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaCadastroSindicoProfissional.getjButtonNovo()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroSindicoProfissional.getjPanelbotoes(), false);
            utilities.Utilities.LimpaComponentes(this.telaCadastroSindicoProfissional.getjPanelDados(), true, this.telaCadastroSindicoProfissional.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroSindicoProfissional.getjButtonCancelar()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroSindicoProfissional.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroSindicoProfissional.getjPanelDados(), false, this.telaCadastroSindicoProfissional.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroSindicoProfissional.getjButtonGravar()) {
            SindicoProfissional sindicoProfissional = new SindicoProfissional();
            sindicoProfissional.setNomefantasia(this.telaCadastroSindicoProfissional.getjTextFieldNomeFantasia().getText());
            sindicoProfissional.setRazaosocial(this.telaCadastroSindicoProfissional.getjTextFieldRazaoSocial().getText());
            sindicoProfissional.setCpf(this.telaCadastroSindicoProfissional.getjFormattedTextFieldCPF().getText());
            sindicoProfissional.setRg(this.telaCadastroSindicoProfissional.getjFormattedTextFieldRg().getText());
            sindicoProfissional.setCnpj(this.telaCadastroSindicoProfissional.getjFormattedTextFieldCnpj().getText());
            sindicoProfissional.setFone1(this.telaCadastroSindicoProfissional.getjTextFieldTelefone1().getText());
            sindicoProfissional.setFone2(this.telaCadastroSindicoProfissional.getjTextFieldTelefone2().getText());
            sindicoProfissional.setEmail(this.telaCadastroSindicoProfissional.getjTextFieldEmail().getText());
            sindicoProfissional.setCep(this.telaCadastroSindicoProfissional.getjFormattedTextFieldCep().getText());
            sindicoProfissional.setEstadocivil(String.valueOf(this.telaCadastroSindicoProfissional.getjComboBoxEstadoCivil().getSelectedItem()));
            sindicoProfissional.setLogradouro(this.telaCadastroSindicoProfissional.getjTextFieldLogradouro().getText());
            sindicoProfissional.setCidade(this.telaCadastroSindicoProfissional.getjTextFieldCidade().getText());
            sindicoProfissional.setBairro(this.telaCadastroSindicoProfissional.getjTextFieldBairro().getText());
            sindicoProfissional.setComplemento(this.telaCadastroSindicoProfissional.getjTextFieldComplemento1().getText());
            sindicoProfissional.setObservacao(this.telaCadastroSindicoProfissional.getjTextArea1().getText());
            sindicoProfissional.setCra(this.telaCadastroSindicoProfissional.getjTextFieldCRA().getText());

            lista.add(sindicoProfissional);

            utilities.Utilities.AtivaDesativa(this.telaCadastroSindicoProfissional.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroSindicoProfissional.getjPanelDados(), false, this.telaCadastroSindicoProfissional.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroSindicoProfissional.getjButtonBuscar()) {
            view.TelaBuscaSindicoProfissional telaBusca = new view.TelaBuscaSindicoProfissional(null, true);
            new ControllerBuscaSindicoProfissional(telaBusca);
            telaBusca.setVisible(true);

        } else if (action.getSource() == this.telaCadastroSindicoProfissional.getjButtonSair()) {
            this.telaCadastroSindicoProfissional.dispose();
        }
    }
}
