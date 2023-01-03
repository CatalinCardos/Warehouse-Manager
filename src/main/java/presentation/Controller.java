package presentation;

import businesslogic.ClientBLL;
import businesslogic.OrderBLL;
import businesslogic.ProductBLL;
import model.Client;
import model.Order;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class Controller {
    private View view;
    private JFrame frame;
    private ClientBLL clientBLL;
    private ProductBLL productBLL;
    private OrderBLL orderBLL;
    public Controller(View view) {
        this.view = view;
        clientBLL = new ClientBLL();
        productBLL = new ProductBLL();
        orderBLL = new OrderBLL();
        view.addbuttonClientListener(new ButtonClient());
        view.addbuttonProductListener(new ButtonProduct());
        view.addbuttonOrderListener(new ButtonOrder());
        view.addbuttonInapoiClientListener(new ButtonInapoiClient());
        view.addbuttonInapoiProductListener(new ButtonInapoiProduct());
        view.addbuttonInapoiOrderListener(new ButtonInapoiOrder());
        view.addbuttonVizualizareClientListener(new ButtonVizualizareClient());
        view.addbuttonVizualizareProductListener(new ButtonVizualizareProduct());
        view.addbuttonStergereClientListener(new ButtonStergereClient());
        view.addbuttonStergereProductListener(new ButtonStergereProduct());
        view.addbuttonAdaugareClientListener(new ButtonAdaugareClient());
        view.addbuttonAdaugareProductListener(new ButtonAdaugareProduct());
        view.addbuttonConfirmareAdaugareCListener(new ButtonConfirmareAdaugareClient());
        view.addbuttonConfirmareAdaugareProdListener(new ButtonConfirmareAdaugareProduct());
        view.addbuttonConfirmareStergreCListener(new ButtonConfirmareStergereClient());
        view.addbuttonConfirmareStergreProdListener(new ButtonConfirmareStergereProduct());
        view.addbuttonActualizareClientListener(new ButtonActualizareClient());
        view.addbuttonActualizareProductListener(new ButtonActualizareProduct());
        view.addbuttonConfirmareActualizareCListener(new ButtonConfirmareActualizareClient());
        view.addbuttonConfirmareActualizareProdListener(new ButtonConfirmareActualizareProduct());
        view.addbuttonAdaugareOrderListener(new ButtonAdaugareOrder());
        view.addbuttonVizualizareOrder(new ButtonVizualizareOrder());

        frame = new JFrame("Shop");
        frame.setContentPane(view.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    class ButtonVizualizareOrder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardOrder().removeAll();
            view.getCardOrder().add(view.getPanelVizualizareOrder());
            view.getCardOrder().repaint();
            view.getCardOrder().validate();
            DefaultTableModel model3 = new DefaultTableModel();
            model3.addColumn("IDOrder");
            model3.addColumn("Client");
            model3.addColumn("Produs");
            model3.addColumn("Cantitate");
            view.getTableVizualizareOrders().setModel(model3);
            view.getTableVizualizareOrders().setRowHeight(30);
            view.getTableVizualizareOrders().setFillsViewportHeight(true);
            view.getTableVizualizareOrders().setVisible(true);

            List<Order> orders = orderBLL.findALL();
            for (Order aux : orders) {
                Vector<String> stringVector = new Vector<>();
                stringVector.add(String.valueOf(aux.getIdOrder()));
                Client client = clientBLL.findbyId(aux.getIdCLient());
                Product product = productBLL.findbyId(aux.getIdProduct());
                stringVector.add(String.valueOf(client.getNume()));
                stringVector.add(String.valueOf(product.getNume()));
                    stringVector.add(String.valueOf(aux.getCantitate()));
                    model3.addRow(stringVector);


            }
        }
    }
    class ButtonAdaugareOrder implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String clientNume = (String) view.getComboBoxClient().getSelectedItem();
            String productNume = (String) view.getComboBoxProduct().getSelectedItem();
            Integer cantitate = Integer.valueOf(view.getComboBoxCant().getSelectedItem().toString());
            Order order = new Order();
            Client client = clientBLL.findByNume(clientNume);
            Product product = productBLL.findbyNume(productNume);
            order.setIdCLient(client.getIdClient());
            order.setIdProduct(product.getIdProduct());
            order.setCantitate( cantitate);
            if(product.getCantitate() > cantitate){
                orderBLL.insertOrder(order);
                product.setCantitate(product.getCantitate() - cantitate);
                productBLL.update(product);
                try{
                    FileWriter fw = new FileWriter("C:\\Users\\catal\\Desktop\\chitanta.txt");
                    StringBuilder sb = new StringBuilder();
                    sb.append(product.getNume());
                    sb.append("\n");
                    sb.append(cantitate * product.getPret());
                    sb.append("\nPentru:");
                    sb.append(clientNume);
                    fw.write(sb.toString());
                    fw.close();
                }catch(Exception a){System.out.println(a);}
            }
            else
            {
                JOptionPane.showMessageDialog(view.getMainPanel(),"Nu avem cantitatea disponibila la acest produs!");
            }

        }
    }

    class ButtonActualizareProduct implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getJComboBoxIDPRoductActualizare().removeAll();
            view.getCardProduct().removeAll();
            view.getCardProduct().add(view.getPanelProductActualizare());
            view.getCardProduct().repaint();
            view.getCardProduct().validate();
            List<Product> products;
            products = productBLL.findALL();
            for (Product aux : products) {
                view.getJComboBoxIDPRoductActualizare().addItem(aux.getIdProduct());

            }
        }
    }
    class ButtonActualizareClient implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getJComboBoxIdClientActualizare().removeAll();
            view.getCardClient().removeAll();
            view.getCardClient().add(view.getPanelClientActualizare());
            view.getCardClient().repaint();
            view.getCardClient().validate();
            List<Client> clients = new ArrayList<>();
            clients = clientBLL.findALL();
            for (Client aux: clients) {
                view.getJComboBoxIdClientActualizare().addItem(aux.getIdClient());
            }
        }
    }
    class ButtonConfirmareActualizareProduct implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Product> products = new ArrayList<>();
            products = productBLL.findALL();
            int idProduct = Integer.parseInt(view.getJComboBoxIDPRoductActualizare().getSelectedItem().toString());
            String nume = view.getTxtFieldActualizareNumeProduct().getText();
            String aux2 = view.getTxtFieldActualizareCantitateProduct().getText();
            int pret,cantitate;
            if(Objects.equals(aux2, ""))
            {
                 cantitate = 0;
            }
            else
            {
                 cantitate = Integer.parseInt(view.getTxtFieldActualizareCantitateProduct().getText());
            }
            aux2 = view.getTxtFieldActualizarePretProduct().getText();
            if(aux2 == "")
            {
                pret = 0;
            }
            else
            {
                 pret = Integer.parseInt(view.getTxtFieldActualizarePretProduct().getText());
            }

            Product theProduct = null;
            for (Product aux: products) {
                if(aux.getIdProduct() == idProduct)
                {
                    theProduct = aux;
                    break;
                }
            }
            if(Objects.equals(nume, ""))
            {
                nume = theProduct.getNume();
            }
            if(cantitate == 0)
            {
                cantitate = theProduct.getCantitate();
            }
            if(pret == 0)
            {
                pret = theProduct.getPret();
            }
            theProduct.setPret(pret);
            theProduct.setNume(nume);
            theProduct.setCantitate(cantitate);
            productBLL.update(theProduct);
            view.getTxtFieldActualizareCantitateProduct().setText("");
            view.getTxtFieldActualizarePretProduct().setText("");
            view.getTxtFieldActualizareNumeProduct().setText("");

        }
    }
    class ButtonConfirmareActualizareClient implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Client> clients = new ArrayList<>();
            clients = clientBLL.findALL();
            int idClient = Integer.parseInt(view.getJComboBoxIdClientActualizare().getSelectedItem().toString());
            String nume = view.getTxtFieldActualizareNumeClient().getText();
            String adresa = view.getTxtFieldAdresaActualizareClient().getText();
            Client theClient = null;
            for (Client aux: clients) {
                if(aux.getIdClient() == idClient)
                {
                    theClient = aux;
                    break;
                }
            }
            if(Objects.equals(nume, ""))
            {
                nume = theClient.getNume();
            }
            if(Objects.equals(adresa, ""))
            {
                adresa = theClient.getAdresa();
            }
            theClient.setAdresa(adresa);
            theClient.setNume(nume);
            clientBLL.update(theClient);
            view.getTxtFieldActualizareNumeClient().setText("");
            view.getTxtFieldAdresaActualizareClient().setText("");
        }
    }
    class ButtonConfirmareStergereClient implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String aux = view.getTextFieldIdClient().getText();
            int idDeleteClient = Integer.parseInt(view.getTextFieldIdClient().getText());
            Field[] allFields = Client.class.getDeclaredFields();
            orderBLL.delete(idDeleteClient,allFields[0].getName());
            clientBLL.delete(idDeleteClient,allFields[0].getName());
        }
    }
    class ButtonConfirmareStergereProduct implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String aux = view.getTextFieldIdProdusStergere().getText();
            int idDeleteProd = Integer.parseInt(view.getTextFieldIdProdusStergere().getText());
            Field[] allFields = Product.class.getDeclaredFields();
            orderBLL.delete(idDeleteProd,allFields[0].getName());
            productBLL.delete(idDeleteProd,allFields[0].getName());
        }
    }
    class ButtonConfirmareAdaugareClient implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String name = view.getTextFieldNumeClient().getText();
            String adresa = view.getTextFieldAdresaClient().getText();
            Client client = new Client();
            client.setNume(name);
            client.setAdresa(adresa);
            view.getTextFieldNumeClient().setText("");
            view.getTextFieldAdresaClient().setText("");
            clientBLL.insertClient(client);

        }
    }
    class ButtonConfirmareAdaugareProduct implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getTextFieldNumeProd().getText();
            int cantitate = Integer.parseInt(view.getTextFieldCantitate().getText());
            int pret = Integer.parseInt(view.getTextFieldPret().getText());
            Product product = new Product();
            product.setNume(name);
            product.setCantitate(cantitate);
            product.setPret(pret);
            view.getTextFieldNumeProd().setText("");
            view.getTextFieldCantitate().setText("");
            view.getTextFieldPret().setText("");
            productBLL.insertProduct(product);
        }
    }
    class ButtonAdaugareClient implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardClient().removeAll();
            view.getCardClient().add(view.getPanelClientAdaugare());
            view.getCardClient().repaint();
            view.getCardClient().validate();

        }
    }
    class ButtonAdaugareProduct implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardProduct().removeAll();
            view.getCardProduct().add(view.getPanelProductAdaugare());
            view.getCardProduct().repaint();
            view.getCardProduct().validate();

        }
    }
    class ButtonStergereProduct implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardProduct().removeAll();
            view.getCardProduct().add(view.getPanelProductStergere());
            view.getCardProduct().repaint();
            view.getCardProduct().validate();
        }
    }
    class ButtonStergereClient implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardClient().removeAll();
            view.getCardClient().add(view.getPanelClientStergere());
            view.getCardClient().repaint();
            view.getCardClient().validate();
            view.getTextFieldIdClient().setText("");
        }
    }
    class ButtonVizualizareClient implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardClient().removeAll();
            view.getCardClient().add(view.getPanelClientVizualizare());
            view.getCardClient().repaint();
            view.getCardClient().validate();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nume");
            model.addColumn("Adresa");
            view.getTableClient().setModel(model);
            view.getTableClient().setRowHeight(30);
            view.getTableClient().setFillsViewportHeight(true);
            view.getTableClient().setVisible(true);


            List<Client> clients = clientBLL.findALL();
            for (Client aux: clients) {
                Vector<String> clientsVector = new Vector<>();
                clientsVector.add(String.valueOf(aux.getIdClient()));
                clientsVector.add(aux.getNume());
                clientsVector.add(aux.getAdresa());
                model.addRow(clientsVector);
            }


        }
    }
    class ButtonVizualizareProduct implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardProduct().removeAll();
            view.getCardProduct().add(view.getPanelProductVizualizare());
            view.getCardProduct().repaint();
            view.getCardProduct().validate();
            DefaultTableModel model2 = new DefaultTableModel();
            model2.addColumn("ID");
            model2.addColumn("Nume");
            model2.addColumn("Cantitate");
            model2.addColumn("Pret");
            view.getTableProduct().setModel(model2);
            view.getTableProduct().setRowHeight(30);
            view.getTableProduct().setFillsViewportHeight(true);
            view.getTableProduct().setVisible(true);


            List<Product> products = productBLL.findALL();
            for (Product aux: products) {
                Vector<String> productVector = new Vector<>();
                productVector.add(String.valueOf(aux.getIdProduct()));
                productVector.add(aux.getNume());
                productVector.add(String.valueOf(aux.getCantitate()));
                productVector.add(String.valueOf(aux.getPret()));
                model2.addRow(productVector);
            }

        }
    }
    class ButtonClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getMainPanel().removeAll();
            view.getMainPanel().add(view.getPanelClient());
            view.getMainPanel().repaint();
            view.getMainPanel().validate();
        }
    }
    class ButtonProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getMainPanel().removeAll();
            view.getMainPanel().add(view.getPanelProduct());
            view.getMainPanel().repaint();
            view.getMainPanel().validate();
        }
    }
    class ButtonOrder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getComboBoxClient().removeAll();
            view.getComboBoxCant().removeAll();
            view.getComboBoxProduct().removeAll();
            view.getMainPanel().removeAll();
            view.getMainPanel().add(view.getPanelOrder());
            view.getMainPanel().repaint();
            view.getMainPanel().validate();
            view.getCardOrder().add(view.getPanelVizualizareOrder());
            List<Client> clients = clientBLL.findALL();
            List<Product> products = productBLL.findALL();
            for (Client aux: clients) {
                view.getComboBoxClient().addItem(aux.getNume());
            }
            for (Product aux: products) {
                view.getComboBoxProduct().addItem(aux.getNume());
            }
        }
    }
    class ButtonInapoiClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getMainPanel().removeAll();
            view.getMainPanel().add(view.getPanelOptiuni());
            view.getMainPanel().repaint();
            view.getMainPanel().validate();
        }
    }
    class ButtonInapoiProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getMainPanel().removeAll();
            view.getMainPanel().add(view.getPanelOptiuni());
            view.getMainPanel().repaint();
            view.getMainPanel().validate();
        }
    }
    class ButtonInapoiOrder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getMainPanel().removeAll();
            view.getMainPanel().add(view.getPanelOptiuni());
            view.getMainPanel().repaint();
            view.getMainPanel().validate();
            view.getCardOrder().add(view.getPanelAdaugareOrder());
        }
    }


}
