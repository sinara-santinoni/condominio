package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaCadastroFornecedor;
import java.util.ArrayList;
import java.util.List;
import condominios.Fornecedor;

public class ControllerCadastroFornecedor implements ActionListener {

    TelaCadastroFornecedor telaCadastroFornecedor;
    private static List<Fornecedor> lista = new ArrayList<>();

    public ControllerCadastroFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaCadastroFornecedor = telaCadastroFornecedor;

        this.telaCadastroFornecedor.getjButtonNovo().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonGravar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonSair().addActionListener(this);

        utilities.Utilities.AtivaDesativa(this.telaCadastroFornecedor.getjPanelbotoes(), true);
    }
    public static List<Fornecedor> getLista() {
    return lista;
}

   @Override
public void actionPerformed(ActionEvent action) {
    
    if (action.getSource() == this.telaCadastroFornecedor.getjButtonNovo()) {
        utilities.Utilities.AtivaDesativa(this.telaCadastroFornecedor.getjPanelbotoes(), false);
        utilities.Utilities.LimpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), true, this.telaCadastroFornecedor.getButtonGroup1());
    } else if (action.getSource() == this.telaCadastroFornecedor.getjButtonCancelar()) {
        utilities.Utilities.AtivaDesativa(this.telaCadastroFornecedor.getjPanelbotoes(), true);
        utilities.Utilities.LimpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false, this.telaCadastroFornecedor.getButtonGroup1());
    } else if (action.getSource() == this.telaCadastroFornecedor.getjButtonGravar()) {

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNomefantasia(this.telaCadastroFornecedor.getjTextFieldNomeFantasia().getText());
        fornecedor.setCpf(this.telaCadastroFornecedor.getjFormattedTextFieldCPF().getText());
        fornecedor.setRg(this.telaCadastroFornecedor.getjFormattedTextFieldRg().getText());
        fornecedor.setCnpj(this.telaCadastroFornecedor.getjFormattedTextFieldCnpj().getText());
        fornecedor.setEmail(this.telaCadastroFornecedor.getjTextFieldEmail().getText());
        fornecedor.setFone1(this.telaCadastroFornecedor.getjTextFieldTelefone1().getText());
        fornecedor.setFone2(this.telaCadastroFornecedor.getjTextFieldTelefone2().getText());
        fornecedor.setCidade(this.telaCadastroFornecedor.getjTextFieldCidade().getText());
        fornecedor.setBairro(this.telaCadastroFornecedor.getjTextFieldBairro().getText());
        fornecedor.setLogradouro(this.telaCadastroFornecedor.getjTextFieldLogradouro().getText());
        fornecedor.setComplemento(this.telaCadastroFornecedor.getjTextFieldComplemento().getText());
        fornecedor.setObservacao(this.telaCadastroFornecedor.getjTextArea1().getText());

        lista.add(fornecedor);

        utilities.Utilities.AtivaDesativa(this.telaCadastroFornecedor.getjPanelbotoes(), true);
        utilities.Utilities.LimpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false, this.telaCadastroFornecedor.getButtonGroup1());

    } else if (action.getSource() == this.telaCadastroFornecedor.getjButtonBuscar()) {
        view.TelaBuscaFornecedor telaBuscaFornecedor = new view.TelaBuscaFornecedor(null, true);
        ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
        telaBuscaFornecedor.setVisible(true);
    } else if (action.getSource() == this.telaCadastroFornecedor.getjButtonSair()) {
        this.telaCadastroFornecedor.dispose();
    }
}}