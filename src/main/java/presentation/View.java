package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View {
    private JPanel mainPanel;
    private JPanel panelOptiuni;
    private JButton buttonClient;
    private JButton buttonProduct;
    private JButton buttonOrder;
    private JPanel panelClient;
    private JPanel panelOrder;
    private JButton buttonAdaugareClient;
    private JButton buttonStergereClient;
    private JButton buttonVizualizareClient;
    private JPanel cardClient;
    private JButton buttonInapoiClient;
    private JPanel panelClientAdaugare;
    private JPanel panelClientStergere;
    private JPanel panelClientVizualizare;
    private JTable tableClient;
    private JPanel panelProduct;
    private JButton buttonInapoiProduct;
    private JButton buttonAdaugareProduct;
    private JButton buttonStergereProduct;
    private JButton buttonVizualizareProduct;
    private JPanel cardProduct;
    private JPanel panelProductAdaugare;
    private JPanel panelProductVizualizare;
    private JTable tableProduct;
    private JButton buttonInapoiOrder;
    private JComboBox comboBoxClient;
    private JComboBox comboBoxProduct;
    private JComboBox comboBoxCantitate;
    private JButton buttonAdaugareOrder;
    private JButton buttonconfirmareAdugareC;
    private JTextField textFieldNumeClient;
    private JTextField textFieldAdresaClient;
    private JTextField textFieldIdClient;
    private JButton buttonConfirmareStergereC;
    private JTextField textFieldNumeProd;
    private JTextField textFieldCantitate;
    private JTextField textFieldPret;
    private JButton buttonConfirmareAdaugProd;
    private JPanel panelProductStergere;
    private JButton buttonConfirmareStergereProd;
    private JButton vizualizareComenziButton;
    private JButton buttonActualizareClient;
    private JPanel panelClientActualizare;
    private JTextField txtFieldActualizareNumeClient;
    private JTextField txtFieldAdresaActualizareClient;
    private JButton buttonActualizareProduct;
    private JComboBox JComboBoxIDPRoductActualizare;
    private JTextField txtFieldActualizareNumeProduct;
    private JTextField txtFieldActualizareCantitateProduct;
    private JTextField txtFieldActualizarePretProduct;
    private JButton buttonConfirmareActualizareProduct;
    private JPanel panelProductActualizare;
    private JComboBox JComboBoxIdClientActualizare;
    private JButton buttonConfirmareActualizareClient;
    private JPanel panelAdaugareOrder;
    private JPanel cardOrder;
    private JPanel panelVizualizareOrder;
    private JTable tableVizualizareOrders;
    private JTextField textFieldIdProdusStergere;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getCardClient() {
        return cardClient;
    }

    public JPanel getCardProduct() {
        return cardProduct;
    }

    public JPanel getPanelClient() {
        return panelClient;
    }

    public JPanel getPanelOrder() {
        return panelOrder;
    }

    public JPanel getPanelProduct() {
        return panelProduct;
    }

    public JPanel getPanelOptiuni() {
        return panelOptiuni;
    }

    public JPanel getPanelClientAdaugare() {
        return panelClientAdaugare;
    }

    public JPanel getPanelClientStergere() {
        return panelClientStergere;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTable getTableClient() {
        return tableClient;
    }

    public void setTableClient(JTable tableClient) {
        this.tableClient = tableClient;
    }

    public JButton getButtonClient() {
        return buttonClient;
    }

    public JButton getButtonProduct() {
        return buttonProduct;
    }

    public JButton getButtonOrder() {
        return buttonOrder;
    }

    public JButton getButtonAdaugareClient() {
        return buttonAdaugareClient;
    }

    public JButton getButtonStergereClient() {
        return buttonStergereClient;
    }

    public JButton getButtonVizualizareClient() {
        return buttonVizualizareClient;
    }

    public JButton getButtonInapoiClient() {
        return buttonInapoiClient;
    }

    public JButton getButtonInapoiProduct() {
        return buttonInapoiProduct;
    }

    public JButton getButtonAdaugareProduct() {
        return buttonAdaugareProduct;
    }

    public JButton getButtonStergereProduct() {
        return buttonStergereProduct;
    }

    public JButton getButtonVizualizareProduct() {
        return buttonVizualizareProduct;
    }

    public JButton getButtonInapoiOrder() {
        return buttonInapoiOrder;
    }

    public JComboBox getComboBoxClient() {
        return comboBoxClient;
    }

    public JComboBox getComboBoxProduct() {
        return comboBoxProduct;
    }

    public JComboBox getComboBoxCant() {
        return comboBoxCantitate;
    }

    public void setPanelOptiuni(JPanel panelOptiuni) {
        this.panelOptiuni = panelOptiuni;
    }

    public void setButtonClient(JButton buttonClient) {
        this.buttonClient = buttonClient;
    }

    public void setButtonProduct(JButton buttonProduct) {
        this.buttonProduct = buttonProduct;
    }

    public void setButtonOrder(JButton buttonOrder) {
        this.buttonOrder = buttonOrder;
    }

    public void setPanelClient(JPanel panelClient) {
        this.panelClient = panelClient;
    }

    public void setPanelOrder(JPanel panelOrder) {
        this.panelOrder = panelOrder;
    }

    public void setButtonAdaugareClient(JButton buttonAdaugareClient) {
        this.buttonAdaugareClient = buttonAdaugareClient;
    }

    public void setButtonStergereClient(JButton buttonStergereClient) {
        this.buttonStergereClient = buttonStergereClient;
    }

    public void setButtonVizualizareClient(JButton buttonVizualizareClient) {
        this.buttonVizualizareClient = buttonVizualizareClient;
    }

    public void setCardClient(JPanel cardClient) {
        this.cardClient = cardClient;
    }

    public void setButtonInapoiClient(JButton buttonInapoiClient) {
        this.buttonInapoiClient = buttonInapoiClient;
    }

    public void setPanelClientAdaugare(JPanel panelClientAdaugare) {
        this.panelClientAdaugare = panelClientAdaugare;
    }

    public void setPanelClientStergere(JPanel panelClientStergere) {
        this.panelClientStergere = panelClientStergere;
    }

    public void setPanelClientVizualizare(JPanel panelClientVizualizare) {
        this.panelClientVizualizare = panelClientVizualizare;
    }

    public void setPanelProduct(JPanel panelProduct) {
        this.panelProduct = panelProduct;
    }

    public void setButtonInapoiProduct(JButton buttonInapoiProduct) {
        this.buttonInapoiProduct = buttonInapoiProduct;
    }

    public void setButtonAdaugareProduct(JButton buttonAdaugareProduct) {
        this.buttonAdaugareProduct = buttonAdaugareProduct;
    }

    public void setButtonStergereProduct(JButton buttonStergereProduct) {
        this.buttonStergereProduct = buttonStergereProduct;
    }

    public void setButtonVizualizareProduct(JButton buttonVizualizareProduct) {
        this.buttonVizualizareProduct = buttonVizualizareProduct;
    }

    public void setCardProduct(JPanel cardProduct) {
        this.cardProduct = cardProduct;
    }

    public void setPanelProductAdaugare(JPanel panelProductAdaugare) {
        this.panelProductAdaugare = panelProductAdaugare;
    }

    public void setPanelProductVizualizare(JPanel panelProductVizualizare) {
        this.panelProductVizualizare = panelProductVizualizare;
    }

    public void setButtonInapoiOrder(JButton buttonInapoiOrder) {
        this.buttonInapoiOrder = buttonInapoiOrder;
    }

    public void setComboBoxClient(JComboBox comboBoxClient) {
        this.comboBoxClient = comboBoxClient;
    }

    public void setComboBoxProduct(JComboBox comboBoxProduct) {
        this.comboBoxProduct = comboBoxProduct;
    }

    public void setComboBoxCant(JComboBox comboBoxCant) {
        this.comboBoxCantitate = comboBoxCant;
    }

    public void setButtonAdaugareOrder(JButton buttonAdaugareOrder) {
        this.buttonAdaugareOrder = buttonAdaugareOrder;
    }

    public void setButtonconfirmareAdugareC(JButton buttonconfirmareAdugareC) {
        this.buttonconfirmareAdugareC = buttonconfirmareAdugareC;
    }

    public void setTextFieldNumeClient(JTextField textFieldNumeClient) {
        this.textFieldNumeClient = textFieldNumeClient;
    }

    public void setTextFieldAdresaClient(JTextField textFieldAdresaClient) {
        this.textFieldAdresaClient = textFieldAdresaClient;
    }

    public void setTextFieldIdClient(JTextField textFieldIdClient) {
        this.textFieldIdClient = textFieldIdClient;
    }

    public void setButtonConfirmareStergereC(JButton buttonConfirmareStergereC) {
        this.buttonConfirmareStergereC = buttonConfirmareStergereC;
    }

    public void setTextFieldNumeProd(JTextField textFieldNumeProd) {
        this.textFieldNumeProd = textFieldNumeProd;
    }

    public void setTextFieldCantitate(JTextField textFieldCantitate) {
        this.textFieldCantitate = textFieldCantitate;
    }

    public void setTextFieldPret(JTextField textFieldPret) {
        this.textFieldPret = textFieldPret;
    }

    public void setButtonConfirmareAdaugProd(JButton buttonConfirmareAdaugProd) {
        this.buttonConfirmareAdaugProd = buttonConfirmareAdaugProd;
    }

    public void setPanelProductStergere(JPanel panelProductStergere) {
        this.panelProductStergere = panelProductStergere;
    }

    public void setButtonConfirmareStergereProd(JButton buttonConfirmareStergereProd) {
        this.buttonConfirmareStergereProd = buttonConfirmareStergereProd;
    }

    public void setVizualizareComenziButton(JButton vizualizareComenziButton) {
        this.vizualizareComenziButton = vizualizareComenziButton;
    }

    public JButton getButtonActualizareClient() {
        return buttonActualizareClient;
    }

    public void setButtonActualizareClient(JButton buttonActualizareClient) {
        this.buttonActualizareClient = buttonActualizareClient;
    }

    public JPanel getPanelClientActualizare() {
        return panelClientActualizare;
    }

    public void setPanelClientActualizare(JPanel panelClientActualizare) {
        this.panelClientActualizare = panelClientActualizare;
    }

    public JTextField getTxtFieldActualizareNumeClient() {
        return txtFieldActualizareNumeClient;
    }

    public void setTxtFieldActualizareNumeClient(JTextField txtFieldActualizareNumeClient) {
        this.txtFieldActualizareNumeClient = txtFieldActualizareNumeClient;
    }

    public JTextField getTxtFieldAdresaActualizareClient() {
        return txtFieldAdresaActualizareClient;
    }

    public void setTxtFieldAdresaActualizareClient(JTextField txtFieldAdresaActualizareClient) {
        this.txtFieldAdresaActualizareClient = txtFieldAdresaActualizareClient;
    }

    public JButton getButtonActualizareProduct() {
        return buttonActualizareProduct;
    }

    public void setButtonActualizareProduct(JButton buttonActualizareProduct) {
        this.buttonActualizareProduct = buttonActualizareProduct;
    }

    public JComboBox getJComboBoxIDPRoductActualizare() {
        return JComboBoxIDPRoductActualizare;
    }

    public void setJComboBoxIDPRoductActualizare(JComboBox JComboBoxIDPRoductActualizare) {
        this.JComboBoxIDPRoductActualizare = JComboBoxIDPRoductActualizare;
    }

    public JTextField getTxtFieldActualizareNumeProduct() {
        return txtFieldActualizareNumeProduct;
    }

    public void setTxtFieldActualizareNumeProduct(JTextField txtFieldActualizareNumeProduct) {
        this.txtFieldActualizareNumeProduct = txtFieldActualizareNumeProduct;
    }

    public JTextField getTxtFieldActualizareCantitateProduct() {
        return txtFieldActualizareCantitateProduct;
    }

    public void setTxtFieldActualizareCantitateProduct(JTextField txtFieldActualizareCantitateProduct) {
        this.txtFieldActualizareCantitateProduct = txtFieldActualizareCantitateProduct;
    }

    public JTextField getTxtFieldActualizarePretProduct() {
        return txtFieldActualizarePretProduct;
    }

    public void setTxtFieldActualizarePretProduct(JTextField txtFieldActualizarePretProduct) {
        this.txtFieldActualizarePretProduct = txtFieldActualizarePretProduct;
    }

    public JButton getButtonConfrmareActualizareProduct() {
        return buttonConfirmareActualizareProduct;
    }

    public void setButtonConfrmareActualizareProduct(JButton buttonConfrmareActualizareProduct) {
        this.buttonConfirmareActualizareProduct = buttonConfrmareActualizareProduct;
    }

    public JPanel getPanelProductActualizare() {
        return panelProductActualizare;
    }

    public void setPanelProductActualizare(JPanel panelProductActualizare) {
        this.panelProductActualizare = panelProductActualizare;
    }

    public JComboBox getJComboBoxIdClientActualizare() {
        return JComboBoxIdClientActualizare;
    }

    public void setJComboBoxIdClientActualizare(JComboBox JComboBoxIdClientActualizare) {
        this.JComboBoxIdClientActualizare = JComboBoxIdClientActualizare;
    }

    public JButton getButtonAdaugareOrder() {
        return buttonAdaugareOrder;
    }

    public JButton getButtonconfirmareAdugareC() {
        return buttonconfirmareAdugareC;
    }

    public JTextField getTextFieldNumeClient() {
        return textFieldNumeClient;
    }

    public JTextField getTextFieldAdresaClient() {
        return textFieldAdresaClient;
    }

    public JTextField getTextFieldIdClient() {
        return textFieldIdClient;
    }

    public JButton getButtonConfirmareStergereC() {
        return buttonConfirmareStergereC;
    }

    public JTextField getTextFieldNumeProd() {
        return textFieldNumeProd;
    }

    public JTextField getTextFieldCantitate() {
        return textFieldCantitate;
    }

    public JTextField getTextFieldPret() {
        return textFieldPret;
    }

    public JButton getButtonConfirmareAdaugProd() {
        return buttonConfirmareAdaugProd;
    }

    public JButton getButtonConfirmareStergereProd() {
        return buttonConfirmareStergereProd;
    }

    public JButton getVizualizareComenziButton() {
        return vizualizareComenziButton;
    }

    public JTable getTableProduct() {
        return tableProduct;
    }

    public void setTableProduct(JTable tableProduct) {
        this.tableProduct = tableProduct;
    }

    public JPanel getPanelClientVizualizare() {
        return panelClientVizualizare;
    }

    public JPanel getPanelProductAdaugare() {
        return panelProductAdaugare;
    }

    public JPanel getPanelProductVizualizare() {
        return panelProductVizualizare;
    }

    public JPanel getPanelProductStergere() {
        return panelProductStergere;
    }

    public JButton getButtonConfirmareActualizareClient() {
        return buttonConfirmareActualizareClient;
    }

    public JPanel getPanelAdaugareOrder() {
        return panelAdaugareOrder;
    }

    public JPanel getCardOrder() {
        return cardOrder;
    }

    public JPanel getPanelVizualizareOrder() {
        return panelVizualizareOrder;
    }

    public JTable getTableVizualizareOrders() {
        return tableVizualizareOrders;
    }

    public JComboBox getComboBoxCantitate() {
        return comboBoxCantitate;
    }

    public void setComboBoxCantitate(JComboBox comboBoxCantitate) {
        this.comboBoxCantitate = comboBoxCantitate;
    }

    public void setButtonConfirmareActualizareClient(JButton buttonConfirmareActualizareClient) {
        this.buttonConfirmareActualizareClient = buttonConfirmareActualizareClient;
    }

    public void setPanelAdaugareOrder(JPanel panelAdaugareOrder) {
        this.panelAdaugareOrder = panelAdaugareOrder;
    }

    public void setCardOrder(JPanel cardOrder) {
        this.cardOrder = cardOrder;
    }

    public void setPanelVizualizareOrder(JPanel panelVizualizareOrder) {
        this.panelVizualizareOrder = panelVizualizareOrder;
    }

    public void setTableVizualizareOrders(JTable tableVizualizareOrders) {
        this.tableVizualizareOrders = tableVizualizareOrders;
    }

    public JTextField getTextFieldIdProdusStergere() {
        return textFieldIdProdusStergere;
    }

    public void setTextFieldIdProdusStergere(JTextField textFieldIdProdusStergere) {
        this.textFieldIdProdusStergere = textFieldIdProdusStergere;
    }

    public void addbuttonClientListener(ActionListener mal){buttonClient.addActionListener(mal);}
    public void addbuttonProductListener(ActionListener mal){buttonProduct.addActionListener(mal);}
    public void addbuttonOrderListener(ActionListener mal){buttonOrder.addActionListener(mal);}
    public void addbuttonInapoiClientListener(ActionListener mal){buttonInapoiClient.addActionListener(mal);}
    public void addbuttonInapoiProductListener(ActionListener mal){buttonInapoiProduct.addActionListener(mal);}
    public void addbuttonInapoiOrderListener(ActionListener mal){buttonInapoiOrder.addActionListener(mal);}
    public void addbuttonVizualizareClientListener(ActionListener mal){buttonVizualizareClient.addActionListener(mal);}
    public void addbuttonVizualizareProductListener(ActionListener mal){buttonVizualizareProduct.addActionListener(mal);}
    public void addbuttonStergereClientListener(ActionListener mal){buttonStergereClient.addActionListener(mal);}
    public void addbuttonStergereProductListener(ActionListener mal){buttonStergereProduct.addActionListener(mal);}
    public void addbuttonAdaugareClientListener(ActionListener mal){buttonAdaugareClient.addActionListener(mal);}
    public void addbuttonAdaugareProductListener(ActionListener mal){buttonAdaugareProduct.addActionListener(mal);}
    public void addbuttonConfirmareAdaugareCListener(ActionListener mal){buttonconfirmareAdugareC.addActionListener(mal);}
    public void addbuttonConfirmareStergreCListener(ActionListener mal){buttonConfirmareStergereC.addActionListener(mal);}
    public void addbuttonConfirmareAdaugareProdListener(ActionListener mal){buttonConfirmareAdaugProd.addActionListener(mal);}
    public void addbuttonConfirmareStergreProdListener(ActionListener mal){buttonConfirmareStergereProd.addActionListener(mal);}
    public void addbuttonActualizareClientListener(ActionListener mal){buttonActualizareClient.addActionListener(mal);}
    public void addbuttonActualizareProductListener(ActionListener mal){buttonActualizareProduct.addActionListener(mal);}
    public void addbuttonConfirmareActualizareCListener(ActionListener mal){buttonConfirmareActualizareClient.addActionListener(mal);}
    public void addbuttonConfirmareActualizareProdListener(ActionListener mal){buttonConfirmareActualizareProduct.addActionListener(mal);}
    public void addbuttonAdaugareOrderListener(ActionListener mal){buttonAdaugareOrder.addActionListener(mal);}
    public void addbuttonVizualizareOrder(ActionListener mal){vizualizareComenziButton.addActionListener(mal);}

}
