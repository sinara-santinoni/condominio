package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaCadastroProprietario;
import java.util.ArrayList;
import java.util.List;
import condominios.Proprietario;

public class ControllerCadastroProprietario implements ActionListener {

    TelaCadastroProprietario telaCadastroProprietario;
    private static List<Proprietario> lista = new ArrayList<>();

    public static List<Proprietario> getLista() {
        return lista;
    }

    public ControllerCadastroProprietario(TelaCadastroProprietario telaCadastroProprietario) {
        this.telaCadastroProprietario = telaCadastroProprietario;

        this.telaCadastroProprietario.getjButtonNovo().addActionListener(this);
        this.telaCadastroProprietario.getjButtonCancelar().addActionListener(this);
        this.telaCadastroProprietario.getjButtonGravar().addActionListener(this);
        this.telaCadastroProprietario.getjButtonBuscar().addActionListener(this);
        this.telaCadastroProprietario.getjButtonSair().addActionListener(this);

        utilities.Utilities.AtivaDesativa(this.telaCadastroProprietario.getjPanelbotoes(), true);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.telaCadastroProprietario.getjButtonNovo()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroProprietario.getjPanelbotoes(), false);
            utilities.Utilities.LimpaComponentes(this.telaCadastroProprietario.getjPanelDados(), true, this.telaCadastroProprietario.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroProprietario.getjButtonCancelar()) {

            utilities.Utilities.AtivaDesativa(this.telaCadastroProprietario.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroProprietario.getjPanelDados(), false, this.telaCadastroProprietario.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroProprietario.getjButtonGravar()) {
            Proprietario proprietario = new Proprietario();
            proprietario.setNomefantasia(this.telaCadastroProprietario.getjTextFieldNomeFantasia().getText());
            proprietario.setRazaosocial(this.telaCadastroProprietario.getjTextFieldRazaoSocial().getText());
            proprietario.setCpf(this.telaCadastroProprietario.getjFormattedTextFieldCPF().getText());
            proprietario.setRg(this.telaCadastroProprietario.getjFormattedTextFieldRg().getText());
            proprietario.setCnpj(this.telaCadastroProprietario.getjFormattedTextFieldCnpj().getText());
            proprietario.setFone1(this.telaCadastroProprietario.getjTextFieldTelefone1().getText());
            proprietario.setFone2(this.telaCadastroProprietario.getjTextFieldTelefone2().getText());
            proprietario.setEmail(this.telaCadastroProprietario.getjTextFieldEmail().getText());
            proprietario.setCep(this.telaCadastroProprietario.getjFormattedTextFieldCep().getText());
            proprietario.setEstadocivil(String.valueOf(this.telaCadastroProprietario.getjComboBoxEstadoCivil().getSelectedItem()));
            proprietario.setLogradouro(this.telaCadastroProprietario.getjTextFieldLogradouro().getText());
            proprietario.setCidade(this.telaCadastroProprietario.getjTextFieldCidade().getText());
            proprietario.setBairro(this.telaCadastroProprietario.getjTextFieldBairro().getText());
            proprietario.setComplemento(this.telaCadastroProprietario.getjTextFieldComplemento().getText());
            proprietario.setObservacao(this.telaCadastroProprietario.getjTextArea1().getText());

            lista.add(proprietario);

            utilities.Utilities.AtivaDesativa(this.telaCadastroProprietario.getjPanelbotoes(), true);
            utilities.Utilities.LimpaComponentes(this.telaCadastroProprietario.getjPanelDados(), false, this.telaCadastroProprietario.getButtonGroup1());

        } else if (action.getSource() == this.telaCadastroProprietario.getjButtonBuscar()) {
            view.TelaBuscaProprietario telaBusca = new view.TelaBuscaProprietario(null, true);
            new ControllerBuscaProprietario(telaBusca);
            telaBusca.setVisible(true);

        } else if (action.getSource() == this.telaCadastroProprietario.getjButtonSair()) {
            this.telaCadastroProprietario.dispose();
        }
    }
}
