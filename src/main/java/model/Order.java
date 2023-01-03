package model;

public class Order {
    private int idOrder;
    private int idProduct;
    private int idCLient;
    private int cantitate;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCLient() {
        return idCLient;
    }

    public void setIdCLient(int idCLient) {
        this.idCLient = idCLient;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
